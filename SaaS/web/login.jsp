<%@page session="true" contentType="text/html" pageEncoding="UTF-8" import= "java.sql.*"%>
<%@page import="java.util.*" %>

<%
            try
        {
                String password,username;
                Connection con = null;
                Statement stmt = null;

                username = request.getParameter("username");
                password = request.getParameter("post");
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/iiitjsp", "root", "");
                stmt = con.createStatement();
                stmt.executeUpdate("INSERT INTO `iiitjsp`.`username1` ( `username` , `password`) VALUES ('" + username + "', '" + password + "')");


  }catch(Exception e)

            {}
        %>

<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Write your Name and Post</title>
    </head>
    <body background="pic.jpg" alink="center" >

<form action="login.jsp" method="post">
            <h1> Hi... I am Animesh Chaturvedi this is my first Blog Page & first Cloud App Engine Deploymed Service </h1>


                <h2> About Me </h2>

                <h3> I love To Dance, Skate, Cinematography, Editing Video's, and R......</h3>
<div id="centerdiv">
            <table width="1000">
                <tr>
                    <td height="2" colspan="2" bgcolor="#efefef"></td>
                </tr>
                <tr>
                    <td width="0" align="center" valign="top" bgcolor="#efefef"></td>
                    <td width="1082" bgcolor="" align="center" valign="middle" bgcolor="#efefef">
                        <%!    Connection con = null;
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
                        <table width="500" id="tableborder" align="left" border="1" >
                            <tr id="tableborder">
                                <td width="30" align="left" bgcolor="#efefef"><strong>Name</strong></td>
                                <td width="100" align="left" bgcolor="#efefef"><strong>Comment</strong></td>

                            </tr>

                            <%
                                            while (rs.next()) {
                                                username = rs.getString("username");
                                                post = rs.getString("password");
                            %>
                            <tr>
                            <p>
                    
                                <td align="left"><%=username%></td>
                                <td align="left"><%=post%></td>
                                
                            </tr>
                          
                            <%
                                            }
                                        } catch (Exception e) {
                                            out.println(e);
                                        }
                            %>
                        </table>
                    </td>
                </tr>
            </table>
        </div>
   
</form>
</body>
</html>
