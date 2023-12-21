package svc;

import java.sql.Connection;

import dao.AdminDAO;

import static db.JdbcUtil.*;

public class DeliveryManagerService {

	Connection con = null;

	public int getUpdateDelivery(String id) throws Exception {
		int DeliverySuccess = 0;
		try 
		{
			Connection con = getConnection();
			AdminDAO adminDAO = AdminDAO.getInstance();
			adminDAO.setConnection(con);
			DeliverySuccess = adminDAO.DeliveryUpdate(id);
			
			if (DeliverySuccess > 0) 
			{
				commit(con);
			} else 
			{
				rollback(con);
			} 
		} catch (Exception e) 
		{
			e.printStackTrace();
			con.rollback();
		} 
		return DeliverySuccess;
	}
}
