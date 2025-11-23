package at.ac.hcw.idledevgame;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

<<<<<<<< HEAD:idleDevGame/src/main/java/at/ac/hcw/idledevgame/IdleDevController.java
public class IdleDevController {
========
public class GameController {
>>>>>>>> origin/main:idleDevGame/src/main/java/at/ac/hcw/idledevgame/GameController.java
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}
