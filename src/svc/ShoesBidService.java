package svc;

import java.sql.Connection;

import dao.ShoseDAO;

import static db.JdbcUtil.*;

import vo.ShoseInfo;

public class ShoesBidService {

	public int insertBid(ShoseInfo shoesinfo, String id) {
		int isbid=0;
		Connection con=null;
		try {
			con=getConnection();
			ShoseDAO shoesdao=ShoseDAO.getInstance();
			shoesdao.setConnection(con);
			isbid=shoesdao.insertBid(shoesinfo, id);
			if(isbid>0) {
				commit(con);
			}else {
				rollback(con);
			}			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			close(con);
		}
		return isbid;
	}

}
