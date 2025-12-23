package classes;

/// Attribute represents abilities of developers,
/// that can be improved as a core classes.game mechanic
public class Attribute {

    private final String name;
    private int rank;

    public Attribute(String name, int rank) {
        this.name = name;
        this.rank = rank;
    }

    /**
     * Call to upgrade attribute by one rank
     */
    public void upgradeAttribute() {
        this.rank++;
    }

    //Getters & Setters
    public String getName() {return name;}
    public int getRank() {return rank;}

}
