package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.MyBuyShoesListService;
import svc.MyUploadShoesListService;
import vo.ActionForward;
import vo.ShoseInfo;

public class MyBuyShoesListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ArrayList<ShoseInfo> MyBuyShoesSuccess = new ArrayList<ShoseInfo>();

		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		
		
		MyBuyShoesListService myBuyShoesListService = new MyBuyShoesListService();

		MyBuyShoesSuccess = myBuyShoesListService.getMyBuyShoes(id);

		request.setAttribute("buylist", MyBuyShoesSuccess);
		
		ActionForward forward = new ActionForward("MyBuyShoes.jsp", false);
		return forward;
	}

}
