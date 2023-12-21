<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="javax.sql.*"%>
<%@ page import="javax.naming.*"%>
<!DOCTYPE html>
<!-- 12-14 수정  -->
<html>
<head>
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@700&display=swap"
	rel="stylesheet">
<meta charset="UTF-8">
<style>
body {
	margin: 0;
	padding: 0;
}

nav {
	background-color: #fff;
	box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
}

.top_inner {
	display: flex;
	justify-content: center;
	align-items: center;
	padding: 15px 20px;
}

.menu_bar {
	list-style: none;
	display: flex;
	align-items: center;
	height: 50px;
}

.menu_bar li {
	margin-right: 20px;
	font-size: 18px;
}

.menu_bar a {
	font-family: 'Noto Sans KR', sans-serif;
	text-decoration: none;
	color: #333;
	transition: color 0.3s ease;
}

.menu_bar a:hover {
	color: #007aff;
}

.user_info a {
	font-family: 'Noto Sans KR', sans-serif;
	text-decoration: none;
	color: #333;
	margin-left: 20px;
	transition: color 0.3s ease;
	font-size: 18px;
}

.user_info a:hover {
	color: #007aff;
}

#searchForm {
	display: none;
	position: fixed;
	top: 12%;
	left: 50%;
	transform: translate(-50%, -50%);
	width: 80%;
	max-width: 400px;
	background-color: #fff;
	box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
	z-index: 1000;
	padding: 10px;
	border-radius: 5px;
	text-align: center;
}

#searchInput {
	width: 100%;
	padding: 10px;
	border: 1px solid #ddd;
	border-radius: 5px;
	margin-bottom: 10px;
	box-sizing: border-box;
}

#searchButton {
	width: 100%;
	padding: 10px;
	border: none;
	color: black;
	cursor: pointer;
	border-radius: 5px;
}
</style>
<script>
	document
			.addEventListener(
					'DOMContentLoaded',
					function() {
						// searchForm 얻어옴 form 태그부분 id값 
						var searchForm = document.getElementById('searchForm');
						// searchButton 얻어옴 a 태그 부분 검색 id값
						var searchButton = document
								.getElementById('searchButton');
						//searchButton 을 누르면 클릭이벤트가 일어남
						searchButton
								.addEventListener(
										'click',
										function() {
											//searchForm의 display가 >> block이 맞다면 -> none 해당 요소숨김 아니면 block searchform을껏다켯다함
											searchForm.style.display = (searchForm.style.display === 'block') ? 'none'
													: 'block';
										});
					});
</script>
<script>
	function submitOnEnter(event) {
		if (event.key === 'Enter') {
			event.preventDefault();
			document.getElementById('searchForm').submit();
		}
	}
</script>
</head>
<body>
	<%
		String id = (String) session.getAttribute("id");
	%>

	<nav>
		<div class="top_inner">
			<ul class="menu_bar">
				<li onclick="location.href='index.jsp'"><img
					src="./images/LUBLE.png" style="max-width: 300px; height: 80px;"></li>
				<li><a href="ShoSearch.sho?trade=trade">거래량 top</a></li>
				<li><a href="ShoSearch.sho">인기순</a></li>
				<li><a href="#" id="searchButton">검색</a> <!-- id searchButton이 -->
					<form id="searchForm" action="ShoSearch.sho" method="post">
						<input type="text" id="searchInput" name="search">
					</form></li>
			</ul>

			<div class="user_info">
				<%
					if (id == null) {
				%>
				<a href="join.jsp">회원가입 </a><b></b> <a href="login.jsp">로그인</a>
				<%
					} else {
				%>
				<a href="LogOut.me">로그아웃</a> <a href="myPage.my">마이 페이지</a>
				<%
					}
				%>
			</div>
		</div>
	</nav>
</body>
</html>