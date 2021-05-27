package DrivingLicence;

import Number.*;
import Name.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.*;

/**
 * Car Project - Driving Licence
 * Created by Ibrahim Ali on 24/04/2016.
 * Student ID: 
 * Newcastle University | Stage 1
 */

public final class DrivingLicence extends AbstractDrivingLicence {
    private final String forename; //Drivers forname
    private final String surname; //Drivers surname
    private final String fullName; //Drivers full name

    private final Date dob; //Stores drivers DOB in Date object
    private final Calendar dobCal; //Stores drivers DOB in Calendar object

    private final String licenceNumber; //Stores licence number
    private final Date dateOfIssue; //Stores date of issue of licence

    private final Boolean licenceFull; //true means Full Licence, false means Not Full Licence

    private static final Map<LicenceNumber, DrivingLicence> DRIVING_LICENCE_MAP = new HashMap<LicenceNumber, DrivingLicence>();
    // ============= CONSTRUCTOR =============
        private DrivingLicence(Boolean licenceFull, GregorianCalendar dob, LicenceNumber licenceNumber, Name name){
            this.licenceFull = licenceFull;
            this.dobCal = dob;
            this.dob = dobCal.getTime(); //Converts Calendar object to Date object

            this.licenceNumber = licenceNumber.getLicenceNumber();
            this.dateOfIssue = licenceNumber.getDate();

            this.forename = name.getForename();
            this.surname = name.getSurname();
            this.fullName = name.getFullName();
        }

    // ============= UNIQUE METHOD =============
    public static DrivingLicence getInstance(Boolean licenceFull, GregorianCalendar dob, LicenceNumber licenceNumber, Name name) {
        final DrivingLicence x = new DrivingLicence(licenceFull, dob, licenceNumber, name); //Driving Licence object
        final LicenceNumber y = licenceNumber; //Licence number object

        if (DRIVING_LICENCE_MAP.containsKey(y)){//Prevents Driving Licences with same licence numbers
            throw new IllegalArgumentException("Do not create a driving licence with an existing licence number");
        }

        if (!DRIVING_LICENCE_MAP.containsKey(y)) {
            DRIVING_LICENCE_MAP.put(y, x);
            return DRIVING_LICENCE_MAP.get(y);
        }
        return null;
    }

    // ============= GET METHODS =============
    public Date getDOB(){ return dob; }

    public String getLicenceType(){
        if (licenceFull){
            return "Full Licence";
        }
        return "Not Full Licence";
    }

    public String getForename(){return forename;}

    public String getSurname(){return surname;}

    public String getLicenceNumber(){return licenceNumber;}

    public Date getDateOfIssue(){return dateOfIssue;} //Date of issue of licence number

    public final long getAge(){
        LocalDate start = dob.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(); //Converts Date to LocalDate
        LocalDate end = LocalDate.now(); //Used for age calculation
        return ChronoUnit.YEARS.between(start, end);
    }

    public final long getLicenceAge(){
        LocalDate start = dateOfIssue.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(); //Converts dateOfIssue to LocalDate
        LocalDate end = LocalDate.now(); //Used for licence-age calculation
        long years = ChronoUnit.YEARS.between(start, end);
        return years;
    }

    // ============= OVERRIDDEN TOSTRING =============
    @Override
    public String toString(){
        StringBuilder result = new StringBuilder();
        final String NEW_LINE = System.getProperty("line.separator");

        result.append("Drivers Name: " + fullName + NEW_LINE);
        result.append("DOB: " + dob + NEW_LINE);
        result.append("Licence No: " + licenceNumber + NEW_LINE);
        result.append("Date of Issue: " + dateOfIssue + NEW_LINE);
        result.append("Licence Type: " + getLicenceType() + NEW_LINE);

        return result.toString();
    }
}
