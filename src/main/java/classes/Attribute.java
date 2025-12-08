package classes;

/// Attribute represents abilities of developers,
/// that can be improved as a core classes.game mechanic
public class Attribute {

    private final String name;
    private int rank;
    private int value;
    private final int baseValue = 100;

    public Attribute(String name, int rank) {
        this.name = name;
        this.rank = rank;
        this.value = baseValue * rank;
    }

    public int getRank() {return rank;}

    public void upgradeRank() {
        rank++;
        value += baseValue;
    }

    public String getName() {return name;}

    public int getValue() {return value;}

}
