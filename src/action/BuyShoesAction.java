package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.ShoseBuyService;
import svc.ShoseUploadService;
import vo.ActionForward;
import vo.ShoseInfo;
import vo.userinfo;

public class BuyShoesAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ShoseInfo shoseInfo = new ShoseInfo();
		userinfo userinfo=new userinfo();
		HttpSession session= request.getSession();
		String id=(String)session.getAttribute("id");
		int checkprice=Integer.parseInt(request.getParameter("checkprice"));
		int price=Integer.parseInt(request.getParameter("price"));
		
		shoseInfo.setUserid(id);
		shoseInfo.setModel(request.getParameter("model"));
		shoseInfo.setPrice(price-checkprice);
		shoseInfo.setSize(request.getParameter("size"));
		shoseInfo.setShoImage(request.getParameter("shoeimage"));
		shoseInfo.setCheckprice(checkprice);
		
		ShoseBuyService shoseBuyService = new ShoseBuyService();
		
		String ShoesNum=shoseBuyService.BuyShose(shoseInfo);
		shoseInfo.setShonum(ShoesNum);
		
		userinfo=shoseBuyService.getAddress(id);		
		System.out.println(userinfo.getAddress());
		
		request.setAttribute("shoesinfo", shoseInfo);
		request.setAttribute("userinfo", userinfo);
		ActionForward forward = new ActionForward("BuyPage3.jsp", false);
		return forward;
	}
}
