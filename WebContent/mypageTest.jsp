<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*"%>
	<%@ page import="java.text.SimpleDateFormat"%>
    <%
    	int sell[]= new int[5];
    	sell=(int[])request.getAttribute("sell");
    	int buy[]= new int[3];
    	buy=(int[])request.getAttribute("buy");
		String email=(String)request.getAttribute("email");
		String id=(String)request.getAttribute("id");
    %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://cdn.tailwindcss.com"></script>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;700&display=swap" rel="stylesheet">
    <style>
        body {
            font-family: 'Noto Sans KR', sans-serif;
        }
        .profile-card {
            background-color: #f9f9f9;
            border-radius: 8px;
            padding: 16px;
        }
        .profile-card-header {
            font-weight: 700;
            margin-bottom: 16px;
        }
        .profile-stat-label {
            color: #6b7280;
        }
        .profile-stat-value {
            font-weight: 700;
        }
        .btn-green {
            background-color: #10b981;
            color: white;
            border-radius: 9999px;
            padding: 8px 16px;
            font-weight: 700;
            display: inline-flex;
            align-items: center;
            gap: 8px;
        }
        .btn-green svg {
            fill: currentColor;
        }
    </style>
</head>
<body class="bg-white text-gray-800">

<jsp:include page="mypage.jsp"></jsp:include>
 
    <div class="container mx-auto p-6">
        <main class="flex gap-6 mt-8">
            <section class="w-3/4">
                <div class="profile-card mb-6">
                    <div class="flex items-center gap-4 mb-4">
                        <div class="rounded-full bg-gray-300 w-16 h-16"></div>
                        <div>
                            <div class="font-bold text-lg"><%=id%></div>
                            <div class="text-sm"><%=email %></div>
                            <a href="loginModify.jsp" class="text-blue-600 text-sm hover:underline">프로필 관리</a>
                        </div>
                    </div>
                    <div class="grid grid-cols-4 gap-4">
                        <div>
                            <div class="profile-stat-label">판매 신청</div>
                            <div class="profile-stat-value"><%=sell[0]+sell[1]+sell[2]+sell[3]+sell[4]%></div>
                        </div>
                        <div>
                            <div class="profile-stat-label">배송 중</div>
                            <div class="profile-stat-value"><%=sell[0]%></div>
                        </div>
                        <div>
                            <div class="profile-stat-label">검수 중</div>
                            <div class="profile-stat-value"><%=sell[1]%></div>
                        </div>
                        <div>
                            <div class="profile-stat-label">판매 중</div>
                            <div class="profile-stat-value"><%=sell[2]%></div>
                        </div>
                        <div>
                            <div class="profile-stat-label">검수 불합격</div>
                            <div class="profile-stat-value"><%=sell[4]%></div>
                        </div>
                        <div>
                            <div class="profile-stat-label">거래완료</div>
                            <div class="profile-stat-value"><%=sell[3]%></div>
                        </div>
                    </div>
                </div>

                <div class="profile-card">
                    <div class="profile-card-header">구매 내역</div>
                    <div class="grid grid-cols-4 gap-4 mb-4">
                        <div>
                            <div class="profile-stat-label">구매 신청</div>
                            <div class="profile-stat-value"><%=buy[0]+buy[1]+buy[2] %></div>
                        </div>
                        <div>
                            <div class="profile-stat-label">입금 중</div>
                            <div class="profile-stat-value"><%=buy[0] %></div>
                        </div>
                        <div>
                            <div class="profile-stat-label">배송 중</div>
                            <div class="profile-stat-value"><%=buy[1] %></div>
                        </div>
                        <div>
                            <div class="profile-stat-label">거래완료</div>
                            <div class="profile-stat-value"><%=buy[2] %></div>
                        </div>
                    </div>                  
                </div>
                
            </section>
        </main>
    </div>
    <jsp:include page="footer.jsp"></jsp:include>
</body>
</html>