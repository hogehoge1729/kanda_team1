package servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.AdminDTO;
import dao.AdminDAO;

public class AdministratorLogin extends HttpServlet {
	String error = "";

	// ポスト送信
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {

		String error = "";

		try {
			// password入力パラメータを取得する
			String mail = (String) request.getParameter("mail");
			String pass = (String) request.getParameter("password");


			// UserDAOをインスタンス化し、管理者情報の検索をおこなう
			AdminDAO adminDaoObj = new AdminDAO();
			AdminDTO admin = adminDaoObj.selectByAdmin(mail, pass);

			// 処理
			// ユーザー情報のチェック
			if (admin.getPass() == null) {
				error = "入力データが間違っています。";
				return;
			}

			// 管理者情報がある場合、セッションにスコープにadminという名前で登録する
			HttpSession session = request.getSession();
			session.setAttribute("admin", admin);


		} catch (IllegalStateException e) {
			error = "DB接続エラーの為、ログイン出来ません。";
			System.out.println("エラー(;A;)" + e);
		} finally {
			try {

				// 正常なフォワード
				if (error.equals("")) {
					request.getRequestDispatcher("/view/menu.jsp").forward(request, response);
				}
				// エラーへのフォワード
				else {
					// エラーメッセージををセット
					request.setAttribute("error", error);
					// フォワード
						request.getRequestDispatcher("/view/error.jsp").forward(request, response);

				}
			} catch (Exception e) {
				System.out.println("エラー(;A;)" + e);
			}
		}
	}

}
