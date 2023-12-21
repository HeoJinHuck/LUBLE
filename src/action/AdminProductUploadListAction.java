package action;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.AdminProductUploadListService;
import vo.ActionForward;
import vo.ShoseInfo;

public class AdminProductUploadListAction implements Action { // 제품 삭제 액션 

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String grade=(String)session.getAttribute("grade");
		String search=request.getParameter("search");
		
		AdminProductUploadListService adminProductUploadListService = new AdminProductUploadListService();
		ArrayList<ShoseInfo> UploadList = new ArrayList<>();
		UploadList=adminProductUploadListService.getUploadShoesList(search);
		request.setAttribute("UploadList",UploadList);
		
		ActionForward forward = new ActionForward();
		if(grade.equals("관리자")) {
			forward = new ActionForward("AdminProductUploadList.jsp",false);
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
