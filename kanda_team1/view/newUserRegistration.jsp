<!-- http://localhost:8080/kanda_team1/view/newUserRegistration.jsp   園山優宇 -->
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

	<form action="<%= context %>/UserInsert">
		会員名<br><input type="text" name="memberName" >
		<br>本名・姓(漢字)<br><input type="text" name="kanjiFamilyName" >
		<br>本名・名(漢字)<br><input type="text" name="kanjiFirstName">
		<br>本名・セイ<br><input type="text" name="kanaFamilyName">
		<br>本名・メイ<br><input type="text" name="kanaFirstName">
		<br>登録住所<br><input type="text" name="residence">
		<br>メール<br><input type="text" name="mail">
		<br>電話番号<br><input type="text" name="telephoneNumber">
		<br>パスワード<br><input type="text" name="password">
		<br>パスワード (確認用)<br><input type="text" name="checkPass">
		<input type="submit" value="登録">
	</form>

</body>
</html>