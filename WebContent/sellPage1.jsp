<%@page import="svc.ShoesDetailService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="vo.ShoseInfo"%>
<%@ page import="java.util.*" %>
<%@ page import="java.text.SimpleDateFormat" %>

<%
	ShoseInfo shoseInfo=(ShoseInfo)request.getAttribute("shoesinfo");
%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>판매 1단계 | LUBLE</title>
    <script src="https://cdn.tailwindcss.com"></script>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;700&display=swap" rel="stylesheet">
    <style>
        body {
            font-family: 'Noto Sans KR', sans-serif;
        }
        .checkmark {
            display: inline-block;
            width: 22px;
            height: 22px;
        }
       

#shoe-list {
    display: flex;
    flex-direction: row;
    flex-wrap: wrap;
    justify-content: center;
    margin-top:30px;
}

.shoe-card {
    width: 200px;
    height: auto;
    margin-right: 24px;
    margin-bottom: 20px;
    border: 1px solid;
    border-radius: 12px;
    display: flex;
    flex-direction: column;
}

a {
    width: 100%;
    height: 150px;
}

.shoe-contents {
    display: flex;
    flex-direction: column;
    padding: 8px;
}

.shoe-price {
    font-size: 16px;
    font-weight: 600;
    margin-top: 2px;
}

.img {
    width: 100%;
    height: 150px;
}

li {
    margin-right: 10px;
    text-align: center;
}
</style>
    <script>
        function validateForm() { // 모든항목 동의 스크립트
		    var checkboxes = document.querySelectorAll('input[type="checkbox"]');
            for (var i = 0; i < checkboxes.length; i++) { 
                if (!checkboxes[i].checked) {
                    alert("모든 항목에 동의해야 합니다.");
                    return false; 
                }
            }
            return true; 
        }
    </script>
</head>

<body class="bg-gray-50">	

<jsp:include page="header.jsp"></jsp:include>						 
  <form method="post" action="sellPage2.jsp" onsubmit="return validateForm()">      
    <div class="max-w-2xl mx-auto p-4">
        <div class="bg-white shadow-md rounded p-4 mb-6">
            <h2 class="text-xl font-semibold mb-4">판매 동의</h2>
            
             <img src="<%=shoseInfo.getShoImage() %>" alt="Shoe Image" class="rounded mr-4"
             style="width: 100px; height: auto; display: block;">
                
          	  <div class="rounded mr-4 s-center mflex itemb-4">   
             <a href="ShoesDetail.sho?model=<%=shoseInfo.getModel()%>"></a>
                		<div class="shoe-contents font-semibold">
                            <span class="shoe-name"><%=shoseInfo.getModel()%></span>
                        <%if(shoseInfo.getPrice()!=0){ %> 
                            <span class="shoe-price"><%=shoseInfo.getPrice()%>원</span>
                        <%}else if(shoseInfo.getPrice()==0){ %>
                        	<span class="shoe-price">판매입찰</span>
                        <%} %>   
                        </div>
            </div>
   			<div class="border-t-2 pt-4">
                <div class="flex items-center justify-between mb-2">
                    <p>판매하려는 상품이 맞습니다.</p>
                   <input type="checkbox" name="color" value="blue" class="checkmark text-green-500"/> 
                </div>
                <p class="text-sm mb-2">번호, 출시일, 상품명, 사이즈를 한 번 더 확인했습니다.</p>
                <p class="text-sm italic">단, 상품의 이미지는 촬영 환경에 따라 실제와 다를 수 있습니다.</p>
            </div>
            <!-- Repeat the agreement section for each item -->
            <div class="border-t-2 pt-4">
                <div class="flex items-center justify-between mb-2">
                    <p>판매하려는 상품이 맞습니다.</p>
                    <input type="checkbox" name="color" value="blue" class="checkmark text-green-500"/>
                </div>
                <p class="text-sm mb-2">번호, 출시일, 상품명, 사이즈를 한 번 더 확인했습니다.</p>
                <p class="text-sm italic">단, 상품의 이미지는 촬영 환경에 따라 실제와 다를 수 있습니다.</p>
            </div>
            <!-- Repeat the agreement section for each item -->
            <div class="border-t-2 pt-4">
                <div class="flex items-center justify-between mb-2">
                    <p>판매하려는 상품이 맞습니다.</p>
                    <input type="checkbox" name="color" value="blue" class="checkmark text-green-500"/>
                </div>
                <p class="text-sm mb-2">번호, 출시일, 상품명, 사이즈를 한 번 더 확인했습니다.</p>
                <p class="text-sm italic">단, 상품의 이미지는 촬영 환경에 따라 실제와 다를 수 있습니다.</p>
            </div>
            <!-- Repeat the agreement section for each item -->
            <div class="border-t-2 pt-4">
                <div class="flex items-center justify-between mb-2">
                    <p>판매하려는 상품이 맞습니다.</p>
                    <input type="checkbox" name="color" value="blue"  class="checkmark text-green-500 "/>
                </div>
                <p class="text-sm mb-2">번호, 출시일, 상품명, 사이즈를 한 번 더 확인했습니다.</p>
                <p class="text-sm italic">단, 상품의 이미지는 촬영 환경에 따라 실제와 다를 수 있습니다.</p>    
                </div>
           
        </div>
        	<input type="hidden" name="model" value="<%=shoseInfo.getModel()%>">
            <input type="hidden" name="shoeimage" value="<%=shoseInfo.getShoImage()%>">
            <input type="hidden" name="price" value="<%=shoseInfo.getPrice()%>">
            <input type="hidden" name="size" value="<%=shoseInfo.getSize()%>">
        <button class="w-full bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded focus:outline-none focus:shadow-outline" type="submit">
            판매 계속
        </button>
    </div>  
 </form>
 <jsp:include page="footer.jsp"></jsp:include>		    
</body>
</html>