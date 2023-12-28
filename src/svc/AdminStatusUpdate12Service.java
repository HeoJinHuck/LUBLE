package svc;

import java.sql.Connection;
import static db.JdbcUtil.*;
import dao.AdminDAO;


public class AdminStatusUpdate12Service {

	

	public int AdminNumber2(String shonum) throws Exception {
		Connection con = null;
		int AdminStatus12Success = 0;
		try 
		{
			con = getConnection();
			AdminDAO adminDAO = AdminDAO.getInstance();
			adminDAO.setConnection(con);
			AdminStatus12Success = adminDAO.AdminNumber12(shonum);		
			if (AdminStatus12Success > 0) 
			{
				commit(con);
			} else 
			{
				rollback(con);
			} 
		} catch (Exception e) 
		{
			e.printStackTrace();
			rollback(con);
		}finally {
			close(con);
		}
		return AdminStatus12Success;
	}


	
}

