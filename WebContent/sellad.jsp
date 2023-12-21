  <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import="vo.ShoseInfo"%>
<%@ page import="java.util.*" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%request.setCharacterEncoding("utf-8"); %>
<%
	String size=request.getParameter("size");
	String price=request.getParameter("price");
	String model=request.getParameter("model");
	String shonum=request.getParameter("shonum");
	String shoimage=request.getParameter("shoeimage");
%>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>가격 수정 | LUBLE</title>
    <script src="https://cdn.tailwindcss.com"></script>
    
<script>
    function validateForm() {
        var checkboxes = document.getElementsByName('color');
        var isChecked = false;
        for (var i = 0; i < checkboxes.length; i++) {
            if (checkboxes[i].checked) {
                isChecked = true;
                break;
            }
        }
        if (!isChecked) {
            alert('약관에 동의해 주세요.'); 
            return false; 
        }

        return true;
    }
</script>

    <style>
        .disabled-link {
            pointer-events: none;
            opacity: 0.5;
        }

.custom-checkbox {
  width: 4.5rem; 
  height: 4.5rem; 
				 }

                 
    </style>
</head>
<body class="bg-gray-100">
<form action="adjustsho.sho" method="post">
    <div class="container mx-auto p-4">
	<jsp:include page="header.jsp"></jsp:include>
        <div class="bg-white p-4 rounded-md shadow-md mb-6">
           
           <div class="bg-white p-4 shadow rounded-lg">
            <div class="flex items-center space-x-4">
                <img src="<%=shoimage %>" class="w-20 h-20 object-cover rounded" alt="Product Image">
                <div>              
                    <p class="text-gray-600 text-sm"><%=model %></p>
                    <p class="text-gray-600 text-sm"><%=size %></p>
                    <p class="text-gray-900 font-bold mt-2">₩<%=price %></p>
                </div>
            </div>	
        </div>       
        	<div class="bg-white mt-4 p-4 shadow rounded-lg">
        		<h3 class="text-lg font-semibold mb-2">가격 수정 란</h3>
            	<input type="text" id="price" name="price" class="mt-1 p-2 block w-full border-gray-300 rounded-md shadow-sm"
            	placeholder="수정 전 가격: ₩<%=price%>">
            </div>
          <div class="bg-white mt-4 p-4 shadow rounded-lg">
                 <h3 class="text-lg font-semibold mb-2">검수비(판매금액의 5%)</h3>
                <input type="text" id="inspection-fee" name="inspection-fee" class="mt-1 p-2 block w-full border-gray-300 rounded-md shadow-sm"
                 placeholder="수수료(검수비 포함)가 자동으로 계산됩니다 ※최소 수수료 5,000원" disabled>
            </div> 
            </div>
                        
 <div class="bg-white mt-4 p-4 shadow rounded-lg">
                 <h3 class="text-lg font-semibold mb-2">수정 전 약관 동의</h3>
            <div class="border-t-2 pt-4">
                <div class="flex items-center justify-between mb-2">
                    <p>수정하려는 가격이 맞습니다.</p>
                    	<div>
                    		<input type="checkbox" name="color" value="blue" class="checkmark text-green-500"/>
                        	<div class="checkmark_stem"></div>
                        	<div class="checkmark_kick"></div>
                    	</div>
                </div>
                <p class="text-sm mb-2">가격, 모델, 출시일, 상품명, 사이즈를 한 번 더 확인했습니다.</p>
            </div>
          <input type="hidden" name="model" value="<%=request.getParameter("model")%>">
          <input type="hidden" name="size" value="<%=request.getParameter("size")%>">
          <input type="hidden" name="shonum" value="<%=shonum%>">
       	 <button class="w-full bg-gray-700 hover:bg-red-500 text-white font-bold py-2 px-4 rounded focus:outline-none focus:shadow-outline"
       	  type="submit">
           		 수정 하기
        </button>
 </div>
</div>
</form>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>