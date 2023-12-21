package svc;


import static db.JdbcUtil.*;
import java.sql.Connection;
import java.util.ArrayList;
import dao.MarkDAO;
import vo.Mark;

public class jjimListService {
	
	public ArrayList<Mark> getjjimList(String id) throws Exception {
		ArrayList<Mark> isjjimListSuccess = null;
		Connection con = null;
		try 
		{
		con=getConnection();
		MarkDAO markDAO=MarkDAO.getInstance();
		markDAO.setConnection(con);
		isjjimListSuccess=markDAO.selectjjim(id);
		}
		catch(Exception e) 
		{
		 e.printStackTrace();	
		}finally {
			close(con);
		}
	
		return isjjimListSuccess; 
	}
}
