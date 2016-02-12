package Recommendation;

import java.io.IOException;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import datamodel.Car;

public class UserActions
{
    //private File userdata = null;
    private static JSONArray userdata=null;
    public UserActions()
    {
//        userdata = new File("C:\\userdata.txt");
    	if(userdata == null) {
    		userdata = new JSONArray();
    	}
    }

    public void saveCarViewed(Car car) throws JSONException, IOException
    {
//        if (!userdata.exists())
//        {
//            userdata.createNewFile();
//        }

        JSONObject object = new JSONObject();
        object.put("brand", car.getBrand());
        object.put("model", car.getModel());
        object.put("coupeType", car.getCoupeType());
        object.put("startProduction", car.getStartProduction());
        object.put("fuelType", car.getFuelType());
        object.put("numGearsA", car.getNumGearsA());
        object.put("power", car.getPower());
        
        userdata.put(object);
        //PrintWriter writer = new PrintWriter(userdata);
//        writer.println(object.toString());
//        writer.close();
    }

    public JSONArray getUserInformation() throws IOException, JSONException
    {
//        JSONArray array = new JSONArray();
//        if (!userdata.exists())
//        {
//            return array;
//        }
//
//        BufferedReader br = new BufferedReader(new FileReader(userdata));
//        String line;
//
//        while ((line = br.readLine()) != null)
//        {
//            array.put(new JSONObject(line));
//        }
//
//        br.close();

        return userdata;
    }

}
