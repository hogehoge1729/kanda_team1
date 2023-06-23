<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ja">
<head>
    <!-- 文字コード -->
    <meta charset="UTF-8">

    <!-- コンテキストパス取得 -->
    <% String context = request.getContextPath();%>

    <title>出品完了</title>
</head>
<body>

    <!-- メイン要素 -->
    <br>
    <h1>　　　　　　　　　　　　　　　　　　　　出品が完了しました</h1>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
    <form action="<%=request.getContextPath()%>/view/userMypage.jsp">
    <table style="margin: auto; border: 0;">
    <td colspan=2 style="text-align: center"><input type="submit" value="マイページ">
    </table>
    </form>
    <br>

    <form action="<%=request.getContextPath()%>/view/exhibitList.jsp">
    <table style="margin: auto; border: 0;">
    <td colspan=2 style="text-align: center"><input type="submit" value="出品一覧">
    </table>
    </form>

</body>
</html>