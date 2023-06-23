//このファイル名とxmlのURLパターンがが正しいか確認したら、このコメントを消してください
//内容  ：
//作成者：
package servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SellDAO;

public class ProductStopServlet extends HttpServlet {

	String error = "";

	// ポスト送信
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		try {

			//id取得
			String sellId = request.getParameter("sellId");

			new SellDAO().delete(sellId);

			System.out.println(sellId);

		} catch (Exception e) {
			System.out.println("エラー(;A;)" + e);
		} finally {
			try {

				// 正常なフォワード
				if (error.equals("")) {
					request.getRequestDispatcher("/ExhibitList").forward(request, response);
				}
				// エラーへのフォワード
				else {
					// エラーメッセージををセット
					request.setAttribute("error", error);
					// フォワード
					request.getRequestDispatcher("/view/error.jsp").forward(request, response);
				}
			} catch (Exception e) {
			}
		}
	}

}
