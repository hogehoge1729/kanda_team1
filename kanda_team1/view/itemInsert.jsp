<!-- ファイル名が設計通りになってると確認したらこのコメントを消してください -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ja">
<head>
	<!-- 文字コード -->
	<meta charset="UTF-8">

	<!-- コンテキストパス取得 -->
	<% String context = request.getContextPath();%>

	<title>○○画面</title>
</head>
<body>

	<!-- メイン要素 -->
	<br>商品名：<input type="text" name="name">

	種類：
	<select name="dinner">
		<option value="1">本</option>
		<option value="2">雑貨</option>
		<option value="3">家具</option>
	</select>

</body>
</html>