package svc;

import java.sql.Connection;

import dao.MarkDAO;
import vo.Mark;
import static db.JdbcUtil.*;

public class jjimInsertService {

	

	public boolean InsertMark(Mark mark) 
	{
		Connection con = null;
		boolean isInsertSuccess = false;
		try 
		{
			con = getConnection();
			MarkDAO markDAO = MarkDAO.getInstance();
			markDAO.setConnection(con);
			int insertCount = markDAO.insertjjim(mark);

			if (insertCount > 0) 
			{
				commit(con);
			} else 
			{
				rollback(con);
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return isInsertSuccess;
	}
}
