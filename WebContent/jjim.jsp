<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="vo.Mark"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat"%>

<%
	ArrayList<Mark> Mark = (ArrayList<Mark>) request.getAttribute("jjimList");
%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>찜 목록| LUBLE</title>
    <script src="https://cdn.tailwindcss.com"></script>
    <style>
        .wishlist-vertical .product-card {
            max-width: 100%;
        }
    </style>
</head>
<%
	String id=(String)request.getAttribute("id");
%>

<body class="bg-gray-50">
	
	<jsp:include page="mypage.jsp"></jsp:include>
    <p class="py-2 text-gray-700 font-semibold  text-2xl">찜한 상품</p>   
    <div class="container mx-auto p-8">
        <div class="flex flex-col lg:flex-row gap-10">
            
			<!-- Main Content -->
            <%if (Mark != null) {%>
			 <div class="w-full lg:w-3/4 bg-white shadow-lg rounded-lg p-4">
        		<%for (int i = 0; i < Mark.size(); i++) { %>
           
           
          
   			<form action="mydeleteList.my" method="post">
            
                <!-- Product Card -->
    			<div class="product-card border rounded-lg p-4 flex items-center">
   					
   					<a href="ShoesDetail.sho?model=<%=Mark.get(i).getModel()%>">
 						<img src="<%=Mark.get(i).getShoeimage()%>" alt="Product" class="rounded" width="80" height="80">
 					</a>
                              
                        <div class="flex-grow">
                            <h3 class="text-lg font-semibold"><%=Mark.get(i).getBrand()%></h3>
                            <p><%=Mark.get(i).getModel() %></p>
                            <p class="font-semibold"><%=Mark.get(i).getPrice()%>원</p>
                        </div>
                      <a href="mydeleteList.my?model=<%=Mark.get(i).getModel()%>">삭제 </a> </div>    
                    </form>
         <% } %> 
       </div>
       
	<% } %>
           
     </div>
</div>

</body>
</html>