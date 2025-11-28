package classes;

import at.ac.hcw.idledevgame.Launcher;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/***
 * Represents the current game
 * Offers methods to track and influence game state
 * @author Johannes Schagerl
 */
public class game {


    //region local variables
    private String companyName = "Macrosoft Inc.";
    private int startingCapital = 5000;
    private final int _GAME_SPEED = 1;
    //endregion

    //region global variables
    public department firstOffice;
    public contract currentContract;
    public int currentCapital;
    public int currentDay;
    public List<String> gameLog = new ArrayList<>();
    public boolean running = false;
    //endregion

    //region development variables
    public List<Exception> errors = new ArrayList<>();
    public List<developer>  developers = new ArrayList<>();
    //endregion

    /***
     * Default constructor, with test-settings
     */
    public game(){
        logStartingValues();
        //todo: implement


    }

    /**
     * Custom game constructor
     * @param companyName //the chosen company name
     * @param startingCapital   //the starting capital
     */
    public game(String companyName, int startingCapital){
        this.companyName = companyName;
        this.startingCapital = startingCapital;
        logStartingValues();
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
                            this.developers.add(hireDeveloper());
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
            //todo: actual values added

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
                currentCapital += 1000;
                return true;
            }
            return false;
        } catch (Exception e) {
            errors.add(e);
            return false;
        }
    }

    public void nextDay(){
        this.currentDay +=1;
        logGameAction("has started.");

        //todo: update variables

    }

    public developer hireDeveloper(){

        //todo: implementation based on real values
        int rnd = new Random().nextInt(0,4);
        int rnd2 = new Random().nextInt(0,4);
        int rnd3 = new Random().nextInt(100,500);
        List<String> firstNames = new ArrayList<>();
        firstNames.add("Johnny");
        firstNames.add("Bill");
        firstNames.add("Julia");
        firstNames.add("Mary");
        List<String> lastNames = new ArrayList<>();
        lastNames.add("Forger");
        lastNames.add("Lichan");
        lastNames.add("Schmidt");
        lastNames.add("Oshab");
        this.gameLog.add("Hired "+ firstNames.get(rnd)+" "+lastNames.get(rnd2));
        return new developer(firstNames.get(rnd)+ " " + lastNames.get(rnd2), rnd3);
    }

    /**
     * Resets the game to starting values
     */
    private void resetGame(){
        this.currentCapital = startingCapital;
        this.currentDay = 1;
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
        developers.forEach((d)-> System.out.println(d.getName()+", Salary: "+ d.getID()));
        System.out.println("#############################################");
    }
    //endregion

    //region getter & setter
    public String getCompanyName() {return companyName;}
    public void setCompanyName(String companyName) {this.companyName = companyName;}
    public int getStartingCapital() {return startingCapital;}
    public void setStartingCapital(int startingCapital) {this.startingCapital = startingCapital;}
    public department getFirstOffice() {return firstOffice;}
    public void setFirstOffice(department firstOffice) {this.firstOffice = firstOffice;}
    public contract getCurrentContract() {return currentContract;}
    public void setCurrentContract(contract currentContract) {this.currentContract = currentContract;}
    public int getCurrentCapital() {return currentCapital;}
    public void setCurrentCapital(int currentCapital) {this.currentCapital = currentCapital;}
    public int getCurrentDay() {return currentDay;}
    public void setCurrentDay(int currentDay) {this.currentDay = currentDay;}
    //endregion
}
