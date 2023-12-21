package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import svc.SelectAddrService;
import vo.ActionForward;
import vo.ShoseInfo;

public class SelectAddrAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
			String id = (String) session.getAttribute("id");
			String sell = request.getParameter("sell");
			ShoseInfo shoesinfo = new ShoseInfo();
			shoesinfo.setShoImage(request.getParameter("shoeimage"));
			shoesinfo.setModel(request.getParameter("model"));
			shoesinfo.setSize(request.getParameter("size"));

			System.out.println(request.getParameter("price"));
			shoesinfo.setPrice(Integer.parseInt(request.getParameter("price")));
			request.setAttribute("shoesinfo", shoesinfo);

			SelectAddrService addrservice = new SelectAddrService();
			String addr = addrservice.selecaddr(id);
			request.setAttribute("sell", sell);
			request.setAttribute("addr", addr);
			ActionForward forward = new ActionForward("sellPage3.jsp", false);
		return forward;
	}

}
