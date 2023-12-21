package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.Position.Bias;

import svc.BidUpdateService;
import svc.SelectAddrService;
import svc.ShoesAdjustService;
import svc.ShoesMatchingService;
import svc.ShoseBuyService;
import vo.ActionForward;
import vo.ShoseInfo;
import vo.userinfo;

public class ShoesAdjustAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String shonum=request.getParameter("shonum");
		String price=request.getParameter("price");
		System.out.println(shonum);
		ShoesAdjustService svc=new ShoesAdjustService();
		int isadd=svc.adjustPrice(shonum,price);//가격수정		
		
		ShoseInfo shoesinfo =  new ShoseInfo();
		shoesinfo.setModel(request.getParameter("model"));
		shoesinfo.setPrice(Integer.parseInt(price));
		shoesinfo.setSize(request.getParameter("size"));
		
		ShoesMatchingService msvc= new ShoesMatchingService();
		userinfo biduser=new userinfo(); // 아이디 검색 
		biduser=msvc.RefreshShoes(shoesinfo);
		//id bidnum
		if(biduser.getId()!=null) {
			SelectAddrService addrservice=new SelectAddrService();
			String addr=addrservice.selecaddr(biduser.getId());
			ShoseBuyService bsvc=new ShoseBuyService(); //주소 받아서 구매 확정 
			boolean isdic=bsvc.BuyDicision(shonum, biduser.getId(), addr);
			
			if(isdic==true) {// ispurchase ='n' 으로 바꾸기  (팔렸다!)
				BidUpdateService upsvc=new BidUpdateService();
				int isup=upsvc.updateBid(biduser.getName());
			}
		}
		ActionForward forward=new ActionForward("index.jsp",false);
		return forward;
	}
}
