package classes;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

public class Developer {

    //Properties
    private final StringProperty name = new SimpleStringProperty();
    private int level;
    Attribute codingSpeed;
    Attribute successRate;
    private IntegerProperty salary = new SimpleIntegerProperty(0);
    private List<String> devLog;
    private StringProperty title = new SimpleStringProperty("Junior Developer");

    //Resources
    private static final ResourceBundle rb = ResourceBundle.getBundle("at/ac/hcw/idledevgame/Names");
    private static final Random rand = new Random();


    /**
     * Generate a new developer
     * @param upperSkillBound ranks get generated between 1 and upperSkillBound
     */
    public Developer(int upperSkillBound) {
        this.name.set(randomName());
        this.devLog = new ArrayList<>();
        this.codingSpeed = new Attribute("codingSpeed", rand.nextInt(1, upperSkillBound));
        this.successRate = new Attribute("successRate", rand.nextInt(1, upperSkillBound));
        updateDeveloper();
        logDevAction(this.name +" was created.");
    }

    /**
     * Public visible method to re-calculate level and salary
     */
    public void updateDeveloper(){
        calculateLevel();
        calculateSalary();
        checkTitle();
        logDevAction(this.name +"'s Level, Salary and Title were updated.");
    }

    /**
     * Public method to calculate successes
     * @return number of successes
     */
    public int work(int difficulty){
        int numberOfLinesWritten = this.codingSpeed.getRank().get() * 100;                    //Number of lines, e.g. Rank 5 = 500 Lines
        float errorRate = 1.0f + ((this.successRate.getRank().get() - difficulty) / 10f);     //Multiplier based on difficulty e.g. 0.8 or 1.2
        errorRate = Math.abs(errorRate);                                                //Ensure positive value
        int result = Math.round((numberOfLinesWritten * errorRate));
        logDevAction(this.name + " worked, and implemented " +result+ " lines.");
        return result;
    }

    public void upgradeCodingSpeed(){
        this.codingSpeed.upgradeAttribute();
        updateDeveloper();
    }

    public void upgradeSuccessRate(){
        this.successRate.upgradeAttribute();
        updateDeveloper();
    }

    /**
     * Log action
     * @param log the thing that happened
     */
    private void logDevAction(String log){
        this.devLog.add(log);
    }

    /**
     * Initialize salary based on level
     */
    private void calculateSalary(){
        this.salary.set(
                (int) (this.level * 500 * rand.nextFloat(0.8f,1.2f)));
    }

    /**
     * Initialize level as sum of ranks
     */
    private void calculateLevel() {
        this.level = codingSpeed.getRank().get() +  successRate.getRank().get();
    }

    private void checkTitle(){
        SimpleStringProperty result = new SimpleStringProperty();
        if(level < 6){
            result.set("Junior Developer");
        }
        else if(level >= 6 && level < 18){
            result.set("Regular Developer");
        }
        else if(level >= 18){
            result.set("Senior Developer");
        }
        this.title.set(result.getValue());
    }


    //Getters & Setters
    public String getName() {return name.get();}
    public int getCodingSpeed() {return codingSpeed.getRank().get();}
    public float getSuccessRate() {return (float) successRate.getRank().get();}
    public int getRank() {return level;}
    public int getSalary() {return salary.get();}
    public int getLevel() {return level;}
    public Attribute getcodingSpeed() {return codingSpeed;}
    public Attribute getsuccessRate() {return successRate;}

    //Observable properties
    public IntegerProperty getCodingSpeedProperty() { return this.codingSpeed.getRank(); }
    public IntegerProperty getSuccessRateProperty() { return this.successRate.getRank(); }
    public IntegerProperty getSalaryProperty(){ return this.salary;}
    public StringProperty getDeveloperNameProperty(){ return this.name;}
    public StringProperty getDeveloperTitle(){ return this.title;}

    //region Helpers

    /**
     * Generate a random name from resource file
     * @return String firstname + lastname
     */
    private static String randomName(){
        String first = randomValue("first");
        String last = randomValue("last");
        return first + " " + last;
    }

    /**
     * Return a random entry from resource file
     * @param prefix /fist or last
     * @return firstname or lastname
     */
    private static String randomValue(String prefix){
        List<String> values = new ArrayList<>();

        for(String key : rb.keySet()){
            if(key.startsWith(prefix + ".")){
                values.add(rb.getString(key));
            }
        }
        return values.get(rand.nextInt(values.size()));
    }

    //endregion Helpers


}


