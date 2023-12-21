package action;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.jjimDeleteService;
import svc.jjimListService;
import vo.ActionForward;
import vo.Mark;


public class jjimListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession(); // 세션 생성
		String id=(String)session.getAttribute("id"); //세션에 아이디 값 넣음 id값은 이제 계속 따라다님 (일정시간동안)
	 
		jjimListService jjimListService=new jjimListService();
		
		ArrayList<Mark> jjimList=new ArrayList<Mark>();
		jjimList = jjimListService.getjjimList(id);
		
		request.setAttribute("jjimList", jjimList);
		
		ActionForward forward = new ActionForward("jjim.jsp", false);
		return forward;
	}

}
