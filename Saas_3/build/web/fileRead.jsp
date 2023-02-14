<%-- 
    Document   : fileRead
    Created on : Apr 11, 2012, 12:30:10 PM
    Author     : ani
--%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<%@page session = "true" contentType="text/html" pageEncoding="UTF-8" import= "java.io.BufferedReader"  %>
<%@page import = "java.io.File" %>
<%@page import = "java.sql.*;" %>
<%@page import= "java.io.FileNotFoundException" %>
<%@page import = "java.io.FileReader" %>
<%@page import = "java.io.IOException" %>

<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Write your Name and Post</title>
    </head>
    <body background="pic.jpg"  alink="center" >
        <form action="login.jsp" method="post" >
            <h1> Hi... I am Animesh Chaturvedi this is my first Cloud App Engine deployed Blog Page </h1>
            <div id="only">
                <h2><a href="AboutMe.html"> About Me </a></h2>

                <table width=""1000">
                    <tr>
                      <td width="214" class="style1"><h3>Your name</h3></td>
                      <td width="732"><input name="username" type="text" value="" size="30" id="tf"/></td>
                    </tr>
                    <tr>
                      <td height="43" class="style1"><h3>Your Post about This Blog </h3></td>
                        <td><textarea name="post" cols="30" rows="2" wrap="virtual" id="tf"></textarea></td>
                    </tr>
                    <tr>
                        <td height="40" colspan="2" align="left"><h3>
                                <input name="post" type="submit" id="post" value="Post" />
                      </h3></td>
                    </tr>

                </table>
            </div>
        </form>
        <div id="centerdiv">
            <table width="1000" height="87" align="left">
                <tr>
                    <td width="0" height="81" align="center" valign="top" ></td>
                    <td width="988"  align="center" valign="middle">
                        <div align="center">
                            <%! Connection con = null;
                                PreparedStatement pst = null;
                                Statement stmt = null;
                                ResultSet rs = null;
                                String username, post;
                            %>
                            <%
                                        try {
                                            Class.forName("com.mysql.jdbc.Driver");
                                            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/iiitjsp", "root", "");
                                            stmt = con.createStatement();
                                            rs = stmt.executeQuery(" SELECT * FROM `username1`");
                            %>
                            <table width="525" id="tableborder" align="left" border="1" >
                                <tr id="tableborder">
                                    <td width="185" align="left" bgcolor="#efefef"><strong>Name</strong></td>
                                    <td width="324" align="left" bgcolor="#efefef"><strong>Comment</strong></td>
                                </tr>

                                <%
                                                                            while (rs.next()) {
                                                                                username = rs.getString("username");
                                                                                post = rs.getString("password");
                                %>
                                <tr>
                                <p>
                                <td align="left" ><%=username%></td>
                                <td align="left" ><%=post%></td>
                                </tr>

                                <%
                                                }
                                            } catch (Exception e) {
                                                out.println(e);
                                            }
                                %>
                            </table>                    </td>
                </tr>
    </table>
    </body>
</html>
