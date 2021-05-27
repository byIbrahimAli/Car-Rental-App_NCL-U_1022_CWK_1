package JUnitTesting;

import org.junit.Test;
import Name.*;
import static org.junit.Assert.*;

/**
 * Car Project - Name Test
 * Created by Ibrahim Ali on 24/04/2016.
 * Student ID: 
 * Newcastle University | Stage 1
 */

public class NameTest {
    //~~~~~~~~ Global ~~~~~~~~
    Name name = new Name("Ibrahim", "Ali");

    @Test
    public void testGetForename() throws Exception {
        assertEquals(name.getForename(), "Ibrahim");
    }

    @Test
    public void testGetSurname() throws Exception {
        assertEquals(name.getSurname(), "Ali");
    }

    @Test
    public void testGetFullName() throws Exception {
        assertEquals(name.getFullName(), "Ibrahim Ali");
    }
}
