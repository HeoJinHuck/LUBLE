<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="vo.ShoseInfo"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat"%>

<%
	ArrayList<ShoseInfo> buylist = (ArrayList<ShoseInfo>)request.getAttribute("buylist");
%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>구매 현황| LUBLE</title>
    <script src="https://cdn.tailwindcss.com"></script>
    <style>
        .wishlist-vertical .product-card {
            max-width: 100%;
        }
    </style>
</head>

<body class="bg-gray-50">
	
	<jsp:include page="mypage.jsp"></jsp:include>
    <p class="py-2 text-gray-700 font-semibold  text-2xl">구매 내역</p>   
    <div class="container mx-auto p-8">
        <div class="flex flex-col lg:flex-row gap-10">
            
			<!-- Main Content -->
            <%if (buylist != null) {%>
			 <div class="w-full lg:w-3/4 bg-white shadow-lg rounded-lg p-4">
        		<%for (int i = 0; i < buylist.size(); i++) { %>
        			<%	String day[]=buylist.get(i).getShonum().split(" ");
           				String buyd=day[0]; 
           			%>
                <!-- Product Card -->
    			<div class="product-card border rounded-lg p-4 flex items-center">
   					
   					<a href="ShoesDetail.sho?model=<%=buylist.get(i).getModel()%>">
 						<img src="<%=buylist.get(i).getShoImage()%>" alt="Product" class="rounded" width="80" height="80">
 					</a>
                              
                        <div class="flex-grow">
                            <h3 class="text-lg font-semibold"><%=buylist.get(i).getBrand()%></h3>
                            <p><%=buylist.get(i).getModel() %></p>
                            <p class="font-semibold"><%=buylist.get(i).getPrice()+3000%>원</p>
                        </div>
                        <div>
                        	구매일자: <%=buyd%>
                        	<%if(buylist.get(i).getIspurchase().equals("1")){ %>
                        		<p class="font-semibold">입금 요망</p>
                        	<%}else if(buylist.get(i).getIspurchase().equals("2")){ %>
                        		<p class="font-semibold">배송 중</p>
                        	<%}else if(buylist.get(i).getIspurchase().equals("3")) {%>
                        		<p class="font-semibold">거래 완료</p>
							<%} %>
                        </div>
                      </div>    
         <% } %> 
       </div>
       
	<% } %>
           
     </div>
</div>

</body>
</html>