<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="vo.ShoseInfo"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat"%>

<%
	ArrayList<ShoseInfo> shoseinfo = (ArrayList<ShoseInfo>) request.getAttribute("sizeinventory");
%>
    
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="style.css">
</head>
<body>
<%
    String id = (String) request.getAttribute("id");
%>
<jsp:include page="AdminHeader.jsp"></jsp:include>

<div class="container mt-10">
    <div class="overflow-x-auto relative shadow-md sm:rounded-lg">
        <table class="w-full text-sm text-left text-gray-500">
            <thead class="text-xs text-gray-700 uppercase">
                <tr>
                    <th scope="col" class="py-3 px-6 ">모델</th>
                    <th scope="col" class="py-3 px-6 ">사이즈</th>
                    <th scope="col" class="py-3 px-6 ">재고</th>
                </tr>
            </thead>
            <tbody>
                <% 
                    if (shoseinfo != null) {
                        for (int i = 0; i < shoseinfo.size(); i++) { 
                %>
                <tr class="bg-white border-b">
                    <td class="py-4 px-6 font-semibold "><%= shoseinfo.get(i).getModel() %></td>
                    <td class="py-4 px-6 font-semibold "><%= shoseinfo.get(i).getSize() %></td>
                    <% 
                        if (shoseinfo.get(i).getCount().equals("0")) { 
                    %>
                        <td class="py-4 px-6 font-semibold  text-black-500"><%= shoseinfo.get(i).getCount() %></td>
                    <% 
                        } else if (Integer.parseInt(shoseinfo.get(i).getCount()) > 0) { 
                    %>
                        <td class="py-4 px-6 font-semibold  text-red-500"><%= shoseinfo.get(i).getCount() %></td>
                    <% 
                        }
                    %>
                </tr>
                
                <% 
                    } 
                %>
                <% 
                    } 
                %>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
