package servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServlet;
import com.oreilly.servlet.MultipartRequest;

import bean.MemberDTO;
import bean.SellDTO;
import dao.MemberDAO;
import dao.SellDAO;

import java.io.IOException;

import javax.servlet.ServletException;

public class ItemInsert extends HttpServlet{



	// ポスト送信
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		String error = "";
		request.setCharacterEncoding("UTF-8");
		SellDTO sell = new SellDTO();
		try {

			String FilePath = getServletContext().getRealPath("image");
			//ファイル名
			String imageName = "no_image.jpg";
			// ファイルの最大バイト数
			int maxBytes = 1024*1024;
			MultipartRequest multireq=new MultipartRequest(request,FilePath,maxBytes,"UTF-8");
			if(multireq.getFile("image") != null){
			imageName = multireq.getFile("image").getName();
			}
			String itemName = multireq.getParameter("itemName");

			String type = multireq.getParameter("type");
			if(type == null || type.equals("")) {
				error = "種類を入力してください";
				return;
			}
			String productStatus = multireq.getParameter("productStatus");
			if(productStatus == null || productStatus.equals("")) {
				error = "商品状態を入力してください";
				return;
			}
			String price = multireq.getParameter("price");
			if(price == null || price.equals("")) {
				error = "価格を入力してください";
				return;
			}
			String pref = multireq.getParameter("pref");
			String remarks = multireq.getParameter("remarks");
			if(price == null || price.equals("")) {
				error = "備考欄を入力してください";
				return;
			}
			String delivaryDay = multireq.getParameter("delivaryDay");

			HttpSession session = request.getSession();
			MemberDTO member =(MemberDTO) session.getAttribute("member");

			sell.setDeliveryDays(Integer.parseInt(delivaryDay));
			sell.setPurchaserMemberId(-1);
			sell.setSellerMemberId(member.getMemberId());
			sell.setImagePath(imageName);
			sell.setProductName(itemName);
			sell.setProductType(type);
			sell.setProductCondition(productStatus);
			sell.setPrice(Integer.parseInt(price));
			sell.setPrefectures(pref);
			sell.setRemarks(remarks);

			SellDAO objSell = new SellDAO();
			objSell.itemInsert(sell);




		}catch(NumberFormatException e) {
			error = "不正な値です。";
		}

		catch (IllegalStateException e) {
			error = "データベース接続時にエラーが発生しました。";
			System.out.println(e);

		}catch(Exception e){
			System.out.println(e);
		}	finally {
		}
			try {

				// 正常なフォワード
				if (error.equals("")) {
					request.getRequestDispatcher("view/listingCompletionScreen.jsp").forward(request, response);
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



