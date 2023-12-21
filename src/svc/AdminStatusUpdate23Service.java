package svc;

import java.sql.Connection;
import static db.JdbcUtil.*;
import dao.AdminDAO;


public class AdminStatusUpdate23Service {

	
	public int AdminNumber3(String shonum) throws Exception {
		int AdminStatus23Success = 0;
		Connection con = null;

		try 
		{
			con = getConnection();
			AdminDAO adminDAO = AdminDAO.getInstance();
			adminDAO.setConnection(con);
			AdminStatus23Success = adminDAO.AdminNumber23(shonum);
			
			if (AdminStatus23Success > 0) 
			{
				commit(con);
			} else 
			{
				rollback(con);
				close(con);
			} 
		} catch (Exception e) 
		{
			e.printStackTrace();
			rollback(con);
		}
		return AdminStatus23Success;
	}


	
}

