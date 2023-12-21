package svc;

import java.sql.Connection;

import dao.ShoseDAO;

import static db.JdbcUtil.*;

public class ShoesAdjustService {

	public int adjustPrice(String shonum, String price) {
		int isadd=0;
		Connection con=null;
		try {
			con=getConnection();
			ShoseDAO shoesDAO=ShoseDAO.getInstance();
			shoesDAO.setConnection(con);
			isadd=shoesDAO.adjustPrice(shonum, price);
			if(isadd>0) {
				commit(con);
			}else {
				rollback(con);
			}			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(con);
		}
		return isadd;
	}

}
