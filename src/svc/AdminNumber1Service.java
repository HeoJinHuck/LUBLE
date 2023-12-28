package svc;

// 12-13 수정 전체 복사  (내용 : 관리자가 아닌경우 다른 카테고리  권한 금지 주는 서비스 )

import java.sql.Connection;
import static db.JdbcUtil.*;
import dao.AdminDAO;
public class AdminNumber1Service {

	
	public String ShowNumber1() throws Exception {
		Connection con = null;

		String ShowDelivery = null;
		try {
			con = getConnection();
			AdminDAO adminDAO = AdminDAO.getInstance();
			adminDAO.setConnection(con);
			ShowDelivery = adminDAO.ShowNumber1();

		} catch (Exception e) {
			e.printStackTrace();
			rollback(con);
		} finally {
			close(con);
		}
		return ShowDelivery;
	}
	
		public String ShowNumber2() throws Exception {
			String ShowCheck = null;
			Connection con=null;
			try {
				con = getConnection();
				AdminDAO adminDAO = AdminDAO.getInstance();
				adminDAO.setConnection(con);
				ShowCheck = adminDAO.ShowNumber2();

			} catch (Exception e) {
				e.printStackTrace();
				rollback(con);
			} finally {
				close(con);
			}
			return ShowCheck;
		}

			public String ShowNumber3() throws Exception {
				Connection con=null;
				String ShowSelling = null;
				try {
					con = getConnection();
					AdminDAO adminDAO = AdminDAO.getInstance();
					adminDAO.setConnection(con);
					ShowSelling = adminDAO.ShowNumber3();

				} catch (Exception e) {
					e.printStackTrace();
					rollback(con);
				} finally {
					close(con);
				}
				return ShowSelling;
			}
			

			public String ShowNumber4() throws Exception {
				String ShowReturn = null;
				Connection con=null;
				try {
					con = getConnection();
					AdminDAO adminDAO = AdminDAO.getInstance();
					adminDAO.setConnection(con);
					ShowReturn = adminDAO.ShowNumber4();
					
				} catch (Exception e) {
					e.printStackTrace();
					rollback(con);
				} finally {
					close(con);
				}
				return ShowReturn;
			}

	public String getAdminEmail(String id) {
		Connection con=null;
		String email = null;
		try {
			con = getConnection();
			AdminDAO adminDAO = AdminDAO.getInstance();
			adminDAO.setConnection(con);
			email = adminDAO.getAdminEmail(id);

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(con);
		}
		return email;
	}
}

