package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.io.BufferedReader;
import java.io.File;
import java.sql.*;;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public final class fileRead_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

 Connection con = null;
                                PreparedStatement pst = null;
                                Statement stmt = null;
                                ResultSet rs = null;
                                String username, post;
                            
  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.Vector _jspx_dependants;

  private org.apache.jasper.runtime.ResourceInjector _jspx_resourceInjector;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.apache.jasper.runtime.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\"\r\n");
      out.write("    \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <title>Write your Name and Post</title>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body background=\"pic.jpg\"  alink=\"center\" >\r\n");
      out.write("        <form action=\"login.jsp\" method=\"post\" >\r\n");
      out.write("            <h1> Hi... I am Animesh Chaturvedi this is my first Cloud App Engine deployed Blog Page </h1>\r\n");
      out.write("            <div id=\"only\">\r\n");
      out.write("                <h2><a href=\"AboutMe.html\"> About Me </a></h2>\r\n");
      out.write("\r\n");
      out.write("                <table width=\"\"1000\">\r\n");
      out.write("                    <tr>\r\n");
      out.write("                      <td width=\"214\" class=\"style1\"><h3>Your name</h3></td>\r\n");
      out.write("                      <td width=\"732\"><input name=\"username\" type=\"text\" value=\"\" size=\"30\" id=\"tf\"/></td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                      <td height=\"43\" class=\"style1\"><h3>Your Post about This Blog </h3></td>\r\n");
      out.write("                        <td><textarea name=\"post\" cols=\"30\" rows=\"2\" wrap=\"virtual\" id=\"tf\"></textarea></td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <td height=\"40\" colspan=\"2\" align=\"left\"><h3>\r\n");
      out.write("                                <input name=\"post\" type=\"submit\" id=\"post\" value=\"Post\" />\r\n");
      out.write("                      </h3></td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("\r\n");
      out.write("                </table>\r\n");
      out.write("            </div>\r\n");
      out.write("        </form>\r\n");
      out.write("        <div id=\"centerdiv\">\r\n");
      out.write("            <table width=\"1000\" height=\"87\" align=\"left\">\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td width=\"0\" height=\"81\" align=\"center\" valign=\"top\" ></td>\r\n");
      out.write("                    <td width=\"988\"  align=\"center\" valign=\"middle\">\r\n");
      out.write("                        <div align=\"center\">\r\n");
      out.write("                            ");
      out.write("\r\n");
      out.write("                            ");

                                        try {
                                            Class.forName("com.mysql.jdbc.Driver");
                                            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/iiitjsp", "root", "");
                                            stmt = con.createStatement();
                                            rs = stmt.executeQuery(" SELECT * FROM `username1`");
                            
      out.write("\r\n");
      out.write("                            <table width=\"525\" id=\"tableborder\" align=\"left\" border=\"1\" >\r\n");
      out.write("                                <tr id=\"tableborder\">\r\n");
      out.write("                                    <td width=\"185\" align=\"left\" bgcolor=\"#efefef\"><strong>Name</strong></td>\r\n");
      out.write("                                    <td width=\"324\" align=\"left\" bgcolor=\"#efefef\"><strong>Comment</strong></td>\r\n");
      out.write("                                </tr>\r\n");
      out.write("\r\n");
      out.write("                                ");

                                                                            while (rs.next()) {
                                                                                username = rs.getString("username");
                                                                                post = rs.getString("password");
                                
      out.write("\r\n");
      out.write("                                <tr>\r\n");
      out.write("                                <p>\r\n");
      out.write("                                <td align=\"left\" >");
      out.print(username);
      out.write("</td>\r\n");
      out.write("                                <td align=\"left\" >");
      out.print(post);
      out.write("</td>\r\n");
      out.write("                                </tr>\r\n");
      out.write("\r\n");
      out.write("                                ");

                                                }
                                            } catch (Exception e) {
                                                out.println(e);
                                            }
                                
      out.write("\r\n");
      out.write("                            </table>                    </td>\r\n");
      out.write("                </tr>\r\n");
      out.write("    </table>\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
