package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.ShoesSearchService;
import vo.ActionForward;
import vo.ShoseInfo;

public class ShoseSearchAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ArrayList<ShoseInfo> articleList=new ArrayList<ShoseInfo>();
		ArrayList<String> kindlist=new ArrayList<String>();		
		
		String search=request.getParameter("search");	
		String trade= request.getParameter("trade");
		String[] seleckind=request.getParameterValues("kind");
		
		ShoesSearchService searchservice=new ShoesSearchService();
		articleList=searchservice.getSearchList(search, trade, seleckind);
		kindlist=searchservice.getKindList();
		
		request.setAttribute("seleckind",seleckind);
		request.setAttribute("articleList", articleList);
		if(search!=null) {
			request.setAttribute("search", search);
		}	
		request.setAttribute("kindlist", kindlist);
		ActionForward forward = new ActionForward("ShoesListTest.jsp",false);
		return forward;
	}

}
