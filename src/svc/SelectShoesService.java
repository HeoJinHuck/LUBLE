package svc;

import static db.JdbcUtil.*;
import java.sql.Connection;

import dao.ShoseDAO;
import vo.ShoseInfo;

public class SelectShoesService {

	public ShoseInfo selecsho(String model, String size, String boc) {
		ShoseInfo shoesinfo=new ShoseInfo();
		Connection con=null;
		try {
			con=getConnection();
			ShoseDAO shoseDAO = ShoseDAO.getInstance();
			shoseDAO.setConnection(con);
			shoesinfo=shoseDAO.getShoesInfo(model, size, boc);
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(con);
		}
		return shoesinfo;
	}

}
