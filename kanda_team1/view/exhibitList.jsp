<!-- http://localhost:8080/kanda_team1/view/exhibitList.jsp -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="java.util.ArrayList,bean.SellDTO"%>
<!DOCTYPE html>
<html lang="ja">
<head>
	<!-- 文字コード -->
	<meta charset="UTF-8">

	<!-- コンテキストパス取得 -->
	<% String context = request.getContextPath();%>
	<% ArrayList<SellDTO> list = (ArrayList<SellDTO>) session.getAttribute("SellList");%>


	<title>出品画面</title>
</head>
<body>

	<h1>出品画面</h1>
	<% if(list==null){ %>
		セッション取得失敗
	<%} else{%>

		<!-- メイン要素 -->
		<table>
			<tr>

				<th>画像</th>
				<th>商品名</th>
				<th>価格</th>
				<th>出品エリア</th>
				<th>状態</th>
				<th>出品日</th>
				<th>現状</th>
				<th>出品取り消し</th>
				<th>発送完了</th>

			</tr>


			<%for(int i=0;i<list.size();i++){%>

				<% int sellId=list.get(i).getSellId();%>
				<% String itemName=list.get(i).getProductName();%>
				<%int price=list.get(i).getPrice();%>
				<% String eria=list.get(i).getPrefectures();%>
				<% String productCondition =list.get(i). getProductCondition();%>
				<% String sellDate =list.get(i). getSellDate();%>
				<% String status =list.get(i). getSellStatus();%>
				<% String imagePath = list.get(i). getImagePath();%>

				<tr>
					<th><img src="<%=context %><%= imagePath %>" alt="<%=context %><%= imagePath %>"></th>
					<th><%= itemName %></th>
					<th><%= price %>円</th>
					<th><%= eria %></th>
					<th><%= productCondition %></th>
					<th><%= sellDate %></th>
					<th><%= status %></th>

					<th><a href="<%=request.getContextPath() %>/productStop?sellId=<%=sellId%>">取消</a></th>
					<th><a href="<%=request.getContextPath() %>/sendFinish?sellId=<%=sellId%>">発送完了</a></th>


				</tr>

			<%}%>
		</table>
	<%}%>
</body>
</html>