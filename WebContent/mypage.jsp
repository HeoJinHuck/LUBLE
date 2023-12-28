<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="vo.userinfo"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>마이페이지 | LUBLE</title>
<link rel="stylesheet" href="style.css">
 <script src="https://cdn.tailwindcss.com"></script>
</head>

<body class="bg-gray-50">

<jsp:include page="header.jsp"></jsp:include>
  
		<main class="max-w-7xl mx-auto px-4 sm:px-6 lg:px-8 mt-8">
		  <aside class="w-1/4 float-left pr-4">
            <ul class="bg-white shadow rounded-lg p-4">
                <li class="py-2 text-gray-700 font-semibold  text-2xl">쇼핑 정보</li>
                <li><a href="mybuyList.my" class="py-2 text-gray-500 hover:text-gray-700 cursor-pointer">구매 내역</a></li>
                <li><a href="mysellList.my?sell=yes" class="py-2 text-gray-500 hover:text-gray-700 cursor-pointer">판매 완료</a></li>  
                <li><a href="mysellList.my?sell=no" class="py-2 text-gray-500 hover:text-gray-700 cursor-pointer">판매 중 상품</a></li>
                <li><a href="myjjimList.my" class="py-2 text-gray-500 hover:text-gray-700 cursor-pointer">찜한 상품</a></li>
              	
              	<li class="py-2 text-gray-700 font-semibold text-2xl">내 정보</li>
              	<li><a href="loginModify.jsp" class="py-2 text-gray-500 hover:text-gray-700 cursor-pointer">내정보 수정</a></li>
            </ul>
        </aside>
		</main>
</body>
</html>