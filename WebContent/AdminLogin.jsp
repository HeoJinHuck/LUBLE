<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="javax.sql.*"%>
<%@ page import="javax.naming.*"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>로그인 | LUBLE</title>
     <script src="https://cdn.tailwindcss.com"></script>
	<link rel="stylesheet" href="style.css">
	<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@700&display=swap" rel="stylesheet">
    <style>
body {
	margin: 0;
	padding: 0;
	font-family: 'Noto Sans KR', sans-serif;
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

.menu_bar a {
	font-family: 'Noto Sans KR', sans-serif;
	text-decoration: none;
	color: #333;
	transition: color 0.3s ease;
}

.menu_bar a:hover {
	color: #007aff;
}

.manager_info a {
	font-family: 'Noto Sans KR', sans-serif;
	text-decoration: none;
	color: #333;
	margin-left: 20px;
	transition: color 0.3s ease;
}

.manager_info a:hover {
	color: #007aff;
}

</style>
</head>
<body>


<%
String id = (String)request.getAttribute("id");
%>
	<nav>
		<div class="top_inner">
			<ul class="menu_bar">
				<li onclick="location.href='AdminHeader.jsp'">
				<img src="./images/LUBLE.png" style="max-width:300px; height:100px;"></li>
			</ul>

			<div class="manager_info">
				<%
					if (id == null) {
				%>
				<a href="AdminLogin.jsp">로그인</a><b></b> 
				<%
					} else {
				%>
				<a href="adminLogin.ad">로그아웃</a>
				<%
					request.setAttribute("id", null);
				%>

				<%
					}
				%>
			
			</div>
			
		</div>
	</nav>

    <!-- Main Content -->
    	 
    <main class="container mx-auto px-6 py-12 flex flex-col items-center">
        <h1 class="text-3xl font-bold mb-8">KREAM</h1>
        
        <form action="./adminLogin.ad" name="login" method="post"  class="w-full max-w-sm space-y-6">
  			<label for="id" class="block text-gray-700 text-sm font-bold mb-2">아이디:</label>
            <input type="text" 	   id="id" 	 name="id"  
            	class="w-full px-4 py-2 border rounded-md focus:outline-none focus:ring-2 focus:ring-gray-300" />
            <label for="pass" class="block text-gray-700 text-sm font-bold mb-2">비밀번호:</label>
            <input type="password" id="pass" name="pass" 
            	class="w-full px-4 py-2 border rounded-md focus:outline-none focus:ring-2 focus:ring-gray-300" />
            
            <button type="submit" 
            class="w-full bg-black text-white px-4 py-2 rounded-md hover:bg-gray-800">로그인</button>
        </form>


    </main>

    <!-- Footer -->
    <footer class="bg-white shadow mt-12 py-6">
        <div class="container mx-auto px-6 text-center text-sm text-gray-600">
             <ul>
        		<li>CUSTOMER CENTER 1544-1129</li>
        		<li>Weekday 10:00~17:00 (Lunch 12:00~13:00)</li>
        		<li>주말 및 공휴일은 휴무입니다.</li>
    		</ul>
        </div>
    </footer>
</body>
</html>