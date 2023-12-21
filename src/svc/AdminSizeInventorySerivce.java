package svc;

import static db.JdbcUtil.*;
import java.sql.Connection;
import java.util.ArrayList;

import dao.AdminDAO;
import vo.ShoseInfo;

public class AdminSizeInventorySerivce {

	
	
	public ArrayList<ShoseInfo> getAllInventory(String model) 
			throws Exception {
		ArrayList<ShoseInfo> SizeInventoryListSuccess = null;
		Connection con = null;
		
		try 
		{
		con=getConnection();
		AdminDAO adminDAO=AdminDAO.getInstance();
		adminDAO.setConnection(con);
		SizeInventoryListSuccess =adminDAO.SelectAllSizeInventory(model);
		}
		catch(Exception e) 
		{
		 e.printStackTrace();	
		 rollback(con);
		}finally {
			close(con);
		}
		return SizeInventoryListSuccess ;
		
	}
}
