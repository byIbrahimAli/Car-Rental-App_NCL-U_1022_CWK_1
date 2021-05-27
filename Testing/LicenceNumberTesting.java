package Testing;

import Name.*;
import Number.*;

import java.util.GregorianCalendar;

/**
 * Car Project - Licence Number Test
 * Created by Ibrahim Ali on 24/04/2016.
 * Student ID: 
 * Newcastle University | Stage 1
 */

public class LicenceNumberTesting {
    public static void main (String[] args){
        //Creating Licence Number object
        LicenceNumber instance1 = LicenceNumber.getInstance(new GregorianCalendar(2010, 4, 12), new Name("Ibrahim", "Ali"));

        System.out.println("LICENCE NUMBER USING TOSTRING: " + instance1.toString());
        System.out.println("LICENCE NUMBER USING GET METHOD: " + instance1.getLicenceNumber());
        System.out.println("LICENCE NUMBER'S DATE OF ISSUE: " + instance1.getDate());
        System.out.println("LICENCE NUMBERS RANDOM-GENERATED INT: " + instance1.getLicNoInt());

        // ~~~~~ Creating #2 LicenceNumber object to prove unique random Licence Number ~~~~~~
        LicenceNumber instance2 = LicenceNumber.getInstance(new GregorianCalendar(2009, 1, 16), new Name("Graham", "Harley"));
        System.out.println("\nLICENCE NUMBER #2: " + instance2.toString()); //Testing random aspect

        // ~~~~~ Creating #3 LicenceNumber object to prove unique random Licence Number ~~~~~~
        LicenceNumber instance3 = LicenceNumber.getInstance(new GregorianCalendar(2016, 0, 1), new Name("Don", "MacSween"));
        System.out.println("\nLICENCE NUMBER #3: " + instance3.toString()); //Testing random aspect

    }
}
