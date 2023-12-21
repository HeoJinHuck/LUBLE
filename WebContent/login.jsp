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
    <style>
        /* Additional styles if needed */
    </style>
</head>
<body class="bg-gray-50">
   	<%
	String id=(String)request.getAttribute("id");
	%>
    <!-- Header -->
	<jsp:include page="header.jsp"></jsp:include>
	
    <!-- Main Content -->
    <main class="container mx-auto px-6 py-12 flex flex-col items-center">
        <h1 class="text-3xl font-bold text-gray-900 mb-8">로그인</h1>
        
        <form action="./memberLogin.me" name="login" method="post"  class="w-full max-w-sm space-y-6">
  			<label for="username" class="block text-gray-700 text-sm font-bold mb-2">아이디:</label>
            <input type="text" id="id" name="id" class="w-full px-4 py-2 border rounded-md focus:outline-none focus:ring-2 focus:ring-gray-300" />
             <label for="password" class="block text-gray-700 text-sm font-bold mb-2">비밀번호:</label>
             <input type="password" id="pass" name="pass" class="w-full px-4 py-2 border rounded-md focus:outline-none focus:ring-2 focus:ring-gray-300" />
            
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