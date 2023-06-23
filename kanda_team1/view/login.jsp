<!-- http://localhost:8080/kanda_team1/view/login.jsp -->
<!-- 平瀬 -->

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ja">
<head>
	<!-- 文字コード -->
	<meta charset="UTF-8">

	<!-- コンテキストパス取得 -->
	<% String context = request.getContextPath();%>

	<title>会員ログイン画面</title>
</head>
<body>
		<!--  商品一覧ボタン -->
	<!--  ユーザーログイン入力 -->
	<div style="text-align:center">
		<form action="<%=request.getContextPath()%>/login">
			<table>
				<tr>
					<td>ユーザー</td>
				</tr>
				<tr>
					<!--  ユーザー入力:mail -->
					<td><input type="text" name="mail"></td>
				</tr>
				<tr>
					<td>パスワード</td>
				</tr>
				<tr>
					<!--  パスワード入力:password -->
					<td><input type="text" name="password"></td>
				</tr>
				<tr>
					<!--  ログインボタン -->
					<td><input type="submit" value="ログイン"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>