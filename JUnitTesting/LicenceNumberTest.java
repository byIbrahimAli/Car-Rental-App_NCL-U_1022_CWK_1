package JUnitTesting;

import org.junit.Test;
import Number.*;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import Name.*;
import static org.junit.Assert.*;

/**
 * Car Project - Licence Number Test
 * Created by Ibrahim Ali on 24/04/2016.
 * Student ID: 
 * Newcastle University | Stage 1
 */

public class LicenceNumberTest {
    //~~~~~~~~ Global ~~~~~~~~
    Name name = new Name("Ibrahim", "Ali");
    LicenceNumber licNo = LicenceNumber.getInstance(new GregorianCalendar(2000, 8, 7), name);

    @Test
    public void testGetDate() throws Exception {
        Calendar calDate = new GregorianCalendar(2000, 8, 7);
        Date date = calDate.getTime();
        assertEquals(licNo.getDate(), date);
    }

    @Test
    public void testGetLicenceNumber() throws Exception {
        String[] tokens = licNo.getLicenceNumber().split("-");
        String methodOutput = tokens[0] + "-" + tokens[1];
        String actualOutput = "IA-2000";
        assertEquals(methodOutput, actualOutput);
    }

    @Test
    public void testGetLicNoInt() throws Exception {
        String[] tokens = licNo.getLicenceNumber().split("-");
        String actualOutput = tokens[2];
        assertEquals(licNo.getLicNoInt(), actualOutput);
    }

    @Test
    public void testToString() throws Exception {
        assertEquals(licNo.toString(), licNo.getLicenceNumber());
    }
}
