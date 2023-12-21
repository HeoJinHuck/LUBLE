package svc;

import java.sql.Connection;

import dao.ShoseDAO;

import static db.JdbcUtil.*;

public class BidUpdateService {

	public int updateBid(String name) {
		Connection con=null;
		int isup=0;		
		try {
			con=getConnection();
			ShoseDAO dao=ShoseDAO.getInstance();
			dao.setConnection(con);
			isup=dao.bidUpdate(name);
			
			if(isup>0) {
				commit(con);
			}else {
				rollback(con);
			}			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(con);
		}
		return isup;
	}

}
