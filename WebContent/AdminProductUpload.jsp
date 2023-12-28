<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ page import="java.sql.*"%>
<%@ page import="javax.sql.*"%>
<%@ page import="javax.naming.*"%>
<html>
<head>
<meta charset="UTF-8">
<script src="https://cdn.tailwindcss.com"></script>
<link rel="stylesheet" href="style.css">
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@700&display=swap" rel="stylesheet">

<meta charset="UTF-8">
<title>상품등록 | LUBLE</title>
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
        }

        .menu_bar a:hover,
        .manager_info a:hover {
            color: #007aff;
        }

        .logo {
            width: 95px;
            height: auto;
        }
</style>
</head>

<body>

<jsp:include page="AdminHeader.jsp"></jsp:include>
	
<!-- 메인  -->
<main class="container mx-auto px-4 py-8">
        <section class="max-w-lg mx-auto">
           <h2 class="text-3xl font-semibold mb-6 text-center text-semibold">제품 등록</h2>
 			
 			<form action="adminProudctUpload.ad" enctype="multipart/form-data" method="post">
                <div class="mb-4">
                    <label for="brand" class="block text-sm font-medium mb-1">브랜드</label>
                    <input type="text" name="brand" id="brand" class="w-full border-gray-300 rounded-md shadow-sm">
                </div>
                <div class="mb-4">
                    <label for="text" class="block text-sm font-medium mb-1">모델</label>
                    <input type="text" name="model" id="model" class="w-full border-gray-300 rounded-md shadow-sm">
                </div>
              	
              	<div class="mb-4">
                    <label for="text" class="block text-sm font-medium mb-1">종류</label>
                    <input type="text" name="kind" id="kind" class="w-full border-gray-300 rounded-md shadow-sm">
                </div>
               
                <div class="mb-4">
                    <label for="fileName1" class="block text-sm font-medium mb-1">이미지</label>
                    <input type="file" name="fileName1" id = "fileName1" class="w-full border-gray-300 rounded-md shadow-sm">
                </div>
                
                <button type="submit" class="w-full bg-black text-white rounded-md py-2">제품등록</button>
            </form>
        </section>
    </main>
 
</body>
</html>
