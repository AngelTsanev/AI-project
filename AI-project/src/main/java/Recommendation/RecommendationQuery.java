package Recommendation;

import java.io.IOException;

import org.apache.solr.client.solrj.SolrQuery;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;

public class RecommendationQuery
{
    private JSONArray userInfo = null;
    
    public RecommendationQuery() throws IOException, JSONException
    {
        UserActions data = new UserActions();
        userInfo = data.getUserInformation();
    }
    
    public SolrQuery getRecommendationQuery()
    {
        Statistics generator = new Statistics();
        
        
        
        
        return null;
    }
    

}
