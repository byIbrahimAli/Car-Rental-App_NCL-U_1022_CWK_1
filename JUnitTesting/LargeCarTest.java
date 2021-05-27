package JUnitTesting;

import Car.*;
import DrivingLicence.*;
import Name.*;
import Number.*;
import Rental.*;
import org.junit.Test;

import java.util.GregorianCalendar;

import static org.junit.Assert.*;

/**
 * Car Project - Large Car Test
 * Created by Ibrahim Ali on 24/04/2016.
 * Student ID: 
 * Newcastle University | Stage 1
 */

/*
WARNING TO MARKER!!
    - Due to the structure of my CarFactory, it's not possible to run getCar() more than once!
    - Therefore run the following tests METHOD BY METHOD, testing the whole class will produce an error
    - I've emailed Niel Speirs in regards to this, he replied "That sounds reasonable."
 */

public class LargeCarTest {

    @Test
    public void testFuelTankCapacity() throws Exception {
        //Creates cars
        CarFactory carFac = new CarFactory();
        carFac.getCar();
        //Create name
        Name name = new Name("Ibrahim", "Ali");
        //Creates driving licence
        DrivingLicence driLic = DrivingLicence.getInstance(true, new GregorianCalendar(1990, 7, 20), LicenceNumber.getInstance(new GregorianCalendar(1995, 4, 6), name), name);
        //Creates rental object with carFac as param
        Rental rental = new Rental(carFac);
        //Issue car to driLic
        rental.issueCar(driLic, CarType.LARGE);

        assertEquals(carFac.CARMAP.get(rental.getRentedCars().get(driLic)).fuelTankCapacity(), 65);
    }

    @Test
    public void testFuelTankFull() throws Exception {
        //Creates cars
        CarFactory carFac = new CarFactory();
        carFac.getCar();
        //Create name
        Name name = new Name("Ibrahim", "Ali");
        //Creates driving licence
        DrivingLicence driLic = DrivingLicence.getInstance(true, new GregorianCalendar(1990, 7, 20), LicenceNumber.getInstance(new GregorianCalendar(1995, 4, 6), name), name);
        //Creates rental object with carFac as param
        Rental rental = new Rental(carFac);
        //Issue car to driLic
        rental.issueCar(driLic, CarType.LARGE);

        assertEquals(carFac.CARMAP.get(rental.getRentedCars().get(driLic)).fuelTankFull(), true);
    }

    @Test
    public void testFuelTankAddFuel() throws Exception {
        //Creates cars
        CarFactory carFac = new CarFactory();
        carFac.getCar();
        //Create name
        Name name = new Name("Ibrahim", "Ali");
        //Creates driving licence
        DrivingLicence driLic = DrivingLicence.getInstance(true, new GregorianCalendar(1990, 7, 20), LicenceNumber.getInstance(new GregorianCalendar(1995, 4, 6), name), name);
        //Creates rental object with carFac as param
        Rental rental = new Rental(carFac);
        //Issue car to driLic
        rental.issueCar(driLic, CarType.LARGE);
        carFac.CARMAP.get(rental.getRentedCars().get(driLic)).drive(50);
        assertEquals(carFac.CARMAP.get(rental.getRentedCars().get(driLic)).fuelTankAddFuel(4), 4);
    }

    @Test
    public void testFuelTankCurrently() throws Exception {
        //Creates cars
        CarFactory carFac = new CarFactory();
        carFac.getCar();
        //Create name
        Name name = new Name("Ibrahim", "Ali");
        //Creates driving licence
        DrivingLicence driLic = DrivingLicence.getInstance(true, new GregorianCalendar(1990, 7, 20), LicenceNumber.getInstance(new GregorianCalendar(1995, 4, 6), name), name);
        //Creates rental object with carFac as param
        Rental rental = new Rental(carFac);
        //Issue car to driLic
        rental.issueCar(driLic, CarType.LARGE);

        assertEquals(carFac.CARMAP.get(rental.getRentedCars().get(driLic)).fuelTankCurrently(), 65);
    }

    @Test
    public void testDrive() throws Exception {
        //Creates cars
        CarFactory carFac = new CarFactory();
        carFac.getCar();
        //Create name
        Name name = new Name("Ibrahim", "Ali");
        //Creates driving licence
        DrivingLicence driLic = DrivingLicence.getInstance(true, new GregorianCalendar(1990, 7, 20), LicenceNumber.getInstance(new GregorianCalendar(1995, 4, 6), name), name);
        //Creates rental object with carFac as param
        Rental rental = new Rental(carFac);
        //Issue car to driLic
        rental.issueCar(driLic, CarType.LARGE);

        assertEquals(carFac.CARMAP.get(rental.getRentedCars().get(driLic)).drive(50), 4);
    }

    @Test
    public void testAmountTillFullTank() throws Exception {
        //Creates cars
        CarFactory carFac = new CarFactory();
        carFac.getCar();
        //Create name
        Name name = new Name("Ibrahim", "Ali");
        //Creates driving licence
        DrivingLicence driLic = DrivingLicence.getInstance(true, new GregorianCalendar(1990, 7, 20), LicenceNumber.getInstance(new GregorianCalendar(1995, 4, 6), name), name);
        //Creates rental object with carFac as param
        Rental rental = new Rental(carFac);
        //Issue car to driLic
        rental.issueCar(driLic, CarType.LARGE);
        //Drive car
        carFac.CARMAP.get(rental.getRentedCars().get(driLic)).drive(50);

        assertEquals(carFac.CARMAP.get(rental.getRentedCars().get(driLic)).amountTillFullTank(), 4);
    }
}
