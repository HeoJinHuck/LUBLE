package action;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.AdminStatusList4Service;
import vo.ActionForward;
import vo.ShoseInfo;

public class AdminStatusList4Action implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String grade=(String)session.getAttribute("grade");
		AdminStatusList4Service adminStatusList4Service = new AdminStatusList4Service();
		
		ArrayList<ShoseInfo> number4List=new ArrayList<ShoseInfo>();
		number4List = adminStatusList4Service.getNumber4();
		
		ActionForward forward = new ActionForward();
		request.setAttribute("number4List",number4List);
		if(grade.equals("관리자")) {
			forward = new ActionForward("AdminStatusList4.jsp",false);
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
