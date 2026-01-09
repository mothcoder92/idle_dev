package classes;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import java.util.Random;

/**
 * Attribute represents one ability on a developer
 * Attributes can be increased in Rank for a cost as
 * a core game mechanic.
 */
public class Attribute {

    private final String name;
    private IntegerProperty rank = new SimpleIntegerProperty(0);
    private int nextUpgradeCost;

    /**
     * Default Constructor
     * @param name Name of the attribute
     * @param rank Initial rank
     */
    public Attribute(String name, int rank) {
        this.name = name;
        this.rank.set(rank);
        this.nextUpgradeCost = getUpgradeCost();
    }

    /**
     * Call to upgrade attribute by one rank
     */
    public void upgradeAttribute() {
        this.rank.set(rank.get()+1);
        this.nextUpgradeCost = getUpgradeCost();
    }

    /**
     * Get upgrade cost from current rank with
     * slight randomness added.
     * @return upgrade cost as int.
     */
    private int getUpgradeCost(){
        Random rand = new Random();
        return (int)(rank.get() * 100 * rand.nextFloat(1,2));
    }

    //Getters & Setters
    public String getName() {return name;}
    public IntegerProperty getRank() {return this.rank;}
    public void setRank(int rank) {this.rank.set(rank);}
    public int getNextUpgradeCost() {return this.nextUpgradeCost;}

}
