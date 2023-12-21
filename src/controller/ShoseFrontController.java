package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import action.Action;
import action.BShosePriceAction;
import action.BidInsertAction;
import action.BuyDecisionAction;
import action.BuyShoesAction;
import action.MainShoseListAction;
import action.SelectShoesAction;
import action.ShoesAdjustAction;
import action.ShoseDetailAction;
import action.ShoseListAction;
import action.ShosePriceAction;
import action.ShoseSearchAction;
import action.ShoseUploadAction;
import vo.ActionForward;

@WebServlet("*.sho")
public class ShoseFrontController extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) 
	throws ServletException, IOException{
		doProcess(request, response);
	}
	
	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response)
	throws ServletException, IOException{
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, 
			HttpServletResponse response) 
	throws ServletException, IOException{
		request.setCharacterEncoding("utf-8");
		
		String requestURI = request.getRequestURI();
		
		String contextPath = request.getContextPath();
			
		
		String command = requestURI.substring(contextPath.length());
		Action action = null;
		ActionForward forward = null;
		System.out.println(command);
		if(command.equals("/UploadSho.sho")) {
			action = new ShoseUploadAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}			
		}else if(command.equals("/MainShoesList.sho")) {
			action = new MainShoseListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/ShoSearch.sho")) {
			action = new ShoseSearchAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/ShoesList.sho")) {
			action = new ShoseListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/ShoesDetail.sho")) {
			action = new ShoseDetailAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/SizePrice.sho")) {
			action = new ShosePriceAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/BSizePrice.sho")) {
			action = new BShosePriceAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/BuySho.sho")) {
			action = new BuyShoesAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/decision.sho")) {
			action = new BuyDecisionAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/SelecShoes.sho")) {
			action = new SelectShoesAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/BuyBidSho.sho")) {
			action = new BidInsertAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/adjustsho.sho")) {
			action = new ShoesAdjustAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		
		//포워딩
		if(forward != null) {
			if(forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			}else {
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		}
	}

}
