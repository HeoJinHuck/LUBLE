package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import svc.AdminUploadDeleteService;
import vo.ActionForward;

public class AdminProductDeliteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) 
			throws Exception {
			
			String model=request.getParameter("model");
			
			AdminUploadDeleteService adminUploadDeleteService = new AdminUploadDeleteService();
			adminUploadDeleteService.getDeleteShoes(model);
			
			ActionForward forward = new ActionForward("adminUploadList.ad",false);
			return forward;
	}

}
