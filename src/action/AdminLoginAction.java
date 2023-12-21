package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.AdminLoginService;
import vo.ActionForward;
import vo.ManagerInfo;

public class AdminLoginAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) 
			throws Exception {
		
		HttpSession session = request.getSession();
		
		ManagerInfo adminmember = new ManagerInfo();
		adminmember.setId(request.getParameter("id"));
		adminmember.setPass(request.getParameter("pass"));
		System.out.println();
		AdminLoginService adminLoginService = new AdminLoginService();
		String adminloginResult =adminLoginService.Adminlogin(adminmember);
				
		ActionForward forward = null;
		if(adminloginResult==null) {
   			response.setContentType("text/html;charset=euc-kr");
	   		PrintWriter out=response.getWriter();
	   		out.println("<script>");
	   		out.println("alert('아이디 또는 비밀번호가 틀렸습니다.');");
	   		out.println("history.back()");
	   		out.println("</script>");
   		}else{
   			session.setAttribute("id", request.getParameter("id"));
   			session.setAttribute("grade", adminloginResult);
	   	    forward = new ActionForward(); 
	   		forward.setRedirect(false);
	   		forward.setPath("AdminMain.ad");
	   		}
		return forward;
	}

}
