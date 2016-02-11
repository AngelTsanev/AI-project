package datamodel;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class QueryPOJO
{   
    public QueryPOJO()
    {
        super();
    }
    public QueryPOJO(String brand, String model, String coupeType, String startProduction,
        String fuelType, String numGearsA, String power)
    {
        super();
        this.brand = brand;
        this.model = model;
        this.coupeType = coupeType;
        this.startProduction = startProduction;
        this.fuelType = fuelType;
        this.numGearsA = numGearsA;
        this.power = power;
    }
    
    private String brand;
    private String model;
    private String coupeType;
    private String startProduction;
    private String fuelType;
    private String numGearsA;
    private String power;
    
    
    public String getPower()
    {
        return power;
    }
    public void setPower(String power)
    {
        this.power = power;
    }
    public String getBrand()
    {
        return brand;
    }
    public void setBrand(String brand)
    {
        this.brand = brand;
    }
    public String getModel()
    {
        return model;
    }
    public void setModel(String model)
    {
        this.model = model;
    }
    public String getCoupeType()
    {
        return coupeType;
    }
    public void setCoupeType(String coupeType)
    {
        this.coupeType = coupeType;
    }
    public String getStartProduction()
    {
        return startProduction;
    }
    public void setStartProduction(String startProduction)
    {
        this.startProduction = startProduction;
    }
    public String getFuelType()
    {
        return fuelType;
    }
    public void setFuelType(String fuelType)
    {
        this.fuelType = fuelType;
    }
    public String getNumGearsA()
    {
        return numGearsA;
    }
    public void setNumGearsA(String numGearsA)
    {
        this.numGearsA = numGearsA;
    }

}
