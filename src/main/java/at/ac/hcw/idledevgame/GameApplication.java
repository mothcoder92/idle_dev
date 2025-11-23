package at.ac.hcw.idledevgame;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

<<<<<<<< HEAD:idleDevGame/src/main/java/at/ac/hcw/idledevgame/IdleDevApplication.java
public class IdleDevApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(IdleDevApplication.class.getResource("company-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle("Hello!");
========
public class GameApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(GameApplication.class.getResource("main-game-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle("Idle Developer");
>>>>>>>> origin/main:idleDevGame/src/main/java/at/ac/hcw/idledevgame/GameApplication.java
        stage.setScene(scene);
        stage.show();
    }
}
