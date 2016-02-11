package DAO;

import java.io.IOException;
import java.util.List;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;

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
    
//    public SolrQuery searchQuery(Map<String, String> map)
//    {
//        Map<String,String> result = editEmptyFields(map);
//        SolrQuery query = new SolrQuery();
//        
//        query.setQuery("brand:" + result.get("brand") + " AND " + 
//        "model:" + result.get("model") + " AND " + 
//            "power:" + result.get("power") + " AND " +
//        "startProduction:" + result.get("startProduction") + " AND " +
//        "numGearsA:" + result.get("numGearsA") + " AND " +
//        "coupeType:" + result.get("coupeType") + " AND " + 
//        "fuelType:" + result.get("fuelType") );
//        
//        return query;
//    }
    
  public SolrQuery searchQuery(QueryPOJO obj)
  {
      QueryPOJO result = editEmptyFields(obj);
      SolrQuery query = new SolrQuery();
      
      query.setQuery("brand:" + result.getBrand() + " AND " + 
      "model:" + result.getModel() + " AND " + 
          "power:" + result.getPower() + " AND " +
      "startProduction:" + result.getStartProduction() + " AND " +
      "numGearsA:" + result.getNumGearsA() + " AND " +
      "coupeType:" + result.getCoupeType() + " AND " + 
      "fuelType:" + result.getFuelType() );
      
      return query;
  }
    
    public Integer numFound(QueryPOJO obj) throws SolrServerException, IOException
    {
        SolrQuery query = searchQuery(obj);
        query.setRows(1000);
        QueryResponse rsp = server.query(query);
      
        return rsp.getResults().size();
    }
    
    public List<Car> getListCars(int page, QueryPOJO obj) throws SolrServerException, IOException
    {
        SolrQuery query = searchQuery(obj);
        query.setRows(10);
        query.setStart(10 * page);
        QueryResponse rsp = server.query(query);
        
        return rsp.getBeans(Car.class);
    }
    
    
//    private Map<String, String> editEmptyFields(Map<String, String> map)
//    {
//        Map<String, String> result = new HashMap<String, String>();
//        
//        for(String key: map.keySet())
//        {
//            if(map.get(key).equals(""))
//            {
//                result.put(key, "*");
//            }
//            else
//            {
//                result.put(key, map.get(key));
//            }
//        }
//        
//        return result;
//    }
    
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
