package svc;

import java.sql.Connection;
import static db.JdbcUtil.*;
import dao.MarkDAO;
import vo.Mark;

public class jjimDeleteService {


	public int getDeleteMark(Mark mark) throws Exception {
		int isDeleteSuccess = 0;
		Connection con = null;
		try 
		{
			con = getConnection();
			MarkDAO markDAO = MarkDAO.getInstance();
			markDAO.setConnection(con);
			isDeleteSuccess = markDAO.Deletejjim(mark);
			
			if (isDeleteSuccess > 0) 
			{
				commit(con);
			} else 
			{
				rollback(con);
			} 
		} catch (Exception e) 
		{
			e.printStackTrace();
			rollback(con);
		} finally {
			close(con);
		}
		return isDeleteSuccess;
	}
}
