package svc;

import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.MemberDAO;
import vo.userinfo;

public class MemberLoginService {

	public boolean login(userinfo member) {
		Connection con = null;
		boolean loginResult = false;
	
		try {			
			con = getConnection();
			MemberDAO memberDAO = MemberDAO.getInstance();
			memberDAO.setConnection(con);
			String loginId = memberDAO.selectLoginId(member);
			if (loginId != null) {
				loginResult = true;
			} else {
				loginResult=false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return loginResult;
	}
}
