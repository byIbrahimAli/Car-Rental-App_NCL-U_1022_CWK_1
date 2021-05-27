package Testing;

import Car.CarFactory;

/**
 * Car Project - Car Factory Test
 * Created by Ibrahim Ali on 24/04/2016.
 * Student ID: 
 * Newcastle University | Stage 1
 */

/*
Lines with code have been deliberately commented out to allow method to run properly.
They've been used to test the exception is thrown
 */

public class CarFactoryTest {
    public static void main (String[] args){
        //Creating Car Factory #1
        CarFactory x = new CarFactory();
        //Creating all Cars #1
        x.getCar();

        // ~~~~~ Attempt to use the getCar method again ~~~~~~
        //Creating all cars #2 - Will throw exception due to method being run more than once
//        x.getCar();

        // ~~~~~ Attempt to create a new Car Factory and run the getCar method ~~~~~~
        //Creating Car Factory #2
//        CarFactory y = new CarFactory();
        //Creating all cars #3 - Will throw exception due to method being run more than once
//        y.getCar();
    }
}
