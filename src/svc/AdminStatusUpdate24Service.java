package svc;

import java.sql.Connection;
import static db.JdbcUtil.*;
import dao.AdminDAO;


public class AdminStatusUpdate24Service {

	

	public int AdminNumber4(String shonum) throws Exception {
		int AdminStatus24Success = 0;
		Connection con = null;
		try 
		{
			con = getConnection();
			AdminDAO adminDAO = AdminDAO.getInstance();
			adminDAO.setConnection(con);
			AdminStatus24Success = adminDAO.AdminNumber24(shonum);
			
			if (AdminStatus24Success > 0) 
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
		return AdminStatus24Success;
	}


	
}

