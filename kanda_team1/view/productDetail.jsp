<!-- ファイル名が設計通りになってると確認したらこのコメントを消してください -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="java.util.ArrayList,bean.SellDTO"%>
<%@page import="java.util.ArrayList,bean.MemberDTO"%>

<%
ArrayList<SellDTO> list = (ArrayList<SellDTO>) session.getAttribute("order_list");
MemberDTO seller = (MemberDTO) session.getAttribute("seller_member");
String num=(String)request.getParameter("count");
int numInt=Integer.parseInt(num);
SellDTO sellDto = list.get(numInt);

%>
<!DOCTYPE html>
<html lang="ja">
<head>
	<!-- 文字コード -->
	<meta charset="UTF-8">

	<!-- コンテキストパス取得 -->
	<% String context = request.getContextPath();%>

	<title>商品詳細画面</title>
</head>
<body>

	<!-- メイン要素 -->

	<!-- ログインリンク：/view/login.jsp -->
	<a href="<%=context %>/view/login.jsp">ログイン</a>

	<h1>商品詳細</h1>

	<img src = "<%= context %><%=sellDto.getImagePath()%>" alt = "なし"></a>
	<br>商品名:<%= sellDto.getProductName()%>
	<br>価格:<%= sellDto.getPrice()%>
	<br>出品エリア:<%= sellDto.getPrefectures()%>
	<br>商品状態:<%= sellDto.getProductCondition()%>
	<br>出品日:<%= sellDto.getSellDate()%>
	<br>出品者:<%=seller.getMail() %>

	<!-- 購入ボタンリンク：/view/login.jsp -->
	<br><a href="<%=context %>/view/login.jsp">購入</a>



</body>
</html>