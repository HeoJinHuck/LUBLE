package dao; // 12-14 수정  전체 복붙

import static db.JdbcUtil.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.sql.DataSource;

import vo.ManagerInfo;
import vo.ShoseInfo;
import vo.userinfo;

public class AdminDAO {
	public static AdminDAO instance;
	Connection con = null;
	DataSource ds = null;
	ResultSet rs = null;

	private AdminDAO() {

	}

	public static AdminDAO getInstance() {
		if (instance == null) {
			instance = new AdminDAO();
		}
		return instance;
	}

	public void setConnection(Connection con) {
		this.con = con;
	}

	public int AdminMemberinsert(ManagerInfo managerjoin) { // 회원가입 기능
		String sql = "insert into managerinfo VALUES (?,?,?,?,?)";
		int AdmininsertCount = 0;
		PreparedStatement pstmt = null;
		try {

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, managerjoin.getId());
			pstmt.setString(2, managerjoin.getPass());
			pstmt.setString(3, managerjoin.getAddress());
			pstmt.setString(4, managerjoin.getEmail());
			pstmt.setString(5, managerjoin.getGrade());
			AdmininsertCount = pstmt.executeUpdate();

		} catch (Exception ex) {
			System.out.println("관리자 회원 가입 실패 : " + ex);
		} finally {
			close(pstmt);
		}

		return AdmininsertCount;
	}

	public String AdminLogin(ManagerInfo adminmember) { // 로그인 기능
		String adminloginId = null;
		PreparedStatement pstmt = null;
		String sql = "SELECT id, grade from managerinfo WHERE id=? AND pass=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, adminmember.getId());
			pstmt.setString(2, adminmember.getPass());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				adminloginId = rs.getString("grade");
			}
		} catch (Exception ex) {
			System.out.println(" 아이디 또는 비밀번호가 잘못되었습니다.: " + ex);
		} finally {
			close(rs);
			close(pstmt);
		}
		return adminloginId;
	}

	public ArrayList<userinfo> SelectAlluser(String search) { // 전체 유저 조회
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		userinfo userinfo = null;

		ArrayList<userinfo> userList = new ArrayList<userinfo>();

		String sql = "SELECT * FROM userinfo";
		sql += search == null ? "" : " where userid like '%" + search + "%' or name like '%" + search + "%' ";

		try {
			pstmt = con.prepareStatement(sql);
			System.out.println(pstmt);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				userinfo = new userinfo();
				userinfo.setUserid(rs.getString("userid"));
				userinfo.setPass(rs.getString("pass"));
				userinfo.setAddress(rs.getString("address"));
				userinfo.setName(rs.getString("name"));
				userinfo.setEmail(rs.getString("email"));
				userinfo.setPoint(rs.getString("point"));
				userinfo.setSecession(rs.getString("secession"));
				userList.add(userinfo);// 유저 정보 유저 리스트에 담기
			}
		} catch (Exception e) {
			System.out.println("전체 유저 쿼리 에러 : " + e);
		} finally {
			close(rs);
			close(pstmt);
		}
		return userList;
	}

	public int AdminMemberDelete(String id) { // 회원 삭제 기능
		int adminMemberUpdate = 0;
		String sql = "UPDATE userinfo set secession='y' where userid=?";
		PreparedStatement pstmt = null;

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			adminMemberUpdate = pstmt.executeUpdate();
		} catch (Exception ex) {
			System.out.println("관리자 회원수정DAO 실패 : " + ex);
		} finally {
			close(pstmt);
		}

		return adminMemberUpdate;
	}

	// SelectAlluser
	public ArrayList<ShoseInfo> SelectAllInventory(String search) { // 전체 재고 조회
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ShoseInfo shoseinfo = null;
		ArrayList<ShoseInfo> AllInventory = new ArrayList<ShoseInfo>();
		String sql = "SELECT * FROM testinven2";
		sql += search == null ? "" : " where brand like '%" + search + "%' or model like '%" + search + "%' ";
		System.out.println(sql);
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				shoseinfo = new ShoseInfo();
				shoseinfo.setBrand(rs.getString("brand"));
				shoseinfo.setModel(rs.getString("model"));
				shoseinfo.setCount(rs.getString("count"));
				AllInventory.add(shoseinfo); // 재고 정보 인벤토리에 담기
			}
		} catch (Exception e) {
			System.out.println("전체 재고 쿼리 에러 : " + e);
		} finally {
			close(rs);
			close(pstmt);
		}
		return AllInventory;
	}

	public ArrayList<ShoseInfo> SelectAllSizeInventory(String model) {

		ArrayList<ShoseInfo> SizeInventory = new ArrayList<ShoseInfo>();

		ShoseInfo shoesinfo = null;
		PreparedStatement pstmt = null;
		int size = 220;
		ResultSet rs = null;

		String sql = "SELECT * FROM testinven WHERE model=? and size=?";
		try {
			for (int i = 0; i < 8; i++) { // 포문 시작쓰 220
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, model);
				pstmt.setInt(2, size);

				shoesinfo = new ShoseInfo();
				rs = pstmt.executeQuery();
				if (rs.next()) {
					shoesinfo.setCount(rs.getString("count"));
					shoesinfo.setModel(model);
					shoesinfo.setSize(Integer.toString(size));
				} else {
					shoesinfo.setCount(Integer.toString(0));
					shoesinfo.setModel(model);
					shoesinfo.setSize(Integer.toString(size));
				}
				SizeInventory.add(shoesinfo);
				size += 10;
			}
		} catch (Exception e) {
			System.out.println("재고 조사 실패  : " + e);
		} finally {
			close(rs);
			close(pstmt);
		}
		return SizeInventory;
	}

	public ArrayList<ShoseInfo> SelectAllNumber1() { // 전체 배송중인 상품 조회
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ShoseInfo shoseinfo = null;

		ArrayList<ShoseInfo> Number1 = new ArrayList<ShoseInfo>();
		String sql = "SELECT model,price,SIZE,pass,ISPURCHASE, shonum\r\n" + "FROM  shoesinfo s \r\n"
				+ "WHERE pass=1 AND ispurchase='n'";

		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				shoseinfo = new ShoseInfo();
				// 1번이면서 n 인 정보 넘버원에 담기
				shoseinfo.setModel(rs.getString("model"));
				shoseinfo.setPrice(Integer.parseInt(rs.getString("price")));
				shoseinfo.setSize(rs.getString("size"));
				shoseinfo.setPass(rs.getString("pass"));
				shoseinfo.setShonum(rs.getString("shonum"));
				Number1.add(shoseinfo);
			}
		} catch (Exception e) {
			System.out.println("전체 넘버원 못찾음 ㅋㅋ 에러 : " + e);
		} finally {
			close(rs);
			close(pstmt);
		}
		return Number1;
	}

	public ArrayList<ShoseInfo> SelectAllNumber2() { // 전체 검수중인 상품 조회
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ShoseInfo shoseinfo = null;

		ArrayList<ShoseInfo> Number2 = new ArrayList<ShoseInfo>();
		String sql = "select model,price,size,pass,shonum\r\n" + "from  shoesinfo \r\n"
				+ "where pass=2 and ispurchase='n'";

		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				shoseinfo = new ShoseInfo();
				// 2번이면서 n 인 정보 넘버원에 담기
				shoseinfo.setModel(rs.getString("model"));
				shoseinfo.setPrice(Integer.parseInt(rs.getString("price")));
				shoseinfo.setSize(rs.getString("size"));
				shoseinfo.setPass(rs.getString("pass"));
				shoseinfo.setShonum(rs.getString("shonum"));
				Number2.add(shoseinfo);
			}
		} catch (Exception e) {
			System.out.println("전체 넘버투 못찾음  에러 : " + e);
		} finally {
			close(rs);
			close(pstmt);
		}
		return Number2;
	}

	public ArrayList<ShoseInfo> SelectAllNumber3() { // 전체 검수중인 상품 조회
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ShoseInfo shoseinfo = null;

		ArrayList<ShoseInfo> Number3 = new ArrayList<ShoseInfo>();
		String sql = "select model,price,size,pass,shonum\r\n" + "from  shoesinfo \r\n"
				+ "where pass=3 and ispurchase='n'";

		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				shoseinfo = new ShoseInfo();
				// 3번이면서 n 인 정보 넘버원에 담기
				shoseinfo.setModel(rs.getString("model"));
				shoseinfo.setPrice(Integer.parseInt(rs.getString("price")));
				shoseinfo.setSize(rs.getString("size"));
				shoseinfo.setPass(rs.getString("pass"));
				shoseinfo.setShonum(rs.getString("shonum"));
				Number3.add(shoseinfo);
			}
		} catch (Exception e) {
			System.out.println("전체 넘버쓰리 못찾음  에러 : " + e);
		} finally {
			close(rs);
			close(pstmt);
		}
		return Number3;
	}

	public ArrayList<ShoseInfo> SelectAllNumber4() { // 전체 검수중인 상품 조회
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ShoseInfo shoseinfo = null;

		ArrayList<ShoseInfo> Number4 = new ArrayList<ShoseInfo>();
		String sql = "select s.model,s.price,s.size,s.pass,s.shonum,u.address \r\n" + "from  shoesinfo s\r\n"
				+ "join userinfo u\r\n" + "on s.userid = u.userid\r\n" + "where s.pass=4 and s.ispurchase='n'";

		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				shoseinfo = new ShoseInfo();
				// 4번이면서 n 인 정보 넘버원에 담기
				shoseinfo.setModel(rs.getString("model"));
				shoseinfo.setPrice(Integer.parseInt(rs.getString("price")));
				shoseinfo.setSize(rs.getString("size"));
				shoseinfo.setPass(rs.getString("pass"));
				shoseinfo.setShonum(rs.getString("shonum"));
				shoseinfo.setAddress(rs.getString("address"));
				Number4.add(shoseinfo);
			}
		} catch (Exception e) {
			System.out.println("전체 넘버포 못찾음  에러 : " + e);
		} finally {
			close(rs);
			close(pstmt);
		}
		return Number4;
	}

	public int AdminNumber12(String shonum) { // 1->2
		int adminNumber2Update = 0;
		String sql = "UPDATE shoesinfo  SET pass='2' WHERE shonum=?;";
		PreparedStatement pstmt = null;

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, shonum);
			adminNumber2Update = pstmt.executeUpdate();
		} catch (Exception ex) {
			System.out.println(" 넘버 2  실패 : " + ex);
		} finally {
			close(pstmt);
		}

		return adminNumber2Update;
	}

	public int AdminNumber23(String shonum) { // 2->3
		int adminNumber3Update = 0;
		String sql = "UPDATE shoesinfo  SET pass='3' WHERE shonum=?;";
		PreparedStatement pstmt = null;

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, shonum);
			adminNumber3Update = pstmt.executeUpdate();
		} catch (Exception ex) {
			System.out.println(" 넘버 3  실패 : " + ex);
		} finally {
			close(pstmt);
		}

		return adminNumber3Update;
	}

	public int AdminNumber24(String shonum) { // 2->4
		int adminNumber4Update = 0;
		String sql = "UPDATE shoesinfo  SET pass='4' WHERE shonum=?;";
		PreparedStatement pstmt = null;

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, shonum);
			adminNumber4Update = pstmt.executeUpdate();
		} catch (Exception ex) {
			System.out.println(" 넘버 4  실패 : " + ex);
		} finally {
			close(pstmt);
		}

		return adminNumber4Update;
	}

	public ArrayList<ShoseInfo> SelectRevenue() {

		ArrayList<ShoseInfo> addrevenue = new ArrayList<ShoseInfo>();

		ShoseInfo shoesinfo = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select o.ordernum,s.price from ordertable inner join shoesinfo "
				+ "on o.shonum=s.shonum where status=3";

		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				shoesinfo = new ShoseInfo();
				shoesinfo.setShonum(rs.getString("ordernum"));
				shoesinfo.setPrice(Integer.parseInt(rs.getString("price")));
				shoesinfo.setCheckprice(Integer.parseInt(rs.getString("price")) / 10);
				addrevenue.add(shoesinfo);
			}
		} catch (Exception e) {
			System.out.println("잔고 DAO : " + e);
		} finally {
			close(rs);
			close(pstmt);
		}
		return addrevenue;
	}

	public int DeliveryUpdate(String id) {
		int adminMemberUpdate = 0;
		String sql = "update managerinfo set grade='배송담당' where id=?;";
		PreparedStatement pstmt = null;

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			adminMemberUpdate = pstmt.executeUpdate();
		} catch (Exception ex) {
			System.out.println("배송담당 지정  실패 : " + ex);
		} finally {
			close(pstmt);
		}

		return adminMemberUpdate;
	}

	public int CheckUpdate(String id) {
		int adminMemberUpdate = 0;
		String sql = "update managerinfo set grade='검수담당' where id=?;";
		PreparedStatement pstmt = null;

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			adminMemberUpdate = pstmt.executeUpdate();
		} catch (Exception ex) {
			System.out.println("검수담당 지정  실패 : " + ex);
		} finally {
			close(pstmt);
		}

		return adminMemberUpdate;
	}

	public String ShowNumber1() { // 전체 배송중인 상품의 pass 값 조회
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String showNumber1 = null;

		String sql = "SELECT count(model) FROM shoesinfo WHERE pass = 1 AND ispurchase = 'n'";

		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				showNumber1 = rs.getString("count(model)");
			}
		} catch (Exception e) {
			System.out.println("show number 1 DAO : " + e);
		} finally {
			close(rs);
			close(pstmt);
		}
		return showNumber1;
	}

	public String ShowNumber2() { // 전체 배송중인 상품의 pass 값 조회
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String showNumber2 = null;

		String sql = "SELECT count(model) FROM shoesinfo WHERE pass = 2 AND ispurchase = 'n'";

		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				showNumber2 = rs.getString("count(model)");
			}
		} catch (Exception e) {
			System.out.println("show number 2 DAO : " + e);
		} finally {
			close(rs);
			close(pstmt);
		}
		return showNumber2;
	}

	public String ShowNumber3() { // 전체 배송중인 상품의 pass 값 조회
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String showNumber3 = null;

		String sql = "SELECT count(model) FROM shoesinfo WHERE pass = 3 AND ispurchase = 'n'";

		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				showNumber3 = rs.getString("count(model)");
			}
		} catch (Exception e) {
			System.out.println("show number 3 DAO : " + e);
		} finally {
			close(rs);
			close(pstmt);
		}
		return showNumber3;
	}

	public String ShowNumber4() { // 전체 배송중인 상품의 pass 값 조회
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String showNumber4 = null;

		String sql = "SELECT count(model) FROM shoesinfo WHERE pass = 4 AND ispurchase = 'n'";

		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				showNumber4 = rs.getString("count(model)");
			}
		} catch (Exception e) {
			System.out.println("show number 4 DAO : " + e);
		} finally {
			close(rs);
			close(pstmt);
		}
		return showNumber4;
	}

	public String getAdminEmail(String id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String email = null;
		String sql = "select email from managerinfo where id=?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				email = rs.getString("email");
			}
			System.out.println(email);
		} catch (Exception e) {
			System.out.println("이메일 가져오기 실패: " + e);
		} finally {
			close(pstmt);
			close(rs);
		}
		return email;
	}

	public int AdminProductUpload(ShoseInfo shoesinfo) { // 제품 등록(shoesmodel) (12-14수정)
		String sql = "insert into shoesmodel VALUES (?,?,0,?,0,0)";
		int adminProductUpload = 0;
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, shoesinfo.getModel());
			pstmt.setString(2, shoesinfo.getBrand());
			pstmt.setString(3, shoesinfo.getKind());
			adminProductUpload = pstmt.executeUpdate();
			System.out.println(pstmt);
		} catch (Exception ex) {
			System.out.println("제품 등록 실패 : " + ex);
		} finally {
			close(pstmt);
		}

		return adminProductUpload;
	}

	public int AdminProductUploadImage(ShoseInfo shoesinfo) { // 제품 등록(shosimage) (12-13)
		String sql = "insert into shoeimage (model,shoeimage) VALUES (?,?)";
		int adminProductUpload = 0;
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, shoesinfo.getModel());
			pstmt.setString(2, shoesinfo.getShoImage());
			adminProductUpload = pstmt.executeUpdate();
			System.out.println(pstmt);
		} catch (Exception ex) {
			System.out.println("제품 이미지 등 실패 : " + ex);
		} finally {
			close(pstmt);
		}

		return adminProductUpload;
	}

	public ArrayList<ShoseInfo> SelectUploadShoes(String search) { // 전체 제품 조회 (12-14 수정)
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ShoseInfo shoesinfo = null;
		ArrayList<ShoseInfo> UploadList = new ArrayList<ShoseInfo>();

		String sql = "SELECT * FROM shoesmodel";
		sql += search == null ? ""
				: " where brand LIKE '%" + search + "%' " + "or model LIKE '%" + search + "%'" + "or kind LIKE '%"
						+ search + "%'";

		try {
			pstmt = con.prepareStatement(sql);
			System.out.println(pstmt);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				shoesinfo = new ShoseInfo();
				shoesinfo.setBrand(rs.getString("brand"));
				shoesinfo.setModel(rs.getString("model"));
				shoesinfo.setKind(rs.getString("kind"));
				shoesinfo.setShoedelete(Integer.parseInt(rs.getString("shoedelete")));
				UploadList.add(shoesinfo);// 신발 정보 신발 리스트에 담기
			}
		} catch (Exception e) {
			System.out.println("전체 유저 쿼리 에러 : " + e);
		} finally {
			close(rs);
			close(pstmt);
		}
		return UploadList;
	}

	public int DeliteUploadShoes(String model) { // 제품 삭제 (12-14 수정)
		int deliteuploadshoes = 0;
		String sql = "UPDATE shoesmodel SET shoedelete=1 WHERE model = ?";
		PreparedStatement pstmt = null;

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, model);
			deliteuploadshoes = pstmt.executeUpdate();
			System.out.println(model);
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("제품 삭제DAO 실패 : " + ex);
		} finally {
			close(pstmt);
		}

		return deliteuploadshoes;
	}
}
