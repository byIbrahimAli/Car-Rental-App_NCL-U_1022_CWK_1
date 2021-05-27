package JUnitTesting;

import org.junit.Test;
import Car.*;
import DrivingLicence.*;
import java.util.GregorianCalendar;
import Number.*;
import Name.*;
import Rental.*;
import static org.junit.Assert.*;

/**
 * Car Project - Rental Test
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

public class RentalTest {

    @Test
    public void testAvailableCarsOne() throws Exception {
        //Creates cars
        CarFactory carFac = new CarFactory();
        carFac.getCar();
        //Create name
        Name name = new Name("Ibrahim", "Ali");
        //Creates driving licence
        DrivingLicence driLic = DrivingLicence.getInstance(true, new GregorianCalendar(1990, 7, 20), LicenceNumber.getInstance(new GregorianCalendar(1995, 4, 6), name), name);
        //Creates rental object with carFac as param
        Rental rental = new Rental(carFac);

        assertEquals(rental.availableCars(CarType.SMALL), 20);
    }

    @Test
    public void testAvailableCarsTwo() throws Exception {
        //Creates cars
        CarFactory carFac = new CarFactory();
        carFac.getCar();
        //Create name
        Name name = new Name("Ibrahim", "Ali");
        //Creates driving licence
        DrivingLicence driLic = DrivingLicence.getInstance(true, new GregorianCalendar(1990, 7, 20), LicenceNumber.getInstance(new GregorianCalendar(1995, 4, 6), name), name);
        //Creates rental object with carFac as param
        Rental rental = new Rental(carFac);

        assertEquals(rental.availableCars(CarType.LARGE), 10);
    }

    @Test
    public void testIssueCarOne() throws Exception {
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

        assertEquals(rental.availableCars(CarType.SMALL), 19); //Amount of available small cars decreased by one
    }

    @Test
    public void testIssueCarTwo() throws Exception {
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

        assertEquals(rental.availableCars(CarType.LARGE), 9); //Amount of available large cars decreased by one
    }

    @Test
    public void testTerminateRental() throws Exception {
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

        assertEquals(rental.terminateRental(driLic), 0); //0 amount of fuel to be added to get full tank

    }
}
