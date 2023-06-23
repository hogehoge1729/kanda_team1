//このファイル名とxmlのURLパターンがが正しいか確認したら、このコメントを消してください
//内容  ：
//作成者：
package servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.MemberDTO;
import dao.MemberDAO;
import dao.SellDAO;
import util.SendMailTest;

public class ReportServlet extends HttpServlet {

	String error = "";

	// ポスト送信
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		try {

			//出品id取得
			String sellerId = request.getParameter("sellerId");


			HttpSession session = request.getSession();
			MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
			String mail = memberDTO.getMail();


			//データベース更新


			new MemberDAO().statusUpdate(sellerId);

			String sellerName = memberDTO.getMamberName();



			//メール送信
			SendMailTest.mailBuy(

					"会員が報告されました。\n"+
					"会員名："+sellerName
					,

					"kawada.t@dream-jack.com");


		} catch (Exception e) {
			System.out.println("エラー(;A;)" + e);
		} finally {
			try {

				// 正常なフォワード
				if (error.equals("")) {
					// フォワード
					request.getRequestDispatcher("/product").forward(request, response);
				}
				// エラーへのフォワード
				else {
					// エラーメッセージををセット
					request.setAttribute("error", error);
					// フォワード
					request.getRequestDispatcher("/product").forward(request, response);
				}
			} catch (Exception e) {
			}
		}
	}

}
