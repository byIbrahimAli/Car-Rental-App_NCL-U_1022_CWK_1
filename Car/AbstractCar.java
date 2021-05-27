package Car;

/**
 * Car Project - Abstract Car
 * Created by Ibrahim Ali on 24/04/2016.
 * Student ID: 
 * Newcastle University | Stage 1
 */

import Number.*;

public abstract class AbstractCar implements Car{
    public boolean carRented;
    private CarType size;
    private final RegistrationNumber registrationNumber;

    public abstract int fuelTankAddFuel(int fuelToAdd);

    public abstract boolean fuelTankFull();

    public abstract int fuelTankCapacity();

    public abstract int fuelTankCurrently(); //Finds out the current amount of fuel

    public abstract int drive(int journeyDistance);

    public RegistrationNumber getRegistrationNumber(){ return registrationNumber; }

    public boolean currentCarOnRent(){ return carRented; }

    protected AbstractCar (CarType size){
        this.size = size;
        registrationNumber = RegistrationNumber.getInstance(); //Creates unique Registration Number
        }

    public CarType getSize(){ return size; }

    public boolean setCarRented(){
        return carRented = true;
    }

    public boolean setCarNotRented(){
        return carRented = false;
    }

    public abstract int amountTillFullTank();
}
