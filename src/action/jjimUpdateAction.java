package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.jjimUpdateService;
import vo.ActionForward;
import vo.Mark;

public class jjimUpdateAction implements Action {


@Override
public ActionForward execute(HttpServletRequest request, 
		HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession(); // 세션아이디 가져오 ㅁ
		
		Mark mark = new Mark(); 
		String id= (String)session.getAttribute("id"); 
		mark.setModel(request.getParameter("model"));
		mark.setUserid(id); 

		jjimUpdateService jjimupdateservice = new jjimUpdateService();
		jjimupdateservice.getUpdateMark(mark);
		
		request.setAttribute("Mark", mark);
		ActionForward forward = new ActionForward("ShoesDetail.sho?model="+request.getParameter("model"), false);
		return forward;
	
	}
}