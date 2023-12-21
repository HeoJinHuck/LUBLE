package action;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.AdminStatusList1Service;
import vo.ActionForward;
import vo.ShoseInfo;

public class AdminStatusList1Action implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) 
			throws Exception {
	
		
		AdminStatusList1Service adminCheckBoxService = new AdminStatusList1Service();

		
		ArrayList<ShoseInfo> number1List=new ArrayList<ShoseInfo>();
		number1List = adminCheckBoxService.getNumber1();
		HttpSession session=request.getSession();
		String grade=(String)session.getAttribute("grade");
		
		request.setAttribute("number1List", number1List);
		System.out.println(grade);
		ActionForward forward=new ActionForward();
		if(grade.equals("관리자")||grade.equals("배송담당")) {
			forward = new ActionForward("AdminStatusList1.jsp",false);
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
