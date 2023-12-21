<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="vo.ShoseInfo"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat"%>

<%
	ArrayList<ShoseInfo> shoseinfo = (ArrayList<ShoseInfo>) request.getAttribute("inventory");
%>
    
<html>
<head>
    <meta charset="UTF-8">
    <title>재고 | LUBEL</title>
    <script src="https://cdn.tailwindcss.com"></script>
    <link rel="stylesheet" href="style.css">
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@700&display=swap" rel="stylesheet">
</head>
<body>

<jsp:include page="AdminHeader.jsp"></jsp:include> 

<div class="container mt-10">
<div class="overflow-x-auto relative shadow-md sm:rounded-lg">
    
    <form action="admininventory.ad" method="post">
	<div class="w-full max-w-md">
    <div class="flex items-center border-b border-gray-300 py-2">
    <input class="appearance-none bg-transparent border-none w-full text-gray-700 mr-3 py-1 px-2 leading-tight focus:outline-none" 
        		type="text" id="search" name="search">
    <button type="submit" class="flex-shrink-0 border-transparent border-4 text-gray-500 hover:text-gray-700 text-sm py-1 px-2 rounded">
          	검 색
    </button>
   </div>
 </div>
</form>
    
    
        <table class="w-full text-sm text-left text-gray-500">
            <thead class="text-xs text-gray-700 uppercase">
                <tr>
                    <th scope="col" class="py-3 px-6 font-semibold ">브랜드</th>
                    <th scope="col" class="py-3 px-6 font-semibold">모델</th>
                    <th scope="col" class="py-3 px-6 font-semibold">재고</th>
                    <th scope="col" class="py-3 px-6 font-semibold">사이즈 별 재고</th>
                </tr>
            </thead>
            <tbody>
                <% 
                if (shoseinfo != null) {
                    for (int i = 0; i < shoseinfo.size(); i++) { 
                %>
                <tr class="bg-white border-b">
                    <td class="py-4 px-6 font-semibold "><%= shoseinfo.get(i).getBrand() %></td>
                    <td class="py-4 px-6 font-semibold "><%= shoseinfo.get(i).getModel() %></td>
                    <td class="py-4 px-6 font-semibold "><%= shoseinfo.get(i).getCount() %></td>
                    <td class="px-5 py-5 border-b border-gray-200 bg-white font-semibold ">
                        <form action="admininventorysize.ad" method="GET">               
                            <input type="hidden" name="model" value="<%= shoseinfo.get(i).getModel() %>">
                            <button type="submit" class="text-red-500 hover:text-red-700">재고</button>
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
