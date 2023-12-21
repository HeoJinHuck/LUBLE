package action;

import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import svc.MemberJoinService;
import vo.ActionForward;
import vo.userinfo;

public class MemberJoinAction implements Action{
	 public ActionForward execute(HttpServletRequest request,HttpServletResponse response) 
	 	throws Exception{
		 	
		 userinfo member=new userinfo();
	   		boolean joinResult=false;
	   		
	   		member.setId(request.getParameter("id"));
	   		member.setPass(request.getParameter("pass"));
	   		member.setAddress(request.getParameter("addr"));
	   		member.setName(request.getParameter("name"));
	   		member.setEmail(request.getParameter("email"));
	   		
	   		MemberJoinService memberJoinService = new MemberJoinService();
	   		joinResult=memberJoinService.joinMember(member);
	   		
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
	   		forward.setPath("login.jsp");
	   		}
	   		return forward;
	}
}