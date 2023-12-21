package svc;

import java.sql.Connection;

import dao.ShoseDAO;

import static db.JdbcUtil.*;

public class ShoesViewService {

	public void updateview(String model) {
		Connection con=null;
		int isupdate=0;
		try {
			con=getConnection();
			ShoseDAO DAO=ShoseDAO.getInstance();
			DAO.setConnection(con);
			isupdate=DAO.ViewUpdate(model);
			if(isupdate>0) {
				commit(con);
			}else {
				rollback(con);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(con);
		}
		
	}

}
