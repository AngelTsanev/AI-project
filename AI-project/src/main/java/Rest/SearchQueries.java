package Rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import datamodel.Car;
import DAO.DAOSolr;

@Path("/")
public class SearchQueries
{
    public void init()
    {
        
    }
    
    @GET
    @Path("/id/{id}")
    public String getById(@PathParam("id") String id) 
    {
        DAOSolr dao = new DAOSolr();
        
        return dao.getElementById(id).toString(); //22645
    }
    
    
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/search/{args}")
    public List<Car> search(@PathParam("args") String args) throws JSONException
    {
        JSONObject object;
        Map<String, String> map = new HashMap<String, String>();
        
        object = new JSONObject(args);
        
        map.put("brand", object.getString("brand"));
        map.put("model", object.getString("model"));
        map.put("power", object.getString("power"));
        map.put("startProduction", object.getString("startProduction"));
        map.put("numGearsA", object.getString("numGearsA"));
        map.put("coupeType", object.getString("coupeType"));
        
        DAOSolr dao = new DAOSolr();
        
        return null;
    }

}
