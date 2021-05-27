package Testing;

/**
 * Car Project - Whole System Test
 * Created by Ibrahim Ali on 24/04/2016.
 * Student ID: 
 * Newcastle University | Stage 1
 */

import Car.*;
import DrivingLicence.*;
import Name.*;
import Number.*;
import Rental.*;

import java.util.GregorianCalendar;

public class WholeSystemTesting {
    public static void main(String[] args) {
        //Creating Cars
        CarFactory x = new CarFactory();
        x.getCar();
        //Creating Names
        Name name1 = new Name("Ibrahim", "Ali");
        Name name2 = new Name("Harry", "Byton");
        Name name3 = new Name("Niel", "Ponce");
        //Creating Licence Numbers
        LicenceNumber licNo1 = LicenceNumber.getInstance(new GregorianCalendar(2010, 4, 12), name1);
        LicenceNumber licNo2 = LicenceNumber.getInstance(new GregorianCalendar(2014, 6, 28), name2);
        LicenceNumber licNo3 = LicenceNumber.getInstance(new GregorianCalendar(1990, 8, 17), name3);
        //Creating Driving Licence object
        DrivingLicence driLic1 = DrivingLicence.getInstance(true, new GregorianCalendar(1991, 4, 4), licNo1, name1); //Just 25
        DrivingLicence driLic2 = DrivingLicence.getInstance(true, new GregorianCalendar(1993, 9, 27), licNo2, name2); //Under 25
        DrivingLicence driLic3 = DrivingLicence.getInstance(true, new GregorianCalendar(1975, 5, 16), licNo3, name3); //Over 25
        //Creating Rental object
        Rental rental = new Rental(x);

        //Printing Driving Licences
        System.out.println("DRIVING LICENCE #1:\n" + driLic1.toString());
        System.out.println("DRIVING LICENCE #2:\n" + driLic2.toString());
        System.out.println("DRIVING LICENCE #3:\n" + driLic3.toString() + "\n");

        //Printing Drivers full names
        System.out.println("'NAME 1's' FULL NAME: " + name1.getFullName());
        System.out.println("'NAME 2's' FULL NAME: " + name2.getFullName());
        System.out.println("'NAME 3's' FULL NAME: " + name3.getFullName() + "\n");

        //Number of available cars
        System.out.println("NUMBER OF AVAILABLE SMALL CARS: " + rental.availableCars(CarType.SMALL));
        System.out.println("NUMBER OF AVAILABLE LARGE CARS: " + rental.availableCars(CarType.LARGE) + "\n");

        //Issuing Cars to Driving Licences
        System.out.println("ISSUING LARGE CAR TO 'DRILIC1': " + rental.issueCar(driLic1, CarType.LARGE));
        System.out.println("ISSUING SMALL CAR TO 'DRILIC2': " + rental.issueCar(driLic2, CarType.SMALL));
        System.out.println("ISSUING LARGE CAR TO 'DRILIC3': " + rental.issueCar(driLic3, CarType.LARGE) + "\n");

        //Checking if Drivers car are on rent
        System.out.println("IS 'DRILIC1's' CAR ON RENT? " + rental.getCar(driLic1).currentCarOnRent());
        System.out.println("IS 'DRILIC2's' CAR ON RENT? " + rental.getCar(driLic2).currentCarOnRent());
        System.out.println("IS 'DRILIC3's' CAR ON RENT? " + rental.getCar(driLic3).currentCarOnRent() + "\n");

        //Number of available cars
        System.out.println("NUMBER OF AVAILABLE SMALL CARS: " + rental.availableCars(CarType.SMALL));
        System.out.println("NUMBER OF AVAILABLE LARGE CARS: " + rental.availableCars(CarType.LARGE) + "\n");

        //Print out each rented cars Registration Number
        System.out.println("'DRILIC1's' RENTED CARS REGISTRATION NUMBER: " + rental.getCar(driLic1).getRegistrationNumber());
        System.out.println("'DRILIC2's' RENTED CARS REGISTRATION NUMBER: " + rental.getCar(driLic2).getRegistrationNumber());
        System.out.println("'DRILIC3's' RENTED CARS REGISTRATION NUMBER: " + rental.getCar(driLic3).getRegistrationNumber() + "\n");

        //Print out current fuel in each cars tank
        System.out.println("CURRENT FUEL IN 'DRILIC1's' CAR: " + rental.getCar(driLic1).fuelTankCurrently());
        System.out.println("CURRENT FUEL IN 'DRILIC2's' CAR: " + rental.getCar(driLic2).fuelTankCurrently());
        System.out.println("CURRENT FUEL IN 'DRILIC3's' CAR: " + rental.getCar(driLic3).fuelTankCurrently() + "\n");

        //Drive each car
        System.out.println("FUEL CONSUMED DURING 'DRILIC1'S' DRIVE" + rental.getCar(driLic1).drive(378));
        System.out.println("FUEL CONSUMED DURING 'DRILIC2'S' DRIVE" + rental.getCar(driLic2).drive(456));
        System.out.println("FUEL CONSUMED DURING 'DRILIC3'S' DRIVE" + rental.getCar(driLic3).drive(983) + "\n");

        //Print out current fuel in each cars tank
        System.out.println("CURRENT FUEL IN 'DRILIC1's' CAR: " + rental.getCar(driLic1).fuelTankCurrently());
        System.out.println("CURRENT FUEL IN 'DRILIC2's' CAR: " + rental.getCar(driLic2).fuelTankCurrently());
        System.out.println("CURRENT FUEL IN 'DRILIC3's' CAR: " + rental.getCar(driLic3).fuelTankCurrently() + "\n");

        //Add fuel to each car
        System.out.println("FUEL ADDED TO 'DRILIC1'S' CAR: " + rental.getCar(driLic1).fuelTankAddFuel(7));
        System.out.println("FUEL ADDED TO 'DRILIC2'S' CAR: " + rental.getCar(driLic2).fuelTankAddFuel(3));
        System.out.println("FUEL ADDED TO 'DRILIC3'S' CAR: " + rental.getCar(driLic3).fuelTankAddFuel(12) + "\n");

        //Print out current fuel in each cars tank
        System.out.println("CURRENT FUEL IN 'DRILIC1's' CAR: " + rental.getCar(driLic1).fuelTankCurrently());
        System.out.println("CURRENT FUEL IN 'DRILIC2's' CAR: " + rental.getCar(driLic2).fuelTankCurrently());
        System.out.println("CURRENT FUEL IN 'DRILIC3's' CAR: " + rental.getCar(driLic3).fuelTankCurrently() + "\n");

        //Get collection of rented cars
        System.out.println("CURRENT RENTED CARS:\n" + rental.getRentedCars() + "\n");

        //Terminating rental for all vehicles
        System.out.println("TERMINATING 'DRILIC1's' CAR, FUEL TO BE ADDED UNTIL FULL TANK: " + rental.terminateRental(driLic1));
        System.out.println("TERMINATING 'DRILIC2's' CAR, FUEL TO BE ADDED UNTIL FULL TANK: " + rental.terminateRental(driLic2));
        System.out.println("TERMINATING 'DRILIC3's' CAR, FUEL TO BE ADDED UNTIL FULL TANK: " + rental.terminateRental(driLic3));

        //Get collection of rented cars
        System.out.println("CURRENT RENTED CARS:\n" + rental.getRentedCars() + "\n");
    }
}
