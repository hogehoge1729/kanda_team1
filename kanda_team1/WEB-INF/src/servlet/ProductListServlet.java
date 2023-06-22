
//内容  ：共通機能。商品一覧。絞り込みと並び替えできる。
//作成者：森菜乃子
package servlet;

import java.util.ArrayList;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.SellDTO;
import dao.SellDAO;

public class ProductListServlet extends HttpServlet {

	String error = "";
	ArrayList<SellDTO> list = new ArrayList<SellDTO>();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) {

		//セッションオブジェクト
		HttpSession session = request.getSession();

		try {
			// SellDAOオブジェクト生成
			SellDAO sellDao = new SellDAO();
			//全検索メソッドを呼び出しArrayListに格納
			list = sellDao.selectAll();

		} catch (Exception e) {
			System.out.println("エラー(;A;)" + e);
		} finally {
			try {

				// 正常なフォワード
				if (error.equals("")) {
					//セッションにデータを登録してフォワード
					session.setAttribute("order_list", list);
					request.getRequestDispatcher("/view/itemList.jsp").forward(request, response);
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
