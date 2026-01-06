package classes;

import javafx.beans.property.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

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

    //Resources
    private static final ResourceBundle rb = ResourceBundle.getBundle("at/ac/hcw/idledevgame/Contracts");
    private static final Random rand = new Random();


    /***
     * Default constructor of classes.contract, generates semi-random
     * name and description and successes/payout based on difficulty
     * @param contractDifficulty    //difficulty of classes.contract
     */
    public Contract(int contractDifficulty) {
        this.contractDifficulty = contractDifficulty;
        this.isCompleted.set(true);
        generateContract();
    }

    public void progressContract(int numberOfLines){
        numberOfLinesWritten += numberOfLines;
        if(numberOfLinesWritten >= numberOfLinesNeeded){
            isCompleted.set(false);
        }
        setContractLinesProperty();
    }

    private void generateContract(){
        //Generate name and description
        randomNameAndDescription();
        this.numberOfLinesWritten = 0;
        this.numberOfLinesNeeded = (int) (this.contractDifficulty * 1000 * rand.nextDouble(1,1.25));
        this.payout = (int) (this.contractDifficulty * 5000 * rand.nextDouble(0.75, 3));
        setContractLinesProperty();
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

    //Helpers
    /**
     * Return a random entry from resource file
     * @return string
     */
    private void randomNameAndDescription(){
        List<String> titles = new ArrayList<>();
        List<String> descriptions = new ArrayList<>();

        int itemNumber = rand.nextInt(50);
        for(String key : rb.keySet()){
            if(key.startsWith("title" + ".")){
                titles.add(rb.getString(key));
            }
        }
        for(String key : rb.keySet()){
            if(key.startsWith("description" + ".")){
                descriptions.add(rb.getString(key));
            }
        }
        contractName.set(titles.get(itemNumber));
        contractDescription.set(descriptions.get(itemNumber));

    }


}
