package svc;

import static db.JdbcUtil.*;
import java.sql.Connection;
import java.util.ArrayList;

import dao.AdminDAO;
import vo.ShoseInfo;

public class AdminStatusList3Service {

	
	public ArrayList<ShoseInfo> getNumber3() throws Exception {
		Connection con = null;
		ArrayList<ShoseInfo> Number3ListSuccess =  new ArrayList<ShoseInfo>();
		
		try 
		{
		con=getConnection();
		AdminDAO adminDAO=AdminDAO.getInstance();
		adminDAO.setConnection(con);
		Number3ListSuccess=adminDAO.SelectAllNumber3();
		}
		catch(Exception e) 
		{
		 e.printStackTrace();	
		 rollback(con);
		}finally {
			close(con);
		}
		return Number3ListSuccess;
		
	}
}
