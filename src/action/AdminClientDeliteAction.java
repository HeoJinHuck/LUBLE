package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import svc.AdminMemberDeleteService;
import vo.ActionForward;

public class AdminClientDeliteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) 
			throws Exception {

		
			String id=request.getParameter("id");
			
			AdminMemberDeleteService adminMemberDeleteService = new AdminMemberDeleteService();
			adminMemberDeleteService.getDeleteAdminMember(id);

			
			ActionForward forward = new ActionForward("clientmember.ad",false);
			return forward;
	}

}
