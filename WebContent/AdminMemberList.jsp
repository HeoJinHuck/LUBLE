<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="vo.userinfo"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat"%>

<%
	ArrayList<userinfo> userinfo = (ArrayList<userinfo>) request.getAttribute("userList");
%>



<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원 목록| LUBLE</title>
    <link rel="stylesheet" href="style.css">

</head>

<body>
<%
    String id = (String) request.getAttribute("id");
%>

<jsp:include page="AdminHeader.jsp"></jsp:include>

<div class="container mt-10">
    <div class="overflow-x-auto relative shadow-md sm:rounded-lg">
        
<form action="clientmember.ad" name="search">
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
            <thead class="text-xs text-gray-700 uppercase ">
                <tr>
                    <th scope="col" class="py-3 px-6 text-red-500">아이디</th>
                    <th scope="col" class="py-3 px-6">비밀번호</th>
                    <th scope="col" class="py-3 px-6">주소</th>
                    <th scope="col" class="py-3 px-6">이름</th>
                    <th scope="col" class="py-3 px-6">이메일</th>
                    <th scope="col" class="py-3 px-6">포인트</th>
                    <th scope="col" class="py-3 px-6">삭제 여부</th>
                </tr>
            </thead>
            <tbody>
                <% 
                    if (userinfo != null) {
                        for (int i = 0; i < userinfo.size(); i++) { 
                %>
                <tr class="bg-white border-b">
                    <td class="py-4 px-6 font-semibold text-red-500"><%= userinfo.get(i).getUserid() %></td>
                    <td class="py-4 px-6 font-semibold"><%= userinfo.get(i).getPass() %></td>
                    <td class="py-4 px-6 font-semibold"><%= userinfo.get(i).getAddress() %></td>
                    <td class="py-4 px-6 font-semibold"><%= userinfo.get(i).getName() %></td>
                    <td class="py-4 px-6 font-semibold"><%= userinfo.get(i).getEmail() %></td>
                    <td class="py-4 px-6 font-semibold"><%= userinfo.get(i).getPoint() %></td>
                    <% if (userinfo.get(i).getSecession().equals("n")) { %>
                    <td class="py-4 px-6 font-semibold"><a href="clientDelite.ad?id=<%= userinfo.get(i).getUserid() %>">삭제하기</a></td>
                    <% } else { %>
                    <td class="py-4 px-6 font-semibold"><a href="clientmember.ad">삭제 완료</a></td>
                    <% } %>
                </tr>
                <%} %>
                <%} %>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
