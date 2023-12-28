<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="vo.ShoseInfo"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%
    ArrayList<ShoseInfo> shoseinfo = (ArrayList<ShoseInfo>) request.getAttribute("number1List");
%>
<html>
<head>
<meta charset="UTF-8">

    <link rel="stylesheet" href="style.css">
    <title>배송관리 | LUBLE</title>
</head>
<body>

<%
    String id = (String) request.getAttribute("id");
%>

<jsp:include page="AdminHeader.jsp"></jsp:include>
<!-- AdminInventory.jsp 메인 -->

<div class="container mt-10">
    <div class="overflow-x-auto relative shadow-md sm:rounded-lg">
        <table class="w-full text-sm text-left text-gray-500">
            <thead class="text-xs text-gray-700 uppercase ">
            <tr>
                <th scope="col" class="py-3 px-6 ">모델</th>
                <th scope="col" class="py-3 px-6 ">가격</th>
                <th scope="col" class="py-3 px-6 ">사이즈</th>
                <th scope="col" class="py-3 px-6 ">검수 단계</th>
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
                <td class="px-5 py-6 border-b border-gray-200 bg-white font-semibold ">
                    <form action="adminStatusUpdate12.ad" method="GET">               
                        <input type="hidden" name="shonum" value="<%= shoseinfo.get(i).getShonum() %>">
                        <button type="submit" class="text-red-500 hover:text-red-700">배송 확인</button>
                    </form>
                </td>
            </tr>
           
            <% } %>
            <% } %>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
