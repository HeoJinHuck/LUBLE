package dao;

import java.sql.*;
import static db.JdbcUtil.*;
import javax.sql.DataSource;
import vo.userinfo;

public class MemberDAO {
	public static MemberDAO instance;
	Connection con = null;

	ResultSet rs = null;
	DataSource ds;

	private MemberDAO() {
	}

	public static MemberDAO getInstance() {
		if (instance == null) {
			instance = new MemberDAO();
		}
		return instance;
	}

	public void setConnection(Connection con) {
		this.con = con;
	}

	public String selectLoginId(userinfo member) { // 아이디 비밀번호 맞는지 확인
		String loginId = null;
		PreparedStatement pstmt = null;
		String sql = "SELECT userid from userinfo WHERE userid=? AND pass=? AND secession='n'";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPass());
			rs = pstmt.executeQuery();

			if (rs.next()) {
				loginId = rs.getString("userid");
			}
		} catch (Exception ex) {
			System.out.println(" 아이디 또는 비밀번호가 잘못되었습니다.: " + ex);
		} finally {
			close(rs);
			close(pstmt);
		}
		return loginId;
	}

	public int insertMember(userinfo user) { // 회원가입 기능
		String sql = "INSERT INTO userinfo VALUES (?,?,?,?,?,0,'n')";
		int insertCount = 0;
		PreparedStatement pstmt = null;
		try {

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getPass());
			pstmt.setString(3, user.getAddress());
			pstmt.setString(4, user.getName());
			pstmt.setString(5, user.getEmail());
			insertCount = pstmt.executeUpdate();

		} catch (Exception ex) {
			System.out.println("회원가입 실패 : " + ex);
		} finally {
			close(pstmt);
		}

		return insertCount;
	}

	public int ModifyMember(userinfo loginmodify) {
		int UpdateMember = 0;
		String spl = "UPDATE userinfo SET email=?, pass=? WHERE userid=?";
		PreparedStatement pstmt = null;

		try {
			pstmt = con.prepareStatement(spl);
			pstmt.setString(1, loginmodify.getEmail());
			pstmt.setString(2, loginmodify.getPass());
			pstmt.setString(3, loginmodify.getId());
			UpdateMember = pstmt.executeUpdate();
			System.out.println("회원 수정 성공");
		} catch (Exception ex) {
			System.out.println("회원수정 실패 : " + ex);
		} finally {
			close(pstmt);
		}

		return UpdateMember;
	}

	public int OutMember(String id) {
		int OutMember = 0;
		PreparedStatement pstmt = null;
		String sql = "update userinfo SET secession = 'y' where userid=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			OutMember = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("회원탈퇴 실패: " + e);
		} finally {
			close(pstmt);
		}
		return OutMember;
	}

	public String selectaddr(String id) {
		String addr = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select address from userinfo where userid=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				addr = rs.getString("address");
			}
		} catch (Exception e) {
			System.out.println("주소 가져오기 실패: " + e);
		} finally {
			close(pstmt);
			close(rs);
		}
		return addr;
	}

	public int[] getMySell(String id) {
		int sell[] = new int[5];
		String sql = "select count(model) as model, pass, ispurchase from shoesinfo where userid=? group by pass, ispurchase";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				if(rs.getString("pass").equals("1")) {
					sell[0]=Integer.parseInt(rs.getString("model"));
				}else if(rs.getString("pass").equals("2")) {
					sell[1]=Integer.parseInt(rs.getString("model"));
				}else if(rs.getString("pass").equals("3")&&rs.getString("ispurchase").equals("n")) {
					sell[2]=Integer.parseInt(rs.getString("model"));
				}else if(rs.getString("pass").equals("3")&&rs.getString("ispurchase").equals("y")) {
					sell[3]=Integer.parseInt(rs.getString("model"));
				}else if(rs.getString("pass").equals("4")) {
					sell[4]=Integer.parseInt(rs.getString("model"));
				}
			}
			
		} catch (Exception e) {
			System.out.println("판매 수량 가져오기 실패: " + e);
		} finally {
			close(pstmt);
			close(rs);
		}
		return sell;
	}

	public int[] getMyOrder(String id) {
		int buy[] = new int[3];
		String sql = "select count(userid) as buy from ordertable where userid=? and status=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			for (int i = 0; i <= 2; i++) {
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, id);
				pstmt.setInt(2, i + 1);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					buy[i] = Integer.parseInt(rs.getString("buy"));
				}
			}
		} catch (Exception e) {
			System.out.println("구매 수량 가져오기 실패: " + e);
		} finally {
			close(pstmt);
			close(rs);
		}
		return buy;
	}

	public String getEmail(String id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select email from userinfo where userid=?";
		String email = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				email = rs.getString("email");
			}
		} catch (Exception e) {
			System.out.println("구매 수량 가져오기 실패: " + e);
		} finally {
			close(pstmt);
			close(rs);
		}
		return email;
	}
}
