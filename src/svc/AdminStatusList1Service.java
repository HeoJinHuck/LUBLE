package svc;

import static db.JdbcUtil.*;
import java.sql.Connection;
import java.util.ArrayList;

import dao.AdminDAO;
import vo.ShoseInfo;

public class AdminStatusList1Service {

	
	
	public ArrayList<ShoseInfo> getNumber1() throws Exception {
		Connection con = null;
		ArrayList<ShoseInfo> Number1ListSuccess = new ArrayList<ShoseInfo>();
		try 
		{
		con=getConnection();
		AdminDAO adminDAO=AdminDAO.getInstance();
		adminDAO.setConnection(con);
		Number1ListSuccess=adminDAO.SelectAllNumber1();
		}
		catch(Exception e) 
		{
		 e.printStackTrace();	
		 rollback(con);
		}finally {
			close(con);
		}
		return Number1ListSuccess;
		
	}
}
