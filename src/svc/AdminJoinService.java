package svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;

import dao.AdminDAO;
import vo.ManagerInfo;

public class AdminJoinService {
	
	public boolean AdminjoinMember(ManagerInfo managermember) {	
			Connection con = null;
			boolean joinSuccess = false;
		try {
			System.out.println("어드민 서비스");
			AdminDAO adminDAO = AdminDAO.getInstance();
			con = getConnection();
			adminDAO.setConnection(con);
			int AdmininsertCount = adminDAO.AdminMemberinsert(managermember);
			if (AdmininsertCount > 0) {
				joinSuccess = true;
				commit(con);
			} else {
				rollback(con);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			close(con);
			}

		return joinSuccess;
	}
}