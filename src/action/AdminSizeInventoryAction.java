package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import svc.AdminSizeInventorySerivce;
import vo.ActionForward;
import vo.ShoseInfo;

public class AdminSizeInventoryAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		AdminSizeInventorySerivce adminSizeInventoryService = new AdminSizeInventorySerivce();
		String model=request.getParameter("model");
		ArrayList<ShoseInfo> sizeinventory = new ArrayList<ShoseInfo>();
		sizeinventory = adminSizeInventoryService.getAllInventory(model);	
		request.setAttribute("sizeinventory", sizeinventory);
		ActionForward forward =new ActionForward("AdminSizeInventory.jsp",false);
		return forward;
	}

}
