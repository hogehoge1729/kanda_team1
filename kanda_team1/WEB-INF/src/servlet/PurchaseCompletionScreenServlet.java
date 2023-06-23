//このファイル名とxmlのURLパターンがが正しいか確認したら、このコメントを消してください
//内容  ：
//作成者：
package servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.MemberDTO;
import dao.SellDAO;
import util.SendMailTest;

public class PurchaseCompletionScreenServlet extends HttpServlet {

	String error = "";

	// ポスト送信
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		try {
			//出品id取得
			String sellId = request.getParameter("sell_id");
			String sellerMail = request.getParameter("seller");

			HttpSession session = request.getSession();
			MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
			String mail = memberDTO.getMail();
			System.out.println(mail);


			//データベース更新
			new SellDAO(). buy(sellId,memberDTO);



			//メール送信
			SendMailTest.mailBuy(

					"購入が完了しました。\n"
					+ sellerMail
					+"\nに連絡をして振込をしてください。\n振込が完了したら振込完了ボタンを押してください。",

					"kawada.t@dream-jack.com");



		} catch (Exception e) {
			System.out.println("エラー(;A;)" + e);
		} finally {
			try {

				// 正常なフォワード
				if (error.equals("")) {

					request.getRequestDispatcher("/view/purchaseCompletion.jsp").forward(request, response);
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
