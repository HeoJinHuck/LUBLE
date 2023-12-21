package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.SelectShoesService;
import vo.ActionForward;
import vo.ShoseInfo;

public class SelectShoesAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String boc=request.getParameter("boc");
		String model=request.getParameter("model");
		String brand=request.getParameter("brand");
		String shoeimage=request.getParameter("shoeimage");
		String size=request.getParameter("size");
		SelectShoesService selecshoservice=new SelectShoesService();
		ShoseInfo shoesinfo=selecshoservice.selecsho(model,size, boc);
		shoesinfo.setBrand(brand);
		shoesinfo.setShoImage(shoeimage);
		request.setAttribute("shoesinfo", shoesinfo);
		ActionForward forward=new ActionForward();
		if(boc.equals("cell")) {
			forward= new ActionForward("sellPage1.jsp",false);
		}else if(boc.equals("buy")) {
			forward= new ActionForward("BuyPage1.jsp",false);
		}
		return forward;
	}

}
