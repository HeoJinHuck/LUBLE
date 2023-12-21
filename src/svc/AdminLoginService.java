package svc;

import static db.JdbcUtil.*;
import java.sql.Connection;
import dao.AdminDAO;
import vo.ManagerInfo;

public class AdminLoginService {
	
	public String Adminlogin(ManagerInfo adminmember) {
		String adminloginId=null;
		Connection con = null;
		try {			
			con = getConnection();
			AdminDAO adminDAO = AdminDAO.getInstance();
			adminDAO.setConnection(con);
			adminloginId = adminDAO.AdminLogin(adminmember);
		
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(con);
		}
		return adminloginId;
	}
}
