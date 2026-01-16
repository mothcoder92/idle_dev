package at.ac.hcw.idledevgame;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class GameApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(GameApplication.class.getResource("main-game-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1010, 572);
        stage.setTitle("Idle Macrop");
        stage.setMaxWidth(1010);
        stage.setMaxHeight(572);
        stage.setScene(scene);
        stage.show();
    }
}
