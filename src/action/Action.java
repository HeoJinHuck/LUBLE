package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import vo.ActionForward;

public interface Action {
	ActionForward execute(HttpServletRequest request,
			HttpServletResponse response)
					throws Exception;
	
	// 데이터 전송 경로,방식  

}
