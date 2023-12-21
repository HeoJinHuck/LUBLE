package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.ShoseListService;
import vo.ActionForward;
import vo.ShoseInfo;

public class MainShoseListAction implements Action {
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ArrayList<ShoseInfo> articleList=new ArrayList<ShoseInfo>();
		ArrayList<ShoseInfo> tradelist=new ArrayList<ShoseInfo>();
		ShoseListService shoseListService=new ShoseListService();
		String search=request.getParameter("search");
		articleList=shoseListService.getArticleList(search);
		tradelist=shoseListService.getTradeList();
		
		request.setAttribute("tradeList", tradelist);
		request.setAttribute("articleList", articleList);
		ActionForward forward = new ActionForward("main.jsp", false);
		return forward;
	}
}