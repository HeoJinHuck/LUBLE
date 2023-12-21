package svc;

import java.sql.*;
import static db.JdbcUtil.*;
import java.util.ArrayList;

import dao.ShoseDAO;
import vo.ShoseInfo;

public class MyBuyShoesListService {

	public ArrayList<ShoseInfo> getMyBuyShoes(String id) {
		ArrayList<ShoseInfo> BuyList=new ArrayList<ShoseInfo>();
		Connection con=null;
		try {
			con=getConnection();
			ShoseDAO shoseDAO = ShoseDAO.getInstance();
			shoseDAO.setConnection(con);
			BuyList=shoseDAO.getBuyShoesList(id);			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(con);
		}
		return BuyList;
	}

}
