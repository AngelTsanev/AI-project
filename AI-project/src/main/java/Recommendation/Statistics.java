package Recommendation;

import java.util.Map;
import java.util.TreeMap;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class Statistics
{
    public Statistics()
    {

    }

    public String fuelTypeStatistics(JSONArray array) throws JSONException
    {
        int diesel = 0, petrol = 0;

        for (int i = 0; i < array.length(); i++)
        {
            JSONObject obj = array.getJSONObject(i);
            if (obj.getString("fuelType").equals("Diesel"))
            {
                diesel++;
            }
            else if (obj.getString("fuelType").contains("Petrol"))
            {
                petrol++;
            }
        }
        diesel = diesel * 2;
        petrol = petrol * 2;

        if (diesel == 0 && petrol == 0)
        {
            return "";
        }
        else if (diesel == 0 && petrol != 0)
        {
            return "fuelType:*Petrol";
        }
        else if (diesel != 0 && petrol == 0)
        {
            return "fuelType:Diesel";
        }

        return "fuelType:Diesel^" + diesel + " OR fuelType:Petrol^" + petrol;
    }

    public String brandStatistics(JSONArray array) throws JSONException
    {
        Map<String, Integer> appearences = new TreeMap<String, Integer>();
        JSONObject object = null;
        String result = "";

        for (int i = 0; i < array.length(); i++)
        {
            object = array.getJSONObject(i);

            if (object.getString("model").equals(""))
            {
                continue;
            }

            Integer count = appearences.get(object.getString("model"));
            if (count != null)
            {
                appearences.put(object.getString("model"), ++count);
            }
            else
            {
                appearences.put(object.getString("model"), 1);
            }
        }

        int firstTreeCarsOnly = 0;

        for (String key : appearences.keySet())
        {

            result = result + "model:" + key + "^" + appearences.get(key);

            if (firstTreeCarsOnly >= 2 || appearences.size() == 1 || (firstTreeCarsOnly==1 && appearences.size() ==2))
            {
                break;
            }
            else
            {
                result = result + " OR ";
            }

            firstTreeCarsOnly++;
        }

        return result;
    }

    public String yearStatistics(JSONArray array) throws JSONException
    {
        String result = "";
        JSONObject object = null;
        int avarageYears = 0, num = 0;

        for (int i = 0; i < array.length(); i++)
        {
            object = array.getJSONObject(i);
            String year = object.getString("startProduction");

            if (year.equals(""))
                continue;

            avarageYears = avarageYears + Integer.parseInt(year.substring(0, 4));

            num++;
        }

        if (avarageYears == 0)
        {
            return result;
        }

        avarageYears = avarageYears / num;

        result = "startProduction:" + avarageYears;

        return result;
    }

    public String hoursePowerStatistics(JSONArray array) throws JSONException
    {
        String result = "";
        JSONObject object = null;
        int hpAvarage = 0, num = 0;

        for (int i = 0; i < array.length(); i++)
        {
            object = array.getJSONObject(i);
            String hp = object.getString("power");

            if (hp.equals(""))
                continue;

            hpAvarage = hpAvarage + Integer.parseInt(hp.substring(0, 4));

            num++;
        }

        if (hpAvarage == 0)
        {
            return result;
        }

        hpAvarage = hpAvarage / num;

        result = "power:" + hpAvarage;

        return result;
    }
    
    public String coupeStatistics(JSONArray array) throws JSONException
    {
      String result = "";
      Map<String, Integer> appear = new TreeMap<String, Integer>();
      JSONObject object = null;
        
      for(int i=0; i<array.length(); i++)
      {
          object = array.getJSONObject(i);
          
          if(object.getString("coupeType").equals(""))
              continue;
          
          Integer count = appear.get(object.getString("coupeType"));
          
          if(count == null)
          {
              appear.put(object.getString("coupeType"), 1);
          }
          else
          {
              appear.put(object.getString("coupeType"), ++count);
          }
      }
      
      boolean temp = false;
      
      for(String key: appear.keySet())
      {
          result = result + "coupeType:" + key + "^" + appear.get(key);
          
          if(appear.size() == 1 || temp)
              break;
          
          result = result + "OR";
          temp = true;
      }
        
      
      return result;
    }
    

}
