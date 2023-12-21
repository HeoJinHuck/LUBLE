package svc;

import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.MarkDAO;
import vo.Mark;

public class jjimUpdateService {
	
	

	public boolean getUpdateMark(Mark mark) throws Exception {
		Connection con=null;
		boolean isUpdateSuccess=false;
		try {			
			con = getConnection();
			MarkDAO markDAO = MarkDAO.getInstance();
			markDAO.setConnection(con);
			isUpdateSuccess = markDAO.Updatejjim(mark);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(con);
		} 
		return isUpdateSuccess;
	}
}
