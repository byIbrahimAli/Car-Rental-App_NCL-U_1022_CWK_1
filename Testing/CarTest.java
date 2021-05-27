package Testing;

import Car.*;
import DrivingLicence.*;
import Number.*;
import Name.*;
import Rental.*;

import java.util.GregorianCalendar;

/**
 * Car Project - Car Test
 * Created by Ibrahim Ali on 24/04/2016.
 * Student ID: 
 * Newcastle University | Stage 1
 */

public class CarTest {
    public static void main(String[] args) {
        //Creates cars
        CarFactory carFac = new CarFactory();
        carFac.getCar();
        //Create name
        Name name = new Name("Ibrahim", "Ali");
        Name name1 = new Name("Alpha", "Beta");
        //Creates driving licence
        DrivingLicence driLic = DrivingLicence.getInstance(true, new GregorianCalendar(1990, 7, 20), LicenceNumber.getInstance(new GregorianCalendar(1995, 4, 6), name), name);
        DrivingLicence driLic1 = DrivingLicence.getInstance(true, new GregorianCalendar(1987, 2, 12), LicenceNumber.getInstance(new GregorianCalendar(1992, 9, 1), name1), name1);
        //Creates rental object with carFac as param
        Rental rental = new Rental(carFac);
        //Issue car to driLic
        rental.issueCar(driLic, CarType.LARGE);
        rental.issueCar(driLic1, CarType.SMALL);

        System.out.format("%s\n%s\n", "LARGE CAR TEST:", "=====================================");
        System.out.println("FUEL CAPACITY: " + carFac.CARMAP.get(rental.getRentedCars().get(driLic)).fuelTankCapacity()); //Testing fuel tank capacity method
        System.out.println("IS THE FUEL TANK FULL? " + carFac.CARMAP.get(rental.getRentedCars().get(driLic)).fuelTankFull()); //Testing method that returns whether fuel tank is full
        System.out.println("FUEL CONSUMED DURING JOURNEY (IN WHOLE LITRES): " + carFac.CARMAP.get(rental.getRentedCars().get(driLic)).drive(198)); //Testing drive method
        System.out.println("FUEL ADDED (IN WHOLE LITRES): " + carFac.CARMAP.get(rental.getRentedCars().get(driLic)).fuelTankAddFuel(6)); //Testing add fuel method
        System.out.println("FUEL CURRENTLY IN TANK (IN WHOLE LITRES): " + carFac.CARMAP.get(rental.getRentedCars().get(driLic)).fuelTankCurrently()); //Testing fuel currently method
        System.out.println("FUEL REQUIRED UNTIL FULL TANK (IN WHOLE LITRES): " + carFac.CARMAP.get(rental.getRentedCars().get(driLic)).amountTillFullTank()); //Testing amount till full method
        System.out.println("REGISTRATION NUMBER: " + carFac.CARMAP.get(rental.getRentedCars().get(driLic)).getRegistrationNumber()); //Testing get registration number method
        System.out.println("CAR SIZE: " + carFac.CARMAP.get(rental.getRentedCars().get(driLic)).getSize()); //Testing get size method
        System.out.println("IS CURRENT CAR ON RENT? " + carFac.CARMAP.get(rental.getRentedCars().get(driLic)).currentCarOnRent()); //Testing current car on rent method
        System.out.println("SET CAR NOT RENT, IS CAR ON RENT? " + carFac.CARMAP.get(rental.getRentedCars().get(driLic)).setCarNotRented()); //Testing method that removes car from being rented

        System.out.format("\n\n%s\n%s\n", "SMALL CAR TEST:", "=====================================");
        System.out.println("FUEL CAPACITY: " + carFac.CARMAP.get(rental.getRentedCars().get(driLic1)).fuelTankCapacity()); //Testing fuel tank capacity method
        System.out.println("IS THE FUEL TANK FULL? " + carFac.CARMAP.get(rental.getRentedCars().get(driLic1)).fuelTankFull()); //Testing method that returns whether fuel tank is full
        System.out.println("FUEL CONSUMED DURING JOURNEY (IN WHOLE LITRES): " + carFac.CARMAP.get(rental.getRentedCars().get(driLic1)).drive(198)); //Testing drive method
        System.out.println("FUEL ADDED (IN WHOLE LITRES): " + carFac.CARMAP.get(rental.getRentedCars().get(driLic1)).fuelTankAddFuel(6)); //Testing add fuel method
        System.out.println("FUEL CURRENTLY IN TANK (IN WHOLE LITRES): " + carFac.CARMAP.get(rental.getRentedCars().get(driLic1)).fuelTankCurrently()); //Testing fuel currently method
        System.out.println("FUEL REQUIRED UNTIL FULL TANK (IN WHOLE LITRES): " + carFac.CARMAP.get(rental.getRentedCars().get(driLic1)).amountTillFullTank()); //Testing amount till full method
        System.out.println("REGISTRATION NUMBER: " + carFac.CARMAP.get(rental.getRentedCars().get(driLic1)).getRegistrationNumber()); //Testing get registration number method
        System.out.println("CAR SIZE: " + carFac.CARMAP.get(rental.getRentedCars().get(driLic1)).getSize()); //Testing get size method
        System.out.println("IS CURRENT CAR ON RENT? " + carFac.CARMAP.get(rental.getRentedCars().get(driLic1)).currentCarOnRent()); //Testing current car on rent method
        System.out.println("SET CAR NOT RENT, IS CAR ON RENT? " + carFac.CARMAP.get(rental.getRentedCars().get(driLic1)).setCarNotRented()); //Testing method that removes car from being rented
    }
}
