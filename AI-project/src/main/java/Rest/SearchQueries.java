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
    public Car getById(@PathParam("id") String id) throws FileNotFoundException, JSONException 
    {
        DAOSolr dao = new DAOSolr();
        Car result = dao.getElementById(id);
        
        UserActions save = new UserActions();
        save.saveCarViewed(result);
        
        return result; 
    }
    
    
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/search")
    public String search(QueryPOJO args) throws JSONException, SolrServerException, IOException
    {
        DAOSolr dao = new DAOSolr();
        
        return dao.numFound(args).toString();
    }
    
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/Page/{number}")
    public List<Car> getPage(@PathParam("number") String number, QueryPOJO args) throws NumberFormatException, SolrServerException, IOException, JSONException
    {
        DAOSolr dao = new DAOSolr();
        
        return dao.getListCars(Integer.parseInt(number), args);
    }
    
/*    private Map<String, String> parse(String json) throws JSONException
    {
        JSONObject object;
        Map<String, String> map = new HashMap<String, String>();
        
        object = new JSONObject(json);
        
        map.put("brand", object.getString("brand"));
        map.put("model", object.getString("model"));
        map.put("power", object.getString("power"));
        map.put("startProduction", object.getString("startProduction"));
        map.put("numGearsA", object.getString("numGearsA"));
        map.put("coupeType", object.getString("coupeType"));
        map.put("fuelType", object.getString("fuelType"));
        
        return map;
    }*/
}
