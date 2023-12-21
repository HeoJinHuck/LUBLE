package dao;

import static db.JdbcUtil.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vo.ShoseInfo;
import vo.userinfo;

public class ShoseDAO {
	private Connection con;
	private static ShoseDAO ShoseDAO;

	private ShoseDAO() {
	}

	public static ShoseDAO getInstance() {
		if (ShoseDAO == null) {
			ShoseDAO = new ShoseDAO();
		}
		return ShoseDAO;
	}

	public void setConnection(Connection con) {
		this.con = con;
	}

	public int uploadShose(ShoseInfo shoseInfo, String sell) {//신발 팔기
		int UploadCount = 0;
		String sql = "INSERT INTO shoesinfo VALUES(now(),?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, shoseInfo.getUserid());
			pstmt.setString(2, shoseInfo.getModel());
			pstmt.setInt(3, shoseInfo.getPrice());
			pstmt.setString(4, shoseInfo.getSize());
			pstmt.setString(5, "1");
			pstmt.setString(6, "n");
			pstmt.setInt(7, (((shoseInfo.getPrice()) / 100) * 5) > 5000 ? ((shoseInfo.getPrice()) / 100) * 5 : 5000);
			System.out.println(shoseInfo.getPrice()/100*5);
			if(sell.equals("want")) {
				pstmt.setString(8, "0");
			}else {
				pstmt.setString(8, "1");
			}
			UploadCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return UploadCount;
	}
	public ArrayList<ShoseInfo> selectTradeList() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = " select * from allview order by trade desc";
		ArrayList<ShoseInfo> tradeList = new ArrayList<ShoseInfo>();

		ShoseInfo shoseInfo = null;

		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				shoseInfo = new ShoseInfo();
				shoseInfo.setBrand(rs.getString("brand"));
				shoseInfo.setModel(rs.getString("model"));
				if(rs.getString("price")==null) {
					shoseInfo.setPrice(0);
				}else{
					shoseInfo.setPrice(Integer.parseInt(rs.getString("price")));
				}			
				shoseInfo.setShoImage(rs.getString("shoeimage"));
				tradeList.add(shoseInfo);
			}
		} catch (Exception e) {
			System.out.println("getshoseInfoList 에러 : " + e);
		} finally {
			close(rs);
			close(pstmt);
		}
		return tradeList;
	}

	public ArrayList<ShoseInfo> selectArticleList(String search, String trade, String[] seleckind) {//신발 검색, 리스트 
	      PreparedStatement pstmt = null;
	      ResultSet rs = null;
	      String sql = " select * from allview ";
	      sql += search == null ? "" : "where (model like '%" + search + "%' or brand like '%" + search + "%') ";
	      if(seleckind!=null) {
	         if(search==null) {
	            sql+="where kind= '"+seleckind[0]+"'";
	            for(int y=1;y<seleckind.length;y++) {         
	               sql+=" or kind= '"+seleckind[y]+"'";
	            }
	         }else {
	            sql+="and kind= '"+seleckind[0]+"'";
	            for(int y=1;y<seleckind.length;y++) {         
	               sql+=" or kind= '"+seleckind[y]+"' and (model like '%" + search + "%' or brand like '%" + search + "%' )";
	            }
	         }
	         
	      }
	      sql += trade == null ? "" : "order by trade desc";
	      
	      ArrayList<ShoseInfo> articleList = new ArrayList<ShoseInfo>();
	      
	      ShoseInfo shoseInfo = null;

	      try {
	         pstmt = con.prepareStatement(sql);
	         System.out.println(pstmt);
	         rs = pstmt.executeQuery();
	         while (rs.next()) {
	            shoseInfo = new ShoseInfo();
	            shoseInfo.setBrand(rs.getString("brand"));
	            shoseInfo.setModel(rs.getString("model"));
	            if(rs.getString("price")==null) {
	               shoseInfo.setPrice(0);
	            }else{
	               shoseInfo.setPrice(Integer.parseInt(rs.getString("price")));
	            }         
	            shoseInfo.setShoImage(rs.getString("shoeimage"));
	            articleList.add(shoseInfo);
	         }
	      } catch (Exception e) {
	         System.out.println("getshoseInfoList 에러 : " + e);
	      } finally {
	         close(rs);
	         close(pstmt);
	      }
	      return articleList;
	   }



	public ShoseInfo selectShoesInfo(String model) {//상품 디테일 페이지 정보
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ShoseInfo shoseInfo = null;
		String sql = "select shoeimage, price, brand from allview where model=?";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, model);
			rs = pstmt.executeQuery();

			if(rs.next()) {
				shoseInfo = new ShoseInfo();
				shoseInfo.setModel(model);
				if(rs.getString("price")==null) {
					shoseInfo.setPrice(0);
				}else{
					shoseInfo.setPrice(Integer.parseInt(rs.getString("price")));
				}			
				shoseInfo.setShoImage(rs.getString("shoeimage"));
				shoseInfo.setBrand(rs.getString("brand"));
			}
		} catch (Exception e) {
			System.out.println("selectShoseInfo 에러 : " + e);
		} finally {
			close(rs);
			close(pstmt);
		}
		return shoseInfo;
	}

	public ArrayList<ShoseInfo> selectShoesPrice(String model, String buyorcell) {//신발 사이즈, 가격 최소값 구하기
		ArrayList<ShoseInfo> shoesList=new ArrayList<ShoseInfo>();
		ShoseInfo shoesinfo=null;
		PreparedStatement pstmt = null;
		int size = 220;
		ResultSet rs = null;
		String sql = "select price, checkprice from itemview where model=? and size=? order by price";
		try {
			for (int i = 0; i <15; i++) {
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, model);
				pstmt.setInt(2, size);
				
				shoesinfo=new ShoseInfo();
				rs = pstmt.executeQuery();
				if (rs.next()) {
					if (buyorcell.equals("buy")) {
						int cellprice = (rs.getInt("price")) + (rs.getInt("checkprice"));
						shoesinfo.setPrice(cellprice);
						shoesinfo.setCheckprice(rs.getInt("checkprice"));
						shoesinfo.setSize((Integer.toString(size)));

						System.out.println(rs.getString("price"));
					} else if (buyorcell.equals("cell")) {
						shoesinfo.setPrice(rs.getInt("price"));
						shoesinfo.setCheckprice(rs.getInt("checkprice"));
						shoesinfo.setSize((Integer.toString(size)));
					}
				} else {
					shoesinfo.setPrice(0);
					shoesinfo.setCheckprice(0);
					shoesinfo.setSize(Integer.toString(size));
				}
				shoesList.add(shoesinfo);
				size += 5;
			}
		} catch (Exception e) {
			System.out.println("selectShosePrice 에러 : " + e);
		} finally {
			close(rs);
			close(pstmt);
		}
		return shoesList;
	}

	public String SelectShoseNum(ShoseInfo shoseInfo) {//구매 시 최저가 신발 중 가장 옛날에 등록된신발 색출(선입 선출)
		PreparedStatement pstmt=null;
		PreparedStatement pstmt2=null;
		ResultSet rs=null;
		String sql="select min(price) as price from itemview where model=? and size=?";
		String sql2="select min(shonum) as shonum from itemview where model=? and size=? and price=?";
		
		String shoesNum = "";
		int price = 0;
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, shoseInfo.getModel());
			pstmt.setString(2, shoseInfo.getSize());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				price=rs.getInt("price");
			}
			
			pstmt2=con.prepareStatement(sql2);
			pstmt2.setString(1, shoseInfo.getModel());
			pstmt2.setString(2, shoseInfo.getSize());
			pstmt2.setInt(3, price);
			
			rs=pstmt2.executeQuery();
			if(rs.next()) {
				shoesNum=rs.getString("shonum");
			}
			
		}catch (Exception e) {
			System.out.println("selectShoseInfo 에러 : " + e);
		} finally {
			close(pstmt);
		}
		return shoesNum;
	}

	public int dicisionShoes(String shonum, String id, String addr) {//구매 확정
		PreparedStatement pstmt=null;
		PreparedStatement pstmt2=null;
		int updateOrder=0;
		int updatePurchase=0;
		String sql="update shoesinfo set ispurchase='y' where shonum=?";
		String sql2="insert into ordertable values(now(),?,?,?,'3')";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, shonum);
			updatePurchase=pstmt.executeUpdate();
			if(updatePurchase>0) {
				pstmt2=con.prepareStatement(sql2);
				pstmt2.setString(1, shonum);	
				pstmt2.setString(2, id);
				pstmt2.setString(3, addr);
				updateOrder=pstmt2.executeUpdate();
			}
		}catch (Exception e) {
			System.out.println("dicisionShoes 에러 : " + e);
		} finally {
			close(pstmt);
			close(pstmt2);
		}
		return updateOrder;
	}
	
	public ArrayList<ShoseInfo> MyshoeUploadDAO(String id) {//내가 판 신발 보기
	      PreparedStatement pstmt=null;
	      ResultSet rs=null;
	      ShoseInfo shoseInfo=null;
	   
	      ArrayList<ShoseInfo> uploadMyShoes=new ArrayList<ShoseInfo>();
	      
	      String sql="select brand,model,price,size,shoeimage, shonum, ispurchase, pass from myupload "
	      		+ "where userid=? order by pass desc";
	      	
	      try {
	         pstmt = con.prepareStatement(sql);
	         pstmt.setString(1, id);
	         rs=pstmt.executeQuery();
	         
	         while(rs.next()) {
	            shoseInfo=new ShoseInfo();
	            shoseInfo.setBrand(rs.getString("brand"));
	            shoseInfo.setModel(rs.getString("model"));
	            shoseInfo.setPrice(Integer.parseInt(rs.getString("price")));
	            shoseInfo.setSize(rs.getString("size"));
	            shoseInfo.setShoImage(rs.getString("shoeimage"));
	            shoseInfo.setShonum(rs.getString("shonum"));
	            shoseInfo.setIspurchase(rs.getString("ispurchase"));
	            shoseInfo.setPass(rs.getString("pass"));
	            uploadMyShoes.add(shoseInfo);
	         }
	      }catch(Exception e) {
	         System.out.println("MyshoeUploadDAO 에러 : "+e);
	      }finally {
	         close(rs);
	         close(pstmt);
	      }	      
	      return uploadMyShoes;
	   }

	public ArrayList<ShoseInfo> getBuyShoesList(String id) {//내가 산 신발 보기
		ArrayList<ShoseInfo> BuyList=new ArrayList<ShoseInfo>();
		ShoseInfo shoseInfo=null;
		PreparedStatement pstmt=null;
		String sql="select brand, model, shoeimage, price, size, ordernum, status from purchaseview where userid=?";
		ResultSet rs=null;
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			System.out.println(pstmt);
			while(rs.next()) {
				shoseInfo=new ShoseInfo();
				shoseInfo.setBrand(rs.getString("brand"));
				shoseInfo.setModel(rs.getString("model"));
				shoseInfo.setShoImage(rs.getString("shoeimage"));
				shoseInfo.setPrice(rs.getInt("price"));
				shoseInfo.setSize(rs.getString("size"));
				shoseInfo.setShonum(rs.getString("ordernum"));
				shoseInfo.setIspurchase(rs.getString("status"));
				BuyList.add(shoseInfo);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			close(rs);
			close(pstmt);
		}
		return BuyList;
	}

	public userinfo getAddress(String id) {//구매 전 주소 불러오기
		PreparedStatement pstmt=null;
		String sql="select address, name from userinfo where userid=?";
		userinfo userinfo = null;
		ResultSet rs=null;
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				userinfo=new userinfo();
				System.out.println(rs.getString("address"));
				userinfo.setAddress(rs.getString("address"));
				userinfo.setName(rs.getString("name"));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			close(rs);
			close(pstmt);
		}
		return userinfo;
	}

	public ShoseInfo getShoesInfo(String model, String size, String boc) {//사이즈 설정 후 신발 정보 검색
		ShoseInfo shoesinfo=null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select price, checkprice from itemview where model=? and size=? order by price";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, model);
			pstmt.setString(2, size);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				shoesinfo=new ShoseInfo();
				shoesinfo.setModel(model);
				if(boc.equals("cell")) {
					shoesinfo.setPrice(rs.getInt("price"));
				}else if(boc.equals("buy")) {
					shoesinfo.setPrice(rs.getInt("price")+rs.getInt("checkprice"));
				}
				shoesinfo.setCheckprice(rs.getInt("checkprice"));
				shoesinfo.setSize(size);
			}else {
				shoesinfo=new ShoseInfo();
				shoesinfo.setModel(model);
				shoesinfo.setPrice(0);
				shoesinfo.setCheckprice(0);
				shoesinfo.setSize(size);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return shoesinfo;
	}

	public boolean sellcalculate(String shonum) {//정산 
		PreparedStatement pstmt=null;
		PreparedStatement pstmt2=null;
		PreparedStatement pstmt3=null;
		ResultSet rs=null;
		ResultSet rs2=null;
		boolean iscalculate=false;
		String sql="select userid, price, checkprice from shoesinfo where shonum=?";
		String sql2="select point from userinfo where userid=?";
		String sql3="update userinfo set point=? where userid=?";
		int price=0;
		int point=0;
		String userid=null;
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, shonum);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				userid=rs.getString("userid");
				System.out.println(userid+"유저 아이디");
				price=(Integer.parseInt(rs.getString("price")))-(Integer.parseInt(rs.getString("checkprice")));
				pstmt2=con.prepareStatement(sql2);
				pstmt2.setString(1, userid);
				rs2=pstmt2.executeQuery();
				if(rs2.next()) {
					point=Integer.parseInt(rs2.getString("point"));
					pstmt3=con.prepareStatement(sql3);
					pstmt3.setString(1, Integer.toString(point+price-3000));//창고 보관비
					pstmt3.setString(2, userid);
					int is=pstmt3.executeUpdate();
					if(is>0) {
						iscalculate=true;
					}
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
			close(rs2);
			close(pstmt2);
			close(pstmt3);
		}		
		return iscalculate;
	}

	public int insertBid(ShoseInfo shoesinfo, String id) {//구매 입찰 예약  0=거래 채결 전 1=거래 채결 완료
		int isbid=0;
		PreparedStatement pstmt=null;
		String sql="insert into bidtable values(now(),?,?,?,?,0)";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, shoesinfo.getModel());
			pstmt.setString(3, shoesinfo.getSize());
			pstmt.setString(4, Integer.toString(shoesinfo.getPrice()));
			isbid=pstmt.executeUpdate();			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return isbid;
	}
	public int adjustPrice(String shonum, String price) {
		PreparedStatement pstmt=null;
		int isadd=0;
		int checkprice=Integer.parseInt(price)/20>5000?Integer.parseInt(price)/20:5000;
		String sql="update shoesinfo set price=?, checkprice=? where shonum=?";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, price);
			pstmt.setString(2, Integer.toString(checkprice));
			pstmt.setString(3, shonum);
			isadd=pstmt.executeUpdate();
			System.out.println(pstmt);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return isadd;
	}
	public userinfo RefreshShoes(ShoseInfo shoesinfo) {
		PreparedStatement pstmt=null;
		String sql="select userid, bidnum from bidtable where model=? and  price=?  and  size=? "
				+ "order by bidnum";
		userinfo biduser=null;
		ResultSet rs=null;
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, shoesinfo.getModel());
			pstmt.setString(2, Integer.toString(shoesinfo.getPrice()));
			pstmt.setString(3, shoesinfo.getSize());
			System.out.println(pstmt);
			rs=pstmt.executeQuery();
			biduser=new userinfo();
			if(rs.next()) {				
				biduser.setId(rs.getString("userid"));
				biduser.setName(rs.getString("bidnum"));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}
		return biduser;
	}

	public int bidUpdate(String name) {
		int isup=0;
		PreparedStatement pstmt=null;
		String sql="update bidtable set ismatched='1' where bidnum=?";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, name);
			isup=pstmt.executeUpdate();			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return isup;
	}

	public int ViewUpdate(String model) {
		int isup=0;
		int view=0;
		PreparedStatement pstmt=null;
		PreparedStatement pstmt2=null;
		String sql="select view from shoesmodel where model=?";
		String sql2="update shoesmodel set view=? where model=?";
		ResultSet rs=null;
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, model);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				view=rs.getInt("view");
				view++;
				pstmt2=con.prepareStatement(sql2);
				pstmt2.setInt(1, view);
				pstmt2.setString(2, model);
				isup=pstmt2.executeUpdate();
			}			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(pstmt2);
			close(rs);
		}
		return isup;
	}
	
	 public ArrayList<String> selectkindList() {
	      PreparedStatement pstmt=null;
	      ResultSet rs=null;
	      ArrayList<String> kindList=null;
	      String sql="select kind from kindtable";
	      try {
	         kindList=new ArrayList<String>();
	         pstmt=con.prepareStatement(sql);
	         rs=pstmt.executeQuery();
	         while(rs.next()) {
	            String kind=rs.getString("kind");
	            kindList.add(kind);            
	         }
	      }catch (Exception e) {
	         e.printStackTrace();
	      }finally {
	         close(pstmt);
	         close(rs);
	      }
	      return kindList;
	   }

	/*public String[] selectkindList() {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String[] kindList=null;
		int i=0;
		String sql="select kind from kindtable";
		try {
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				i++;				
			}
			kindList=new String[i];
			i=0;
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}
		return kindList;
	}*/
}