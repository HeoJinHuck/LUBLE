package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.ShoesDetailService;
import svc.ShoesViewService;
import svc.jjimUpdateService;
import vo.ActionForward;
import vo.Mark;
import vo.ShoseInfo;

public class ShoseDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		
		String model=request.getParameter("model");
		String id=(String)session.getAttribute("id");
		
		ShoseInfo shoesinfo=new ShoseInfo();
		ShoesDetailService shoesDetailService=new ShoesDetailService();
		shoesinfo=shoesDetailService.getShoesInfo(model);
		
		Mark mark=new Mark();
		
		ShoesViewService shoesviewservice=new ShoesViewService();
		shoesviewservice.updateview(model);
		
		mark.setUserid(id);
		mark.setModel(model);
		
		jjimUpdateService jjimupdateservice = new jjimUpdateService();
		boolean isUpdateSuccess=jjimupdateservice.getUpdateMark(mark);
		
		request.setAttribute("ShoesInfo", shoesinfo);
		request.setAttribute("jung", isUpdateSuccess);
	
		ActionForward forward=new ActionForward("productpage.jsp",false);
		return forward;
	}
}
