package action;

import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.MemberModifyService;
import vo.ActionForward;
import vo.userinfo;

public class MemberModifyAction implements Action {
	ActionForward forward = null;
	boolean isModifySuccess=false;
	
	@Override
	public ActionForward execute(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();	
		String id= (String)session.getAttribute("id"); 
		try {
			
		
		userinfo loginmodify = new userinfo();
		loginmodify.setPass(request.getParameter("pass"));
		loginmodify.setEmail(request.getParameter("email"));
		loginmodify.setId(id);
		MemberModifyService memberModifyService = new MemberModifyService();
		isModifySuccess = memberModifyService.MemberLogin(loginmodify);
		
		
		if(!isModifySuccess) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('수정 실패')");
			out.println("history.back()");
			out.println("</script>");
		} else {
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("mypage.jsp");
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return forward;
	}

}
