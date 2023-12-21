package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.MyUploadShoesListService;
import vo.ActionForward;
import vo.ShoseInfo;

public class MyUploadShoesListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {

		ArrayList<ShoseInfo> MyUploadShoesSuccess = new ArrayList<ShoseInfo>();

		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		String sell=request.getParameter("sell");
		MyUploadShoesListService myUploadShoesListService = new MyUploadShoesListService();

		MyUploadShoesSuccess = myUploadShoesListService.getMyUploadShoes(id);

		request.setAttribute("myUploadShoes",MyUploadShoesSuccess);
		System.out.println(sell);
		ActionForward forward = new ActionForward();
		if(sell.equals("yes")) {
			forward = new ActionForward("mySellShoes.jsp", false);
		}else if(sell.equals("no")) {
			forward = new ActionForward("myUploadShose.jsp", false);
		}
		
		return forward;
	}

}
