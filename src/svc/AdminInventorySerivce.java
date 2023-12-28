package svc;

import static db.JdbcUtil.*;
import java.sql.Connection;
import java.util.ArrayList;

import dao.AdminDAO;
import vo.ShoseInfo;

public class AdminInventorySerivce {
	
	public ArrayList<ShoseInfo> getAllInventory(String search) 
			throws Exception {
		ArrayList<ShoseInfo> AllInventoryListSuccess = null;
		Connection con= null;
		try 
		{
		con=getConnection();
		AdminDAO adminDAO=AdminDAO.getInstance();
		adminDAO.setConnection(con);
		AllInventoryListSuccess=adminDAO.SelectAllInventory(search);
		}
		catch(Exception e) 
		{
		 e.printStackTrace();	
		}finally{
			close(con);
		}
		return AllInventoryListSuccess;
	}
}
