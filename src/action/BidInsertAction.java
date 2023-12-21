package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.ShoesBidService;
import vo.ActionForward;
import vo.ShoseInfo;

public class BidInsertAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session=request.getSession();
		String id= (String)session.getAttribute("id");
		String model=request.getParameter("model");
		ShoseInfo shoesinfo=new ShoseInfo();
		shoesinfo.setModel(model);
		shoesinfo.setSize(request.getParameter("size"));
		shoesinfo.setPrice(Integer.parseInt(request.getParameter("price")));
		
		ShoesBidService shoesbid=new ShoesBidService();
		int isbid=shoesbid.insertBid(shoesinfo,id);
		ActionForward forward=new ActionForward();
		if(isbid>0) {
			forward=new ActionForward("alram.jsp?bs=1",false);
		}
		return forward;
	}

}
