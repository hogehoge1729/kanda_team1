
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="java.util.ArrayList,bean.MemberDTO"%>

<%
ArrayList<MemberDTO> list = (ArrayList<MemberDTO>)request.getAttribute("member_list");
%>
<!DOCTYPE html>
<html lang="ja">
<head>
	<!-- 文字コード -->
	<meta charset="UTF-8">

	<!-- コンテキストパス取得 -->
	<% String context = request.getContextPath();%>

	<title>会員一覧</title>
</head>
<body>
	<form action="<%= context%>/memberSearch" method = "get">
	<table>
			<tr>
				<td>会員名</td>
				<td><input type="text" size="10" name="memberName"></input></td>
				<td>姓</td>
				<td><input type="text" size="10" name="familyName"></input></td>
				<td>名</td>
				<td><input type="text" size="10" name="firstName"></input></td>
				<td><input type = "radio" name = "tuuhou" value = "1">通報された人</td>
				<td><input type = "radio" name = "syuppin" value = "1">出品している人</td>
			</tr>
			<tr>
				<td>mail</td>
				<td><input type="text" size="30" name="mail"></input></td>
				<td>住所</td>
				<td><input type="text" size="30" name="residence"></input></td>
			</tr>
			<tr>
				<td>
					<input type = "submit" name = "search" value = "絞り込み">
				</td>
			</tr>
		</table>
		</form>

		<table>

			<%
			if (list != null) {%>

				<tr>
					<th>会員名</th>
					<th>mai</th>
					<th>姓</th>
					<th>本名 名</th>
					<th>住所</th>
					<th>電話</th>
					<th>状態</th>
					<th>凍結</th>
				</tr>

				<%
				for (int i = 0; i < list.size(); i++) {
					MemberDTO memberDto = (MemberDTO) list.get(i);
				%>
					<tr>
					<td><%= memberDto.getMamberName() %></td>
					<td><%= memberDto.getMail() %></td>
					<td><%= memberDto.getKanjiFamilyName() %></td>
					<td><%= memberDto.getKanjiFirstName() %></td>
					<td><%= memberDto.getResidence() %></td>
					<td><%= memberDto.getTelephoneNumber() %></td>
					<td>
						<% if(memberDto.getAccountStatus()==0){%>
							普通
						<%} %>

						<% if(memberDto.getAccountStatus()==1){%>
							通報
						<%} %>

						<% if(memberDto.getAccountStatus()==2){%>
							凍結
						<%} %>

					</td>
					<td>
						<form action="<%=request.getContextPath()%>/MemberDiscontinuedServlet" method = "get">
							<input type = "submit" name = "search" value = "凍結">
						</form>
					</td>
					</tr>
				<%}
			}%>
		</table>
</body>
</html>