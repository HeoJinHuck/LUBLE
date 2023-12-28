package dao;

import java.sql.*;
import java.util.ArrayList;

import static db.JdbcUtil.*;
import javax.sql.DataSource;
import vo.Mark;

public class MarkDAO {
	private static MarkDAO MarkDAO;

	Connection con = null;
	ResultSet rs = null;
	DataSource ds;

	private MarkDAO() {}

	public static MarkDAO getInstance() {
		if (MarkDAO == null) {
			MarkDAO = new MarkDAO();
		}
		return MarkDAO;
	}
	public void setConnection(Connection con) {
		this.con = con;
	}
	public ArrayList<Mark> selectjjim(String id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Mark mark = null;

		ArrayList<Mark> jjimList = new ArrayList<Mark>();

		String sql = "SELECT brand, model, price, shoeimage " 
				+ "FROM jjim WHERE userid = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				mark = new Mark();
				mark.setBrand(rs.getString("brand"));
				mark.setModel(rs.getString("model"));
				mark.setPrice(rs.getString("price"));
				mark.setShoeimage(rs.getString("shoeimage"));
				jjimList.add(mark);//
				System.out.println("셀렉트 출력");
			}
		} catch (Exception e) {
			System.out.println("SELECT JJIM 쿼리 에러 : " + e);
		} finally {
			close(rs);
			close(pstmt);
		}
		return jjimList;
	}

	public int insertjjim(Mark mark) { //찜 삽입 
		String sql = "INSERT INTO mark (model, userid) " 
					+ "VALUES (?,?)";

		int insertCount = 0;

		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mark.getModel());
			pstmt.setString(2, mark.getUserid());
			insertCount = pstmt.executeUpdate();
			System.out.println("인서트DAO");

		} catch (Exception ex) {
			System.out.println("찜 목록 insert 실패  : " + ex);
		} finally {
			close(pstmt);
		}

		return insertCount;
	}

	public boolean Updatejjim(Mark mark) { // 찜목록 안보이게 
		String sql = "select model,userid from mark where model=? " + "and userid=?";
	
		PreparedStatement pstmt = null;
		boolean isUpdate=false;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mark.getModel());
			pstmt.setString(2, mark.getUserid());
			rs=pstmt.executeQuery();
			if(rs.next()) {
				isUpdate=true;
			}else {
				isUpdate=false;
			}
		} catch (Exception ex) {
			System.out.println("찜 목록 업데이트 실패  : " + ex);
		} finally {
			close(rs);
			close(pstmt);
		}
		return isUpdate;
	}
		
		
	
	
	public int Deletejjim(Mark mark) {
		String sql = "delete from mark where model=? and userid=?";
		PreparedStatement pstmt = null;
		int isDelete=0;
		System.out.println(mark.getModel()+", "+mark.getUserid());
	
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mark.getModel());
			pstmt.setString(2, mark.getUserid());
			isDelete=pstmt.executeUpdate();
		
			System.out.println(pstmt);
			
		} catch (Exception ex) {
			System.out.println("찜 목록 삭제 실패  : " + ex);
		} finally {
			close(pstmt);
		}
		return isDelete;
	}
	
}