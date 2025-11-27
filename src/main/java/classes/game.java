package classes;

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
    //endregion

    /***
     * Default constructor, with test-settings
     */
    public game(){
        logStartingValues();
        //todo: implement


    }

    public game(String companyName, int startingCapital){
        this.companyName = companyName;
        this.startingCapital = startingCapital;
        logStartingValues();
    }
    
    public void consoleGame(){
        //console based implementation
        List<String> commands = new ArrayList<>();
        commands.add("1. Progress to next day");
        commands.add("2. Work on Contracts (success randomized)");
        commands.add("3. Hire a developer");
        commands.add("4. Reset game");
        commands.add("5. Display current company stats");
        commands.add("6. Display full game log");
        commands.add("7. Exit game");
        commands.add("#########################################");
        commands.add("Enter a command: ");

        boolean consoleGame = true;
        int counter = 0;
        int rnd = new Random().nextInt(50,200);

        while(consoleGame){
            for(String line: commands){
                System.out.println(line);
            }
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
                            this.firstOffice.addDeveloper(new developer("Worker "+ counter, rnd));
                            break;
                            case "4":
                                this.firstOffice = new department(this.companyName, rnd+2);
                                break;
            }

        }




        //todo: implement




    }


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
        this.currentDay++;
        logGameAction("has started.");

        //todo: update variables

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

    public void printGameLog(){
        logEndingValues();
        if(errors.isEmpty()){
            for(String log : this.gameLog){
                System.out.println(log);
            }
        }else {
            for(Exception error : errors){
                System.out.println(error.getMessage());
            }
        }

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
