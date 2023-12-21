<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="vo.ShoseInfo"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%
	ArrayList<ShoseInfo> shoseInfo = (ArrayList<ShoseInfo>) request.getAttribute("articleList");
	ArrayList<ShoseInfo> tradeInfo = (ArrayList<ShoseInfo>) request.getAttribute("tradeList");
%>
<html>
<head>
<title>전체 리스트| LUBLE</title>
<meta charset="UTF-8">
<style>
#shoe-list {
	display: flex;
	flex-direction: row;
	flex-wrap: wrap;
	justify-content: center;
	margin-top: 30px;
	text-align: right;
}

.shoe-card {
	width: 200px;
	height: auto;
	margin-right: 24px;
	margin-bottom: 20px;
	border: 1px solid;
	border-radius: 12px;
	display: flex;
	flex-direction: column;
}

.shoe-contents {
	display: flex;
	flex-direction: column;
	padding: 8px;
}

.shoe-price {
	font-size: 16px;
	font-weight: 600;
	margin-top: 2px;
}

.img {
	width: 100%;
	height: 150px;
}

.img-container {
	width: 100%;
	height: 150px;
	overflow: hidden;
	display: block;
	margin: 0 auto;
}
</style>
<link
	href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css"
	rel="stylesheet">
</head>
<body>
	<h2 class="text-2xl font-semibold my-5 mx-20">Popular List</h2>
	<div id="shoe-list" class="shoe-list">
		<%
			if (shoseInfo != null) {
			int displayCount = 6; // Initial number of items to display
			for (int i = 0; i < shoseInfo.size(); i++) {
		%>
		<div class="shoe-card"
			style="<%if (i >= displayCount) {%> display: none; <%}%>">
			<a href="ShoesDetail.sho?model=<%=shoseInfo.get(i).getModel()%>"
				class="img-container"> <img
				src="<%=shoseInfo.get(i).getShoImage()%>" class="img">
			</a>
			<div class="shoe-contents">
				<span class="shoe-name"><%=shoseInfo.get(i).getModel()%></span>
				<%
					if (shoseInfo.get(i).getPrice() == 0) {
				%>
				<span class="shoe-price">-</span>
				<%
					} else {
				%>
				<span class="shoe-price"><%=shoseInfo.get(i).getPrice()%>원</span>
				<%
					}
				%>
			</div>
		</div>
		<%
			}
		%>
		<%
			}
		%>
	</div>
	<div class="text-center" id="loadMoreContainer">
		<button id="loadMore" class="bg-white text-black border-black px-6 py-3 ">더보기</button>
	</div>
	<h2 class="text-2xl font-semibold my-5 mx-20">Trading Top List</h2>
	<div id="shoe-list" class="shoe-list">
		<%
			if (tradeInfo != null) {
			int displayCount = 6; // Initial number of items to display
			for (int i = 0; i < tradeInfo.size(); i++) {
		%>
		<div class="shoe-card"
			style="<%if (i >= displayCount) {%> display: none; <%}%>">
			<a href="ShoesDetail.sho?model=<%=tradeInfo.get(i).getModel()%>"
				class="img-container"> <img
				src="<%=tradeInfo.get(i).getShoImage()%>" class="img">
			</a>
			<div class="shoe-contents">
				<span class="shoe-name"><%=tradeInfo.get(i).getModel()%></span>
				<%
					if (tradeInfo.get(i).getPrice() == 0) {
				%>
				<span class="shoe-price">-</span>
				<%
					} else {
				%>
				<span class="shoe-price"><%=tradeInfo.get(i).getPrice()%>원</span>
				<%
					}
				%>
			</div>
		</div>
		<%
			}
		%>
		<%
			}
		%>
	</div>
	<script>
		document.getElementById('loadMore').addEventListener(
				'click',
				function() {
					let shoeCards = document.querySelectorAll('.shoe-card');
					let displayCount = 3; // Change this value as per your requirement

					for (let i = displayCount; i < shoeCards.length; i++) {
						shoeCards[i].style.display = 'block';
					}

					// Move the "더보기" button below the products
					let shoeList = document.getElementById('shoe-list');
					let loadMoreContainer = document
							.getElementById('loadMoreContainer');
					shoeList.appendChild(loadMoreContainer.cloneNode(true));
					loadMoreContainer.remove();
				});
	</script>
</body>

</html>
