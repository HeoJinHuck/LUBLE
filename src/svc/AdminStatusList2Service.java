package svc;

import static db.JdbcUtil.*;
import java.sql.Connection;
import java.util.ArrayList;

import dao.AdminDAO;
import vo.ShoseInfo;

public class AdminStatusList2Service {

	
	public ArrayList<ShoseInfo> getNumber2() throws Exception {
		Connection con = null;
		ArrayList<ShoseInfo> Number2ListSuccess = null;
		
		try 
		{
		con=getConnection();
		AdminDAO adminDAO=AdminDAO.getInstance();
		adminDAO.setConnection(con);
		Number2ListSuccess=adminDAO.SelectAllNumber2();
		}
		catch(Exception e) 
		{
		 e.printStackTrace();	
		 rollback(con);
		}finally {
			close(con);
		}
		return Number2ListSuccess;
		
	}
}
