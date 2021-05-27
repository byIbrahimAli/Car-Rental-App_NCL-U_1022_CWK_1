package Car;

/**
 * Car Project - Small Car
 * Created by Ibrahim Ali on 24/04/2016.
 * Student ID: 
 * Newcastle University | Stage 1
 */

public final class SmallCar extends AbstractCar {
    private static final int FUELTANKCAPACITY = 45;
    private int fuelTank = 45;//Default value
    private static final int FUELCONSUMPTIONRATE = 25; //Kilometres/Litre

    public int fuelTankCapacity() {
        return FUELTANKCAPACITY;
    }

    public boolean fuelTankFull(){
        if(fuelTank == FUELTANKCAPACITY){
            return true;
        }
        return false;
    }

    public int fuelTankAddFuel(int fuelToAdd) {

        int untilFull = FUELTANKCAPACITY - fuelTank;

        if (untilFull == 0) {
            return 0; //Tank is already full
        }

        if (currentCarOnRent() == false) {
            return 0; //Car is currently not on rent
        }

        if (fuelToAdd <= untilFull && fuelToAdd > 0) {
            fuelTank = fuelTank + fuelToAdd;
            return fuelToAdd;
        } else {
            throw new IllegalArgumentException("Please enter a value less than or equal to: " + untilFull);
        }
    }

    public int fuelTankCurrently() {
        return fuelTank;
    }

    public int drive(int journeyDistance){
        final String error1 = "No journey has been undertaken.";
        int fuelConsumed;


        if (!currentCarOnRent()){ //Car isn't being rented
            System.err.println(error1);
            return 0;
        }

        if(fuelTank <= 0){ //Car fuel tank is empty
            System.err.println(error1);
            return 0;
        }

        fuelConsumed = journeyDistance / FUELCONSUMPTIONRATE;
        fuelConsumed = (int)Math.ceil(fuelConsumed); //Rounds up as per spec
        fuelTank = fuelTank - fuelConsumed;
        return fuelConsumed;
    }

    protected SmallCar(){
        super(CarType.SMALL);
        fuelTankCapacity();
    }

    public int amountTillFullTank() {
        return FUELTANKCAPACITY - fuelTank;
    }
}
