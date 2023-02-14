/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package postingSoa;

/**
 *
 * @author ani
 */
import java.io.File;
import org.w3c.dom.*;
import java.io.FileOutputStream;
import javax.xml.soap.*;
import java.net.URL;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;


public class SoapRequest {
    public static void main(String[] args)  {
    try {
      SOAPConnectionFactory soapConnectionFactory =
        SOAPConnectionFactory.newInstance();
      SOAPConnection connection =
        soapConnectionFactory.createConnection();
      SOAPFactory soapFactory =
        SOAPFactory.newInstance();

      MessageFactory factory =
        MessageFactory.newInstance();
      SOAPMessage message = factory.createMessage();

      SOAPHeader header = message.getSOAPHeader();
      SOAPBody body = message.getSOAPBody();
      header.detachNode();

Name bodyName = soapFactory.createName("readingFile" ,"ns2","http://saas/");
  SOAPBodyElement bodyElement = body.addBodyElement(bodyName);

    Name name = soapFactory.createName("File");
      SOAPElement symbol = bodyElement.addChildElement(name);
      symbol.addTextNode("C:\\LOKESH ROLLNO.txt");

      URL destination = new URL("http://localhost:38462/SAAS_2/dirService");
      //SOAPMessage response = connection.call(message, endpoint);

       SOAPMessage reply = connection.call(message, destination);

            System.out.println("\nRESPONSE:\n");
            //Create the transformer

           TransformerFactory transformerFactory =
                           TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        //Extract the content of the reply
        Source sourceContent = reply.getSOAPPart().getContent(); //    getSOAPPart().getAttributes();
/*do not modify very close to result of return

Name x = soapFactory.createName("readingFileResponse","ns2","http://saas/");
  SOAPBodyElement y = sourceContent.addBodyElement(x);

    Name name1 = soapFactory.createName("return");
        SOAPElement z = y.addChildElement(name1);
        String a = z.getValue();
*/
        //String a = sourceContent.toString(); //getNamedItem("Result");


        File x =new File("response.xml");
        FileOutputStream f = new FileOutputStream(x);
        //Set the output for the transformation
        StreamResult result = new StreamResult(f);
        transformer. transform(sourceContent, result);
        f.close();


        File file = new File("response.xml");
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(file);

        //new GetNodeValue().GettingText(doc);

          Element e = doc.getDocumentElement();
        NodeList nodeList = doc.getElementsByTagName("ns2:readingFileResponse");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                NodeList nodelist = element.getElementsByTagName("return");
                Element element1 = (Element) nodelist.item(0);
                NodeList fstNm = element1.getChildNodes();
                System.out.print("Return : " + (fstNm.item(0)).getNodeValue());
               }

    }

        //String a = null;
        
        //System.out.println("excellent"+a+"good");

            //s = writer.toString();

            //System.out.println(s);

        //StreamResult a = result;
      //AttachmentPart a = reply.getAttachment((SOAPElement) result);
         System.out.print("lkskjajfdkjhfsjhsk");


//System.out.print(a);



      connection.close();


    /*  SOAPBody soapBody = response.getSOAPBody();

      Iterator iterator =
              soapBody.getChildElements(bodyName);
      bodyElement = (SOAPBodyElement)iterator.next();
      String lastPrice = bodyElement.getValue();

      System.out.print("The last price for  ");
      System.out.println(lastPrice);
*/
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }


}
