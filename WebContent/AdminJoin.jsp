<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="javax.sql.*"%>
<%@ page import="javax.naming.*"%>
<%
String id = (String)request.getAttribute("id");
%>


<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원가입 | LUBLE</title>
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

        .logo {
            width: 95px;
            height: auto;
        }

        .container {
            max-width: 1024px;
            margin: 0 auto;
            padding: 0 20px;
        }
</style>
</head>


<body>

	<jsp:include page="AdminHeader.jsp"></jsp:include>
<!--  메인    -->
   		
    <main class="container mx-auto px-4 py-8">
        <section class="max-w-lg mx-auto">
           <h2 class="text-3xl font-semibold mb-6 text-center ">관리자 회원생성</h2>
 			<form action="./adminmember.ad" name="AdminjoinForm" method="post">
                <div class="mb-4">
                    <label for="id" class="block text-sm font-medium mb-1 font-semibold ">아이디</label>
                    <input type="text" name="id" id="id" class="w-full  rounded-md shadow-sm" required>
                </div>
                <div class="mb-4">
                    <label for="password" class="block text-sm font-medium mb-1 font-semibold ">비밀번호*</label>
                    <input type="password" name="pass" id="password" class="w-full border-gray-300 rounded-md shadow-sm" required>
                </div>
                <div class="mb-4">
                    <label for="password-confirm" class="block text-sm font-medium mb-1 font-semibold">비밀번호 확인*</label>
                    <input type="password" id="password-confirm" class="w-full border-gray-300 rounded-md shadow-sm" required>
                </div>
                <div class="mb-4">
                    <label for="email" class="block text-sm font-medium mb-1 font-semibold">이메일</label>
                    <input type="email" name="email" id="email" class="w-full border-gray-300 rounded-md shadow-sm" required>
                </div>
                <div class="mb-4">
                    <label for="address" class="block text-sm font-medium mb-1 font-semibold">주소</label>
                    <input type="text" name="address" id="address" class="w-full border-gray-300 rounded-md shadow-sm" required>
                </div>
                <div class="mb-4">
                    <label for="grade" class="block text-sm font-medium mb-1 font-semibold">직무</label>
                    <input type="radio" name="grade" id="grade" class="" value="배송담당" >배송담당<br>
                	<input type="radio" name="grade" id="grade" class="" value="검수담당" >검수담당
                
                </div>
                <button type="submit" class="w-full bg-black text-white rounded-md py-2">가입하기</button>
            </form>
        </section>
    </main>
</body>
</html>