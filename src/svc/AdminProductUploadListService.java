package svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import dao.AdminDAO;
import vo.ShoseInfo;

public class AdminProductUploadListService {
	public ArrayList<ShoseInfo> getUploadShoesList(String search) 
		throws Exception {
		ArrayList<ShoseInfo> AllShoesListSuccess = null;
		Connection con = null;
		try 
		{
			con=getConnection();
			AdminDAO adminDAO=AdminDAO.getInstance();
			adminDAO.setConnection(con);
			AllShoesListSuccess=adminDAO.SelectUploadShoes(search);	
		}
		catch(Exception e) 
		{
		 e.printStackTrace();	
		 rollback(con);
		}finally {
			close(con);
		}
		return AllShoesListSuccess;
		
	}
}
