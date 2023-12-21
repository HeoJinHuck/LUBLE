package svc;

import static db.JdbcUtil.*;

import java.sql.Connection;
import java.util.ArrayList;

import dao.ShoseDAO;
import vo.ShoseInfo;

public class ShoseListService {

	public ArrayList<ShoseInfo> getArticleList(String search) {
		Connection con=null;
		ArrayList<ShoseInfo> articleList = null;
		String[] seleckind=null;
		String trade=null;
		try {
			con=getConnection();
			ShoseDAO shoseDAO=ShoseDAO.getInstance();
			shoseDAO.setConnection(con);
			articleList=shoseDAO.selectArticleList(search, trade, seleckind);	
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(con);
		}		
		return articleList;
	}

	public ArrayList<ShoseInfo> getTradeList() {
		Connection con=null;
		ArrayList<ShoseInfo> tradeList = null;
		try {
			con=getConnection();
			ShoseDAO shoseDAO=ShoseDAO.getInstance();
			shoseDAO.setConnection(con);
			tradeList=shoseDAO.selectTradeList();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(con);
		}
		return tradeList;
	}
}
