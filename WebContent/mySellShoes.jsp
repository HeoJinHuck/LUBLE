<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="vo.ShoseInfo"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat"%>

<%
	ArrayList<ShoseInfo> selllist = (ArrayList<ShoseInfo>)request.getAttribute("myUploadShoes");
%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>판매 목록 | LUBLE</title>
    <script src="https://cdn.tailwindcss.com"></script>
    <style>
        .wishlist-vertical .product-card {
            max-width: 100%;
        }
    </style>
</head>

<body class="bg-gray-50">
	
	<jsp:include page="mypage.jsp"></jsp:include>
 	<p class="py-2 text-gray-700 font-semibold  text-2xl">판매 내역</p>   
    <div class="container mx-auto p-8">
        <div class="flex flex-col lg:flex-row gap-10">
            
			<!-- Main Content -->
            <%if (selllist != null) {%>
			 <div class="w-full lg:w-3/4 bg-white shadow-lg rounded-lg p-4">
        		<%for (int i = 0; i < selllist.size(); i++) { %>
           		<%
           			if(selllist.get(i).getIspurchase().equals("y")){
           			String day[]=selllist.get(i).getShonum().split(" ");
           			String selld=day[0];
           		%>
    			<div class="product-card border rounded-lg p-4 flex items-center">  					
   					<a href="ShoesDetail.sho?model=<%=selllist.get(i).getModel()%>">
 						<img src="<%=selllist.get(i).getShoImage()%>" alt="Product" class="rounded" width="80" height="80">
 					</a>                             
                        <div class="flex-grow">
                        	<%int check=(selllist.get(i).getPrice()/20)>5000?(selllist.get(i).getPrice()/20):5000; %> 
                            <h3 class="text-lg font-semibold"><%=selllist.get(i).getBrand()%></h3>
                            <p><%=selllist.get(i).getModel() %></p>
                            <p class="font-semibold"><%=selllist.get(i).getPrice()-check%>원</p>
                        </div>
                        <div>                                                                                                         	
                        	등록 일자: <%=selld%>                        
                        	<p class="font-semibold">판매 완료</p>
                        </div>                  
                     </div>
                	<%} %>         
         	<% } %> 
       		</div>
		<% } %>           
     </div>
</div>

</body>
</html>