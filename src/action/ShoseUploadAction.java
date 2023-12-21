package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.ShoseUploadService;
import vo.ActionForward;
import vo.ShoseInfo;

public class ShoseUploadAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ShoseInfo shoseInfo = new ShoseInfo();
		HttpSession session= request.getSession();
		
		String sell=request.getParameter("sell");
		shoseInfo.setUserid((String)session.getAttribute("id"));
		shoseInfo.setModel(request.getParameter("model"));
		shoseInfo.setPrice(Integer.parseInt(request.getParameter("price")));
		shoseInfo.setSize(request.getParameter("size"));
		
		ShoseUploadService shoseUploadService = new ShoseUploadService();
		boolean isUp=shoseUploadService.UploadShose(shoseInfo, sell);
		ActionForward forward = new ActionForward();
		if(isUp==true) {
			forward=new ActionForward("alram.jsp?bs=2",false);
		}
		return forward;
	}
}