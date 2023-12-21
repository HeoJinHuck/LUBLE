package action;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.AdminClientListService;
import vo.ActionForward;
import vo.userinfo;

public class AdminClientListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) 
			throws Exception {
		
		HttpSession session = request.getSession(); // 세션 생성
		String grade=(String)session.getAttribute("grade");
		String search=request.getParameter("search");
		
		AdminClientListService adminClientService = new AdminClientListService();		
		ArrayList<userinfo> userList=new ArrayList<userinfo>();
		userList = adminClientService.getuserList(search);	
		request.setAttribute("userList", userList);
		
		ActionForward forward = new ActionForward();
		if(grade.equals("관리자")) {
			forward = new ActionForward("AdminMemberList.jsp",false);
   		}else{
   			response.setContentType("text/html;charset=euc-kr");
	   		PrintWriter out=response.getWriter();
	   		out.println("<script>");
	   		out.println("alert('권한이 없습니다.');");
	   		out.println("history.back()");
	   		out.println("</script>"); 	     
	   	}		
		return forward;
	}
}
