package svc;

import static db.JdbcUtil.*;

import java.sql.Connection;
import dao.MemberDAO;
import vo.userinfo;

public class MemberModifyService {

	public boolean MemberLogin(userinfo loginmodify) {
		
		boolean isModifySuccess = false;
		Connection con=null;
		try {
			con = getConnection();
			MemberDAO memberDAO = MemberDAO.getInstance();
			memberDAO.setConnection(con);
			int loginupdateCount = memberDAO.ModifyMember(loginmodify);

			if (loginupdateCount > 0) {
				commit(con);
				isModifySuccess = true;				
			} else {
				rollback(con);
				isModifySuccess=false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(con);
		}
		return isModifySuccess;
	}
}
