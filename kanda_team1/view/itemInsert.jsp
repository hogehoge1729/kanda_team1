<!-- ファイル名が設計通りになってると確認したらこのコメントを消してください -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="bean.MemberDTO" %>
<!DOCTYPE html>
<html lang="ja">
<head>
	<!-- 文字コード -->
	<meta charset="UTF-8">

	<!-- コンテキストパス取得 -->
	<% String context = request.getContextPath();%>

	<title>出品登録画面</title>
</head>
<body>
<% MemberDTO member = (MemberDTO)session.getAttribute("member"); %>

	<form action="<%= request.getContextPath() %>/view/UserMypage.jsp">
		<input type="submit" value="マイページ">
	</form>

	<form action="<%= request.getContextPath() %>/itemInsert"method="Post"enctype="multipart/form-data">
		商品名<input type="text" name="itemName"><br>
		種類<select name="type">
		<option value="雑貨">雑貨</option>
		<option value="家具">家具</option>
		<option value="その他">その他</option>
		</select><br>
		備考<input type="text" name="remarks">
		状態<input type="text" name="productStatus"><br>
		値段<input type="text" name="price"><br>
		配送日数<select name="delivaryDay">
			<option value="1" selected>1日</option>
  		<option value="2">2日</option>
  		<option value="3">三日以上</option>


		</select>
		出品地域<select name="pref">
  		<option value="" selected>都道府県</option>
  		<option value="北海道">北海道</option>
  		<option value="青森県">青森県</option>
  		<option value="岩手県">岩手県</option>
  <option value="宮城県">宮城県</option>
  <option value="秋田県">秋田県</option>
  <option value="山形県">山形県</option>
  <option value="福島県">福島県</option>
  <option value="茨城県">茨城県</option>
  <option value="栃木県">栃木県</option>
  <option value="群馬県">群馬県</option>
  <option value="埼玉県">埼玉県</option>
  <option value="千葉県">千葉県</option>
  <option value="東京都">東京都</option>
  <option value="神奈川県">神奈川県</option>
  <option value="新潟県">新潟県</option>
  <option value="富山県">富山県</option>
  <option value="石川県">石川県</option>
  <option value="福井県">福井県</option>
  <option value="山梨県">山梨県</option>
  <option value="長野県">長野県</option>
  <option value="岐阜県">岐阜県</option>
  <option value="静岡県">静岡県</option>
  <option value="愛知県">愛知県</option>
  <option value="三重県">三重県</option>
  <option value="滋賀県">滋賀県</option>
  <option value="京都府">京都府</option>
  <option value="大阪府">大阪府</option>
  <option value="兵庫県">兵庫県</option>
  <option value="奈良県">奈良県</option>
  <option value="和歌山県">和歌山県</option>
  <option value="鳥取県">鳥取県</option>
  <option value="島根県">島根県</option>
  <option value="岡山県">岡山県</option>
  <option value="広島県">広島県</option>
  <option value="山口県">山口県</option>
  <option value="徳島県">徳島県</option>
  <option value="香川県">香川県</option>
  <option value="愛媛県">愛媛県</option>
  <option value="高知県">高知県</option>
  <option value="福岡県">福岡県</option>
  <option value="佐賀県">佐賀県</option>
  <option value="長崎県">長崎県</option>
  <option value="熊本県">熊本県</option>
  <option value="大分県">大分県</option>
  <option value="宮崎県">宮崎県</option>
  <option value="鹿児島県">鹿児島県</option>
  <option value="沖縄県">沖縄県</option>
</select><br>

		<input type="file" name="image"  size="60"><br>


		<input type="submit" value="出品開始">

	</form>

</body>
</html>