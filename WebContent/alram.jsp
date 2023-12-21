<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%String bs=request.getParameter("bs"); %>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>결제 완료| LUBLE </title>
<script src="https://cdn.tailwindcss.com"></script>
<style>
body {
	font-family: 'Inter', sans-serif;
}
</style>
</head>
<body class="bg-gray-50">
<jsp:include page="header.jsp"></jsp:include>
<div class=" flex items-center justify-center h-screen">
    <div class="bg-white rounded-lg shadow-lg p-6 max-w-sm w-full mx-auto">
        <div class="text-center">
        <%if(bs.equals("0")){ %>
            <h2 class="text-2xl font-semibold mb-2">결제 완료</h2>
        <%}else if(bs.equals("1")){ %>
        	<h2 class="text-2xl font-semibold mb-2">입찰 완료</h2>
        <%}else if(bs.equals("2")){ %>
    		<h2 class="text-2xl font-semibold mb-2">등록 완료</h2>
    	<%} %>
        <div class="text-orange-500 mb-4">
        <svg xmlns="http://www.w3.org/2000/svg" class="h-12 w-12 mx-auto" fill="none" viewBox="0 0 24 24" stroke="currentColor" stroke-width="2">
        <path stroke-linecap="round" stroke-linejoin="round" d="M5 13l4 4L19 7" />
        </svg>
        </div>
        <%if(bs.equals("0")){ %>
            <p class="mb-6">결제가 정상적으로 처리되었습니다.</p>
            <hr class="mb-6">
            <p class="text-sm text-gray-600 mb-6">
                - 결제 완료는 결제완료시 화면 요청을 해야합니다.<br>
                - 결제완료후 인증정보 전송은 자동 발송되며,<br>
               	 결제완료후 관리자에게 발급 가능합니다.
         <%}else if(bs.equals("1")){ %>
            <p class="mb-6">입찰이 정상적으로 처리되었습니다.</p>
            <hr class="mb-6">
            <p class="text-sm text-gray-600 mb-6">
                - 입찰 가격의 상품이 등록되면 자동 거래성사됩니다.<br>
                - 결제완료후 인증정보 전송은 자동 발송되며,<br>
               	 결제완료후 관리자에게 발급 가능합니다.
         <%}else if(bs.equals("2")){ %>
          <p class="mb-6">등록이 정상적으로 처리되었습니다.</p>
            <hr class="mb-6">
            <p class="text-sm text-gray-600 mb-6">
                - 거래가 이루어지면 자동 정산됩니다.<br>
                - 등록완료후 인증정보 전송은 자동 발송되며,<br>
               	 등록완료후 관리자에게 발급 가능합니다.
         <%} %>         
            </p>
            <button class="bg-black text-white w-full py-3 rounded-lg" onclick="location.href='index.jsp'">확인</button>
        </div>
    </div>
    </div>
    <jsp:include page="footer.jsp"></jsp:include>
</body>
</html>