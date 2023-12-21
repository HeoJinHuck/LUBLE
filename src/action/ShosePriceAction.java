package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.ShoesPriceService;
import vo.ActionForward;
import vo.ShoseInfo;

public class ShosePriceAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		boolean buyorcell=false;
		String model=request.getParameter("model");
		ArrayList<ShoseInfo> shoesList=new ArrayList<ShoseInfo>();
		ShoesPriceService shoepriceservice=new ShoesPriceService();
		//shoesList=shoepriceservice.getShoesPrice(model, buyorcell);
		request.setAttribute("shoeslist", shoesList);
		ActionForward forward=new ActionForward("ChooseSize.jsp?model="+model,false);
		return forward;
	}

}
