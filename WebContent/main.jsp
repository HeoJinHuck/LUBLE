<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="javax.sql.*"%>
<%@ page import="javax.naming.*"%>
<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>단,한명을 위한 신발 | LUBLE</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.css" />

<style>
.swiper {
	width: 100%;
	height: 100%;
}

.swiper-slide {
	text-align: center;
	font-size: 18px;
	background: #fff;
	display: flex;
	justify-content: center;
	align-items: center;
}

.swiper-slide img {
	display: block;
	width: 100%;
	height: 100%;
	object-fit: cover;
}

.swiper-pagination-bullet {
	width: 20px;
	height: 20px;
	text-align: center;
	line-height: 20px;
	font-size: 12px;
	color: #000;
	opacity: 1;
	background: rgba(0, 0, 0, 0.2);
}

.swiper-pagination-bullet-active {
	color: #fff;
	background: #007aff;
}

* {
	padding-top: 100px;
	padding: 0;
	box-sizing: border-box;
}

.section {
	display: flex;
	justify-content: center;
	flex-direction: column;
	font-family: 'Montserrat', sans-serif;
	height: 100vh;
}
</style>
</head>

<body>
	<%
		String id = (String) session.getAttribute("id");
	%>

	<jsp:include page="header.jsp"></jsp:include>

	<section>

		<div class="swiper mySwiper">
			<div class="swiper-wrapper">
				<div class="swiper-slide">
					<img src="./images/image1.png" alt="Slide 1">
				</div>
				<div class="swiper-slide">
					<img src="./images/image2.png" alt="Slide 2">
				</div>
				<div class="swiper-slide">
					<img src="./images/image3.png" alt="Slide 2">
				</div>
				<div class="swiper-slide">
					<img src="./images/image4.png" alt="Slide 2">
				</div>
				<div class="swiper-slide">
					<img src="./images/image5.png" alt="Slide 2">
				</div>
			</div>

			<div class="swiper-pagination"></div>
		</div>

	</section>

	<jsp:include page="MainShoesList.jsp"></jsp:include>
	
	<jsp:include page="footer.jsp"></jsp:include>


<script src="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.js"></script>
<script>
		document.addEventListener('DOMContentLoaded', function() 
			{
			var swiper = new Swiper(".mySwiper", 
			{
			pagination : 
			{
			el : ".swiper-pagination",
			clickable : true,
		},
		autoplay: {
			delay:2000,
		},
	});
});
	
</script>
</body>
</html></html>