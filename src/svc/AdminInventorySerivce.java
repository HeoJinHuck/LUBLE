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
		try 
		{
		Connection con=getConnection();
		AdminDAO adminDAO=AdminDAO.getInstance();
		adminDAO.setConnection(con);
		AllInventoryListSuccess=adminDAO.SelectAllInventory(search);
		close(con);
		}
		catch(Exception e) 
		{
		 e.printStackTrace();	
		}
		return AllInventoryListSuccess;
	}
}
