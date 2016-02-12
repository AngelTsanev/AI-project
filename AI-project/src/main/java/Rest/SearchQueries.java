package Rest;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.solr.client.solrj.SolrServerException;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import DAO.DAOSolr;
import Recommendation.UserActions;
import datamodel.Car;
import datamodel.QueryPOJO;

@Path("/")
public class SearchQueries
{
    public void init()
    {
        
    }
    
    @GET
    @Path("/id/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Car getById(@PathParam("id") String id) throws JSONException, IOException 
    {
        DAOSolr dao = new DAOSolr();
        Car result = dao.getElementById(id);
        
        UserActions save = new UserActions();
        save.saveCarViewed(result);
        
        return result; 
    }
    
    @GET
    @Path("/test")
    public String getTest() throws FileNotFoundException, JSONException 
    {
    	String result ="[{\"brand\":\"3er\",\"model\":\"BMW\",\"coupeType\":\"Sedan\",\"startProduction\":\"2010 year\",\"fuelType\":\"Diesel\",\"numGearsA\":\"8\",\"power\":\"100\",\"id\":\"1\"},{\"brand\":\"3er\",\"model\":\"BMW\",\"coupeType\":\"Coupe\",\"startProduction\":\"2012 year\",\"fuelType\":\"Petrol\",\"numGearsA\":\"8\",\"power\":\"200\",\"id\":\"2\"},{\"brand\":\"3er\",\"model\":\"BMW\",\"coupeType\":\"Coupe\",\"startProduction\":\"2012 year\",\"fuelType\":\"Petrol\",\"numGearsA\":\"8\",\"power\":\"200\",\"id\":\"3\"},{\"brand\":\"3er\",\"model\":\"BMW\",\"coupeType\":\"Sedan\",\"startProduction\":\"2010 year\",\"fuelType\":\"Diesel\",\"numGearsA\":\"8\",\"power\":\"100\",\"id\":\"4\"},{\"brand\":\"3er\",\"model\":\"BMW\",\"coupeType\":\"Coupe\",\"startProduction\":\"2012 year\",\"fuelType\":\"Petrol\",\"numGearsA\":\"8\",\"power\":\"200\",\"id\":\"5\"},{\"brand\":\"3er\",\"model\":\"BMW\",\"coupeType\":\"Coupe\",\"startProduction\":\"2012 year\",\"fuelType\":\"Petrol\",\"numGearsA\":\"8\",\"power\":\"200\",\"id\":\"6\"},{\"brand\":\"3er\",\"model\":\"BMW\",\"coupeType\":\"Sedan\",\"startProduction\":\"2010 year\",\"fuelType\":\"Diesel\",\"numGearsA\":\"8\",\"power\":\"100\",\"id\":\"7\"},{\"brand\":\"3er\",\"model\":\"BMW\",\"coupeType\":\"Coupe\",\"startProduction\":\"2012 year\",\"fuelType\":\"Petrol\",\"numGearsA\":\"8\",\"power\":\"200\",\"id\":\"8\"},{\"brand\":\"3er\",\"model\":\"BMW\",\"coupeType\":\"Coupe\",\"startProduction\":\"2012 year\",\"fuelType\":\"Petrol\",\"numGearsA\":\"8\",\"power\":\"200\",\"id\":\"9\"},{\"brand\":\"3er\",\"model\":\"BMW\",\"coupeType\":\"Sedan\",\"startProduction\":\"2010 year\",\"fuelType\":\"Diesel\",\"numGearsA\":\"8\",\"power\":\"100\",\"id\":\"10\"},{\"brand\":\"3er\",\"model\":\"BMW\",\"coupeType\":\"Coupe\",\"startProduction\":\"2012 year\",\"fuelType\":\"Petrol\",\"numGearsA\":\"8\",\"power\":\"200\",\"id\":\"11\"},{\"brand\":\"3er\",\"model\":\"BMW\",\"coupeType\":\"Coupe\",\"startProduction\":\"2012 year\",\"fuelType\":\"Petrol\",\"numGearsA\":\"8\",\"power\":\"200\",\"id\":\"12\"},{\"brand\":\"3er\",\"model\":\"BMW\",\"coupeType\":\"Sedan\",\"startProduction\":\"2010 year\",\"fuelType\":\"Diesel\",\"numGearsA\":\"8\",\"power\":\"100\",\"id\":\"13\"},{\"brand\":\"3er\",\"model\":\"BMW\",\"coupeType\":\"Coupe\",\"startProduction\":\"2012 year\",\"fuelType\":\"Petrol\",\"numGearsA\":\"8\",\"power\":\"200\",\"id\":\"14\"},{\"brand\":\"3er\",\"model\":\"BMW\",\"coupeType\":\"Coupe\",\"startProduction\":\"2012 year\",\"fuelType\":\"Petrol\",\"numGearsA\":\"8\",\"power\":\"200\",\"id\":\"15\"},{\"brand\":\"3er\",\"model\":\"BMW\",\"coupeType\":\"Sedan\",\"startProduction\":\"2010 year\",\"fuelType\":\"Diesel\",\"numGearsA\":\"8\",\"power\":\"100\",\"id\":\"16\"},{\"brand\":\"3er\",\"model\":\"BMW\",\"coupeType\":\"Coupe\",\"startProduction\":\"2012 year\",\"fuelType\":\"Petrol\",\"numGearsA\":\"8\",\"power\":\"200\",\"id\":\"17\"},{\"brand\":\"3er\",\"model\":\"BMW\",\"coupeType\":\"Coupe\",\"startProduction\":\"2012 year\",\"fuelType\":\"Petrol\",\"numGearsA\":\"8\",\"power\":\"200\",\"id\":\"18\"},{\"brand\":\"3er\",\"model\":\"BMW\",\"coupeType\":\"Sedan\",\"startProduction\":\"2010 year\",\"fuelType\":\"Diesel\",\"numGearsA\":\"8\",\"power\":\"100\",\"id\":\"19\"},{\"brand\":\"3er\",\"model\":\"BMW\",\"coupeType\":\"Coupe\",\"startProduction\":\"2012 year\",\"fuelType\":\"Petrol\",\"numGearsA\":\"8\",\"power\":\"200\",\"id\":\"20\"},{\"brand\":\"3er\",\"model\":\"BMW\",\"coupeType\":\"Coupe\",\"startProduction\":\"2012 year\",\"fuelType\":\"Petrol\",\"numGearsA\":\"8\",\"power\":\"200\",\"id\":\"21\",\"idsf\":\"1\"}]";
        
        return result; 
    }
      
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/search/{args}")
    public List<Car> search(@PathParam("args") String args) throws JSONException, SolrServerException, IOException
    {
        DAOSolr dao = new DAOSolr();
        QueryPOJO pojo = parse(args);
        
        return dao.getListCars(pojo);
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/recommend")
    public List<Car> getRecommend() throws IOException, JSONException, SolrServerException
    {
        DAOSolr dao = new DAOSolr();
        
        return dao.recommendation();
    }
    
    private QueryPOJO parse(String json) throws JSONException
    {
        JSONObject object;
        object = new JSONObject(json);
        QueryPOJO result = new QueryPOJO();
        
        
        result.setBrand(object.getString("brand"));
        result.setModel(object.getString("model"));
        result.setPower(object.getString("power"));
        result.setStartProduction(object.getString("startProduction"));
        result.setNumGearsA(object.getString("numGearsA"));
        result.setCoupeType(object.getString("coupeType"));
        result.setFuelType(object.getString("fuelType"));
        
        return result;
    }

}
