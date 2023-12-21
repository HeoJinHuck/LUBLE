<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import="vo.ShoseInfo"%>
<%@ page import="vo.userinfo"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat"%>

<%
	ShoseInfo shoesinfo = (ShoseInfo) request.getAttribute("shoesinfo");
userinfo userinfo = (userinfo) request.getAttribute("userinfo");
%>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>구매 3단계| LUBLE</title>
<script src="https://cdn.tailwindcss.com"></script>

<script>
	function validateForm() {
		var checkboxes = document.getElementsByName('color');
		var isChecked = false;
		for (var i = 0; i < checkboxes.length; i++) {
			if (checkboxes[i].checked) {
				isChecked = true;
				break;
			}
		}
		if (!isChecked) {
			alert('약관에 동의해 주세요.');
			return false;
		}

		return true;
	}
</script>

<style>
.disabled-link {
	pointer-events: none;
	opacity: 0.5;
}

.custom-checkbox {
	width: 4.5rem;
	height: 4.5rem;
}
</style>
</head>
<body class="bg-gray-100">
	<div class="container mx-auto p-4">
		<jsp:include page="header.jsp"></jsp:include>

		<div class="bg-white p-4 rounded-md shadow-md mb-6">

			<div class="bg-white p-4 shadow rounded-lg">
				<div class="flex items-center space-x-4">
					<img class="w-20 h-20 object-cover rounded"
						src="<%=shoesinfo.getShoImage()%>" alt="Product Image">
					<div>
						<p class="text-gray-600 text-sm"><%=shoesinfo.getModel()%></p>
						<p class="text-gray-900 font-bold mt-2"><%=shoesinfo.getPrice() + shoesinfo.getCheckprice() + "원"%></p>
					</div>
				</div>
			</div>

			<div class="bg-white mt-4 p-4 shadow rounded-lg">
				<h3 class="text-lg font-semibold mb-2">배송 주소</h3>
				<div class="border-t pt-2">
					<p class="text-gray-600 text-sm"><%=userinfo.getAddress()%></p>
					<button
						class="text-blue-600 hover:text-blue-800 transition duration-300 mt-2">주소
						변경하기</button>
				</div>
			</div>

			<div class="bg-white mt-4 p-4 shadow rounded-lg">
				<h3 class="text-lg font-semibold mb-2">배송 방법</h3>
				<div class="flex items-center justify-between border-t pt-2">
					<div class="flex items-center">
						<img src="./images/Delivery.png"
							class="w-10 h-10 object-cover rounded-full mr-2">
						<div>
							<p class="text-gray-900 font-semibold">판매자 부담</p>
							<p class="text-gray-600 text-sm"><%=userinfo.getAddress()%>(배송
								완료 및 검수 기준 통과 시 금액 정산)
							</p>
						</div>
					</div>
				</div>
			</div>

			<div class="bg-white mt-4 p-4 shadow rounded-lg">
				<h3 class="text-lg font-semibold mb-2">검수비(판매금액의 5%)</h3>
				<input type="text" id="inspection-fee" name="inspection-fee"
					class="mt-1 p-2 block w-full border-gray-300 rounded-md shadow-sm"
					placeholder="수수료(검수비 포함)가 자동으로 계산됩니다 ※최소 수수료 5,000원" disabled>
			</div>

			<%
				int cprice = (shoesinfo.getPrice()) / 20 > 5000 ? shoesinfo.getPrice() / 20 : 5000;
			%>
			<div class="bg-white mt-4 p-4 shadow rounded-lg">
				<h3 class="text-lg font-semibold mb-2">최종 주문 정보</h3>
				<div class="mt-1 p-2 border border-gray-300 rounded-md">

					<p>
						상품명:
						<%=shoesinfo.getModel()%></p>
					<p>수량: 1</p>
					<p>
						가격: ₩<%=shoesinfo.getPrice()%></p>
					<p>배송비: ₩3000
					<p>
						중개수수료: ₩<%=shoesinfo.getCheckprice()%></p>
					<p class="font-semibold">
						총 결제금액: ₩<%=shoesinfo.getPrice() + shoesinfo.getCheckprice() + 3000%></p>
				</div>
			</div>
			<form method="post" action="decision.sho"
				onsubmit="return validateForm()">

				<div class="bg-white mt-4 p-4 shadow rounded-lg">
					<h3 class="text-lg font-semibold mb-2">구매 전 약관 동의</h3>
					<div class="border-t-2 pt-4">
						<div class="flex items-center justify-between mb-2">
							<p>구매하려는 상품이 맞습니다.</p>
							<div>
								<input type="checkbox" name="color" value="blue"
									class="checkmark text-green-500" />
								<div class="checkmark_stem"></div>
								<div class="checkmark_kick"></div>
							</div>

						</div>
						<p class="text-sm mb-2">번호, 출시일, 상품명, 사이즈를 한 번 더 확인했습니다.</p>
						<br>
					</div>
					<input type="hidden" name="shonum"
						value="<%=shoesinfo.getShonum()%>"> <input type="hidden"
						name="addr" value="<%=userinfo.getAddress()%>">
					<button
						class="w-full bg-gray-700 hover:bg-red-500 text-white font-bold py-2 px-4 rounded focus:outline-none focus:shadow-outline"
						type="submit">구매 하기</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>