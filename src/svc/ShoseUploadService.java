package svc;

import java.sql.Connection;

import dao.ShoseDAO;
import vo.ShoseInfo;
import static db.JdbcUtil.*;
public class ShoseUploadService {

	public boolean UploadShose(ShoseInfo shoseInfo, String sell) {
		Connection con=null;
		boolean isUploadSuccess=false;
		try {
			ShoseDAO shoseDAO=ShoseDAO.getInstance();
			con=getConnection();
			shoseDAO.setConnection(con);			
			int UploadCount=shoseDAO.uploadShose(shoseInfo, sell);
			if(UploadCount>0) {
				commit(con);
				isUploadSuccess=true;
			}else {
				rollback(con);
				isUploadSuccess=false;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(con);
		}
		return isUploadSuccess;
	}
}
