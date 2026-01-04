package classes;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

import java.util.Random;

/// Attribute represents abilities of developers,
/// that can be improved as a core classes.game mechanic
public class Attribute {

    private final String name;
    private IntegerProperty rank = new SimpleIntegerProperty(0);
    private int nextUpgradeCost;

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
