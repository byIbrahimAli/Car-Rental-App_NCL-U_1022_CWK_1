package Testing;

/**
 * Car Project - Registration Number Test
 * Created by Ibrahim Ali on 24/04/2016.
 * Student ID: 
 * Newcastle University | Stage 1
 */

import Number.*;

public class RegistrationNumberTesting {
    public static void main (String[] args){
        //Creating Registration Number object #1
        RegistrationNumber instance1 = RegistrationNumber.getInstance();

        System.out.println("REGISTRATION NUMBER USING GET METHOD: " + instance1.getRegNo());
        System.out.println("REGISTRATION NUMBER USING TOSTRING: " + instance1.toString());
        System.out.println("REGISTRATION NUMBER RANDOM LETTER: " + instance1.getRegNoLetter());
        System.out.println("REGISTRATION NUMBER RANDOM INT: " + instance1.getRegNoInt());

        System.out.println("\n"); //break

        //Creating Registration Number object #2
        RegistrationNumber instance2 = RegistrationNumber.getInstance(); //Evidences unique random Registration Number
        System.out.println("REGISTRATION NUMBER #2: " + instance2.toString());

        //Creating Registration Number object #1
        RegistrationNumber instance3 = RegistrationNumber.getInstance(); //Evidences unique random Registration Number
        System.out.println("REGISTRATION NUMBER #3: " + instance3.toString());
    }
}
