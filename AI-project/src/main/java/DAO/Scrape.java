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
            
            createCar(car, i);
            
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
    
    private void createCar(Map<String, String> map, int id)
    {
        Car car = new Car();
        car.setId(Integer.toString(id));
        
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
            case "Fuel tank volume":
                 car.setFuelTankCapacity(map.get(key));
                break;
            case "Year of putting into production":
                car.setStartProduction(map.get(key));
                break;
            case "Year of stopping production":
                car.setStopProduction(map.get(key));
                break;
            case "Coupe type":
                car.setCoupeType(map.get(key));
                break;
            case "Length":
                car.setLength(map.get(key));
                break;
            case "Width":
                car.setWeigth(map.get(key));
                break;
            case "Height":
                car.setHeight(map.get(key));
                break;
            case "Minimum volume of Luggage (trunk)":
                car.setTrunkSize(map.get(key));
                break;
            case "Volume of engine":
                car.setEngineVolume(map.get(key));
                break;
            case "Max power in":
                car.setMaxPowerIn(map.get(key));
                break;
            case "Torque":
                car.setTorque(map.get(key));
                break;
            case "Fuel System":
                car.setFuelSystem(map.get(key));
                break;
            case "Turbine":
                car.setTurbine(map.get(key));
                break;
            case "Number of cylinders":
                car.setCylinders(Short.parseShort(map.get(key)));
                break;
            case "Number of valves per cylinder":
                car.setNumValvesPerCylinder(Short.parseShort(map.get(key)));
                break;
            case "Fuel Type":
                car.setFuelType(map.get(key));
                break;
            case "Wheel Drive":
                car.setWheelDrive(map.get(key));
                break;
            case "Number of Gears (automatic transmission)":
                car.setNumGearsA(map.get(key));
                break;
            case "Number of Gears (manual transmission)":
                car.setNumGearsM(map.get(key));
                break;
            case "Fuel consumption (economy) - urban":
                car.setFuelConsumptionU(map.get(key));
                break;
            case "Fuel consumption (economy) - extra urban":
                car.setFuelConsumptionEU(map.get(key));
                break;
            case "Kerb Weight":
                car.setKerbWeigth(map.get(key));
                break;
            case "Tire size":
                car.setTireSize(map.get(key));
                break;
            }         
        }      
        
        cars.add(car);
        this.car = new HashMap<String, String>();
    }

}
