package classes;

import java.util.ArrayList;
import java.util.List;

/// Representing the base class of a classes.developer,
/// which can be hired and upgraded as part of
/// the core classes.game mechanic
public class developer {

    private String name;
    private int ID;
    private List<attribute> skills;

    /***
     * A classes.developer is the bass class for a
     * worker in the company
     * @param name  //name for UI-Display
     * @param ID    //Unique identifier
     */
    public developer(String name, int ID) {
        this.name = name;
        this.ID = ID;
        this.skills = new ArrayList<>();
        skills.add(new attribute(0, attribute.attr.CodingSpeed));
        skills.add(new attribute(0, attribute.attr.ErrorRate));
    }

    //implement here


    public boolean upgradeAttribute(attribute.attr a) {
        //todo: implement

        return false;
    }

    /***
     * Call to get "random" developers for hiring
     * @return List of developers
     */
    public List<developer> hireDeveloper() {
        //todo: implement
        return null;
    }

    /***
     * Calculate number of successes
     * @return number of successes
     */
    public int work(){

        //todo: implement
        return 0;

    }

    //Getters and Setters
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public int getID() {return ID;}
}
