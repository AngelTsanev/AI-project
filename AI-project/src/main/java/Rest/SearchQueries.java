package Rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/")
public class SearchQueries
{
    public void init()
    {
        
    }
    
    @GET
    @Path("/test")
    public String test()
    {
        
           return "test";
    }
    

}
