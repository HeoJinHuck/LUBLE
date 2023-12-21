<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="vo.ShoseInfo"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat"%>

<%
	ArrayList<ShoseInfo> shoesinfo = (ArrayList<ShoseInfo>) request.getAttribute("UploadList");
%>


<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>상품리스트 | LUBLE</title>
    <link rel="stylesheet" href="style.css">

</head>

<body class="bg-gray-50">
<%
	String id = (String) request.getAttribute("id");
%>

<jsp:include page="AdminHeader.jsp"></jsp:include>

<div class="container mt-10">
<div class="overflow-x-auto relative shadow-md sm:rounded-lg">
        
<form action="adminUploadList.ad" name="search">
<div class="w-full max-w-md">
 <div class="flex items-center border-b border-gray-300 py-2">
	<input type="text" id="search" name="search" 
	class="appearance-none bg-transparent border-none w-full text-gray-700 mr-3 py-1 px-2 leading-tight focus:outline-none">
	<button type="submit" 
	class="flex-shrink-0 border-transparent border-4 text-gray-500 hover:text-gray-700 text-sm py-1 px-2 rounded">
검 색
</button>
</div>
</div>
</form>
    
<table class="w-full text-sm text-left text-gray-500">
<thead class="text-xs text-gray-700 uppercase bg-gray-50">
<tr>
	<th scope="col" class="py-3 px-6 font-semibold">브랜드</th>
	<th scope="col" class="py-3 px-6 font-semibold">모델</th>
	<th scope="col" class="py-3 px-6 font-semibold">종류</th>
	<th scope="col" class="py-3 px-6 font-semibold">삭제 여부(0==등록상태)</th>
</tr>
</thead>
<tbody>
<% 
	if (shoesinfo != null) {
		for (int i = 0; i < shoesinfo.size(); i++) { 
%>
  <tr class="bg-white border-b">
  	<td class="py-4 px-6 font-semibold"><%= shoesinfo.get(i).getBrand() %></td>
    <td class="py-4 px-6 font-semibold"><%= shoesinfo.get(i).getModel() %></td>
    <td class="py-4 px-6 font-semibold"><%= shoesinfo.get(i).getKind() %></td>
   <% if (shoesinfo.get(i).getShoedelete()==0) { %>
    <td class="py-3 px-5 font-semibold">
        <a href="adminUploadDelete.ad?model=<%=shoesinfo.get(i).getModel()%>">등록 상태</a>
    </td>
	<% } else { %>
    <td class="py-3 px-5 font-semibold">미등록 상태</td>
	<% } %>

  </tr>
  <%}%>
<%}%>
</tbody>
</table>
</div>
</div>
</body>
</html>
