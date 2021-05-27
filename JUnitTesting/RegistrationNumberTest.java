package JUnitTesting;

import org.junit.Test;
import Number.*;
import static org.junit.Assert.*;

/**
 * Car Project - Registration Number Test
 * Created by Ibrahim Ali on 24/04/2016.
 * Student ID: 
 * Newcastle University | Stage 1
 */

public class RegistrationNumberTest {
    //~~~~~~~~ Global ~~~~~~~~
    RegistrationNumber regNo = RegistrationNumber.getInstance();

    @Test
    public void testToString() throws Exception {
        assertEquals(regNo.toString(), regNo.getRegNo());
    }

    @Test
    public void testGetRegNo() throws Exception {
        assertEquals(regNo.getRegNo(), regNo.toString());
    }
}
