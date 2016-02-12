package DAO;

import java.io.IOException;
import java.util.List;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.codehaus.jettison.json.JSONException;

import Recommendation.Recommendation;
import datamodel.Car;
import datamodel.QueryPOJO;

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
    public SolrQuery searchQuery(QueryPOJO obj)
  {
      String queryString = "";
      QueryPOJO result = editEmptyFields(obj);
      SolrQuery query = new SolrQuery();
      
      if(!result.getBrand().equals("*")){
    	  queryString += "brand:" + result.getBrand();
      }
      if(!result.getModel().equals("*")){
    	  if(!queryString.equals("")){
    			  queryString += " AND ";
    	  }
    	  queryString += "model:" + result.getModel();
      }
      
      if(!result.getPower().equals("*")){
    	  if(!queryString.equals("")){
    			  queryString += " AND ";
    	  }
    	  queryString += "power:[" + result.getPower() +  " TO *]";
      }
      
      if(!result.getStartProduction().equals("*")){
    	  if(!queryString.equals("")){
    			  queryString += " AND ";
    	  }
    	  queryString += "startProduction:[" + result.getStartProduction() +  " TO *]";
      }
      
      if(!result.getNumGearsA().equals("*")){
    	  if(!queryString.equals("")){
    			  queryString += " AND ";
    	  }
    	  queryString += "numGearsA:" + result.getNumGearsA();
      }
      
      if(!result.getCoupeType().equals("*")){
    	  if(!queryString.equals("")){
    			  queryString += " AND ";
    	  }
    	  queryString += "coupeType:" + result.getCoupeType();
      }
      
      if(!result.getFuelType().equals("*")){
    	  if(!queryString.equals("")){
    			  queryString += " AND ";
    	  }
    	  queryString += "fuelType:" + result.getFuelType();
      }
      
      if(queryString.equals("")){
    	  queryString = "*";
      }
      query.setQuery(queryString);
      
      return query;
  }
    
    public Integer numFound(QueryPOJO obj) throws SolrServerException, IOException
    {
        SolrQuery query = searchQuery(obj);
        query.setRows(1000);
        QueryResponse rsp = server.query(query);
      
        return rsp.getResults().size();
    }
    
    public List<Car> getListCars(QueryPOJO obj) throws SolrServerException, IOException
    {
        SolrQuery query = searchQuery(obj);
        query.setRows(100);
        QueryResponse rsp = server.query(query);
        
        return rsp.getBeans(Car.class);
    }
    
    public List<Car> recommendation() throws IOException, JSONException, SolrServerException
    {
        Recommendation recommendation = new Recommendation();
        
        QueryResponse rsp = server.query(recommendation.getRecommendationQuery());
        
        return rsp.getBeans(Car.class);
    }
    
    private QueryPOJO editEmptyFields(QueryPOJO obj)
    {    
       if( obj.getBrand().equals("") ){ 
           obj.setBrand("*");
       }
       if(obj.getCoupeType().equals("")){
           obj.setCoupeType("*");
       }
       if(obj.getFuelType().equals("")){
            obj.setFuelType("*");
       }
       if(obj.getModel().equals("")){
           obj.setModel("*");
       }
       if(obj.getNumGearsA().equals("")){
           obj.setNumGearsA("*");
       }
       if(obj.getStartProduction().equals("")){
           obj.setStartProduction("*");
       }
       if(obj.getPower().equals("")){
           obj.setPower("*");
       }
       
       return obj;
    }

}
