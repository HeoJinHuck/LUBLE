package svc;

import static db.JdbcUtil.*;

import java.sql.Connection;

import java.util.ArrayList;
import dao.ShoseDAO;
import vo.ShoseInfo;

public class MyUploadShoesListService {

	
	public ArrayList<ShoseInfo> getMyUploadShoes(String id) throws Exception {
		Connection con = null;
		ArrayList<ShoseInfo> MyUploadShoesSuccess = null;
		try {
			con = getConnection();
			ShoseDAO shoseDAO = ShoseDAO.getInstance();
			shoseDAO.setConnection(con);
			MyUploadShoesSuccess = shoseDAO.MyshoeUploadDAO(id);			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}finally {
			close(con);
		}
		return MyUploadShoesSuccess;
	}

}
