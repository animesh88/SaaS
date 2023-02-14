/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package postingSoa;

import org.w3c.dom.*;


/**
 *
 * @author ani
 */
class GetNodeValue {

    public GetNodeValue() {
    }

    void GettingText(Document doc) {
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

}
}