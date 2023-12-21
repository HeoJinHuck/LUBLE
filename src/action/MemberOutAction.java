package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.MemberOutService;
import vo.ActionForward;

public class MemberOutAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String id= (String)session.getAttribute("id");
		MemberOutService memberOutService=new MemberOutService();
		int isOut=memberOutService.MemberOut(id);
		System.out.println(isOut);
		session.setAttribute("id", null);
		ActionForward forward=new ActionForward("index.jsp",true);
		return forward;
	}

}
