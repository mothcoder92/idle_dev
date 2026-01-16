package at.ac.hcw.idledevgame;

import classes.Developer;
import classes.Game;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.awt.*;
import java.util.List;

public class hireController {

    //Game Object passed by parent
    private Game game;
    private Runnable onHireFinished;

    public void setGameObject(Game game) {
        this.game = game;
    }

    //Potential Hire 0
    @FXML
    protected Label hire_0_name;
    @FXML
    protected Label hire_0_cost;
    @FXML
    protected Label hire_0_speed;
    @FXML
    protected Label hire_0_quality;

    //Potential Hire 1
    @FXML
    protected Label hire_1_name;
    @FXML
    protected Label hire_1_cost;
    @FXML
    protected Label hire_1_speed;
    @FXML
    protected Label hire_1_quality;

    //Potential Hire 2
    @FXML
    protected Label hire_2_name;
    @FXML
    protected Label hire_2_cost;
    @FXML
    protected Label hire_2_speed;
    @FXML
    protected Label hire_2_quality;

    //Grouping
    private List<Label> nameLabels;
    private List<Label> costLabels;
    private List<Label> speedLabels;
    private List<Label> qualityLabels;

    //Control Elements
    @FXML
    protected Button hire_0_btn;
    @FXML
    protected Button hire_1_btn;
    @FXML
    protected Button hire_2_btn;

    //On choosing dev, return to main window
    @FXML
    protected void hire_0_btn_click() {
        game.developers.get().add(game.potentialDevelopers.get(0));

        //Runnable to callback to gameController
        if (onHireFinished != null) {
            onHireFinished.run();
        }

        ((Stage) hire_0_btn.getScene().getWindow()).close();
    }

    /**
     * Add newly hired Dev to the gameObject and
     * fire callback to notify gameController
     */
    @FXML
    protected void hire_1_btn_click() {
        game.developers.get().add(game.potentialDevelopers.get(1));

        //Runnable to callback to gameController
        if (onHireFinished != null) {
            onHireFinished.run();
        }

        ((Stage) hire_1_btn.getScene().getWindow()).close();
    }

    @FXML
    protected void hire_2_btn_click() {
        game.developers.get().add(game.potentialDevelopers.get(2));

        //Runnable to callback to gameController
        if (onHireFinished != null) {
            onHireFinished.run();
        }

        ((Stage) hire_2_btn.getScene().getWindow()).close();
    }

    public void setOnHireFinished(Runnable callback) {
        this.onHireFinished = callback;
    }

    @FXML
    protected void initialize() {
        //no game reference here, as it is still null
    }

    public void initUI() {
        //Group in Lists
        nameLabels = List.of(hire_0_name, hire_1_name, hire_2_name);
        costLabels = List.of(hire_0_cost, hire_1_cost, hire_2_cost);
        speedLabels = List.of(hire_0_speed, hire_1_speed, hire_2_speed);
        qualityLabels = List.of(hire_0_quality, hire_1_quality, hire_2_quality);

        //generate 3 developers
        game.hireNewDevelopers(3); //adjust rank to gameplay
        //bind them to ui-elements
        bindDevelopers();
    }

    private void bindDevelopers() {
        int count = Math.min(game.potentialDevelopers.size(), nameLabels.size());

        for (int i = 0; i < count; i++) {
            Developer dev = game.potentialDevelopers.get(i);

            nameLabels.get(i).textProperty().bind(dev.getDeveloperNameProperty());
            costLabels.get(i).textProperty().bind(dev.getSalaryProperty().asString());
            speedLabels.get(i).textProperty().bind(dev.getCodingSpeedProperty().asString());
            qualityLabels.get(i).textProperty().bind(dev.getSuccessRateProperty().asString());
        }
    }
}
