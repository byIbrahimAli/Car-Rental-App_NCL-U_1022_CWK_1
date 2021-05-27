package Number;

/**
 * Car Project - Registration Number
 * Created by Ibrahim Ali on 24/04/2016.
 * Student ID: 
 * Newcastle University | Stage 1
 */

import java.util.HashMap;
import java.util.Random;
import java.util.Map;

public final class RegistrationNumber{

    private static final int INTSTART = 1000; //Minimum 4 digit value

    private static final int INTEND = 9999; //Maximum 4 digit value

    private static final long INTRANGE = (long) INTEND - (long) INTSTART + 1; //Calculates range of acceptable values

    private static final String LOWALPHABET = "abcdefghijklmnopqrstuvwxyz"; //Lower-case alphabet

    private static final int LENLOWALPHABET = LOWALPHABET.length(); //Calculates the length of the lower-case alphabet

    private final String regNo;

    private final char regNoLetter;

    private final int regNoInt;

    private static final Map<String, RegistrationNumber> REGNOS = new HashMap<String, RegistrationNumber>();
    // ============= CONSTRUCTOR =============

    private RegistrationNumber() {
        regNoLetter = rndomLetter();
        regNoInt = rndomInt();
        regNo = regNoLetter + Integer.toString(regNoInt);
    }

    // ============= RANDOM GENERATOR METHODS =============
    private char rndomLetter() { // Generating randomised single-digit letter
        Random rGen = new Random();
        return LOWALPHABET.charAt(rGen.nextInt(LENLOWALPHABET));
    }

    private int rndomInt() { // Generating randomised 4-digit number
        Random rGen = new Random();
        long intFraction = (long) (INTRANGE * rGen.nextDouble());
        int rndomInt = (int) (intFraction + INTSTART);
        return rndomInt;
    }

    // ============= UNIQUE METHOD =============
    public static RegistrationNumber getInstance() {
        final RegistrationNumber x = new RegistrationNumber(); //RegistrationNumber registration number
        final String y = x.getRegNo(); //String registration number
        if (!REGNOS.containsKey(y))
            REGNOS.put(y, x);

        return REGNOS.get(y);
    }

    // ============= TOSTRING METHOD =============
    @Override
    public String toString() {
        return regNoLetter + Integer.toString(regNoInt);
    }

    // ============= GET METHODS =============
    public String getRegNo() { return regNo; }

    public char getRegNoLetter() {
        return regNoLetter;
    }

    public int getRegNoInt() {
        return regNoInt;
    }
}
