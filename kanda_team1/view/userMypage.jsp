<!-- http://localhost:8080/kanda_team1/view/userMypage.jsp -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ja">
<head>
	<!-- 文字コード -->
	<meta charset="UTF-8">

	<!-- コンテキストパス取得 -->
	<% String context = request.getContextPath();%>
	<%@page import="bean.MemberDTO"%>

	<!-- セッションから会員情報取得 -->
	<% MemberDTO member = (MemberDTO)session.getAttribute("member"); %>

	<% if(member==null){
		request.setAttribute("error", "ログインしていないかセッション切れです");
		request.getRequestDispatcher("/view/error.jsp").forward(request, response);

	} %>

	<% String memberName=member.getMamberName(); %>
	<% String kanaFamilyName = member.getKanaFamilyName(); %>
	<% String kanaFirstName = member.getKanaFirstName(); %>
	<% String kanjiFirstName = member.getKanjiFirstName(); %>
	<% String kanjiFamilyName = member.getKanjiFamilyName(); %>
	<% String residence = member.getResidence();%>
	<% String mail = member.getMail();%>
	<% String phone = member.getTelephoneNumber();%>

	<title>○○画面</title>
</head>
<body>

	<!-- メイン要素 -->

	会員名：<%= memberName %><br>
	姓(かな)：<%= kanaFamilyName%><br>
	名(かな)：<%= kanaFirstName%><br>
	姓(漢字)：<%= kanjiFirstName%><br>
	名(漢字)：<%= kanjiFamilyName%><br>
	登録住所：<%= residence%><br>
	MAIL：<%= mail%><br>
	電話番号：<%= phone%><br>

	<form action="<%= context %>/ExhibitList" >
		<input type="submit" value="出品一覧">
	</form>

	<form action="" method="POST">]
		<input type="submit" value="購入一覧">
	</form>

	<form action="" method="POST">]
		<input type="submit" value="商品一覧">
	</form>

	<form action="<%= context %>/view/memberInformationScreen.jsp">
		<input type="submit" value="登録情報変更">
	</form>




</body>
</html>