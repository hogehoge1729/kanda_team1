//このファイル名とxmlのURLパターンがが正しいか確認したら、このコメントを消してください
//内容  ：
//作成者：
package servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SellDAO;

public class BuyFinish extends HttpServlet {

	String error = "";


	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		try {

			String sellId = request.getParameter("sellId");
			String cmd = request.getParameter("cmd");

			if(cmd.equals("buy")) {
				new SellDAO(). statusUpdate(sellId,"振込完了");
			}
			if(cmd.equals("get")) {
				new SellDAO(). statusUpdate(sellId,"受取完了");
			}



		} catch (Exception e) {
			System.out.println("エラー(;A;)" + e);
		} finally {
			try {

				// 正常なフォワード
				if (error.equals("")) {
					request.getRequestDispatcher("/purchaseHistory").forward(request, response);
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
