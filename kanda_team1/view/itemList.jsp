<!-- http://localhost:8080/kanda_team1/view/itemList.jsp  森菜乃子-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList,bean.SellDTO,bean.MemberDTO"%>

<%
ArrayList<SellDTO> list = (ArrayList<SellDTO>) session.getAttribute("order_list");
%>

<!DOCTYPE html>
<html lang="ja">
<head>
<!-- 文字コード -->
<meta charset="UTF-8">

<!-- コンテキストパス取得 -->
<%
	String context = request.getContextPath();
%>

<title>商品一覧画面</title>
</head>
<body>
	<!-- ログインリンク：/view/login.jsp -->
	<a href="<%=context %>/view/login.jsp">ログイン</a>
		<form action="<%=context%>/searchitemlist" method = "get">
		<table>
				<tr>
					<td>商品名</td>
					<td>値段（上）</td>
					<td>値段（下）</td>
					<td>エリア</td>
				</tr>

				<tr>
					<!-- 商品名：product_type -->
					<td><select name = "product_type">
							<option value ="雑貨">雑貨</option>
							<option value ="家具">家具</option>
							<option value ="その他">その他</option>
						</select>
					</td>

					<!-- 上限の値段：upperPrice -->
					<td>
						<select name = "upperPrice">
							<option value ="1">10000</option>
							<option value ="2">8000</option>
							<option value ="3">5000</option>
						</select>
					</td>

					<!-- 下限の値段：lowerPrice -->
					<td>
						<select name = "lowerPrice">
							<option value ="1">500</option>
							<option value ="2">1000</option>
							<option value ="3">3000</option>
						</select>
					</td>

					<!-- エリア：prefectures -->
					<td>
						<select name = "prefectures">
							<option value ="北海道">北海道</option>
							<option value ="青森県">青森県</option>
							<option value ="岩手県">岩手県</option>
							<option value ="宮城県">宮城県</option>
							<option value ="秋田県">秋田県</option>
							<option value ="山形県">山形県</option>
							<option value ="福島県">福島県</option>
							<option value ="茨城県">茨城県</option>
							<option value ="栃木県">栃木県</option>
							<option value ="群馬県">群馬県</option>
							<option value ="埼玉県">埼玉県</option>
							<option value ="千葉県">千葉県</option>
							<option value ="東京都">東京都</option>
							<option value ="神奈川県">神奈川県</option>
							<option value ="新潟県">新潟県</option>
							<option value ="富山県">富山県</option>
							<option value ="石川県">石川県</option>
							<option value ="福井県">福井県</option>
							<option value ="山梨県">山梨県</option>
							<option value ="長野県">長野県</option>
							<option value ="気府県">岐阜県</option>
							<option value ="静岡県">静岡県</option>
							<option value ="愛知県">愛知県</option>
							<option value ="三重県">三重県</option>
							<option value ="滋賀県">滋賀県</option>
							<option value ="京都府">京都府</option>
							<option value ="大阪府">大阪府</option>
							<option value ="兵庫県">兵庫県</option>
							<option value ="奈良県">奈良県</option>
							<option value ="和歌山県">和歌山県</option>
							<option value ="鳥取県">鳥取県</option>
							<option value ="島根県">島根県</option>
							<option value ="岡山県">岡山県</option>
							<option value ="広島県">広島県</option>
							<option value ="山口県">山口県</option>
							<option value ="徳島県">徳島県</option>
							<option value ="香川県">香川県</option>
							<option value ="愛媛県">愛媛県</option>
							<option value ="高知県">高知県</option>
							<option value ="福岡県">福岡県</option>
							<option value ="佐賀県">佐賀県</option>
							<option value ="長崎県">長崎県</option>
							<option value ="熊本県">熊本県</option>
							<option value ="大分県">大分県</option>
							<option value ="宮崎県">宮崎県</option>
							<option value ="鹿児島県">鹿児島県</option>
							<option value ="沖縄県">沖縄県</option>

						</select>
					</td>
				</tr>

				<tr>
					<!-- 商品状態：product_condition -->
					<td>
						<select name = "product_condition">
							<option value ="未使用">未使用</option>
							<option value ="使用済み">使用済み</option>
							<option value ="傷あり">傷あり</option>
						</select>
					</td>
				</tr>

				<tr>
					<!-- 絞り込み：/searchitemlist -->
					<td>
						<input type = "submit" name = "searchitemlist" value = "絞り込み">
					</td>
				</tr>
			</table>
			</form>


			<!-- 並び替え：/searchitemlist -->
			<form action="<%=request.getContextPath()%>/searchitemlist" method = "get">

					<!-- 並び順：sortType -->
					<select name = "sortType">
						<option value ="1">価格が安い</option>
						<option value ="2">価格が高い</option>
						<option value ="3">出品日が新しい</option>
					</select>
				<input type = "submit" name = "sort" value = "並び替え">
			</form>

	<table>

		<%
			if (list != null) {
				for (int i = 0; i < list.size(); i++) {
					SellDTO sellDto = (SellDTO) list.get(i);
					String name=sellDto.getProductName();

		%>
					<tr>
						<td>
						<a href="<%=context%>/productDetail?count=<%=i%>"><img src = "<%= request.getContextPath() %><%=sellDto.getImagePath()%>" alt = "なし"></a>
						<br><a href="<%=context%>/productDetail?count=<%=i%>"><%=name %></a>
						<br><%=sellDto.getPrice()%>
						<%
							MemberDTO member = (MemberDTO)session.getAttribute("member");
							if(member!=null){
						%>
							<br><a href="<%=context%>/favoriteInsert?sellId=<%=sellDto.getSellId()%>">お気に入り登録</a>
						<%
							}
						%>
						</td>
					</tr>
		<%
				}
			}else {
		%>
				<tr>
					<td style="text-align: center; width: 200px">&nbsp;</td>
					<td style="text-align: center; width: 200px">&nbsp;</td>
					<td style="text-align: center; width: 200px">&nbsp;</td>
					<td style="text-align: center; width: 250px" colspan="2">&nbsp;</td>
				</tr>
		<%
			}
		%>
	</table>
</body>
</html>