package classes;

import java.util.Random;

/// A classes.contract is a classes.game objective that can be completed
/// to earn capital
public class Contract {

    private String contractName;
    public boolean isCompleted;
    private int numberOfLinesWritten;
    private int payout;
    private String contractDescription;
    private int contractDifficulty;

    //Randomness
    private float rngUpperBound = 0.5f;
    private float rngLowerBound = 1.5f;

    //Contract Spieler startet Spiel
    //Spiel start: game.class erstellt 5-10 Contracts (müssen abgeschlossen sein zum gewinnen)
    // Contract: Schwierigkeit -> Zeilen Code für Abschluss notwendig
    // Contract erstellen (Constructor) -> int Schwierigkeit (Zahl zwischen 1 und 5)

    //Formel Developer: Coding Speed 5 * 100 = 500 Zeilen Code * Fehler Rate ( 0.8 - 1.2 * Schwierigkeit )


    //Ablauf: Contract wird erstellt, und bekommt eine Schwierigkeit: 1
    //M: Contract bekommt: wv Zeilen zum abschließen, namen, Beschreibung, ist er fertig?, payout
    //M: Schwierigkeit 1: 2000 Zeilen, 3000€, namen und beschreibung generiert
    //Ablauf: -> 400 neue Zeilen geschrieben
    //M: 400/2000
    //Ablauf: 1700 Zeilen geschrieben
    //M: 2000/2000, boolean Wert: Contract abgeschlossen.




    /***
     * Default constructor of classes.contract, generates semi-random
     * name and description and successes/payout based on difficulty
     * @param contractDifficulty    //difficulty of classes.contract
     */
    public Contract(int contractDifficulty) {
        this.contractDifficulty = contractDifficulty;
        //leg fest wv Zeilen auf Basis der Schwierigkeit
        this.isCompleted = false;

        //Schwierigkeit 1 zwischen 1000-2000 Zeilen
        Random rand = new Random();
        int Zeilen = rand.nextInt(1000,2000);
        //todo: generate classes.contract values semi-randomly

        generateContract();

    }

    //implement here

    public boolean progressContract(int numberOfLines){


        //todo: implement
        //return true as soon as classes.contract is completed

        return false;
    }

    private void generateContract(){
        //todo: implement

        //contractDifficulty * RND = numberOfSuccessesNeeded
        //difficulty * successesneeded * RND = payout

    }

    private String randomContractDescription(){

        //todo: implement

        return "";
    }

    private String randomContractName(){

        //todo: implement

        return "";
    }

    //Getters and Setters
    public String getContractName() {return contractName;}
    public void setContractName(String contractName) {this.contractName = contractName;}
    //public int getContractNumber() {return contractNumber;}
    //public void setContractNumber(int contractNumber) {this.contractNumber = contractNumber;}
    public int getNumberOfLinesWritten() {return numberOfLinesWritten;}
    public void setNumberOfLinesWritten(int numberOfLinesWritten) {this.numberOfLinesWritten = numberOfLinesWritten;}
    public int getPayout() {return payout;}
    public void setPayout(int payout) {this.payout = payout;}
    public String getContractDescription() {return contractDescription;}
    public void setContractDescription(String contractDescription) {this.contractDescription = contractDescription;}
    public int getContractDifficulty() {return contractDifficulty;}
    public void setContractDifficulty(int contractDifficulty) {this.contractDifficulty = contractDifficulty;}
}
