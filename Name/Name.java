package Name;

/**
 * Car Project - Name
 * Created by Ibrahim Ali on 24/04/2016.
 * Student ID: 
 * Newcastle University | Stage 1
 */

public class Name {
    private final String forename;
    private final String surname;

    // ============= CONSTRUCTOR =============
    public Name(String forename, String surname){
        this.forename = forename;
        this.surname = surname;
    }

    // ============= GET METHODS =============
    public String getForename(){
        return forename; // gets forename
    }

    public String getSurname(){
        return surname; // gets surname
    }

    public String getFullName(){
        return forename + " " + surname; // gets full name
    }
}
