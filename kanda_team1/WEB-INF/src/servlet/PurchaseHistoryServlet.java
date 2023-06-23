//このファイル名とxmlのURLパターンがが正しいか確認したら、このコメントを消してください
//内容  ：
//作成者：
package servlet;

import java.util.ArrayList;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.MemberDTO;
import bean.SellDTO;
import dao.MemberDAO;
import dao.SellDAO;

public class PurchaseHistoryServlet extends HttpServlet {

	String error = "";

	// ポスト送信
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {


		try {

			//文字コーディングの指定
			request.setCharacterEncoding("UTF-8");

			//
			SellDAO sellDAO = new SellDAO();
			ArrayList<SellDTO> sellList ;
			HttpSession session = request.getSession();
			MemberDTO member = (MemberDTO)session.getAttribute("member");

			int purchaseId = member.getMemberId();
//			if(member==null) {
//				error="セッション切れ";
//				return;
//			}

			int sellerId=member.getMemberId();
			sellList = sellDAO.selectByPurchase(purchaseId);

			for(int i=0;i<sellList.size();i++) {
				int id = sellList.get(i).getSellerMemberId();
				MemberDTO seller = new MemberDAO().selectByMember(id);
				sellList.get(i).setSellerName(seller.getMamberName());
				sellList.get(i).setSellerMail(seller.getMail());
			}

			session.setAttribute("BuyList",sellList);

			System.out.println("ログイン者"+sellerId);



		} catch (Exception e) {
			System.out.println("aエラー(;A;)" + e);
		} finally {
			try {

				// 正常なフォワード
				if (error.equals("")) {
					request.getRequestDispatcher("/view/purchaseHistory.jsp").forward(request, response);
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
