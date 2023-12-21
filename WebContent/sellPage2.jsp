<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8"); %>
<html>
<head>
<meta charset="UTF-8">
<title>판매 2단계 | LUBLE</title>
</head>
<style>

* {
  box-sizing: border-box;
}

body {
  background: #f6f5f7;
  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;
  font-family: 'Montserrat', sans-serif;
  height: 100vh;
  margin: -20px 0 50px;
}

h1 {
  margin: 0;
 }

h2 {
  text-align: center;
}

p {
  font-size: 14px;
  font-weight: 100;
  line-height: 20px;
  letter-spacing: 0.5px;
  margin: 20px 0 30px;
}

span {
  font-size: 12px;
}

a {
  color: #333;
  font-size: 14px;
  text-decoration: none;
  margin: 15px 0;
}

button {
  border-radius: 20px;
  border: 1px solid #24272B;
  background-color: #24272B;
  color: #FFFFFF;
  font-size: 12px;
  font-weight: bold;
  padding: 12px 45px;
  letter-spacing: 1px;
  text-transform: uppercase;
  transition: transform 80ms ease-in;
}

button:active {
  transform: scale(0.95);
}

button:focus {
  outline: none;
}

button.ghost {
  background-color: transparent;
  border-color: #FFFFFF;
}

form {
  background-color: #FFFFFF;
  display: flex;
  align-items: center;
  justify-content: center;
  flex-direction: column;
  padding: 0 50px;
  height: 100%;
  text-align: center;
}

input {
  background-color: #eee;
  border: none;
  padding: 12px 15px;
  margin: 8px 0;
  width: 100%;
}

.container {
  background-color: #fff;
  border-radius: 10px;
    box-shadow: 0 14px 28px rgba(0,0,0,0.25), 
      0 10px 10px rgba(0,0,0,0.22);
  position: relative;
  overflow: hidden;
  width: 1240px;
  max-width: 100%;
  min-height: 840px;
}

.form-container {
  position: absolute;
  top: 0;
  height: 100%;
  transition: all 0.6s ease-in-out;
}

.sign-in-container {
  left: 0;
  width: 50%;
  z-index: 2;
}

.container.right-panel-active .sign-in-container {
  transform: translateX(100%);
}

.sign-up-container {
  left: 0;
  width: 50%;
  opacity: 0;
  z-index: 1;
}

.container.right-panel-active .sign-up-container {
  transform: translateX(100%);
  opacity: 1;
  z-index: 5;
  animation: show 0.6s;
}

@keyframes show {
  0%, 49.99% {
    opacity: 0;
    z-index: 1;
  }
  
  50%, 100% {
    opacity: 1;
    z-index: 5;
  }
}

.overlay-container {
  position: absolute;
  top: 0;
  left: 50%;
  width: 50%;
  height: 100%;
  overflow: hidden;
  transition: transform 0.6s ease-in-out;
  z-index: 100;
}

.container.right-panel-active .overlay-container{
  transform: translateX(-100%);
}

.overlay {
  background: #24272B;
  background-repeat: no-repeat;
  background-size: cover;
  background-position: 0 0;
  color: #FFFFFF;
  position: relative;
  left: -100%;
  height: 100%;
  width: 200%;
    transform: translateX(0);
  transition: transform 0.6s ease-in-out;
}

.container.right-panel-active .overlay {
    transform: translateX(50%);
}

.overlay-panel {
  position: absolute;
  display: flex;
  align-items: center;
  justify-content: center;
  flex-direction: column;
  padding: 0 40px;
  text-align: center;
  top: 0;
  height: 100%;
  width: 50%;
  transform: translateX(0);
  transition: transform 0.6s ease-in-out;
}

.overlay-left {
  transform: translateX(-20%);
}

.container.right-panel-active .overlay-left {
  transform: translateX(0);
}

.overlay-right {
  right: 0;
  transform: translateX(0);
}

.container.right-panel-active .overlay-right {
  transform: translateX(20%);
}

.social-container {
  margin: 20px 0;
}

.social-container a {
  border: 1px solid #DDDDDD;
  border-radius: 50%;
  display: inline-flex;
  justify-content: center;
  align-items: center;
  margin: 0 5px;
  height: 40px;
  width: 40px;
}

</style>
<body>

<jsp:include page="header.jsp"></jsp:include>

<div class="container" id="container">
  <div class="form-container sign-up-container">
    <form method="post" action="SelecAdress.me?sell=want" onsubmit="return validateForm()">      
	
	<br>
      <div style="border-radius: 10px; overflow: hidden;" class="social-container">
        <img src="<%=request.getParameter("shoeimage")%>"style="width: 100%; height: auto;">
      </div>
    	<b class="text-sm"><%=request.getParameter("model") %></b>
        <b class="text-sm"><%=request.getParameter("size") %></b>
         
                <div class="mb-4">
                    <label for="price" class="block text-sm font-medium text-gray-700">판매 희망가</label>
                    <input type="text" id="price" name="price" class="mt-1 block w-full border-gray-300 rounded-md shadow-sm" 
                    	placeholder="원하는 판매 희망가를 적어주세요.">
                </div>               
                 <input type="hidden" name="size" value="<%=request.getParameter("size")%>">
                 <input type="hidden" name="model" value="<%=request.getParameter("model")%>">
                 <input type="hidden" name="shoeimage" value="<%=request.getParameter("shoeimage")%>">
                <div> 
                 <button>판매 희망가 설정</button>
                </div>
    </form> 
  </div>
  
  <div class="form-container sign-in-container">
    <form action="SelecAdress.me?sell=sell" method="post">
    <h1>즉시 판매 하기</h1>
    <br>
	 <div style="border-radius: 10px; overflow: hidden;" class="social-container">
        <img src="<%=request.getParameter("shoeimage")%>"style="width: 100%; height: auto;">
      </div>
      <b><%=request.getParameter("model") %></b>
      <b><%=request.getParameter("size") %></b>
      <div class="mb-4">
		<label for="instantPrice"class="block text-sm font-medium text-gray-700">즉시 판매 가격</label> 
		<%if(!request.getParameter("price").equals("0")){ %>
		<input type="text" id="instantPrice" class="mt-1 block w-full border-gray-300 rounded-md shadow-sm"
		placeholder=<%=request.getParameter("price") + "원"%> disabled>
		</div> 	
    	<input type="hidden" name="size" value="<%=request.getParameter("size")%>">
    	<input type="hidden" name="price" value="<%=request.getParameter("price")%>">
    	<input type="hidden" name="model" value="<%=request.getParameter("model")%>">
    	<input type="hidden" name="shoeimage" value="<%=request.getParameter("shoeimage")%>">
    	<div>
    	<button type="submit">즉시 판매</button>
    <%}else{ %>
    	<input type="text" id="instantPrice" class="mt-1 block w-full border-gray-300 rounded-md shadow-sm"
		placeholder="매물이 없습니다. 입찰 기능을 이용해보세요!" disabled> 	
    <%} %>
    </div>
    </form>
  </div>
  
  <div class="overlay-container">
    <div class="overlay">
      <div class="overlay-panel overlay-left">
        <h1>즉시판매가는<br>정산이 빨라요!</h1>
        <p>신발이 적정가격이라 생각 하신다면 <br>즉시! 정산 받는 즉시판매를 추천드려요!</p>
        <button class="ghost" id="signIn">즉시 판매 바로가기</button>
      </div>
      <div class="overlay-panel overlay-right">
        <h1>희망 판매가로 <br>팔아보세요!</h1>
        <p>내가 팔고싶은 가격, 화혜장의 <br>경매 시스템을 이용해보세요.</p>
        <button class="ghost" id="signUp">희망가 판매 바로가기</button>
      </div>
    </div>
  </div>
</div>

<jsp:include page="footer.jsp"></jsp:include>

<script>
const signUpButton = document.getElementById('signUp');
const signInButton = document.getElementById('signIn');
const container = document.getElementById('container');

signUpButton.addEventListener('click', () => {
container.classList.add("right-panel-active");
});

signInButton.addEventListener('click', () => {
container.classList.remove("right-panel-active");
});


</script>

</body>
</html>