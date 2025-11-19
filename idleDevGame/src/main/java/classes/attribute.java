package classes;

/// Attribute represents abilities of developers,
/// that can be improved as a core classes.game mechanic
public class attribute {

    public enum attr{
        CodingSpeed,
        ErrorRate
    }
    private int Rank;

    /***
     * Default constructor
     * @param rank  //The rank of an classes.attribute
     * @param a     //the type of classes.attribute
     */
    public attribute(int rank, attr a) {
        Rank = rank;
    }

    //implement here


    //Getters and Setters
    public int getRank() {return Rank;}
    public void setRank(int rank) {Rank = rank;}
}
