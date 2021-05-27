package Car;

/**
 * Car Project - Large Car
 * Created by Ibrahim Ali on 24/04/2016.
 * Student ID: 
 * Newcastle University | Stage 1
 */

public final class LargeCar extends AbstractCar {
    private static final int FUELTANKCAPACITY = 65;
    private int fuelTank = 65;//Default value
    private static final int FIRSTFUELCONSUMPTIONRATE = 15; //Kilometres/Litre for first 50Km
    private static final int FINALFUELCONSUMPTIONRATE = 20; //Kilometres/Litre
    private static final int FIRSTFUELCONSUMPTIONDISTANCE = 50; //Kilometres

    public int fuelTankCapacity(){return FUELTANKCAPACITY;}

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

    public int fuelTankCurrently(){
        return fuelTank;
    }

    public int drive(int journeyDistance){
        final String error1 = "No journey has been undertaken.";
        double firstFuelConsumed = 0; //Default value
        double secondFuelConsumed;
        int remainingDistance = 0; //Default value
        int fuelConsumed;

        if (!currentCarOnRent()){ //Car isn't being rented
            System.err.println(error1);
            return 0;
        }

        if(fuelTank <= 0){ //Car fuel tank is empty
            System.err.println(error1);
            return 0;
        }

        remainingDistance = journeyDistance - FIRSTFUELCONSUMPTIONDISTANCE;
        firstFuelConsumed = FIRSTFUELCONSUMPTIONDISTANCE / (double)FIRSTFUELCONSUMPTIONRATE;
        secondFuelConsumed = firstFuelConsumed + (remainingDistance / (double)FINALFUELCONSUMPTIONRATE);
        fuelConsumed = (int)Math.ceil(secondFuelConsumed); //Rounds up as per spec
        fuelTank = fuelTank - fuelConsumed;
        return fuelConsumed;
    }

    protected LargeCar(){
        super(CarType.LARGE);
        fuelTankCapacity();
    }

    public int amountTillFullTank() {
        return FUELTANKCAPACITY - fuelTank;
    }
}
