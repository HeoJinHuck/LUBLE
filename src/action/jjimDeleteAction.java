package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import svc.jjimDeleteService;
import vo.ActionForward;
import vo.Mark;

public class jjimDeleteAction implements Action {


@Override
public ActionForward execute(HttpServletRequest request, 
		HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		Mark mark = new Mark(); 
		String id= (String)session.getAttribute("id");
		String model=request.getParameter("model");
		mark.setModel(model);
		String pro=request.getParameter("page");
		mark.setUserid(id); 
		
		jjimDeleteService jjimdelteservice = new jjimDeleteService();
		jjimdelteservice.getDeleteMark(mark);
		
		ActionForward forward = new ActionForward();
		if(pro!=null) {
			forward = new ActionForward("ShoesDetail.sho?model="+model,false);
		}else {
			forward = new ActionForward("myjjimList.my",false);
		}
		return forward;
	}
}