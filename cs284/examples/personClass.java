/** Person is a class that represents a human being.
* @author Koffman and Wolfgang
* */
public class Person {
    // Data Fields
    private String givenName;
    private String familyName;
    private String IDNumber;
    private int birthYear = 1900;

    // Constants
    private static final int VOTE_AGE = 18;
    private static final int SENIOR_AGE = 65;

    // Constructors
    public Person(String first, String family, String ID, int birth){
        givenName = first;
        familyName = family;
        IDNumber = ID;
        birthYear = birth;
    }
    public Person(String ID){
        IDNumber = ID;
    }

    // Modifier Methods
    public void setGivenName(String given){
        givenName = given;
    }
    public void setFamilyName(String family){
        familyName = family;
    }
    public void setBirthYear(int birthYear){
        this.birthYear = birthYear;
    }

    // Accessor Methods
    public String getGivenName(){
        return givenName;
    }
    public String getFamilyName(){
        return familyName;
    }
    public String getIDNumber(){
        return IDNumber;
    }
    public int getBirthYear(){
        return birthYear;
    }

    // Other Methods
    public int age(int year){
        return year - birthYear;
    }
    public boolean canVote(int year){
        int theAge = age(year);
        return theAge >= VOTE_AGE;
    }
    public boolean isSenior(int year){
        return age(year) >= SENIOR_AGE;
    }
    public String toString(){
        return "Given name: " + givenName + "\n"
        + "Family name: " + familyName + "\n"
        + "ID number: " + IDNumber + "\n"
        + "Year of birth: " + birthYear + "\n";
    }
    public boolean equals(Person per){
        if (per == null)
        return false;
        else
        return IDNumber.equals(per.IDNumber);
    }
}
