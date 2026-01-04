package classes;

import javafx.beans.property.*;

import java.util.Random;

/// A classes.contract is a classes.game objective that can be completed
/// to earn capital
public class Contract {

    public StringProperty contractName = new SimpleStringProperty();
    public BooleanProperty isCompleted = new SimpleBooleanProperty(true);
    public int numberOfLinesWritten;
    public int numberOfLinesNeeded;
    public int payout;
    public StringProperty contractDescription = new SimpleStringProperty();
    public int contractDifficulty;

    //Observable properties
    private StringProperty contractLinesProperty = new SimpleStringProperty();

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
        this.isCompleted.set(true);

        //Schwierigkeit 1 zwischen 1000-2000 Zeilen
        Random rand = new Random();
        int Zeilen = rand.nextInt(1000,2000);
        //todo: generate classes.contract values semi-randomly

        generateContract();

    }

    //implement here

    public void progressContract(int numberOfLines){
        numberOfLinesWritten += numberOfLines;
        if(numberOfLinesWritten >= numberOfLinesNeeded){
            isCompleted.set(false);
        }
        setContractLinesProperty();
    }

    private void generateContract(){
        //todo: implement

        //contractDifficulty * RND = numberOfSuccessesNeeded
        //difficulty * successesneeded * RND = payout

        this.contractName.set("Meine erste Website");
        this.numberOfLinesWritten = 0;
        this.numberOfLinesNeeded = this.contractDifficulty * 1000;
        this.payout = 5000;
        this.contractDescription.set("Dies ist ein Testcontract. Noch ist nicht mehr implementiert.");
        setContractLinesProperty();

    }

    private String randomContractDescription(){

        //todo: implement

        return "";
    }

    private String randomContractName(){

        //todo: implement

        return "";
    }

    public StringProperty getContractLinesProperty(){
        return contractLinesProperty;
    }
    public StringProperty getContractPayoutProperty(){
        return new SimpleStringProperty("Payout: " +  this.payout + " IMC");
    }

    //Observable properties
    public StringProperty getContractNameProperty(){ return this.contractName; }
    public StringProperty getContractDescriptionProperty(){ return this.contractDescription; }
    public BooleanProperty isCompletedProperty(){ return this.isCompleted; }
    public void setContractLinesProperty(){ this.contractLinesProperty.set(numberOfLinesWritten + " / " + numberOfLinesNeeded);}

    //Getters and Setters
    public String getContractName() {return contractName.get();}
    public void setContractName(String contractName) {this.contractName.set(contractName);}
    public int getNumberOfLinesWritten() {return numberOfLinesWritten;}
    public void setNumberOfLinesWritten(int numberOfLinesWritten) {this.numberOfLinesWritten = numberOfLinesWritten;}
    public int getPayout() {return payout;}
    public void setPayout(int payout) {this.payout = payout;}
    public String getContractDescription() {return contractDescription.get();}
    public void setContractDescription(String contractDescription) {this.contractDescription.set(contractDescription);}
    public int getContractDifficulty() {return contractDifficulty;}
    public void setContractDifficulty(int contractDifficulty) {this.contractDifficulty = contractDifficulty;}
}
