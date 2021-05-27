package Number;

/**
 * Car Project - Licence Number
 * Created by Ibrahim Ali on 24/04/2016.
 * Student ID: 
 * Newcastle University | Stage 1
 */

import Name.*;
import java.text.SimpleDateFormat;
import java.util.*;

public final class LicenceNumber{

    private final Calendar dateOfIssueCal;

    private final Date dateOfIssue;

    private final String yearOfIssue;

    private final String licenceNumber;

    private final Name person;

    private final String forename;

    private final String surname;

    private final String initials;

    private static final int INTSTART = 10;

    private static final int INTEND = 99;

    private static final long INTRANGE = (long)INTEND - (long)INTSTART + 1;

    private static final SimpleDateFormat YEARFORMAT = new SimpleDateFormat("yyyy");

    private static final Map<String, LicenceNumber> LICNOS = new HashMap<String, LicenceNumber>();

    private final int licNoInt;


    //============= CONSTRUCTOR =============
    private LicenceNumber (GregorianCalendar dateOfIssue, Name person){
        this.dateOfIssueCal = dateOfIssue;
        this.dateOfIssue = dateOfIssueCal.getTime();

        yearOfIssue = YEARFORMAT.format(dateOfIssue.getTime());

        this.person = person;
        forename = person.getForename();
        surname = person.getSurname();

        initials = initials();

        licNoInt = rndomInt();

        licenceNumber = initials + "-" + yearOfIssue + "-" + licNoInt;
    }

    // ============= UNIQUE METHOD =============
    public static LicenceNumber getInstance(GregorianCalendar dateOfIssue, Name person) {
        final LicenceNumber x = new LicenceNumber(dateOfIssue, person); //LicenceNumber licence number
        final String y = x.getLicenceNumber(); //String licence number
        if (!LICNOS.containsKey(y))
            LICNOS.put(y, x);

        return LICNOS.get(y);
    }

    //============= GET METHODs =============
    public Date getDate(){
        return dateOfIssue;
    }

    private String getYear(){ return yearOfIssue; }

    public String getLicenceNumber(){ return licenceNumber; }

    public String getLicNoInt(){
        return Integer.toString(licNoInt);
    }

    //============= FORNAME AND SURNAME INITIALS =============
    private String initials(){
        char iF = forename.charAt(0); //forename initial
        char iS = surname.charAt(0); //surname initial
        return Character.toString(iF) + Character.toString(iS);
    }

    //============= ARBITRARY SERIAL NUMBER =============
    private int rndomInt(){
        Random rGen = new Random();
        long intFraction = (long)(INTRANGE * rGen.nextDouble());
        int rndomInt = (int)(intFraction + INTSTART);
        return rndomInt;
    }

    //============= OVERRIDING TOSTRING =============
    @Override
    public String toString(){
        //return initials() + "-" + getYear() + "-" + getLicNoInt();
        return initials + "-" + yearOfIssue + "-" + licNoInt;
    }
}
