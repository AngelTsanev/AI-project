package DAO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrServerException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import datamodel.Car;

public class Scrape
{
    private SolrClient server;
    private List<Car> cars = new ArrayList<Car>();
    private Map<String, String> car = new HashMap<String, String>();

    public Scrape(SolrClient server)
    {
        this.server = server;
    }

    public void scrapeInformation() throws IOException, SolrServerException
    {
        String key = "";
        String value = "";

        for (int i = 1; i < 2; i++)
        {
            Document doc = Jsoup.connect("http://www.auto-data.net/en/?f=showCar&car_id=" + i)
                .get();
            Elements td = doc.select("td");


            for (Element el : td)
            {
                if (el.childNodeSize() == 1)
                {
                    key = el.ownText();
                    continue;
                }

                if (el.childNodeSize() > 1)
                {
                    value = el.getAllElements().select("strong").text();
                    if (!key.equals("") && !value.equals(""))
                    {
                        car.put(key, value);
                        key = "";
                        value = "";
                    }
                }
            }
            
            createCar(car);
            
            if((i % 100) == 0)
                persistDocuments(cars);

        }
        
        return;
    }
    
    private void persistDocuments(List<Car> cars) throws SolrServerException, IOException
    {
        server.addBeans(cars);
        server.commit();
        
        this.cars = new ArrayList<Car>();
    }
    
    private void createCar(Map<String, String> map)
    {
        Car car = new Car();
        
        for(String key: map.keySet())
        {
            switch(key)
            {
            case "Brand": 
                car.setBrand(map.get(key));
                break;
            case "Model":
                car.setModel(map.get(key));
                break;
            case "Generation":
                car.setGeneration(map.get(key));
                break;
            case "Engine":
                car.setEngine(map.get(key));
                break;
            case "Doors":
                car.setDoors(Short.parseShort(map.get(key)));
                break;
            case "Power":
                car.setPower(map.get(key));
                break;
            case "Maximum speed":
                car.setMaxSpeed(map.get(key));
                break;
            case "":
                
                
                
            }
            
            
            
            
        }
        
        
        cars.add(car);
        this.car = new HashMap<String, String>();
    }

}
