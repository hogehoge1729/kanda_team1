//内容  ：会員一覧機能から絞り込みする
//作成者：森菜乃子
package servlet;

import java.util.ArrayList;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.xml.internal.ws.api.pipe.Tube;

import bean.MemberDTO;
import dao.AdminDAO;


public class MemberSearchServlet extends HttpServlet {

	String error = "";
	ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) {

		try {
			//文字エンコーディングの指定
			request.setCharacterEncoding("UTF-8");

			int accountStatus = 0;		//通報された人ボタンが押されてない状態で初期化

			//パラメータの取得
			String memberName = request.getParameter("memberName");
			String familyName = request.getParameter("familyName");
			String firstName = request.getParameter("firstName");
			String strTuuhou = request.getParameter("tuuhou");
			String mail = request.getParameter("mail");
			String residence = request.getParameter("residence");
			String syuppinn = request.getParameter("syuppin");

			//オブジェクト化
			AdminDAO adminDao = new AdminDAO();

			//結果の戻り値としてMemberDTOオブジェクトのリストを取得
			if(strTuuhou != null) {		//通報された人ボタンが押されていたら
				list = adminDao.search(memberName, familyName, firstName, mail, residence, strTuuhou);
			}else if(syuppinn == null){		//通報された人ボタンが押されていない且つ出品した人ボタンが押されていないただの会員絞り込み検索
				list = adminDao.search(memberName, familyName, firstName, mail, residence, accountStatus);
			}else {		//出品した人ボタンのみ押されたら
				list = adminDao.searchShopper(memberName, familyName, firstName, mail, residence, accountStatus);
			}

		} catch (Exception e) {
			System.out.println("エラー(;A;)" + e);
		} finally {
			try {

				// 正常なフォワード
				if (error.equals("")) {
					//セッションにデータを登録してフォワード
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
