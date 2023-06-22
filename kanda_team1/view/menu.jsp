<!-- ファイル名が設計通りになってると確認したらこのコメントを消してください -->
<!-- http://localhost:8080/kanda_team1/view/menu.jsp -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="bean.AdminDTO" %>
<%
//セッションから管理者情報を取得
AdminDTO admin = (AdminDTO)session.getAttribute("admin");
%>
<!DOCTYPE html>
<html lang="ja">
<head>
	<!-- 文字コード -->
	<meta charset="UTF-8">

	<!-- コンテキストパス取得 -->
	<% String context = request.getContextPath();%>

	<title>管理者メニュー画面</title>
</head>
<body>
	<!-- 管理者IDの表示 -->
	<table style="margin:auto; width:850px">
		<tr>
			<td style="text-align:right; width:80px">管理ID:<%=admin.getMail() %></td>
		</tr>
	</table>
	<!-- リンク -->
	<div style="margin-bottom:350px">
		<table  style="margin:auto; border:0;">
			<tr><td><a href="<%=request.getContextPath() %>/member">【会員一覧】</a></td></tr>
			<tr><td><a href="<%=request.getContextPath() %>/salesconfirmation">【売上確認】</a></td></tr>
			<tr><td><a href="<%=request.getContextPath() %>/changepassword">【パスワード変更】</a></td></tr>
		</table>
	</div>
</body>
</html>