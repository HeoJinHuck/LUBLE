package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import svc.AdminStatusUpdate24Service;
import vo.ActionForward;

public class AdminStatusUpdate24Action implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) 
			throws Exception {

		
			String shonum=request.getParameter("shonum");
			System.out.println(shonum);
			AdminStatusUpdate24Service adminUpdate24= new AdminStatusUpdate24Service();
			adminUpdate24.AdminNumber4(shonum);

			request.setAttribute("adminUpdate24", adminUpdate24);
			
			ActionForward forward = new ActionForward("adminStatusList2.ad",false);
			return forward;
	}

}
