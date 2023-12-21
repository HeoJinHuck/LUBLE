package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.ShoseListService;
import vo.ActionForward;
import vo.ShoseInfo;

public class ShoseListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ArrayList<ShoseInfo> articleList=new ArrayList<ShoseInfo>();		
		ShoseListService shoseListService=new ShoseListService();
		String search=request.getParameter("search");
		articleList=shoseListService.getArticleList(search);
		request.setAttribute("articleList", articleList);
		ActionForward forward = new ActionForward("ShoesList.jsp", false);
		return forward;
	}

}
