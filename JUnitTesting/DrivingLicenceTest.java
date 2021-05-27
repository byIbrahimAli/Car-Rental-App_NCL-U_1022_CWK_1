package JUnitTesting;

import org.junit.Test;
import Number.*;
import Name.*;
import DrivingLicence.*;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import static org.junit.Assert.*;

/**
 * Car Project - Driving Licence Test
 * Created by Ibrahim Ali on 24/04/2016.
 * Student ID: 
 * Newcastle University | Stage 1
 */

public class DrivingLicenceTest {
    //~~~~~~~~ Global ~~~~~~~~
    Name name = new Name("Alpha", "Bravo");
    DrivingLicence driLic = DrivingLicence.getInstance(true, new GregorianCalendar(1990, 9, 20), LicenceNumber.getInstance(new GregorianCalendar(2000, 8, 7), name), name);

    @Test
    public void testGetDOB() throws Exception {
        Calendar calDate = new GregorianCalendar(1990, 9, 20);
        Date date = calDate.getTime();
        assertEquals(driLic.getDOB(), date);
    }

    @Test
    public void testGetLicenceType() throws Exception {
        assertEquals(driLic.getLicenceType(), "Full Licence");
    }

    @Test
    public void testGetForname() throws Exception {
        assertEquals(driLic.getForename(), "Alpha");
    }

    @Test
    public void testGetSurname() throws Exception {
        assertEquals(driLic.getSurname(), "Bravo");
    }

    @Test
    public void testGetLicenceNumber() throws Exception {
        String[] tokens = driLic.getLicenceNumber().split("-");
        String methodOutput = tokens[0] + "-" + tokens[1];
        String actualOutput = "AB-2000";
        assertEquals(methodOutput, actualOutput); //Unable test the random number part
    }

    @Test
    public void testGetDateOfIssue() throws Exception {
        Calendar calDate = new GregorianCalendar(2000, 8, 7);
        Date date = calDate.getTime();
        assertEquals(driLic.getDateOfIssue(), date);
    }

    @Test
    public void testGetAge() throws Exception {
        assertEquals(driLic.getAge(), 25);
    }

    @Test
    public void testGetLicenceAge() throws Exception {
        assertEquals(driLic.getLicenceAge(), 15);
    }
}
