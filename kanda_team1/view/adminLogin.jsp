<!-- http://localhost:8080/kanda_team1/view/adminLogin.jsp -->
<!-- 作成者 瀬川 -->
<%@page contentType="text/html; charset=UTF-8"%>
<html>
	<head>
		<title>管理者ログイン画面</title>
	</head>
	<body>

		<h1>管理者画面</h1>

		<!-- フォーム送信先：/login -->

		<form action="<%= request.getContextPath()%>/AdminLogin" method="POST">
			<table>

				<tr>
					<td>メールアドレス</td>
				</tr>

				<!-- メールアドレス：mail -->

				<tr>
					<td>
						<input type="text" name="mail" required>
					</td>
				</tr>

				<tr>
					<td>パスワード</td>
				</tr>

				<!-- パスワードの名前：pass -->

				<tr>
					<td>
						<input type="password" name="password" required>
					</td>
				</tr>
				<tr>
					<td><input type="submit" value="ログイン"></td>
				</tr>
			</table>
		</form>
	</body>
</html>