/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.32
 * Generated at: 2023-06-23 03:25:10 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.view;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import bean.SellDTO;
import java.util.ArrayList;
import bean.MemberDTO;

public final class productDetail_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("bean.MemberDTO");
    _jspx_imports_classes.add("java.util.ArrayList");
    _jspx_imports_classes.add("bean.SellDTO");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<!-- ファイル名が設計通りになってると確認したらこのコメントを消してください -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

ArrayList<SellDTO> list = (ArrayList<SellDTO>) session.getAttribute("order_list");
MemberDTO seller = (MemberDTO) session.getAttribute("seller_member");
String num=(String)request.getParameter("count");
int numInt=Integer.parseInt(num);
SellDTO sellDto = list.get(numInt);


      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"ja\">\r\n");
      out.write("<head>\r\n");
      out.write("\t<!-- 文字コード -->\r\n");
      out.write("\t<meta charset=\"UTF-8\">\r\n");
      out.write("\r\n");
      out.write("\t<!-- コンテキストパス取得 -->\r\n");
      out.write("\t");
 String context = request.getContextPath();
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<title>商品詳細画面</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("\t<!-- メイン要素 -->\r\n");
      out.write("\r\n");
      out.write("\t<!-- ログインリンク：/view/login.jsp -->\r\n");
      out.write("\t<a href=\"");
      out.print(context );
      out.write("/view/login.jsp\">ログイン</a>\r\n");
      out.write("\r\n");
      out.write("\t<h1>商品詳細</h1>\r\n");
      out.write("\r\n");
      out.write("\t<img src = \"");
      out.print( context );
      out.print(sellDto.getImagePath());
      out.write("\" alt = \"なし\"></a>\r\n");
      out.write("\t<br>商品名:");
      out.print( sellDto.getProductName());
      out.write("\r\n");
      out.write("\t<br>価格:");
      out.print( sellDto.getPrice());
      out.write("\r\n");
      out.write("\t<br>出品エリア:");
      out.print( sellDto.getPrefectures());
      out.write("\r\n");
      out.write("\t<br>商品状態:");
      out.print( sellDto.getProductCondition());
      out.write("\r\n");
      out.write("\t<br>出品日:");
      out.print( sellDto.getSellDate());
      out.write("\r\n");
      out.write("\t<br>出品者:");
      out.print(seller.getMail() );
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<!-- 購入ボタンリンク：/view/login.jsp -->\r\n");
      out.write("\t<br><a href=\"");
      out.print(context );
      out.write("/purchaseCompletion?sell_id=");
      out.print( sellDto.getSellId() );
      out.write("&seller=");
      out.print( seller.getMail() );
      out.write("\">購入</a>\r\n");
      out.write("\t<br><a href=\"");
      out.print(context );
      out.write("/ReportServlet?sellerId=");
      out.print( sellDto.getSellerMemberId() );
      out.write("\">通報/報告</a>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
