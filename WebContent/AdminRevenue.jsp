<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="vo.ShoseInfo"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%
	ArrayList<ShoseInfo> shoseinfo = (ArrayList<ShoseInfo>) request.getAttribute("RevenueList");
%>
<html>
<head>
    <link rel="stylesheet" href="style.css">
    <meta charset="UTF-8">
    <title>수익 | LUBLE</title>
</head>

<body>

<jsp:include page="AdminHeader.jsp"></jsp:include>

<div class="container mt-10">
    <div class="overflow-x-auto relative shadow-md sm:rounded-lg">
        <table class="w-full text-sm text-left text-gray-500">
            <thead class="text-xs text-gray-700 uppercase">
                <tr>
                    <th scope="col" class="py-3 px-6 ">거래 일시</th>
                    <th scope="col" class="py-3 px-6 ">수익 금</th>
                </tr>
            </thead>
            <tbody>
                <%
                    int revenue = 0;
                    int a = 0;

                    if (shoseinfo != null) {
                        for (int i = 0; i < shoseinfo.size(); i++) {
                            revenue += shoseinfo.get(i).getCheckprice();
                            a++;
                        }
                    }
                %>
                <tr class="bg-white border-b">
                    <td class="py-4 px-6 font-semibold text-red-500">총 거래 수: <%= a %></td>
                    <td class="py-4 px-6 font-semibold text-red-500">총 수익금: <%= revenue %></td>
                </tr>
                <%
                    if (shoseinfo != null) {
                        for (int i = 0; i < shoseinfo.size(); i++) {
                %>
                <tr class="bg-white border-b">
                    <td class="py-4 px-6 font-semibold "><%= shoseinfo.get(i).getShonum() %></td>
                    <td class="py-4 px-6 font-semibold "><%= shoseinfo.get(i).getCheckprice() %></td>
                </tr>     
                <%}%> 

              <%}%>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
