/// Attribute represents abilities of developers,
/// that can be improved as a core game mechanic
public class attribute {

    public enum attributes{
        CodingSpeed,
        ErrorRate
    }
    private int Rank;

    /***
     * Default constructor
     * @param rank  //The rank of an attribute
     * @param a     //the type of attribute
     */
    public attribute(int rank, attributes a) {
        Rank = rank;
    }

    //implement here


    //Getters and Setters
    public int getRank() {return Rank;}
    public void setRank(int rank) {Rank = rank;}
}
