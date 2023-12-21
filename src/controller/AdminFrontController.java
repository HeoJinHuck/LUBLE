package controller;

import java.io.IOException;   // 12-14 수정 복붙

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.AdminClientDeliteAction;
import action.AdminClientListAction;
import action.AdminInventoryAction;
import action.AdminJoinAction;
import action.AdminLogOutAction;
import action.AdminLoginAction;
import action.AdminMainAction;
import action.AdminProductDeliteAction;
import action.AdminProductUploadAction;
import action.AdminProductUploadListAction;
import action.AdminRevenueAction;
import action.AdminSizeInventoryAction;
import action.AdminStatusList1Action;
import action.AdminStatusList2Action;
import action.AdminStatusList3Action;
import action.AdminStatusList4Action;
import action.AdminStatusUpdate12Action;
import action.AdminStatusUpdate23Action;
import action.AdminStatusUpdate24Action;
import vo.ActionForward;

@WebServlet("*.ad")
public class AdminFrontController extends javax.servlet.http.HttpServlet {
	static final long serialVersionUID = 1L;

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String RequestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = RequestURI.substring(contextPath.length());
		ActionForward forward = null;
		Action action = null;
		
			if (command.equals("/AdminMain.ad")) {
				action = new AdminMainAction();
				try {
					forward = action.execute(request, response);
				} catch (Exception e) {
					e.printStackTrace();
				}
		
			} 
		
		else if (command.equals("/adminmember.ad")) {
				action = new AdminJoinAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} 
		
		
		else if (command.equals("/adminLogin.ad")) {
			action = new AdminLoginAction();
		try {
			forward = action.execute(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	} 
		else if (command.equals("/adminLogOut.ad")) {
			action = new AdminLogOutAction();
		try {
			forward = action.execute(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	} 
		
		else if (command.equals("/clientmember.ad")) {
			action = new AdminClientListAction();
		try {
			forward = action.execute(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	} 
		
		else if (command.equals("/clientDelite.ad")) {
			action = new AdminClientDeliteAction();
		try {
			forward = action.execute(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	} 
								
		else if (command.equals("/admininventory.ad")) {
			action = new AdminInventoryAction();
		try {
			forward = action.execute(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	} 							
		else if (command.equals("/admininventorysize.ad")) {
			System.out.println("인벤토리 사이즈");
			action = new AdminSizeInventoryAction();
		try {
			forward = action.execute(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	} 
		
		else if (command.equals("/adminStatusList1.ad")) {
			System.out.println("검수 1번 리스트 출력 ");
			action = new AdminStatusList1Action();
		try {
			forward = action.execute(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
		else if (command.equals("/adminStatusList2.ad")) {
			action = new AdminStatusList2Action();
			System.out.println("검수2번 리스트출력 ");
		try {
			forward = action.execute(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
		else if (command.equals("/adminStatusList3.ad")) {
			action = new AdminStatusList3Action();
			System.out.println("검수3번 리스트출력 ");
		try {
			forward = action.execute(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}							
		else if (command.equals("/adminStatusList4.ad")) {
			action = new AdminStatusList4Action();
			System.out.println("검수4번 리스트출력 ");
		try {
			forward = action.execute(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
		
		else if (command.equals("/adminStatusUpdate12.ad")) {
			action = new AdminStatusUpdate12Action();
			System.out.println("1->2");
		try {
			forward = action.execute(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
		
		
		else if (command.equals("/adminStatusUpdate23.ad")) {
			action = new AdminStatusUpdate23Action();
			System.out.println("2->3");
		try {
			forward = action.execute(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
		
		else if (command.equals("/adminStatusUpdate24.ad")) {
			action = new AdminStatusUpdate24Action();
			System.out.println("2->4");
		try {
			forward = action.execute(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
		else if (command.equals("/adminrevenue.ad")) {
			action = new AdminRevenueAction();
			System.out.println("수익");
		try {
			forward = action.execute(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
		else if (command.equals("/adminProudctUpload.ad")) { // (12-14)수정
			action = new AdminProductUploadAction();
			try {
				forward=action.execute(request, response);
			} catch (Exception e) {
			e.printStackTrace();
		}
		
	}							 
		else if (command.equals("/adminUploadList.ad")) {
			action = new AdminProductUploadListAction();
			try {
				forward=action.execute(request, response);
			} catch (Exception e) {
			e.printStackTrace();
		}
		
	}									
		else if (command.equals("/adminUploadDelete.ad")) {
			action = new AdminProductDeliteAction();
			try {
				forward=action.execute(request, response);
			} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
		
		if (forward != null) {
			if (forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doProcess(request, response);
	}
}