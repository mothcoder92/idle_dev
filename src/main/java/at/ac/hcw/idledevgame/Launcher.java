package at.ac.hcw.idledevgame;

import classes.Game;
import javafx.application.Application;

import java.util.Scanner;

public class Launcher {

    public static void main(String[] args) {

        System.out.println("Welcome to IDLE DEV GAME!");
        System.out.println("1: Launch App with UI");
        System.out.println("2: Console-based game");
        System.out.println("3: Launch auto-run");
        System.out.println("Choose a command: \n");

        Scanner sc = new Scanner(System.in);

        int cmd = 0;
        try {
            cmd = sc.nextInt();
        } catch (Exception e) {
            System.out.println("Invalid input");
            main(args);
        }

        switch (cmd) {
            case 1:
                //Launch Game UI
                Application.launch(GameApplication.class, args);
                break;
            case 2:
                //Console game
                Game ConsolePlaythrough = new Game();
                ConsolePlaythrough.consoleGame();
                break;
            case 3:
                //auto-run game with log
                Game AutoRunGame = new Game();
                AutoRunGame.gameAutoRun();
                AutoRunGame.printGameLog();
            default:
                System.out.println("Wrong input!");
                main(args);

        }

    }
}
