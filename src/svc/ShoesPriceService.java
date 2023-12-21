package svc;

import static db.JdbcUtil.*;

import java.sql.Connection;
import java.util.ArrayList;

import dao.ShoseDAO;
import vo.ShoseInfo;

public class ShoesPriceService {

	public ArrayList<ShoseInfo> getShoesPrice(String model, String buyorcell) {
		ArrayList<ShoseInfo> shoesList=new ArrayList<ShoseInfo>();
		Connection con=null;
		try {
			con=getConnection();
			ShoseDAO shoseDAO=ShoseDAO.getInstance();
			shoseDAO.setConnection(con);
			shoesList=shoseDAO.selectShoesPrice(model, buyorcell);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(con);
		}
		return shoesList;
	}
}
