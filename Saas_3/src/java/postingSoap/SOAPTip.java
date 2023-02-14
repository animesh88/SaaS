/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package postingSoap;

import java.io.DataOutputStream;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPElement;
import java.io.FileInputStream;
import javax.xml.transform.stream.StreamSource;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamResult;


public class SOAPTip {

   public static void main(String args[]) {

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
         SOAPBody body =  envelope.getBody();


        //Populate the Message
        StreamSource preppedMsgSrc = new StreamSource(
        new FileInputStream("C:\\Users\\ani\\Documents\\NetBeansProjects\\WebApplication1\\src\\java\\postingSoap\\post.msg"));
        soapPart.setContent(preppedMsgSrc);


        //Check the input
        System.out.println("\nREQUEST:\n");
        message.writeTo(System.out);
        System.out.println();




             //Send the message and get a reply

        //Set the destination
        String destination = "http://localhost:38462/SAAS_initial/dirService";
        //Send the message
        SOAPMessage reply = connection.call(message, destination);


                    //Check the output
        System.out.println("\nRESPONSE:\n");
        //Create the transformer
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        //Extract the content of the reply
        Source sourceContent = reply.getSOAPPart().getContent();
        //Set the output for the transformation
       // String S ;
        StreamResult result = new StreamResult(System.out);
        transformer.transform(sourceContent, result);
        System.out.println();



         //Close the connection
         connection.close();

        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}