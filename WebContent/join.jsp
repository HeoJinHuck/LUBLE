<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="javax.sql.*"%>
<%@ page import="javax.naming.*"%>
<%
	String id=(String)request.getAttribute("id");
%>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>회원 가입| LUBLE </title>
<script src="https://cdn.tailwindcss.com"></script>
<link href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@400;600&display=swap" rel="stylesheet">
<script>
    function validateForm(event) {
      event.preventDefault(); // 기본 동작 중지

      var id = document.getElementById("id").value;
      var pass = document.getElementById("pass").value;
      var passConfirm = document.getElementById("passConfirm").value;
      var name = document.getElementById("name").value;
      var email = document.getElementById("email").value;
      var address = document.getElementById("address").value;

      if (!id || !pass || !passConfirm || !name || !email || !address) {
        alert("모든 필수 입력 항목을 입력하세요.");
        return false;
      }

      if (pass !== passConfirm) {
        alert("비밀번호가 일치하지 않습니다.");
        return false;
      }

      document.forms["joinForm"].submit(); // 모든 유효성 검사가 통과하면 양식을 제출합니다.

    }
 </script>
</head>
<body class="bg-gray-50 text-gray-700">


	<jsp:include page="header.jsp"></jsp:include>


<!--  메인    -->  
    <main class="container mx-auto px-4 py-8 flex flex-col items-center">		      
        <section class="max-w-lg mx-auto">
              <h1 class="text-3xl font-bold text-gray-900 mb-8 text-center">회원가입</h1>
        <form action="./memberJoin.me" name="joinForm" method="post" onsubmit="validateForm(event);">

                <label for="username" class="block text-gray-700 text-sm font-bold mb-2">아이디:</label>
            	<input type="text" id="id" name="id" class="w-full px-4 py-2 border rounded-md focus:outline-none focus:ring-2 focus:ring-gray-300" />
             	
             	<label for="password" class="block text-gray-700 text-sm font-bold mb-2">비밀번호*</label>
             	<input type="password" id="pass" name="pass" class="w-full px-4 py-2 border rounded-md focus:outline-none focus:ring-2 focus:ring-gray-300" />
            
                <label for="password" class="block text-gray-700 text-sm font-bold mb-2">비밀번호 확인*</label>
             	<input type="password" id="passConfirm" name="pass" class="w-full px-4 py-2 border rounded-md focus:outline-none focus:ring-2 focus:ring-gray-300" />
   				
   				<label for="name" class="block text-gray-700 text-sm font-bold mb-2">이름:</label>
                <input type="text" name="name" id="name" class="w-full px-4 py-2 border rounded-md focus:outline-none focus:ring-2 focus:ring-gray-300" />     
                
                <label for="email" class="block text-gray-700 text-sm font-bold mb-2">이메일:</label>
                <input type="email" name="email" id="email" class="w-full px-4 py-2 border rounded-md focus:outline-none focus:ring-2 focus:ring-gray-300" />

                <label for="address" class="block text-gray-700 text-sm font-bold mb-2">주소:</label>
                <input type="text" name="addr" id="address" class="w-full px-4 py-2 border rounded-md focus:outline-none focus:ring-2 focus:ring-gray-300" />
                
                <button type="submit" class="w-full bg-black text-white rounded-md py-2 mt-3">가입하기</button>
            </form>
        </section>
    </main>


<!--  푸터    -->
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