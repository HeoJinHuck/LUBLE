package svc;

import java.sql.Connection;

import dao.ShoseDAO;

import static db.JdbcUtil.*;

import vo.ShoseInfo;

public class ShoesDetailService {

	public ShoseInfo getShoesInfo(String model) {
		ShoseInfo shoesinfo=null;
		Connection con=null;
		try {
			con=getConnection();
			ShoseDAO shoseDAO=ShoseDAO.getInstance();
			shoseDAO.setConnection(con);
			shoesinfo=shoseDAO.selectShoesInfo(model);			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(con);
		}		
		return shoesinfo;
	}

}
