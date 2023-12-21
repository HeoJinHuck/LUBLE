package svc;

import static db.JdbcUtil.*;

import java.sql.Connection;
import dao.MemberDAO;

public class SelectAddrService {

	public String selecaddr(String id) {
		String addr = null;
		Connection con=null;
		try 
		{
			con=getConnection();
			MemberDAO memberDAO=MemberDAO.getInstance();
			memberDAO.setConnection(con);
			addr=memberDAO.selectaddr(id);			
		}
		catch(Exception e) 
		{
		 e.printStackTrace();
		}finally {
			close(con);
		}
		return addr;
	}

}
