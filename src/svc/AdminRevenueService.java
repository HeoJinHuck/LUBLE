package svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import dao.AdminDAO;
import vo.ShoseInfo;

public class AdminRevenueService {


	
	public ArrayList<ShoseInfo> getRevenueList() throws Exception {
		Connection con = null;
		ArrayList<ShoseInfo> RevenueSuccess = null;
		try 
		{
		con=getConnection();
		AdminDAO adminDAO=AdminDAO.getInstance();
		adminDAO.setConnection(con);
		RevenueSuccess=adminDAO.SelectRevenue();	
		}
		catch(Exception e) 
		{
		 e.printStackTrace();	
		 rollback(con);
		}finally {
			close(con);
		}
		return RevenueSuccess;
		
	}
}
