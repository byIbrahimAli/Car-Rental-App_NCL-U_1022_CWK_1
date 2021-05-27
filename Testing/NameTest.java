package Testing;

import Name.*;

/**
 * Car Project - Name Test
 * Created by Ibrahim Ali on 24/04/2016.
 * Student ID: 
 * Newcastle University | Stage 1
 */

public class NameTest {
    public static void main (String[] args){
        //Creating Name object #1
        Name instance1 = new Name("Alpha", "Bravo");
        System.out.println("NAME #1:");
        System.out.println("#1 FULL NAME: " + instance1.getFullName());
        System.out.println("#1 FORENAME: " + instance1.getForename());
        System.out.println("#1 SURNAME: " + instance1.getSurname());

        //Creating Name object #2
        Name instance2 = new Name("Charlie", "Delta");
        System.out.println("\n\nNAME #2:");
        System.out.println("#2 FULL NAME: " + instance2.getFullName());
        System.out.println("#2 FORENAME: " + instance2.getForename());
        System.out.println("#2 SURNAME: " + instance2.getSurname());
    }
}
