//このファイル名とxmlのURLパターンがが正しいか確認したら、このコメントを消してください
//内容  ：
//作成者：
package servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.MemberDTO;
import dao.MemberDAO;

public class UserInsertServlet extends HttpServlet {

	String error = "";

	// ポスト送信
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		try {

			request.setCharacterEncoding("UTF-8");
			String memberName = request.getParameter("memberName");
			String kanjiFamilyName = request.getParameter("kanjiFamilyName");
			String kanjiFirstName = request.getParameter("kanjiFirstName");
			String kanaFamilyName = request.getParameter("kanaFamilyName");
			String kanaFirstName = request.getParameter("kanaFirstName");
			String residence = request.getParameter("residence");
			String mail = request.getParameter("mail");
			String telephon = request.getParameter("telephoneNumber");
			String password = request.getParameter("password");
			String checkPass = request.getParameter("checkPass");

			MemberDTO member = new MemberDTO();

			member.setMamberName(memberName);
			member.setKanjiFamilyName(kanjiFamilyName);
			member.setKanjiFirstName(kanjiFirstName);
			member.setKanaFamilyName(kanaFamilyName);
			member.setKanaFirstName(kanaFirstName);
			member.setResidence(residence);
			member.setMail(mail);
			member.setTelephoneNumber(telephon);
			member.setPassword(password);


			MemberDAO memberDao = new MemberDAO();
			memberDao.memberInsert(member);

		} catch (Exception e) {
			System.out.println("エラー(;A;)" + e);
		} finally {
			try {

				// 正常なフォワード
				if (error.equals("")) {
					request.getRequestDispatcher("/view/login.jsp").forward(request, response);
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
