package action;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.AdminStatusList2Service;
import vo.ActionForward;
import vo.ShoseInfo;

public class AdminStatusList2Action implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		String grade = (String) session.getAttribute("grade");
		
		AdminStatusList2Service adminStatusList2Service = new AdminStatusList2Service();
		ArrayList<ShoseInfo> number2List = new ArrayList<ShoseInfo>();
		number2List = adminStatusList2Service.getNumber2();
		request.setAttribute("number2List", number2List);

		ActionForward forward = new ActionForward();
		if (grade.equals("관리자") || grade.equals("검수담당")) {
			forward = new ActionForward("AdminStatusList2.jsp", false);
		} else {
			response.setContentType("text/html;charset=euc-kr");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('권한이 없습니다.');");
			out.println("history.back()");
			out.println("</script>");
		}
		return forward;
	}

}
