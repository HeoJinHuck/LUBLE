package svc;

import java.sql.Connection;

import dao.MemberDAO;

import static db.JdbcUtil.*;

public class MemberOutService {

	public int MemberOut(String id) {
		int OutSuccess = 0;
		Connection con=null;
		try {
			 con=getConnection();
			MemberDAO memberDAO=MemberDAO.getInstance();
			memberDAO.setConnection(con);
			
			OutSuccess=memberDAO.OutMember(id);
			
			if (OutSuccess > 0) 
			{
				commit(con);
			} else 
			{
				rollback(con);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(con);
		}
		return OutSuccess;
	}
}
