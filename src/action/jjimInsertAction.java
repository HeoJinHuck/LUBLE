package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.jjimInsertService;
import vo.ActionForward;
import vo.Mark;

public class jjimInsertAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
	
		HttpSession session = request.getSession();
		Mark mark = new Mark(); 
		String id= (String)session.getAttribute("id"); 
		mark.setModel(request.getParameter("model"));
		mark.setUserid(id); 

		jjimInsertService jjiminsertService = new jjimInsertService();
		jjiminsertService.InsertMark(mark);
		
	
		ActionForward forward = new ActionForward("ShoesDetail.sho?model="+request.getParameter("model"), false);
		return forward;
	}

}
