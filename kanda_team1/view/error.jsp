<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ja">
<head>
	<!-- 文字コード -->
	<meta charset="UTF-8">

	<!-- コンテキストパス取得 -->
	<% String context = request.getContextPath();%>
	<% String message = (String)request.getAttribute("error"); %>


	<title>○○画面</title>
</head>
<body>

	<!-- メイン要素 -->
	<h1>エラー画面</h1><br>
	<!-- ログインリンク：/view/login.jsp -->
	<a href="<%=context %>/view/login.jsp">ログイン</a>

	<%if(message!=null) {%>
		<%= message %>
	<%} %>

</body>
</html>