import java.util.ArrayList;
import java.util.List;

/// Representing the base class of a developer,
/// which can be hired and upgraded as part of
/// the core game mechanic
public class developer {

    private String name;
    private int ID;
    private List<attribute> attributes;

    /***
     * A developer is the bass class for a
     * worker in the company
     * @param name  //name for UI-Display
     * @param ID    //Unique identifier
     */
    public developer(String name, int ID) {
        this.name = name;
        this.ID = ID;
        this.attributes = new ArrayList<>();
        attributes.add(new attribute(0, attribute.attributes.CodingSpeed));
        attributes.add(new attribute(0, attribute.attributes.ErrorRate));
    }

    //implement here


    public boolean upgradeAttribute(attribute.attributes a) {
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
