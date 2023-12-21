package svc;

import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.MemberDAO;
import vo.userinfo;

public class MemberJoinService {
	

	public boolean joinMember(userinfo member) {
			Connection con = null;
			boolean joinSuccess = false;
		try {

			MemberDAO memberDAO = MemberDAO.getInstance();
			con = getConnection();
			memberDAO.setConnection(con);
			int insertCount = memberDAO.insertMember(member);
			if (insertCount > 0) {
				joinSuccess = true;
				commit(con);
			} else {
				rollback(con);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(con);
		}

		return joinSuccess;
	}
}
