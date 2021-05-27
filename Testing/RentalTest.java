package Testing;

import Car.*;
import DrivingLicence.*;
import Name.*;
import Number.*;
import Rental.*;

import java.util.GregorianCalendar;

/**
 * Car Project - Rental Test
 * Created by Ibrahim Ali on 24/04/2016.
 * Student ID: 
 * Newcastle University | Stage 1
 */

public class RentalTest {
    public static void main (String[] args){
        //Creates cars
        CarFactory carFac = new CarFactory();
        carFac.getCar();
        //Creates Name
        Name me = new Name("Ibrahim", "Ali");
        //Creates Licence Number
        LicenceNumber licNo = LicenceNumber.getInstance(new GregorianCalendar(2010, 9, 26), me);
        //Creates Driving Licence
        DrivingLicence driLic = DrivingLicence.getInstance(true, new GregorianCalendar(1994, 7, 27), licNo, me);
        //Creates Rental object
        Rental rental = new Rental(carFac);

        System.out.println("AVAILABLE CARS TO RENT: "+ rental.availableCars(CarType.SMALL));
        System.out.println("HAS THE CAR BEEN ISSUED? " + rental.issueCar(driLic, CarType.SMALL));
        System.out.println("CAR ASSOCIATED TO 'DRILIC': " + rental.getCar(driLic));
        System.out.println("FUEL TANK CAPACITY: " + carFac.CARMAP.get(rental.getRentedCars().get(driLic)).fuelTankCapacity());
        System.out.println("REGISTRATION NUMBER: " + carFac.CARMAP.get(rental.getRentedCars().get(driLic)).getRegistrationNumber());
        System.out.println("\nCOLLECTION OF CURRENT RENTED CARS:\n" + rental.getRentedCars());
        System.out.println("\nNUMBER OF AVAILABLE SMALL CARS: " + rental.availableCars(CarType.SMALL));
        System.out.println("TERMINATE RENTAL CONTRACT FOR 'DRILIC': " + rental.terminateRental(driLic));
        System.out.println("NUMBER OF AVAILABLE SMALL CARS: " + rental.availableCars(CarType.SMALL));
        System.out.println("NUMBER OF AVAILABLE LARGE CARS: " + rental.availableCars(CarType.LARGE));

        //~~~~~~~~~~~~ Attempt to associate the same Drivers Licence to multiple cars  ~~~~~~~~~~~~
        System.out.println("ATTEMPT #2 ISSUING CAR: " + rental.issueCar(driLic, CarType.LARGE)); //Isn't issued due to age restriction
        System.out.println("ATTEMPT #3 ISSUING CAR: " + rental.issueCar(driLic, CarType.SMALL));
        System.out.println("ATTEMPT #4 ISSUING CAR: " + rental.issueCar(driLic, CarType.SMALL));
    }
}
