<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="vo.ShoseInfo"%>
	<%@ page import="java.util.*" %>
	<%@ page import="java.text.SimpleDateFormat" %>
	<%
		String id= (String)session.getAttribute("id");
		ShoseInfo shoseInfo=(ShoseInfo)request.getAttribute("ShoesInfo");
		boolean isjjim=(boolean)request.getAttribute("jung");
	%>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title><%=shoseInfo.getModel() %> 상세 페이지 | LUBLE</title>
    <script src="https://cdn.tailwindcss.com"></script>
    <link href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@400;600;700&display=swap" rel="stylesheet">
    <style>
        body {
            font-family: 'Open Sans', sans-serif;
        }
        .product-slider img {
            max-width: 100%;
            display: block;
            margin: 0 auto;
        }
    </style>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>

    <main class="max-w-7xl mx-auto px-4 py-8">
        <div class="grid grid-cols-1 md:grid-cols-2 gap-8">
            <div class="product-slider">
            <img src="<%=shoseInfo.getShoImage() %>" Style="width:500px; height:500px;object-fit: cover; ">  
            </div>
            <div class="space-y-4">
                <h2 class="text-3xl font-bold"><%=shoseInfo.getModel() %></h2>
                <p class="text-gray-600 font-bold"><%=shoseInfo.getBrand() %></p>
                <div class="flex items-center space-x-2">
                    
                    <%if(shoseInfo.getPrice()==0){ %>
                    <span class="text-2xl font-bold text-gray-900">
                    	입찰 요망
                    </span>
                    <%}else{ %>
                    <span class="text-4xl font-bold text-gray-900">
                    	<%=shoseInfo.getPrice() %>원
                    </span>
                    <%} %>
                    
               </div>
                <div class="flex space-x-2">
                <form action="#" method="post">
                	<%if(id!=null){ %> 
                    	<button type="submit" class="bg-red-500 text-white px-4 py-2 rounded hover:bg-red-600"    
                    	formaction="BSizePrice.sho?model=<%=shoseInfo.getModel()%>&boc=buy&shoeimage=<%=shoseInfo.getShoImage()%>">구매</button>
                    <%}else{ %>
                    	<button type="submit" class="bg-red-500 text-white px-4 py-2 rounded hover:bg-red-600"    
                    	formaction="login.jsp">구매</button>
                    <%} %>
                    <%if(id!=null){ %> 
                    <button  type="submit" class="bg-green-500 text-white px-4 py-2 rounded hover:bg-green-600" 
                    formaction="BSizePrice.sho?model=<%=shoseInfo.getModel()%>&boc=cell&shoeimage=<%=shoseInfo.getShoImage()%>">판매</button>
                    <%}else{ %>   
                    <button  type="submit" class="bg-green-500 text-white px-4 py-2 rounded hover:bg-green-600" 
                    formaction="login.jsp">판매</button>
                    <%} %>
                </form>			
                <form action="myjjim.my?model=<%=shoseInfo.getModel()%>" method="post" >    
                <%if(!isjjim&&id!=null){ %>    
                    <button type="submit" class="bg-gray-500 text-white px-4 py-2 rounded hover:bg-gray-600">관심상품</button>
 				<%}else if(isjjim&&id!=null){%>
 					<button type="submit" class="bg-gray-500 text-white px-4 py-2 rounded hover:bg-gray-600"
 					formaction="mydeleteList.my?model=<%=shoseInfo.getModel()%>&page=pro">관심상품 해제</button>
 				<%}else{ %>
 					<button type="submit" class="bg-gray-500 text-white px-4 py-2 rounded hover:bg-gray-600"
 					 formaction="login.jsp">장바구니</button>
 				<%} %>                
                </form>
                </div>
                <div class="border-t border-gray-200 py-2">
                    <p class="text-gray-600">구매 혜택</p>
                    <ul class="list-disc pl-5 space-y-1">
                        <li>적립금 2% 적립</li>
                        <li>무료 배송</li>
                    </ul>
                </div>
            </div>
        </div>
    </main>
    <jsp:include page="footer.jsp"></jsp:include>
</body>
</html>