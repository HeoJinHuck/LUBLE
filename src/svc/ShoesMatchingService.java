package svc;

import dao.ShoseDAO;
import vo.ShoseInfo;
import vo.userinfo;

import static db.JdbcUtil.*;

import java.sql.Connection;

public class ShoesMatchingService {

	public userinfo RefreshShoes(ShoseInfo shoesinfo) {
		Connection con= null;
		userinfo biduser=new userinfo();
		try {
			con= getConnection();
			ShoseDAO shoesDAO=ShoseDAO.getInstance();
			shoesDAO.setConnection(con);
			biduser=shoesDAO.RefreshShoes(shoesinfo);			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(con);
		}
		
		return biduser;
	}

}
