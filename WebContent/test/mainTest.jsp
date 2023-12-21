<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>	
	<form action="ShoSearch.sho" method="post">
		<input type="text" id="search" name="search">
		<input type="submit" value="검색">
	</form>
	<a href="ShoseUpload.jsp?cell=min">현재가 판매</a>
	<a href="ShoseUpload.jsp?cell=want">판매가 설정</a>
	<a href="ShoList.sho">상품 리스트 보기</a>
</body>
</html>