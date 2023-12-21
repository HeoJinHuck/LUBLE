package action;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.AdminStatusList3Service;
import vo.ActionForward;
import vo.ShoseInfo;

public class AdminStatusList3Action implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String grade=(String)session.getAttribute("grade");
		AdminStatusList3Service adminStatusList3Service = new AdminStatusList3Service();
		ArrayList<ShoseInfo> number3List=new ArrayList<ShoseInfo>();
		number3List = adminStatusList3Service.getNumber3();
		
		ActionForward forward = new ActionForward();
		request.setAttribute("number3List",number3List);
		if(grade.equals("관리자")) {
		 forward = new ActionForward("AdminStatusList3.jsp",false);
			
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

