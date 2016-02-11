package Recommendation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import datamodel.Car;

public class UserActions
{
    private File userdata = null;

    public UserActions()
    {
        userdata = new File("userdata.txt");
    }

    public void saveCarViewed(Car car) throws FileNotFoundException, JSONException
    {
        if (!userdata.exists())
        {
            userdata.mkdir();
        }

        JSONObject object = new JSONObject();
        object.put("brand", car.getBrand());
        object.put("model", car.getModel());
        object.put("coupeType", car.getCoupeType());
        object.put("startProduction", car.getStartProduction());
        object.put("fuelType", car.getFuelType());
        object.put("numGearsA", car.getNumGearsA());
        object.put("power", car.getPower());

        PrintWriter writer = new PrintWriter(userdata);
        writer.println(object.toString());
        writer.close();
    }

    public JSONArray getUserInformation() throws IOException, JSONException
    {
        JSONArray array = new JSONArray();
        if (!userdata.exists())
        {
            return array;
        }

        BufferedReader br = new BufferedReader(new FileReader(userdata));
        String line;

        while ((line = br.readLine()) != null)
        {
            array.put(new JSONObject(line));
        }

        br.close();

        return array;
    }

}
