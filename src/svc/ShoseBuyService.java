package svc;

import static db.JdbcUtil.*;
import java.sql.Connection;

import dao.ShoseDAO;
import vo.ShoseInfo;
import vo.userinfo;

public class ShoseBuyService {
	
	public String BuyShose(ShoseInfo shoseInfo) {		
		String ShoesNum=null;
		Connection con=null;
		try {
			con=getConnection();
			ShoseDAO shoseDAO=ShoseDAO.getInstance();
			shoseDAO.setConnection(con);		
			ShoesNum=shoseDAO.SelectShoseNum(shoseInfo);			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(con);		
		}		
		return ShoesNum;
	}

	public boolean BuyDicision(String shonum, String id, String addr) {
		Connection con=null;
		boolean isb=false;
		try {
			con=getConnection();
			ShoseDAO shoseDAO=ShoseDAO.getInstance();
			shoseDAO.setConnection(con);
			int UploadCount=shoseDAO.dicisionShoes(shonum, id, addr);
			if(UploadCount>0) {
				commit(con);
				isb=true;
			}else {
				rollback(con);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(con);
		}
		return isb;
	}

	public userinfo getAddress(String id) {
		Connection con=null;
		userinfo userinfo=null;
		try {
			ShoseDAO shoseDAO=ShoseDAO.getInstance();
			con=getConnection();
			shoseDAO.setConnection(con);
			userinfo=new userinfo();
			userinfo=shoseDAO.getAddress(id);			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(con);
		}
		return userinfo;
	}

	public void Calculate(String shonum) {
		Connection con=null;
		boolean calculate=false;
		try {
			con=getConnection();
			ShoseDAO shoesDAO=ShoseDAO.getInstance();
			shoesDAO.setConnection(con);
			calculate=shoesDAO.sellcalculate(shonum);
			if(calculate==true) {
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