package svc;

import java.sql.Connection;
import static db.JdbcUtil.*;
import dao.AdminDAO;


public class AdminUploadDeleteService {

	public int getDeleteShoes(String model) throws Exception {
		int AdminShoesDeleteSuccess = 0;
		Connection con = null;
		
		try 
		{
			con = getConnection();
			AdminDAO adminDAO = AdminDAO.getInstance();
			adminDAO.setConnection(con);
			AdminShoesDeleteSuccess = adminDAO.DeliteUploadShoes(model);
			if (AdminShoesDeleteSuccess > 0) 
			{
				commit(con);
			} 
			else 
			{
				rollback(con);
			} 
		} catch (Exception e) 
			{
			e.printStackTrace();
			}finally {
				close(con);
			}
		return AdminShoesDeleteSuccess;
	}
}

