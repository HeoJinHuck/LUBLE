package svc;

import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.AdminDAO;

import vo.ShoseInfo;

public class AdminProductImageUploadService {

	public boolean getAdminProductImageUpload(ShoseInfo shoesinfo) {
		Connection con = null;
		boolean joinSuccess = false;
		try {
			AdminDAO adminDAO = AdminDAO.getInstance();
			con = getConnection();
			adminDAO.setConnection(con);
			int AdminProUPCount = adminDAO.AdminProductUploadImage(shoesinfo);
			System.out.println("a");
			if (AdminProUPCount > 0) {
				joinSuccess = true;
				commit(con);
			} else {
				rollback(con);
				close(con);
			}
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		return joinSuccess;
	}
}