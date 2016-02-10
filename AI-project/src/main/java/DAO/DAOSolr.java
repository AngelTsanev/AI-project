package DAO;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;

import datamodel.Car;

public class DAOSolr
{
    private SolrClient server = null;
    private static String url = "http://localhost:8983/solr/ai";
    
    public DAOSolr()
    {
        if(server == null)
        {
            this.server = new HttpSolrClient(url);
        }
    }
    
    public Car getElementById(String id) 
    {
        try
        {
            SolrQuery query = new SolrQuery();
            query.setQuery( "id:" + id);
            query.setRows(1);
            query.setStart(0);
            QueryResponse rsp = server.query( query );
            List<Car> beans = rsp.getBeans(Car.class);
            
            return  beans.get(0);
        }
        catch (SolrServerException | IOException e) 
        {
            //TODO
        }
        
        return null;
    }
    
    
    public List<Car> searchQuery(Map<String, String> map)
    {
        
        
        
        return null;
    }
    
    
    

}
