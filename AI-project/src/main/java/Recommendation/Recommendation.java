package Recommendation;

import java.io.IOException;

import org.apache.solr.client.solrj.SolrQuery;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;

public class Recommendation
{
    private static JSONArray userInfo = null;
    
    public Recommendation() throws IOException, JSONException
    {
        UserActions data = new UserActions();
        userInfo = data.getUserInformation();
    }
    
    public SolrQuery getRecommendationQuery() throws JSONException
    {
        Statistics stat = new Statistics();
        String queryString = "";
        
        if(!stat.brandStatistics(userInfo).equals("")){
          
            queryString = stat.brandStatistics(userInfo);
        }
        if(!stat.coupeStatistics(userInfo).equals("")){
            
            if(queryString.equals(""))
            {
                queryString = stat.coupeStatistics(userInfo);
            }else
            {
                queryString = queryString + " AND " + stat.coupeStatistics(userInfo);
            }
        }
        if(!stat.fuelTypeStatistics(userInfo).equals(""))
        {
            if(queryString.equals(""))
            {
                queryString = stat.fuelTypeStatistics(userInfo);
            }
            else
            {
                queryString = queryString + " AND " + stat.fuelTypeStatistics(userInfo);
            }
        }
        if(!stat.hoursePowerStatistics(userInfo).equals(""))
        {
            if(queryString.equals(""))
            {
                queryString = stat.hoursePowerStatistics(userInfo);
            }
            else
            {
                queryString = queryString + " AND " + stat.hoursePowerStatistics(userInfo);
            } 
        }
        if(!stat.yearStatistics(userInfo).equals(""))
        {
            if(queryString.equals(""))
            {
                queryString = stat.yearStatistics(userInfo);
            }
            else
            {
                queryString = queryString + " AND " + stat.yearStatistics(userInfo);
            } 
        }
        
        SolrQuery query = new SolrQuery();
        query.setQuery(queryString);
        query.setRows(10);
        
        return query;
    }
    
    
    public static void main(String args[]) throws JSONException, IOException
    {
        Statistics temp = new Statistics();
        UserActions data = new UserActions();
        userInfo = data.getUserInformation();
        
        System.out.println(temp.hoursePowerStatistics(userInfo));
        
    }

}
