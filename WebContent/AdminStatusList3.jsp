<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="vo.ShoseInfo"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%
	ArrayList<ShoseInfo> shoseinfo = (ArrayList<ShoseInfo>) request.getAttribute("number3List");
%>
<%
	String id = (String) request.getAttribute("id");
%>
<html>
<head>
<title>검수 중 | LUBLE</title>
    <script src="https://cdn.tailwindcss.com"></script>
    <link rel="stylesheet" href="style.css">
    <title>배송 중 인 상품 리스트</title>
</head>
<body>

<jsp:include page="AdminHeader.jsp"></jsp:include>

<div class="container mt-10">
    <div class="overflow-x-auto relative shadow-md sm:rounded-lg">
        <table class="w-full text-sm text-left text-gray-500">
            <thead class="text-xs text-gray-700 uppercase">
                <tr>
                    <th scope="col" class="py-3 px-6 ">모델</th>
                    <th scope="col" class="py-3 px-6 ">가격</th>
                    <th scope="col" class="py-3 px-6 ">사이즈</th>
                    <th scope="col" class="py-3 px-6 ">판매 중 상태</th>
                </tr>
            </thead>
            <tbody>
                <% 
                if (shoseinfo != null) {
                    for (int i = 0; i < shoseinfo.size(); i++) { 
                %>
                <tr class="bg-white border-b">
                    <td class="py-4 px-6 font-semibold "><%= shoseinfo.get(i).getModel() %></td>
                    <td class="py-4 px-6 font-semibold "><%= shoseinfo.get(i).getPrice() %></td>
                    <td class="py-4 px-6 font-semibold "><%= shoseinfo.get(i).getSize() %></td>
                    <td class="py-4 px-6 font-semibold "><%= shoseinfo.get(i).getPass() %></td>
                </tr>
            
                <% } %>
                <% } %>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
                