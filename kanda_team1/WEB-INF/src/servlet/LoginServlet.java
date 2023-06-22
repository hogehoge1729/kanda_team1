//このファイル名とxmlのURLパターンがが正しいか確認したら、このコメントを消してください
//内容  ：
//作成者：
package servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDAO;
import bean.MemberDTO;

public class LoginServlet extends HttpServlet {

	String error = "";

	// ポスト送信
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		try {

			//文字コーディングの指定
			request.setCharacterEncoding("UTF-8");

			//DAOオブジェクト宣言
			MemberDAO memberDao = new MemberDAO();

			//入力パラメーターの取得
			String mail = request.getParameter("mail");
			String password = request.getParameter("password");


			//ログイン処理
			if(mail == null) {
				error = "メールアドレスを入力してください";
				return;
			}
			if(password == null) {
				error = "パスワードを入力してください";
				return;
			}


			//データベースから引数のmemberデータを取得するメソッド
			MemberDTO memberDto = memberDao.selectByMember(mail,password);

			//ログイン処理
			if(memberDto.getMail() == null) {
				error = "入力データが間違っています！";
				return;

			}else {
				//取得したMemberDtoオブジェクトをセッションスコープに"member"という名前で登録する。
				HttpSession session = request.getSession();
				session.setAttribute("member", memberDto);
				error="";
				System.out.println("ログインセッション登録"+memberDto.getMemberId());
			}

		} catch (Exception e) {
			System.out.println("エラー(;A;)" + e);
		} finally {
			try {

				// 正常なフォワード
				if (error.equals("")) {
					//登録したデータを待ってmenu.jspへ
					request.getRequestDispatcher("/view/userMypage.jsp").forward(request, response);
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
