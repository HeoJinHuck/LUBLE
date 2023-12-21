package svc;

import java.sql.Connection;
import static db.JdbcUtil.*;
import dao.AdminDAO;


public class AdminMemberDeleteService {

	
	public int getDeleteAdminMember(String id) throws Exception {
		int AdminMemberDeleteSuccess = 0;
		Connection con = null;
		try 
		{
			con = getConnection();
			AdminDAO adminDAO = AdminDAO.getInstance();
			adminDAO.setConnection(con);
			AdminMemberDeleteSuccess = adminDAO.AdminMemberDelete(id);
			
			if (AdminMemberDeleteSuccess > 0) 
			{
				commit(con);
			} 
			else 
			{
				rollback(con);
				close(con);
			} 
			} catch (Exception e) 
			{
			e.printStackTrace();
			}
		return AdminMemberDeleteSuccess;
	}
}

