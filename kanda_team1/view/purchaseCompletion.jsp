<!-- ファイル名が設計通りになってると確認したらこのコメントを消してください -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ja">
<head>
	<!-- 文字コード -->
	<meta charset="UTF-8">

	<!-- コンテキストパス取得 -->
	<% String context = request.getContextPath();%>

	<title>購入画面</title>
</head>
<body>

	<!-- メイン要素 -->


	<h1>購入完了画面</h1>
	<h3>購入が完了しました</h3>

	相手とやり取りして
	振込してください。
	<br>
	<br>

	振り込んだら、
	<br>[購入履歴]から
	<br>[購入完了]ボタンをおして下さい

	<form action="<%= context %>/ExhibitList" >
		<input type="submit" value="出品一覧">
	</form>

	<form action="<%= context %>/purchaseHistory" >
		<input type="submit" value="購入一覧">
	</form>

	<form action="<%= context %>/product">
		<input type="submit" value="商品一覧">
	</form>



</body>
</html>