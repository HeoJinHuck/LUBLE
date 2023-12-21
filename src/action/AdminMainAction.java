package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.AdminNumber1Service;
import vo.ActionForward;

public class AdminMainAction implements Action { // 관리자 외  아이디들이  권한없음 하는 액션 

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) 
			throws Exception {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		
		AdminNumber1Service adminNumber1Service = new AdminNumber1Service();

		ActionForward forward = null;
		if(id==null) 
		{
			 forward = new ActionForward("AdminLogin.jsp", false);
		}
		else 
		{
		
		String ShowDelivery = adminNumber1Service.ShowNumber1();
		String ShowCheck = adminNumber1Service.ShowNumber2();
		String ShowSelling = adminNumber1Service.ShowNumber3();
		String ShowReturn = adminNumber1Service.ShowNumber4();
		String email = adminNumber1Service.getEmail(id);
		
		request.setAttribute("delivery", ShowDelivery);
		request.setAttribute("check", ShowCheck);
		request.setAttribute("selling", ShowSelling);
		request.setAttribute("return", ShowReturn);
		request.setAttribute("email", email);
		request.setAttribute("id", id);
		
		forward = new ActionForward("AdminTest.jsp", false);
		}
		return forward;
	}
}
