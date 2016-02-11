package datamodel;

import javax.xml.bind.annotation.XmlRootElement;

import org.apache.solr.client.solrj.beans.Field;
@XmlRootElement
public class Car
{
    
    public Car()
    {
        super();
    }
    
    public Car(String id, String brand, String generation, String model, String engine,
        short doors, String power, String fuelTankCapacity, String maxSpeed, String coupeType,
        String startProduction, String stopProduction, String length, String height, String weigth,
        String engineVolume, String maxPowerIn, String torque, String fuelSystem, String turbine,
        short cylinders, short numValvesPerCylinder, String fuelType, String wheelDrive,
        String kerbWeigth, String tireSize, String fuelConsumptionU, String fuelConsumptionEU,
        String numGearsM, String numGearsA, String trunkSize)
    {
        super();
        this.id = id;
        this.brand = brand;
        this.generation = generation;
        this.model = model;
        this.engine = engine;
        this.doors = doors;
        this.power = power;
        this.fuelTankCapacity = fuelTankCapacity;
        this.maxSpeed = maxSpeed;
        this.coupeType = coupeType;
        this.startProduction = startProduction;
        this.stopProduction = stopProduction;
        this.length = length;
        this.height = height;
        this.weigth = weigth;
        this.engineVolume = engineVolume;
        this.maxPowerIn = maxPowerIn;
        this.torque = torque;
        this.fuelSystem = fuelSystem;
        this.turbine = turbine;
        this.cylinders = cylinders;
        this.numValvesPerCylinder = numValvesPerCylinder;
        this.fuelType = fuelType;
        this.wheelDrive = wheelDrive;
        this.kerbWeigth = kerbWeigth;
        this.tireSize = tireSize;
        this.fuelConsumptionU = fuelConsumptionU;
        this.fuelConsumptionEU = fuelConsumptionEU;
        this.numGearsM = numGearsM;
        this.numGearsA = numGearsA;
        this.trunkSize = trunkSize;
    }

    @Field
    private String id;
    
    @Field
    private String brand;
    
    @Field
    private String generation;
    
    @Field
    private String model;
    
    @Field 
    private String engine;
    
    @Field
    private int doors;
    
    @Field
    private String power;
    
    @Field
    private String fuelTankCapacity;
    
    @Field
    private String maxSpeed;
    
    @Field
    private String coupeType;
    
    @Field
    private String startProduction;
    
    @Field 
    private String stopProduction;
    
    @Field
    private String length;
    
    @Field 
    private String height;
    
    @Field
    private String weigth;
    
    @Field
    private String engineVolume;
    
    @Field
    private String maxPowerIn;
    
    @Field
    private String torque;
    
    @Field 
    private String fuelSystem;
    
    @Field
    private String turbine;
    
    @Field
    private int cylinders;
    
    @Field
    private int numValvesPerCylinder;
    
    @Field 
    private String fuelType;
    
    @Field
    private String wheelDrive;
    
    @Field
    private String kerbWeigth;
    
    @Field
    private String tireSize;
    
    @Field 
    private String fuelConsumptionU;
    
    @Field 
    private String fuelConsumptionEU;
    
    @Field
    private String numGearsM;
    
    @Field
    private String numGearsA;
    
    @Field
    private String trunkSize;

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getBrand()
    {
        return brand;
    }

    public void setBrand(String brand)
    {
        this.brand = brand;
    }

    public String getGeneration()
    {
        return generation;
    }

    public void setGeneration(String generation)
    {
        this.generation = generation;
    }

    public String getModel()
    {
        return model;
    }

    public void setModel(String model)
    {
        this.model = model;
    }

    public String getEngine()
    {
        return engine;
    }

    public void setEngine(String engine)
    {
        this.engine = engine;
    }

    public int getDoors()
    {
        return doors;
    }

    public void setDoors(int doors)
    {
        this.doors = doors;
    }

    public String getPower()
    {
        return power;
    }

    public void setPower(String power)
    {
        this.power = power;
    }

    public String getFuelTankCapacity()
    {
        return fuelTankCapacity;
    }

    public void setFuelTankCapacity(String fuelTankCapacity)
    {
        this.fuelTankCapacity = fuelTankCapacity;
    }

    public String getMaxSpeed()
    {
        return maxSpeed;
    }

    public void setMaxSpeed(String maxSpeed)
    {
        this.maxSpeed = maxSpeed;
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

    public String getStopProduction()
    {
        return stopProduction;
    }

    public void setStopProduction(String stopProduction)
    {
        this.stopProduction = stopProduction;
    }

    public String getLength()
    {
        return length;
    }

    public void setLength(String length)
    {
        this.length = length;
    }

    public String getHeight()
    {
        return height;
    }

    public void setHeight(String height)
    {
        this.height = height;
    }

    public String getWeigth()
    {
        return weigth;
    }

    public void setWeigth(String weigth)
    {
        this.weigth = weigth;
    }

    public String getEngineVolume()
    {
        return engineVolume;
    }

    public void setEngineVolume(String engineVolume)
    {
        this.engineVolume = engineVolume;
    }

    public String getMaxPowerIn()
    {
        return maxPowerIn;
    }

    public void setMaxPowerIn(String maxPowerIn)
    {
        this.maxPowerIn = maxPowerIn;
    }

    public String getTorque()
    {
        return torque;
    }

    public void setTorque(String torque)
    {
        this.torque = torque;
    }

    public String getFuelSystem()
    {
        return fuelSystem;
    }

    public void setFuelSystem(String fuelSystem)
    {
        this.fuelSystem = fuelSystem;
    }

    public String getTurbine()
    {
        return turbine;
    }

    public void setTurbine(String turbine)
    {
        this.turbine = turbine;
    }

    public int getCylinders()
    {
        return cylinders;
    }

    public void setCylinders(int cylinders)
    {
        this.cylinders = cylinders;
    }

    public int getNumValvesPerCylinder()
    {
        return numValvesPerCylinder;
    }

    public void setNumValvesPerCylinder(int numValvesPerCylinder)
    {
        this.numValvesPerCylinder = numValvesPerCylinder;
    }

    public String getFuelType()
    {
        return fuelType;
    }

    public void setFuelType(String fuelType)
    {
        this.fuelType = fuelType;
    }

    public String getWheelDrive()
    {
        return wheelDrive;
    }

    public void setWheelDrive(String wheelDrive)
    {
        this.wheelDrive = wheelDrive;
    }

    public String getKerbWeigth()
    {
        return kerbWeigth;
    }

    public void setKerbWeigth(String kerbWeigth)
    {
        this.kerbWeigth = kerbWeigth;
    }

    public String getTireSize()
    {
        return tireSize;
    }

    public void setTireSize(String tireSize)
    {
        this.tireSize = tireSize;
    }

    public String getFuelConsumptionU()
    {
        return fuelConsumptionU;
    }

    public void setFuelConsumptionU(String fuelConsumptionU)
    {
        this.fuelConsumptionU = fuelConsumptionU;
    }

    public String getFuelConsumptionEU()
    {
        return fuelConsumptionEU;
    }

    public void setFuelConsumptionEU(String fuelConsumptionEU)
    {
        this.fuelConsumptionEU = fuelConsumptionEU;
    }

    public String getNumGearsM()
    {
        return numGearsM;
    }

    public void setNumGearsM(String numGearsM)
    {
        this.numGearsM = numGearsM;
    }

    public String getNumGearsA()
    {
        return numGearsA;
    }

    public void setNumGearsA(String numGearsA)
    {
        this.numGearsA = numGearsA;
    }

    public String getTrunkSize()
    {
        return trunkSize;
    }

    public void setTrunkSize(String trunkSize)
    {
        this.trunkSize = trunkSize;
    }

    @Override
    public String toString()
    {
        return "Car [id=" + id + ", brand=" + brand + ", generation=" + generation + ", model=" +
            model + ", engine=" + engine + ", doors=" + doors + ", power=" + power +
            ", fuelTankCapacity=" + fuelTankCapacity + ", maxSpeed=" + maxSpeed + ", coupeType=" +
            coupeType + ", startProduction=" + startProduction + ", stopProduction=" +
            stopProduction + ", length=" + length + ", height=" + height + ", weigth=" + weigth +
            ", engineVolume=" + engineVolume + ", maxPowerIn=" + maxPowerIn + ", torque=" + torque +
            ", fuelSystem=" + fuelSystem + ", turbine=" + turbine + ", cylinders=" + cylinders +
            ", numValvesPerCylinder=" + numValvesPerCylinder + ", fuelType=" + fuelType +
            ", wheelDrive=" + wheelDrive + ", kerbWeigth=" + kerbWeigth + ", tireSize=" + tireSize +
            ", fuelConsumptionU=" + fuelConsumptionU + ", fuelConsumptionEU=" + fuelConsumptionEU +
            ", numGearsM=" + numGearsM + ", numGearsA=" + numGearsA + ", trunkSize=" + trunkSize +
            "]";
    }
    
}
