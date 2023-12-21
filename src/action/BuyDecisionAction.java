package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.ShoseBuyService;
import vo.ActionForward;
import vo.ShoseInfo;

public class BuyDecisionAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String id=(String)session.getAttribute("id");
		String shonum=request.getParameter("shonum");
		String addr=request.getParameter("addr");
		System.out.println(shonum+","+addr);
		ShoseBuyService shoseBuyService = new ShoseBuyService();
		boolean isB=shoseBuyService.BuyDicision(shonum, id, addr);
		System.out.println(isB);
		shoseBuyService.Calculate(shonum);
		ActionForward forward = new ActionForward();
		if(isB==true) {
			forward = new ActionForward("alram.jsp?bs=0", true);
		}		
		return forward;
	}
}
