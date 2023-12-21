<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="vo.userinfo"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat"%>


<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="style.css">
<script src="https://cdn.tailwindcss.com"></script>
</head>
<%
	String id=(String) session.getAttribute("id");
%>

<body>

<jsp:include page="AdminHeader.jsp"></jsp:include>

<div class="mx-auto px-4 sm:px-6 lg:px-8 mt-8">
		<aside class="w-1/4 float-left pr-4">

			<ul class="bg-white shadow rounded-lg p-4">
				<li class="py-2 text-gray-700 font-semibold text-2xl">쇼핑 정보</li>
			
				<li><a href="./clientmember.ad"
					class="py-2 text-gray-500 hover:text-gray-700 cursor-pointer">회원
						관리</a></li>
				<li><a href="./admininventory.ad"
					class="py-2 text-gray-500 hover:text-gray-700 cursor-pointer">재고
						관리</a></li>
				<li><a href="./adminrevenue.ad"
					class="py-2 text-gray-500 hover:text-gray-700 cursor-pointer">잔고
						관리 </a></li>
				<li><a href="./adminStatusList1.ad"
					class="py-2 text-gray-500 hover:text-gray-700 cursor-pointer">배송
						관리</a></li>
				<li><a href="./adminStatusList2.ad"
					class="py-2 text-gray-500 hover:text-gray-700 cursor-pointer">검수
						관리</a></li>
				<li><a href="./adminStatusList3.ad"
					class="py-2 text-gray-500 hover:text-gray-700 cursor-pointer">판매
						관리</a></li>
				<li><a href="./adminStatusList4.ad"
					class="py-2 text-gray-500 hover:text-gray-700 cursor-pointer">반송
						관리</a></li>		
			</ul>
		</aside>
	</div>
</body>
</html>
