package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import svc.AdminStatusUpdate12Service;
import svc.AdminStatusUpdate23Service;
import svc.BidUpdateService;
import svc.SelectAddrService;
import svc.ShoesMatchingService;
import svc.ShoseBuyService;
import vo.ActionForward;
import vo.ShoseInfo;
import vo.userinfo;

public class AdminStatusUpdate23Action implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) 
			throws Exception {

		
			String shonum=request.getParameter("shonum");
			
			System.out.println(shonum);
			AdminStatusUpdate23Service adminUpdate23= new AdminStatusUpdate23Service();
			adminUpdate23.AdminNumber3(shonum);
			
			ShoseInfo shoesinfo =  new ShoseInfo();
			shoesinfo.setModel(request.getParameter("model"));
			shoesinfo.setPrice(Integer.parseInt(request.getParameter("price")));
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
			
			request.setAttribute("adminUpdate23", adminUpdate23);
			
			ActionForward forward = new ActionForward("adminStatusList2.ad",false);
			return forward;
	}

}
