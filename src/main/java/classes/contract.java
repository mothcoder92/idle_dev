package classes;

/// A classes.contract is a classes.game objective that can be completed
/// to earn capital
public class contract {

    private String contractName;
    private int contractNumber;
    private int numberOfSuccessesNeeded;
    private int numberOfSuccessesAchieved;
    private int payout;
    private String contractDescription;
    private int contractDifficulty;

    //Randomness
    private float rngUpperBound = 0.5f;
    private float rngLowerBound = 1.5f;

    /***
     * Default constructor of classes.contract, generates semi-random
     * name and description and successes/payout based on difficulty
     * @param contractNumber        //unique identifier for classes.contract
     * @param contractDifficulty    //difficulty of classes.contract
     */
    public contract(int contractNumber, int contractDifficulty) {
        this.contractNumber = contractNumber;
        this.contractDifficulty = contractDifficulty;
        this.numberOfSuccessesAchieved = 0;

        //todo: generate classes.contract values semi-randomly

        generateContract();

    }

    //implement here

    public boolean addSuccesses(){

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
    public int getContractNumber() {return contractNumber;}
    public void setContractNumber(int contractNumber) {this.contractNumber = contractNumber;}
    public int getNumberOfSuccessesNeeded() {return numberOfSuccessesNeeded;}
    public void setNumberOfSuccessesNeeded(int numberOfSuccessesNeeded) {this.numberOfSuccessesNeeded = numberOfSuccessesNeeded;}
    public int getPayout() {return payout;}
    public void setPayout(int payout) {this.payout = payout;}
    public String getContractDescription() {return contractDescription;}
    public void setContractDescription(String contractDescription) {this.contractDescription = contractDescription;}
    public int getContractDifficulty() {return contractDifficulty;}
    public void setContractDifficulty(int contractDifficulty) {this.contractDifficulty = contractDifficulty;}
}
