package action;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.AdminInventorySerivce;
import vo.ActionForward;
import vo.ShoseInfo;

public class AdminInventoryAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		String grade=(String)session.getAttribute("grade");
		String search=request.getParameter("search");
		System.out.println(search);
		
		AdminInventorySerivce adminInventoryService = new AdminInventorySerivce();
		ArrayList<ShoseInfo> inventory = new ArrayList<ShoseInfo>();
		inventory = adminInventoryService.getAllInventory(search);
		request.setAttribute("inventory", inventory);
		
		ActionForward forward =new ActionForward();
		if(grade.equals("관리자")) {
			forward = new ActionForward("AdminInventory.jsp",false);
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
