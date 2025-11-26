package at.ac.hcw.idledevgame;

import classes.game;
import javafx.application.Application;

public class Launcher {
    // Das ist ein Test für einen Commit
    public static void main(String[] args) {

        //Launch Game UI
        Application.launch(GameApplication.class, args);

        //Run automated test-game ~15 sec
        //game FirstPlaythrough = new game();
        //FirstPlaythrough.gameAutoRun();
        //FirstPlaythrough.printGameLog();

        //Run manual console-game
        //todo:

    }
}
