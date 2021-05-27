package DrivingLicence;

import java.util.Date;

/**
 * Car Project - Abstract Driving Licence
 * Created by Ibrahim Ali on 24/04/2016.
 * Student ID: 
 * Newcastle University | Stage 1
 */

public abstract class AbstractDrivingLicence {

    public abstract Date getDOB();

    public abstract String getLicenceType();

    public abstract String getForename();

    public abstract String getSurname();

    public abstract String getLicenceNumber();

    public abstract Date getDateOfIssue(); //Date of issue of licence number

    public abstract long getAge();

    public abstract long getLicenceAge();

    public abstract String toString();
}
