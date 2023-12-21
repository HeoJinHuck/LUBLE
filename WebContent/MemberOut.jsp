<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ page import="vo.ShoseInfo"%>
	<%@ page import="java.util.*" %>
	<%@ page import="java.text.SimpleDateFormat" %>
<!DOCTYPE html>
<% String id=(String)session.getAttribute("id"); %>
<html>
<head>
<meta charset="UTF-8">
<title>회원 탈퇴 | LUBLE</title>
</head>
<body>
	<form method="post" action="MemberOut.me">
		<input type="submit" value="탈퇴탈퇴">
	</form>
	
</body>
</html>