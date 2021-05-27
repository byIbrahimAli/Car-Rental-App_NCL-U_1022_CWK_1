package Rental;

/**
 * Car Project - Rental
 * Created by Ibrahim Ali on 24/04/2016.
 * Student ID: 
 * Newcastle University | Stage 1
 */

import Car.*;
import DrivingLicence.*;
import Number.*;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class Rental {
    private static final Map<RegistrationNumber, Car> CARMAP = new LinkedHashMap<RegistrationNumber, Car>();
    private static final Map<DrivingLicence, RegistrationNumber> RENTALCONTRACTMAP = new LinkedHashMap<DrivingLicence, RegistrationNumber>(); //Prevents driver from renting >1 cars

    public Rental(CarFactory carFactory){ // Copying "CARMAP" from CarFactory to "CARMAP" in Rental
        CARMAP.putAll(CarFactory.CARMAP);
    }

    public int availableCars(CarType size) { // Returns number of cars !rented of a particular type
        final int noOfCars;
        int falseCounter = 0;

        Set<RegistrationNumber> keys = CARMAP.keySet();
        final RegistrationNumber[] keysArray = keys.toArray(new RegistrationNumber[keys.size()]); //Convert set to array - Stores all Registration Numbers
        int index = 0;
        for (RegistrationNumber regNo : keys) keysArray[index++] = regNo; //Iterate over each element of CARMAP and copy its value in keysArray

        for (int i = 0; i < keysArray.length; i++) {
            if (CARMAP.get(keysArray[i]).getSize() == size) { //Access cars of this particular size
                if(CARMAP.get(keysArray[i]).currentCarOnRent() == false){
                    falseCounter++;
                }
            }
        }
        return falseCounter;
    }

    public String issueCar(DrivingLicence drivingLicence, CarType size){
        // ~~~~~~~~ Variables ~~~~~~~~
        final String error = "The car cannot be issued.";
        boolean age21 = false; //Default value
        boolean age25 = false; //Default value
        boolean licenceAge1 = false; //Default value
        boolean licenceAge5 = false; //Default value

        // ~~~~~~~~ Rules ~~~~~~~~
        if (availableCars(size) <= 0) { //Checks if cars of that size are available
            return error;
        }

        if (drivingLicence.getLicenceType() == "Not Full Licence") return error; //Checks Driving Licence is full

        if (drivingLicence.getAge() >= 25) { //Checks age
            age25 = true;
            age21 = true;
        } else if (drivingLicence.getAge() >= 21) {
            age21 = true;
        } else {
            return error;
        }

        if (drivingLicence.getLicenceAge() >= 5) { //Checks Licence age
            licenceAge5 = true;
            licenceAge1 = true;
        } else if (drivingLicence.getLicenceAge() >= 1) {
            licenceAge1 = true;
        } else {
            return error;
        }

        // ~~~~~~~~ Main functionality ~~~~~~~~
        if ((size == CarType.LARGE && age25 && licenceAge5) || (size == CarType.SMALL && age21 && licenceAge1)) {
            for (RegistrationNumber regNo : CARMAP.keySet()) {
                if (!CARMAP.get(regNo).currentCarOnRent() && CARMAP.get(regNo).getSize() == size && !RENTALCONTRACTMAP.containsKey(drivingLicence)) { //Checks car is available and car is of specified size
                    CARMAP.get(regNo).setCarRented();
                    RENTALCONTRACTMAP.put(drivingLicence, regNo);
                    return "Car has been issued";
                }
            }
        }
        return error;
    }

    public int terminateRental(DrivingLicence drivingLicence){
        RegistrationNumber regNo = RENTALCONTRACTMAP.get(drivingLicence);
        int amountTillFull = CARMAP.get(regNo).amountTillFullTank();
        CARMAP.get(regNo).setCarNotRented();
        RENTALCONTRACTMAP.remove(drivingLicence, RENTALCONTRACTMAP.get(drivingLicence));
        return amountTillFull;
    }

    public Map<DrivingLicence, RegistrationNumber> getRentedCars() {
        return RENTALCONTRACTMAP;
    }

    public Car getCar(DrivingLicence drivingLicence){
        return CARMAP.get(RENTALCONTRACTMAP.get(drivingLicence));
    }

}
