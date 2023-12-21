package svc;

import static db.JdbcUtil.*;

import java.sql.Connection;
import java.util.ArrayList;

import dao.ShoseDAO;
import vo.ShoseInfo;

public class ShoesSearchService {

	public ArrayList<ShoseInfo> getSearchList(String search, String trade, String[] seleckind) {
		Connection con=null;
		ArrayList<ShoseInfo> articleList = null;
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

	public ArrayList<String> getKindList() {
		Connection con=null;
		ArrayList<String> kindlist = null;
		try {
			con=getConnection();
			ShoseDAO shoseDAO=ShoseDAO.getInstance();
			shoseDAO.setConnection(con);
			kindlist=shoseDAO.selectkindList();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(con);
		}
		return kindlist;
	}

}
