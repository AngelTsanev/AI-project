package SolrJ;

import java.io.IOException;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;

import DAO.Scrape;

public class Main
{
    
    public static void main(String args[]) throws IOException, SolrServerException
    {
        String url = "http://localhost:8983/solr/ai";
        SolrClient server = new HttpSolrClient(url);
        
        
//        Scrape scrape = new Scrape(server);
//        scrape.scrapeInformation();
//        System.out.println("finish");
        
    }

}
