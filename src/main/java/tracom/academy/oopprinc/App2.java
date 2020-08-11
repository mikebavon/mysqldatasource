package tracom.academy.oopprinc;

import java.util.Scanner;

public class App2 {

    public static void main(String args []){
        Scanner input = new Scanner(System.in);

        String carType = input.nextLine();

        Car car = CarFactory.produceCar(carType);

        car.printDetails();



    }
}
