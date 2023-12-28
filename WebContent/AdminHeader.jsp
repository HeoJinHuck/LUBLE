<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="javax.sql.*"%>
<%@ page import="javax.naming.*"%>
<meta charset="UTF-8">
<html>
<head>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@700&display=swap" rel="stylesheet">
<link rel="stylesheet" href="style.css">
<script src="https://cdn.tailwindcss.com"></script>
    <style>
body {
            margin: 0;
            padding: 0;
            color: #333;
           
        }

        nav {
            background-color: #fff;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        }

        .top_inner {
            display: flex;
            justify-content: center;
            align-items: center;
        }

        .menu_bar {
            list-style: none;
            display: flex;
            align-items: center;
        }

        .menu_bar li {
            margin-right: 20px;
        }

        .menu_bar a,
        .manager_info a {
            text-decoration: none;
            transition: color 0.3s ease;
            margin-left: 20px;
        }

        .menu_bar a:hover,
        .manager_info a:hover {
            color: #007aff;
        }
	
        .container {
            max-width: 1024px;
            margin: 0 auto;
            padding: 0 20px;
        }
</style>
</head>
<body class="font-semibold">

	<%
		String grade = (String) session.getAttribute("grade");
		String id=(String) session.getAttribute("id");
	%>

	<nav>
		<div class="top_inner">
			<ul class="menu_bar">
				<li onclick="location.href='AdminMain.ad'">
				<img src="./images/LUBLE.png" style="max-width:300px; height:100px;"></li>
			</ul>

			<div class="manager_info">
				
				<%if (id == null) {%>				
					<a href="Login.jsp">로그인</a>
				<%} else {%>
					<%if(grade.equals("관리자")){ %>				
						<a href="adminLogOut.ad">로그아웃</a><b></b>
						<a href="AdminJoin.jsp">회원생성</a>
						<a href="AdminProductUpload.jsp">제품등록</a>
					<%}else{%>
						<a href="adminLogOut.ad">로그아웃</a><b></b>
					<%}%>
				<%}%>
				
				
			</div>
		</div>
	</nav>
	
	<div class="mx-auto px-4 sm:px-6 lg:px-8 mt-8">
		<aside class="w-1/4 float-left pr-4">

			<ul class="bg-white shadow rounded-lg p-4">
				<li class="py-2 text-gray-700 font-semibold text-2xl">관리자 관리</li>
			
				<li><a href="./clientmember.ad"
					class="py-2 text-gray-500 hover:text-gray-700 font-semibold cursor-pointer">회원
						관리</a></li>
						<li><a href="./adminUploadList.ad"
					class="py-2 text-gray-500 hover:text-gray-700 font-semibold cursor-pointer">제품
						관리</a></li>	
				<li><a href="./admininventory.ad"
					class="py-2 text-gray-500 hover:text-gray-700 font-semibold cursor-pointer">재고
						관리</a></li>
				<li><a href="./adminrevenue.ad"
					class="py-2 text-gray-500 hover:text-gray-700 font-semibold cursor-pointer">잔고
						관리 </a></li>
				<li><a href="./adminStatusList1.ad"
					class="py-2 text-gray-500 hover:text-gray-700 font-semibold cursor-pointer">배송
						관리</a></li>
				<li><a href="./adminStatusList2.ad"
					class="py-2 text-gray-500 hover:text-gray-700 font-semibold cursor-pointer">검수
						관리</a></li>
				<li><a href="./adminStatusList3.ad"
					class="py-2 text-gray-500 hover:text-gray-700 font-semibold cursor-pointer">판매
						관리</a></li>
				<li><a href="./adminStatusList4.ad"
					class="py-2 text-gray-500 hover:text-gray-700 font-semibold cursor-pointer">반송
						관리</a></li>		
			</ul>
	
		</aside>
	</div>
	
</body>
</html>