package action;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import svc.AdminJoinService;
import vo.ActionForward;
import vo.ManagerInfo;

public class AdminJoinAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) 
	throws Exception {
		
		ManagerInfo managermember = new ManagerInfo();
		boolean joinResult=false;
	
		managermember.setId(request.getParameter("id"));
		managermember.setPass(request.getParameter("pass"));
		managermember.setAddress(request.getParameter("address"));
		managermember.setEmail(request.getParameter("email"));
		managermember.setGrade(request.getParameter("grade"));
		
		AdminJoinService adminMemberService = new AdminJoinService();
		joinResult=adminMemberService.AdminjoinMember(managermember);
		
		request.setAttribute("grade",joinResult);
		ActionForward forward = null;
		if(joinResult==false){
   			response.setContentType("text/html;charset=UTF-8");
   			PrintWriter out = response.getWriter();
   			out.println("<script>");
   			out.println("alert('회원가입이 실패! 아이디 또는 비밀번호를 수정하세요!')");
   			out.println("history.back()");
   			out.println("</script>");
	   	}
   		else{
   	    forward = new ActionForward(); 
   		forward.setRedirect(true);
   		forward.setPath("AdminHeader.jsp");
   		}
   		return forward;
	}
}