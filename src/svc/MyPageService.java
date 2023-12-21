package svc;

import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.MemberDAO;

public class MyPageService {

	public int[] getSell(String id) {
		int sell[]=new int[5];
		Connection con=null;
		try {
			con = getConnection();
			MemberDAO memberDAO=MemberDAO.getInstance();
			memberDAO.setConnection(con);
			sell = memberDAO.getMySell(id);
			close(con);
		}catch (Exception e) 
		{
			e.printStackTrace();
		}finally {
			close(con);
		}
		return sell;
	}
	public int[] getOrder(String id) {
		int order[]=new int[3];
		Connection con=null;
		try {
			con = getConnection();
			MemberDAO memberDAO=MemberDAO.getInstance();
			memberDAO.setConnection(con);
			order = memberDAO.getMyOrder(id);
			
		}catch (Exception e) 
		{
			e.printStackTrace();
		}finally {
			close(con);
		} 
		return order;
	}

	public String getEmail(String id) {
		String email=null;
		Connection con=null;
		try {
			con = getConnection();
			MemberDAO memberDAO=MemberDAO.getInstance();
			memberDAO.setConnection(con);
			email = memberDAO.getEmail(id);
			close(con);
		}catch (Exception e) 
		{
			e.printStackTrace();
		} 
		return email;
	}

}
