package svc;

import static db.JdbcUtil.*;
import java.sql.Connection;
import java.util.ArrayList;

import dao.AdminDAO;
import vo.userinfo;


public class AdminClientListService {

	
	
	public ArrayList<userinfo> getuserList(String search) throws Exception {
		ArrayList<userinfo> AllMemberListSuccess = null;
		Connection con = null;
		try 
		{
			con=getConnection();
			AdminDAO adminDAO=AdminDAO.getInstance();
			adminDAO.setConnection(con);
			AllMemberListSuccess=adminDAO.SelectAlluser(search);	
		}
		catch(Exception e) 
		{
		 e.printStackTrace();	
		 rollback(con);
		}finally {
			close(con);
		}
		return AllMemberListSuccess;
		
	}
}
