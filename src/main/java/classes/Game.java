package classes;

import at.ac.hcw.idledevgame.Launcher;
import javafx.beans.property.*;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/***
 * Represents the current game
 * Offers methods to track and influence game state
 * @author Johannes Schagerl
 */
public class Game {

    //region local variables
    private StringProperty companyName = new SimpleStringProperty("Macrosoft Inc.");
    private IntegerProperty startingCapital = new SimpleIntegerProperty(5000);
    private final int _GAME_SPEED = 1;
    //endregion

    //region game time
    private static final int WORK_HOURS_PER_DAY = 12;
    private static final int MINUTES_PER_HOUR = 100;
    private int hour = 0;
    private int minute = 0;
    private Game game;
    //endregion

    //region global variables
    public Department firstOffice;
    public ObjectProperty<Contract> currentContract = new SimpleObjectProperty<Contract>();
    public IntegerProperty currentCapital = new SimpleIntegerProperty(0);
    public IntegerProperty currentDay = new SimpleIntegerProperty(1);
    public List<String> gameLog = new ArrayList<>();
    public boolean running = false;
    //endregion

    //region development variables
    public List<Exception> errors = new ArrayList<>();
    public List<Developer>  developers = new ArrayList<>();
    //endregion

    /***
     * Default constructor, with test-settings
     */
    public Game(){
        logStartingValues();
        //todo: implement
        //contract Aufgabe1 = new contract()


    }

    /**
     * Custom game constructor
     * @param companyName //the chosen company name
     * @param startingCapital   //the starting capital
     */
    public Game(String companyName, int startingCapital){
        this.companyName.set(companyName);
        this.currentCapital.set(startingCapital);
        logStartingValues();
        //initial dev
        this.developers.add(new Developer(4));
        //initial contract
        this.currentContract.set(new Contract(1));

    }

    /**
     * A console-based implementation for testing purposes
     */
    public void consoleGame(){
        List<String> commands = new ArrayList<>();
        commands.add("1. Progress to next day");
        commands.add("2. Work on Contracts (success randomized)");
        commands.add("3. Hire a developer");
        commands.add("4. Reset game");
        commands.add("5. Display current company stats");
        commands.add("6. Display full game log");
        commands.add("7. Exit game");
        commands.add("8. Back to menu");
        commands.add("#########################################\n");
        commands.add("Enter a command: ");

        boolean consoleGame = true;
        int counter = 0;
        int rnd = new Random().nextInt(50,200);

        while(consoleGame){
            commands.forEach(System.out::println);
            String input = System.console().readLine();
            switch (input){
                case "1":
                    this.nextDay();
                    break;
                    case "2":
                        progressContract();
                        progressContract();
                        break;
                        case "3":
                            this.developers.add(hireDeveloper(5));
                            System.out.println("Developer has been successfully hired!");
                            break;
                            case "4":
                                resetGame();
                                System.out.println("Game has been reset.");
                                break;
                                case "5":
                                    printCurrentGameStats();
                                    break;
                                    case "6":
                                        printGameLog();
                                        break;
                                        case "7":
                                            System.exit(0);
                                            case "8":
                                                Launcher.main(new String[]{});
                default:
                    System.out.println("-------------");
                    System.out.println("Invalid input");
                    System.out.println("-------------\n");
            }
        }
    }

    /**
     * Auto-playthrough with randomized values
     * for testing purposes
     * @return  //false if errors occurred
     */
    public boolean gameAutoRun(){
        try {
            this.running = true;
            int timer = 0;
            int rnd = new Random().nextInt(0,1000);
            while(running && timer <= 10000) {
                this.nextDay();
                this.progressContract();
                this.progressContract();
                this.wait(rnd);
                timer+= rnd;
                rnd = new Random().nextInt(0,1000);
            }
            return true;
        } catch (Exception e) {
            errors.add(e);
            return false;
        }
    }

    public boolean gamePause(){
        //todo: implement
        this.running = false;
        logGameAction("Game paused");
        return true;
    }

    public boolean gameContinue(){
        //todo: implement
        this.running = true;
        logGameAction("Game continued");
        return true;
    }

    public void advanceMinute(){
        this.minute++;
        int contractProgress = 0;

        for(Developer developer : this.developers){
            developer.addProgress();
            if(developer.getProgress().get() >= 1.0){
                developer.setProgress(0.0);
                contractProgress += developer.work(currentContract.get().getContractDifficulty());
                //numberofLines
            }
        }

        this.currentContract.get().progressContract(contractProgress);

        if(minute >= MINUTES_PER_HOUR){
            hour++;
            minute = 0;
            advanceHour();
        }
    }

    public void advanceHour(){

        //per hour game object things

        if(hour >= WORK_HOURS_PER_DAY){
            hour = 0;
            advanceDay();
        }
    }

    public void advanceDay(){
        currentDay.set(currentDay.get()+1);
        //todo: events
    }


    //region Game control

    /**
     * Pause the game for specified time
     * @param milliseconds //time to pause
     */
    private void wait(int milliseconds){
        try {
            logGameAction("Sleeping for "+milliseconds+" milliseconds");
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            errors.add(e);
        }
    }

    public boolean progressContract (){
        try {
            int codeLinesWritten = 0;
            for(Developer dev : this.developers){
                codeLinesWritten += dev.work(currentContract.get().getContractDifficulty()); //todo: check contract difficulty
            }

            //todo: add success to contract
            //todo: check if contract is finished


            //test values
            int rnd = new Random().nextInt(0,4);
            if(rnd == 0){
                logGameAction("Developers keep working on the current Contract.");
            } else if(rnd == 1){
                logGameAction("Contract almost complete");
            } else {
                logGameAction("Contract has been successfully finished!");
                //get new contract todo
                logGameAction("We have earned 1000€");
                currentCapital.add(1000);
                return true;
            }
            return false;
        } catch (Exception e) {
            errors.add(e);
            return false;
        }
    }

    public void nextDay(){
        this.currentDay.add(1);
        logGameAction("has started.");

        //todo: update variables

    }

    /**
     * Hire a new developer with max ranks
     * @param upperRankBound max possible ranks
     * @return Developer object
     */
    public Developer hireDeveloper(int upperRankBound){
        Developer dev = new Developer(upperRankBound);
        this.gameLog.add("Hired "+dev.getName()+".");
        return dev;
    }

    /**
     * Resets the game to starting values
     */
    private void resetGame(){
        setCurrentCapital(startingCapital.getValue());
        this.currentDay.set(1);
        this.gameLog.clear();
        this.developers.clear();
    }

    private void logStartingValues(){
        this.gameLog.add("New game started as "+this.companyName);
        this.gameLog.add("Starting funds: "+this.startingCapital);
        //todo: implement
    }

    private void logEndingValues(){
        this.gameLog.add("Ending funds: "+this.currentCapital);
        this.gameLog.add("Final day: "+this.currentDay);
    }

    private void logGameAction(String action){
        this.gameLog.add("Day " + currentDay + ": " + action);
    }

    /**
     * Print internal log of game-actions to console
     */
    public void printGameLog(){
        logEndingValues();
        System.out.println("-------------------------------------------------");
        if(errors.isEmpty()){
            gameLog.forEach(System.out::println);
        }else {
            errors.forEach(System.out::println);
        }
        System.out.println("-------------------------------------------------");
    }

    /**
     * Print current game stats to console
     */
    public void printCurrentGameStats(){
        System.out.println("#############################################");
        System.out.println("Currently Playing as: " + this.companyName);
        System.out.println("Current Capital: " + this.currentCapital);
        System.out.println("Current Day: " + this.currentDay);
        System.out.println("Workforce: ");
        developers.forEach((d)-> System.out.println(d.getName()+", Salary: "+ d.getSalary()));
        System.out.println("#############################################");
    }
    //endregion

    //region ViewModel Properties
    public StringProperty companyNameProperty(){
        return this.companyName;
    }

    public IntegerProperty currentCapitalProperty(){
        return this.currentCapital;
    }



    //endregion




    //region getter & setter
    public String getCompanyName() {return this.companyName.get();}
    public void setCompanyName(String companyName) {this.companyName.set(companyName);}
    public int getStartingCapital() {return this.startingCapital.get();}
    public void setStartingCapital(int startingCapital) {this.startingCapital.set(startingCapital);}
    public Department getFirstOffice() {return firstOffice;}
    public void setFirstOffice(Department firstOffice) {this.firstOffice = firstOffice;}
    public Contract getCurrentContract() {return currentContract.get();}
    public void setCurrentContract(Contract currentContract) {this.currentContract.set(currentContract);}
    public int getCurrentCapital() {return this.currentCapital.get();}
    public void setCurrentCapital(int currentCapital) {this.currentCapital.set(currentCapital);}
    public int getCurrentDay() {return this.currentDay.get();}
    public void setCurrentDay(int currentDay) {this.currentDay.set(currentDay);}
    public int getHour() {return hour;}
    public void setHour(int hour) {this.hour = hour;}
    public ObjectProperty<Contract> getContractProperty() {return this.currentContract;}
    //endregion
}
