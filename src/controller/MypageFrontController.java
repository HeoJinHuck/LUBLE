package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.MyBuyShoesListAction;
import action.MyUploadShoesListAction;
import action.jjimDeleteAction;
import action.jjimInsertAction;
import action.jjimListAction;
import action.myPageAction;
import vo.ActionForward;

@WebServlet("*.my")
public class MypageFrontController extends HttpServlet{
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
			
							
			if(command.equals("/myjjim.my")) {
				action = new jjimInsertAction();
				try {
					forward = action.execute(request, response);
				} catch (Exception e) {
					e.printStackTrace();
				}			
			}
				else if(command.equals("/myjjimList.my")) {
				System.out.println("마이찜리스트 컨트롤러");
				action = new jjimListAction();
				try {
					forward = action.execute(request, response);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
				else if(command.equals("/mybuyList.my")) {
					
					action = new MyBuyShoesListAction();
					try {
						forward = action.execute(request, response);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				else if(command.equals("/mysellList.my")) {
					
					action = new MyUploadShoesListAction();
					try {
						forward = action.execute(request, response);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				else if(command.equals("/myupdateList.my")) {
			
					action = new jjimListAction();
					try {
						forward = action.execute(request, response);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				else if(command.equals("/mydeleteList.my")) {
					
					action = new jjimDeleteAction();
					try {
						forward = action.execute(request, response);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				else if(command.equals("/myPage.my")) {
					
					action = new myPageAction();
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
					RequestDispatcher dispatcher = request.
							getRequestDispatcher(forward.getPath());
					dispatcher.forward(request, response);
				}
			}
		}

	}
