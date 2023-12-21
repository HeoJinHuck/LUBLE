package svc;

import static db.JdbcUtil.*;
import java.sql.Connection;
import java.util.ArrayList;

import dao.AdminDAO;
import vo.ShoseInfo;

public class AdminStatusList4Service {

	
	public ArrayList<ShoseInfo> getNumber4() throws Exception {
		Connection con = null;
		ArrayList<ShoseInfo> Number4ListSuccess =  new ArrayList<ShoseInfo>();
		
		try 
		{
		con=getConnection();
		AdminDAO adminDAO=AdminDAO.getInstance();
		adminDAO.setConnection(con);
		Number4ListSuccess=adminDAO.SelectAllNumber4();	
		}
		catch(Exception e) 
		{
		 e.printStackTrace();	
		 rollback(con);
		}finally {
			close(con);
		}
		return Number4ListSuccess;
		
	}
}
