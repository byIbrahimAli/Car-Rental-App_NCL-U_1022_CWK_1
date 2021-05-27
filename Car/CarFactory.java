package Car;

/**
 * Car Project - Car Factory
 * Created by Ibrahim Ali on 24/04/2016.
 * Student ID:
 * Newcastle University | Stage 1
 */

import Number.*;
import java.util.LinkedHashMap;
import java.util.Map;

public final class CarFactory {
    private static boolean alreadyExecuted; //Check to ensure getCar() executed once
    public static final Map<RegistrationNumber, Car> CARMAP = new LinkedHashMap<RegistrationNumber, Car>();

    public void getCar() throws IllegalArgumentException{
        if (alreadyExecuted){
            throw new IllegalArgumentException("Do not use getCar() more than once"); //Stops user running getCar() more than once
        }

        if (!alreadyExecuted) {

            //Creating SmallCars
            for (int i = 0; i < 20; i++) {
                Car x = new SmallCar();
                CARMAP.put(x.getRegistrationNumber(), x);
            }

            //Creating LargeCars
            for (int i = 0; i < 10; i++) {
                Car x = new LargeCar();
                CARMAP.put(x.getRegistrationNumber(), x);
            }
            alreadyExecuted = true;
        }
    }
}
