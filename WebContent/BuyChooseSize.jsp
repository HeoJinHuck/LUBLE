<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="vo.ShoseInfo"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%
    ArrayList<ShoseInfo> shoesList = (ArrayList<ShoseInfo>) request.getAttribute("shoeslist");
    String model = request.getParameter("model");
    String shoeimage=(String)request.getAttribute("shoeimage");
%>

<html lang="ko">
<head>
<title>사이즈 선택 | LUBLE</title>
<meta charset="UTF-8">
 <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-100">
    <jsp:include page="header.jsp"></jsp:include>

    <div class="min-h-screen flex items-center justify-center">
        <div class="bg-white p-6 rounded-lg product-card">
            <div class="flex flex-col items-cente mb-5">
                <div class="mt-3">
                    <p class="text-red-600 text-xl font-semibold "><%=request.getParameter("model")%></p>
                </div>
            </div>
            
        <div class="grid grid-cols-3 gap-4">
        <!-- 숫자를 세 개씩 나열 -->
        <% for (int i = 0; i < shoesList.size(); i ++) { %>
            <form method="post" class="text-center border p-4 rounded-lg">
                <a href="#" class="text-black-500 hover:text-red-700" onclick="submitForm(<%=shoesList.get(i).getSize()  %>)">
                    <p class="text-lg font-semibold"><%= shoesList.get(i).getSize() %></p>
                    <p class="text-gray-500"><%= shoesList.get(i).getPrice() == 0 ? "구매입찰" : shoesList.get(i).getPrice() + "원" %></p>
                </a>
            </form>
        <% } %>
    </div>
        </div>
    </div>

    <jsp:include page="footer.jsp"></jsp:include>

    <script>
        function submitForm(size) {
            var model = '<%= model %>';
            var boc = '<%= request.getParameter("boc") %>';
            var shoeimage = '<%= shoeimage %>';
            var url = 'SelecShoes.sho?model=' + model + '&size=' + size + '&boc=' + boc + '&shoeimage=' + shoeimage;
            window.location.href = url;
        }
    </script>
</body>
</html>
