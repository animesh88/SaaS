<%@page contentType="text/html" pageEncoding="UTF-8" import = "java.sql.*;" %>
<%@page import= "javax.xml.soap.SOAPConnectionFactory;"%>
<%@page import = "javax.xml.soap.SOAPConnection;"
import = "javax.xml.soap.MessageFactory;"
import = "javax.xml.soap.SOAPMessage;"
import= "javax.xml.soap.SOAPPart;"
import = "javax.xml.soap.SOAPEnvelope;"
import = "javax.xml.soap.SOAPBody;"
import = "javax.xml.soap.SOAPElement;"
import = "java.io.FileInputStream;"
import = "javax.xml.transform.stream.StreamSource;"
import = "javax.xml.transform.TransformerFactory;"
import = "javax.xml.transform.Transformer;"
import = "javax.xml.transform.Source;"
import = "javax.xml.transform.stream.StreamResult;"
import = "java.io.OutputStream;"

%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body bgcolor="#ffffff">
            <div id="centerdiv">
                <table width="1094">
                    <tr>
                        <td height="2" colspan="2" bgcolor="#000000"></td>
                    </tr>
                    <tr>
                        <td align="center" bgcolor="#efefef" valign="top">

                        </td>
         
                        
                        <td width="924" bgcolor="#efefef" align="center" valign="middle">
                            <%
//String username,post;

      try {

         //First create the connection
         SOAPConnectionFactory soapConnFactory = SOAPConnectionFactory.newInstance();
         SOAPConnection connection = soapConnFactory.createConnection();


         //Next, create the actual message
         MessageFactory messageFactory = MessageFactory.newInstance();
         SOAPMessage message = messageFactory.createMessage();

         //Create objects for the message parts
         SOAPPart soapPart =     message.getSOAPPart();
         SOAPEnvelope envelope = soapPart.getEnvelope();
         SOAPBody body =         envelope.getBody();


         //Populate the body
        //Create the main element and namespace
        SOAPElement bodyElement = body.addChildElement(envelope.createName("readingFile" ,"ns2","http://saas/"));
        //Add content
        bodyElement.addChildElement("File").addTextNode("C:\\LOKESH ROLLNO.txt");

        //Save the message
        message.saveChanges();


        //Check the input
        out.println("\nREQUEST:\n");
        //JspWriter out = new JspWriter();
        System.out.println("\nREQUEST:\n");
        message.writeTo(System.out);
        System.out.println();
        String s = message.toString();
        //message.writeTo();
        //System.out.println(message.toString());
        %>
        <%=s%>  s      <%//String S = message.writeTo();
        //out.println(message);
//        out.println(S);

        out.println("<h3><div id=\"print\">System.out</div></h3>");



             //Send the message and get a reply

        //Set the destination
        String destination = "http://localhost:38462/SAAS_initial/dirService";
        //Send the message
        SOAPMessage reply = connection.call(message, destination);


                    //Check the output
        //System.out.println("\nRESPONSE:\n");
        //Create the transformer
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        //Extract the content of the reply
        Source sourceContent = reply.getSOAPPart().getContent();
        //Set the output for the transformation
        StreamResult result = new StreamResult(System.out);
        transformer.transform(sourceContent, result);

        System.out.println(result);
   %>
   <%=sourceContent%>
<tr id="tableborder">
    <td width="130" align="center"><strong>Name</strong></td>
    <td width="190" align="center"><strong>Post</strong></td>

  </tr>
  <%      ResultSet rs = null;


        //username = result;
        //post=rs.getString();
        
 } catch (Exception e) {
                                            out.println(e);
                                        }
                %>
    

            <table width="723" id="tableborder">
  

                            </table>
                        
                   
                </table>
            </div>
</html>