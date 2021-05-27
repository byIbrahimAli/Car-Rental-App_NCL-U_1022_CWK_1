package Car;

/**
 * Car Project - Car Interface
 * Created by Ibrahim Ali on 24/04/2016.
 * Student ID: 
 * Newcastle University | Stage 1
 */

import Number.*;

public interface Car {
    public int fuelTankAddFuel(int fuelToAdd);

    public boolean fuelTankFull();

    public int fuelTankCapacity();

    public int fuelTankCurrently();

    public int drive(int journeyDistance);

    public RegistrationNumber getRegistrationNumber();

    public boolean currentCarOnRent();

    public CarType getSize();

    public boolean setCarRented();

    public int amountTillFullTank();

    public boolean setCarNotRented();
}
