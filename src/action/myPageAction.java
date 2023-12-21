package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.MyPageService;
import vo.ActionForward;

public class myPageAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session=request.getSession();
		String id=(String)session.getAttribute("id");
		int sell[]=new int[5];
		int order[]=new int[3];
		MyPageService mypageservice=new MyPageService();
		
		order=mypageservice.getOrder(id);
		sell=mypageservice.getSell(id);
		String email=mypageservice.getEmail(id);
		
		request.setAttribute("buy", order);
		request.setAttribute("sell", sell);
		request.setAttribute("email", email);
		request.setAttribute("id", id);
		ActionForward forward=new ActionForward("mypageTest.jsp",false);
		return forward;
	}

}
