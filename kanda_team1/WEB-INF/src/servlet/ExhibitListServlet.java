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
import dao.SellDAO;

public class ExhibitListServlet extends HttpServlet {

	String error = "";

	// 送信
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		try {

			//文字コーディングの指定
			request.setCharacterEncoding("UTF-8");

			//
			SellDAO sellDAO = new SellDAO();
			ArrayList<SellDTO> sellList ;
			HttpSession session = request.getSession();
			MemberDTO member = (MemberDTO)session.getAttribute("member");
//			if(member==null) {
//				error="セッション切れ";
//				return;
//			}

			int sellerId=member.getMemberId();
			sellList = sellDAO.selectBySeller(sellerId);

			session.setAttribute("SellList",sellList);

			System.out.println("ログイン者"+sellerId);



		} catch (Exception e) {
			System.out.println("エラー(;A;)" + e);
		} finally {
			try {

				// 正常なフォワード
				if (error.equals("")) {
					request.getRequestDispatcher("/view/exhibitList.jsp").forward(request, response);
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
