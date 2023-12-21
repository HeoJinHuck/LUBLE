package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.ShoesPriceService;
import vo.ActionForward;
import vo.ShoseInfo;

public class BShosePriceAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String buyorcell=request.getParameter("boc");
		String model=request.getParameter("model");
		String shoeimage=request.getParameter("shoeimage");
		System.out.println(shoeimage+"chooseSize");
		ArrayList<ShoseInfo> shoesList=new ArrayList<ShoseInfo>();
		ShoesPriceService shoepriceservice=new ShoesPriceService();
		shoesList=shoepriceservice.getShoesPrice(model, buyorcell);
		request.setAttribute("shoeslist", shoesList);
		request.setAttribute("shoeimage", shoeimage);
		ActionForward forward=new ActionForward();
		if(buyorcell.equals("buy")) {
			forward=new ActionForward("BuyChooseSize.jsp",false);
		}else if(buyorcell.equals("cell")) {
			forward=new ActionForward("ChooseSize.jsp",false);
		}
		return forward;
	}
}
