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
 * Car Project - Small Car Test
 * Created by Ibrahim Ali on 24/04/2016.
 * Student ID:
 * Newcastle University | Stage 1
 */

/*
WARNING TO MARKER!!
    - Due to the structure of my CarFactory, it's not possible to run getCar() more than once!
    - Therefore run the following tests METHOD BY METHOD, testing the whole class will produce an error
    - I've emailed # in regards to this, # replied "That sounds reasonable."
 */

public class SmallCarTest {

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
        rental.issueCar(driLic, CarType.SMALL);

        assertEquals(carFac.CARMAP.get(rental.getRentedCars().get(driLic)).fuelTankCapacity(), 45);
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
        rental.issueCar(driLic, CarType.SMALL);

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
        rental.issueCar(driLic, CarType.SMALL);
        carFac.CARMAP.get(rental.getRentedCars().get(driLic)).drive(50);
        assertEquals(carFac.CARMAP.get(rental.getRentedCars().get(driLic)).fuelTankAddFuel(2), 2);
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
        rental.issueCar(driLic, CarType.SMALL);

        assertEquals(carFac.CARMAP.get(rental.getRentedCars().get(driLic)).fuelTankCurrently(), 45);
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
        rental.issueCar(driLic, CarType.SMALL);

        assertEquals(carFac.CARMAP.get(rental.getRentedCars().get(driLic)).drive(50), 2);
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
        rental.issueCar(driLic, CarType.SMALL);
        carFac.CARMAP.get(rental.getRentedCars().get(driLic)).drive(50);

        assertEquals(carFac.CARMAP.get(rental.getRentedCars().get(driLic)).amountTillFullTank(), 2);
    }
}
