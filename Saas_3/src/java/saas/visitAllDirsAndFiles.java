package saas;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.common.SolrInputDocument;
import org.apache.solr.client.solrj.impl.CommonsHttpSolrServer;

public class visitAllDirsAndFiles {

	public visitAllDirsAndFiles(File f1) {
		visitAllFiles(f1);
	}

	public static void visitAllFiles(File dir) {
		if (dir.isDirectory()) {
			String[] children = dir.list();
			for (int i = 0; i < children.length; i++) {
				visitAllFiles(new File(dir, children[i]));
			}
		} else {
			try {
				process(dir);
			} catch (SolrServerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

static int a=0;
static int b=0;
static int c=0;
static int d=0;
static int e=0;
	// public static List<String> fileList = new ArrayList<String>();
	private static void process(File dir) throws SolrServerException,
			IOException {

		//SolrServer myServer = new CommonsHttpSolrServer("http://localhost:8983/solr");

			if (dir.getName().matches("^(.*jar)")) {
				System.out.println(dir.getAbsolutePath());

				SolrServer myServer = new CommonsHttpSolrServer("http://localhost:8983/solr");
				SolrInputDocument objectInput = new SolrInputDocument();

				objectInput.addField("name", dir.getAbsolutePath());
				objectInput.addField("id", "jar"+a);
				//objectInput.addField("File type", ".Jar");
				a++;
				myServer.add(objectInput);

                                myServer.commit();
		}

                        if (dir.getName().matches("^(.*flv)")) {
				System.out.println(dir.getAbsolutePath());

				SolrServer myServer = new CommonsHttpSolrServer("http://localhost:8983/solr");
				SolrInputDocument objectInput = new SolrInputDocument();

				objectInput.addField("name", dir.getAbsolutePath());
				objectInput.addField("id", "flv"+b);
				//objectInput.addField("File type", ".Jar");
				b++;
				myServer.add(objectInput);


			    myServer.commit();
		}
                        if (dir.getName().matches("^(.*txt)")) {
				System.out.println(dir.getAbsolutePath());

				SolrServer myServer = new CommonsHttpSolrServer("http://localhost:8983/solr");
				SolrInputDocument objectInput = new SolrInputDocument();

				objectInput.addField("name", dir.getAbsolutePath());
				objectInput.addField("id", "txt"+c);
				//objectInput.addField("File type", ".Jar");
				c++;
				myServer.add(objectInput);


			    myServer.commit();
		}
                        if (dir.getName().matches("^(.*xml)")) {
				System.out.println(dir.getAbsolutePath());

				SolrServer myServer = new CommonsHttpSolrServer("http://localhost:8983/solr");
				SolrInputDocument objectInput = new SolrInputDocument();

				objectInput.addField("name", dir.getAbsolutePath());
				objectInput.addField("id", "xml"+d);
				//objectInput.addField("File type", ".Jar");
				d++;
				myServer.add(objectInput);


			    myServer.commit();
		}

                        if (dir.getName().matches("^(.*html)")) {
				System.out.println(dir.getAbsolutePath());

				SolrServer myServer = new CommonsHttpSolrServer("http://localhost:8983/solr");
				SolrInputDocument objectInput = new SolrInputDocument();

				objectInput.addField("name", dir.getAbsolutePath());
				objectInput.addField("id", "html"+e);
				//objectInput.addField("File type", ".Jar");
				e++;
				myServer.add(objectInput);


			    myServer.commit();
		}

	}
}

