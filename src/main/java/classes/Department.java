package classes;

import java.util.ArrayList;
import java.util.List;

/// A classes.department is the "büro", which acts as a screen
/// in the classes.game. It can hold multiple developers, and
/// can have permanent upgrades.
public class Department {

    private String name;
    private int ID;
    private List<Developer> developers;
    private int numberOfWorkplaces;

    /***
     * Default constructor for classes.department
     * @param name  //name of classes.department for UI-Display
     * @param ID    //Unique identifier
     */
    public Department(String name, int ID) {
        this.name = name;
        this.ID = ID;
        this.numberOfWorkplaces = 2; //default
        this.developers = new ArrayList<Developer>();
    }

    //implement here

    public boolean addDeveloper(Developer developer){
        //todo: implement
        return false;
    }

    public boolean addWorkplace(){
        //todo: implement
        return false;
    }

    //Getters and Setters
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public int getID() {return ID;}

}
