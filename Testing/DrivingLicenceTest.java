package Testing;

import DrivingLicence.*;
import Number.*;
import Name.Name;

import java.util.GregorianCalendar;

/**
 * Car Project - Driving Licence Test
 * Created by Ibrahim Ali on 24/04/2016.
 * Student ID: 
 * Newcastle University | Stage 1
 */

/*
Lines with code have been deliberately commented out to allow method to run properly.
They've been used to test the exception is thrown
 */

public class DrivingLicenceTest {
    public static void main (String[] args){
        //Creating Name object
        Name me = new Name("Ibrahim", "Ali");
        //Creating Licence Number object
        LicenceNumber licNo = LicenceNumber.getInstance(new GregorianCalendar(2010, 4, 12), me);
        //Creating Driving Licence object
        DrivingLicence drivLic = DrivingLicence.getInstance(true, new GregorianCalendar(1990, 6, 27), licNo, me);


        System.out.println("DRIVERS LICENCE AGE: " + drivLic.getLicenceAge()); //Test licence age method
        System.out.println("DRIVERS LICENCE TYPE: " + drivLic.getLicenceType()); //Test licence type method
        System.out.println("DRIVERS AGE: " + drivLic.getAge()); //Test drivers age method
        System.out.println("DRIVERS LICENCE DATE OF ISSUE: " + drivLic.getDateOfIssue()); //Test date of issue method
        System.out.println("DRIVERS LICENCE DATE OF BIRTH: " + drivLic.getDOB()); //Test dob method
        System.out.println("DRIVERS FORNAME: " + drivLic.getForename()); //Test forename method
        System.out.println("DRIVERS SURNAME: " + drivLic.getSurname()); //Test surname method
        System.out.println("DRIVERS DRIVER LICENCE NUMBER: " + drivLic.getLicenceNumber()); //Test licence number method
        System.out.println("DRIVERS LICENCE: \n\n" + drivLic.toString()); //Test toString implementation

        // ~~~~~ Attempt to create DrivingLicence with same licence number ~~~~~~
//        Name attempt = new Name("Graham", "Harley");
        //Below will throw an exception to identify a Driving Licence with an existing licence number has attempted to be created
//        DrivingLicence attemptDrivLic = DrivingLicence.getInstance(true, new GregorianCalendar(1998, 06, 27), licNo, attempt);
    }
}
