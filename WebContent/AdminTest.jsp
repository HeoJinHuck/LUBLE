<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*"%>
	<%@ page import="java.text.SimpleDateFormat"%>
    <%
    	String email=(String)request.getAttribute("email"); // 프로필 이메일 
		String id=(String)request.getAttribute("id"); // 프로필 아이디
		String shownumber1=(String)request.getAttribute("delivery"); // 배송 갯수
		String shownumber2=(String)request.getAttribute("check"); // 검수 갯수
		String shownumber3=(String)request.getAttribute("selling"); // 판매 갯수
		String shownumber4=(String)request.getAttribute("return"); // 반송 갯수
	%>
    
<html lang="ko">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>단, 한명의 위한 신발| LUBLE</title>
   	<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;700&display=swap" rel="stylesheet">
    <style>
        body {
           margin: 0;
           padding: 0;      
           font-family: 'Noto Sans KR', sans-serif;
        }
        .profile-card {// 
            border-radius: 8px;
            padding: 16px;
        }
    </style>
</head>
<body>

<jsp:include page="AdminHeader.jsp"></jsp:include>
 
    <div class="container mx-auto">
        <main class="flex gap-6">
            <section class="w-3/4">
                <div class="profile-card mb-10">
                    <div class="flex items-center gap-4 mb-4">
                        <div>
                            <div class="font-bold text-lg"><%=id%></div>
                            <div class="text-sm"><%=email %></div>
                            <a href="#" class="text-blue-600 text-sm hover:underline">프로필 관리</a>
                        </div>
                    </div>
                    <div class="grid grid-cols-4 gap-4">
                        <div>
                            <div class="font-semibold">배송 관리</div>
                            <div class="font-semibold"><%=shownumber1%></div>
                        </div>
                        <div>
                            <div class="font-semibold">검수 관리</div>
                            <div class="font-semibold"><%=shownumber2%></div>
                        </div>
                        <div>
                            <div class="font-semibold">판매 관리</div>
                            <div class="font-semibold"><%=shownumber3%></div>
                        </div>
                        <div>
                            <div class="font-semibold">반송 관리</div>
                            <div class="font-semibold"><%=shownumber4%></div>
                        </div>
                    </div>
                </div> 
            </section>
        </main>
    </div>
</body>
</html>