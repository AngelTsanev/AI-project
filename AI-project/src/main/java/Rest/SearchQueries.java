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
    @Path("/Recommend")
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
