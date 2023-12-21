package action;

import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import svc.MemberLoginService;
import vo.ActionForward;
import vo.userinfo;

public class MemberLoginAction implements Action{
	 public ActionForward execute(HttpServletRequest request,HttpServletResponse response) 
	 	throws Exception{
		 	HttpSession session = request.getSession();
	   		userinfo member=new userinfo();
	   		member.setId(request.getParameter("id"));
	   		member.setPass(request.getParameter("pass"));
	   		
	   		MemberLoginService memberLoginService = new MemberLoginService();
	   		
	   		boolean loginResult = memberLoginService.login(member); // 아이디 비번 비교 
	   		
	   		ActionForward forward = null;
	   		if(loginResult==false) {
	   			response.setContentType("text/html;charset=euc-kr");
		   		PrintWriter out=response.getWriter();
		   		out.println("<script>");
		   		out.println("alert('로그인 실패');");
		   		out.println("history.back()");
		   		out.println("</script>");
	   		}else{
	   			session.setAttribute("id", request.getParameter("id"));
	   			String id=(String)session.getAttribute("id");
	   			System.out.println(id);
		   	    forward = new ActionForward(); 
		   		forward.setRedirect(false);
		   		forward.setPath("MainShoesList.sho");
		   		}
	   		return forward;
	}
}