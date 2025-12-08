package classes;


import java.util.Random;

public class Developer {

    private final String name;
    private int rank;
    Attribute codingSpeed;
    Attribute successRate;
    private int salary;



    public Developer(String name, int rank) {
        this.name = name;
        this.rank = rank;
        this.codingSpeed = new Attribute("codingSpeed", generateSkillsRank());
        this.successRate = new Attribute("successRate", generateSkillsRank());
        this.salary = rank * 500;
    }


    public String getName() {return name;}

    public String getDevType() {
        if (rank < 10) return "Junior";
        else if (rank < 100) return "Senior";
        else return "10x";
    }

    public int getCodingSpeed() {return codingSpeed.getValue();}

    public float getSuccessRate() {return (float) successRate.getValue();}

    public int getRank() {return rank;}

    @Override
    public String toString() {
        return "Name: " + this.getName() + System.lineSeparator() +
                "Rank: " + this.getRank() + System.lineSeparator() +
                "Title: " + this.getDevType() + " Developer";

    }


    public int calcOutput() {
        int output = (getRank() * 10) + getCodingSpeed();
        Random rnd = new Random();
        float modifier = rnd.nextFloat(getSuccessRate(), 1.0f);
        return (int) (output * modifier);
    }

    public int generateSkillsRank() {
        Random rnd = new Random();
        return rnd.nextInt(1, getRank());
    }

    public void updateRank() {rank++;}

    public int getSalary() {return salary;}

}


