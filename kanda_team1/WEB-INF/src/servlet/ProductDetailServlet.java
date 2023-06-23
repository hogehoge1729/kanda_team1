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

public class ProductDetailServlet extends HttpServlet {

	String error = "";

	// ポスト送信
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		try {

			//出品者の情報取得
			String num = request.getParameter("count");
			int numInt=Integer.parseInt(num);
			HttpSession session = request.getSession();
			ArrayList<SellDTO> list = (ArrayList<SellDTO>) session.getAttribute("order_list");
			int id = list.get(numInt).getSellerMemberId();
			MemberDTO member = new MemberDAO().selectByMember(id);

			session.setAttribute("seller_member",member);

		} catch (Exception e) {
			System.out.println("エラー(;A;)" + e);
		} finally {
			try {

				// 正常なフォワード
				if (error.equals("")) {
					request.getRequestDispatcher("/view/productDetail.jsp").forward(request, response);
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
