<%@page import="action.ShoesAdjustAction"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="vo.ShoseInfo"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%
	ArrayList<ShoseInfo> shoseInfo = (ArrayList<ShoseInfo>) request.getAttribute("articleList");
	ArrayList<String> kindlist=(ArrayList<String>) request.getAttribute("kindlist");
	String search=(String)request.getAttribute("search");
	String[] seleckind=(String[])request.getAttribute("seleckind");
	String s="";
	if(search!=null){
		s="?search="+search;
	}else{
		s="";
	}
	int c=0;
%>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>신발 리스트| LUBLE</title>
<link
	href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css"
	rel="stylesheet">
</head>
<body class="bg-white text-gray-800">

	<jsp:include page="header.jsp"></jsp:include>
	<div class="container mx-auto p-4 flex flex-wrap">
		<div class="p-1 ml-10">
			<div class="p-2">
				<h2 class="font-bold mb-4 text-2xl">카테고리</h2>
				<div class="space-y-2"> 
					<div>
					<form action="ShoSearch.sho<%=s %>"  method="post" id="kind">
					<%for(int i=0;i<kindlist.size();i++){ %>
						<%if(seleckind!=null){ %>
						<%for(int a=0;a<seleckind.length;a++){ %>
							<%if(kindlist.get(i).equals(seleckind[a])){ %>
								<%c++;%>
							<%}%>																			 	 						
						<%}%>
						<%} %>
						<%if(c>0){ %> 
						 	<label for="<%=i%>" class="block cursor-pointer p-2"><%=kindlist.get(i)%><input type="checkbox" name="kind" id="<%=i%>"
						 	onclick="document.getElementById('kind').submit();" value="<%=kindlist.get(i)%>" checked="checked"/> </label>
						 <%}else{ %>
						 	<label for="<%=i%>" class="block cursor-pointer p-2"><%=kindlist.get(i)%><input type="checkbox" name="kind" id="sneakers"
						 	onclick="document.getElementById('kind').submit();" value="<%=kindlist.get(i)%>"/> </label>
						 <%} %>
						<%c=0;%>
					<%} %>	
					</form>
					</div>
				</div>
			</div>
		</div>
		<div class="w-full md:w-3/4 p-2 ml-20">
			<h2 class="text-2xl font-semibold my-6">상품 리스트</h2>
			<%if(search!=null){ %>
				<h2 class="text-1xl font-semibold my-6 text-left">검색어: <%=search %></h2>
			<%} %>
			<h2 class="text-1xl font-semibold my-6 text-right">검색상품: <%=shoseInfo.size() %>건</h2>
			
			<div
				class="grid grid-cols-1 sm:grid-cols-2 md:grid-cols-3 lg:grid-cols-4 gap-4">
				<%
					if (shoseInfo.size()>0) {
					for (int i = 0; i < shoseInfo.size(); i++) {
				%>
				<div class="border p-0 rounded-lg">
					<a href="ShoesDetail.sho?model=<%=shoseInfo.get(i).getModel()%>">
						<div class="w-full h-48 mb-2 border border-gray-300 rounded-md overflow-hidden">
						<img src="<%=shoseInfo.get(i).getShoImage()%>" class="w-full h-full object-cover">
						</div>
						<h3 class="font-semibold text-right mt-2 pr-1"><%=shoseInfo.get(i).getBrand()%></h3>
						<p class="font-semibold text-right pr-1"><%=shoseInfo.get(i).getModel()%></p>
						<%if(shoseInfo.get(i).getPrice()!=0){ %>
							<p class="text-red-500 text-right pr-1"><%=shoseInfo.get(i).getPrice()%>원</p>
						<%}else{ %>						
							<p class="text-red-500 text-right pr-3">-</p>
						<%} %>						
						</a>
				</div>
				<%
					}
				}else{%>
					검색 결과가 없습니다.....					
				<%}%>				
			</div>
		</div>
	</div>
</body>
</html>