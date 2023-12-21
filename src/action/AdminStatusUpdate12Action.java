package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import svc.AdminStatusUpdate12Service;
import vo.ActionForward;

public class AdminStatusUpdate12Action implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) 
			throws Exception {

		
			String shonum=request.getParameter("shonum");
			System.out.println(shonum);
			AdminStatusUpdate12Service adminCheckBox2= new AdminStatusUpdate12Service();
			adminCheckBox2.AdminNumber2(shonum);

			request.setAttribute("adminCheckBox2", adminCheckBox2);
			
			ActionForward forward = new ActionForward("adminStatusList1.ad",false);
			return forward;
	}

}
