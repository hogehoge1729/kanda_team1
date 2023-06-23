//内容  ：管理者が会員一覧を見る。絞り込みもできる。
//作成者：森菜乃子
package servlet;

import java.util.ArrayList;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.MemberDTO;
import dao.AdminDAO;


public class MemberServlet extends HttpServlet {

	String error = "";
	ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();

	// ポスト送信
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		try {

			// AdminDAOオブジェクト生成
			AdminDAO adminDao = new AdminDAO();
			//全検索メソッドを呼び出しArrayListに格納
			list = adminDao.selectAll();
		} catch (Exception e) {
			System.out.println("エラー(;A;)" + e);
		} finally {
			try {
				// 正常なフォワード
				if (error.equals("")) {
					request.setAttribute("member_list", list);
					request.getRequestDispatcher("/view/memberList.jsp").forward(request, response);
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
