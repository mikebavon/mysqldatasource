package tracom.academy.oopprinc;

public class CarFactory {

    public static Car produceCar(String carType){

        if (carType.equalsIgnoreCase("T"))
            return new Toyota();
        else if(carType.equalsIgnoreCase("A"))
            return new Audi();
        else if(carType.equalsIgnoreCase("L"))
            return new Landrover();
        else if(carType.equalsIgnoreCase("N"))
            return new Nissan();
        else
            return new Car();

    }
}
