/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package saas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.CommonsHttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;

/**
 *
 * @author ani
 */
@WebService()
public class dir {
    @WebMethod(operationName = "Index")
    public String Index(@WebParam(name = "Indexing")
    String Indexing){


        File X	= new File(Indexing);
        new visitAllDirsAndFiles(X);

return "end";
}

    /**
     * Web service operation
     */
    @WebMethod(operationName = "Searching")
    public String Searching(@WebParam(name = "QueryString")
    String QueryString) {String outputString = null;
        try {
            //new Search(QueryString);
            CommonsHttpSolrServer server = null;

     try {
         server = new CommonsHttpSolrServer("http://localhost:8983/solr");
     } catch(Exception e) { e.printStackTrace(); }

     // escape special characters
     SolrQuery query = new SolrQuery();
     query.setQuery(QueryString);

     //try {
     QueryResponse rsp = server.query (query);
     rsp.getResults();
     SolrDocumentList listOfdoc = rsp.getResults();
     String Output = ("\n\n***** The total results returned is = "+ listOfdoc.size()+" *****\n");
     String output = "\n***********************************************************\n";

     for (Iterator<SolrDocument> it = listOfdoc.iterator(); it.hasNext();) {
           SolrDocument solrDocument = it.next();
           String id = (String) solrDocument.getFieldValue("id");
           //Output.concat(" "+ id +" ");
           //System.out.println(id);
           String name = (String) solrDocument.getFieldValue("name");

           output = output.concat("\n ID: "+ id.concat("           Path: "+ name +" \n\n"));
           //System.out.println(output);
           //X.concat(output);
       }
            outputString = Output.concat(output);

    } catch (SolrServerException ex) {        }

            return outputString;

    }
    

    /**
     * Web service operation
     */
    @WebMethod(operationName = "readingFile")
    public String readingFile(@WebParam(name = "File")
    String File) {
        String str = " \n";
        String output = "\n************ \n ";
        try {
            FileReader reader = null;
            try {
                //String dir = "File";
                reader = new FileReader(new File(File));
            } catch (FileNotFoundException ex) {
                Logger.getLogger(dir.class.getName()).log(Level.SEVERE, null, ex);
            }
            BufferedReader bufferReader = new BufferedReader(reader);
            
            while ((str = bufferReader.readLine()) != null) {
              output = output.concat(str);
            }
              output=output.concat("\n************\n");
        } catch (IOException ex) {
            Logger.getLogger(dir.class.getName()).log(Level.SEVERE, null, ex);
        }
return output; }

    /**
     * Web service operation author Animesh Chaturvedi
     */
    @WebMethod(operationName = "editFile")
    public String editFile(@WebParam(name = "inputPosting")
    String string) throws IOException {
        //TODO write your implementation code here:
        FileOutputStream fos = null;
    try {
        String fileName = "C:\\Users\\ani\\Desktop\\Anand Pateriya.txt";
        fos = new FileOutputStream(fileName);
        fos.write(string.getBytes("UTF-8"));
    } catch (IOException e) {
        throw e;
    }
        return null;
    }
}
/*
    private void close(FileOutputStream fos) {
       try {
        closeable.close();
    } catch(IOException ignored) {
    }

}
 *
 */