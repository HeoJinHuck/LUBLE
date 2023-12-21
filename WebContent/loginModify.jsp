<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="javax.sql.*"%>
<%@ page import="javax.naming.*"%>
<%@ page import="vo.userinfo"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%
    ArrayList<userinfo> userinfo= (ArrayList<userinfo>) request.getAttribute("joinMember");
	String id=(String)request.getAttribute("id");
%>

<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>회원 수정 | LUBLE</title>
<script src="https://cdn.tailwindcss.com"></script>
<link href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@400;600&display=swap" rel="stylesheet">
<style>
body {
font-family: 'Open Sans', sans-serif;
}
</style>
</head>
<body class="bg-white text-gray-700">
<jsp:include page="mypage.jsp"></jsp:include>
<div class="container mx-auto p-2">
<main class=" w-md rounded-lg">
<h1 class="text-2xl font-semibold mb-6">기본 회원정보</h1>
<div class="flex flex-col ">
<div class="w-full max-w-lg">
	<form method="post" action="memberLoginModify.me">
 
	<label for="password" class="block text-gray-700 text-sm font-bold mb-2">비밀번호*</label>
	<input type="password" id="pass" name="pass" class="w-full mb-5 px-4 py-2 border rounded-md focus:outline-none focus:ring-2 focus:ring-gray-300" placeholder="*****" />
				
	<label for="password" class="block text-gray-700 text-sm font-bold mb-2">비밀번호 확인*</label>
	<input type="password" id="passConfirm" name="pass" class="w-full mb-5 px-4 py-2 border rounded-md focus:outline-none focus:ring-2 focus:ring-gray-300" placeholder="*****" />

	<label for="email" class="block text-gray-700 text-sm font-bold mb-2">이메일:</label>
	<input type="email" name="email" id="email" class="w-full px-4  mb-5 py-2 border rounded-md focus:outline-none focus:ring-2 focus:ring-gray-300" placeholder="abc@naver.com" />

	<label for="address" class="block text-gray-700 text-sm font-bold mb-2">주소:</label>
	<input type="text" name="addr" id="address" class="w-full px-4 mb-5 py-2 border rounded-md mb-5 focus:outline-none focus:ring-2 focus:ring-gray-300" placeholder="대구시 달서구 파도고개로 70 1동 123호 " />
	
	<button class="bg-gray-500 hover:bg-gray-700 text-white font-bold py-2 px-4 rounded focus:outline-none focus:shadow-outline" type="submit">
	 정보 수정
	</button>
	<form action="MemberOut.me">
	<button class="bg-gray-500 hover:bg-gray-700 text-white font-bold py-2 px-4 rounded focus:outline-none focus:shadow-outline" type="submit">
	 회원 탈퇴
	</button>
	 </form>
</form>
</div>
</div>
</main>
</div>
</body>
</html>