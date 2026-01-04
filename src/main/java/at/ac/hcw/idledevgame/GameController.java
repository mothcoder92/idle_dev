package at.ac.hcw.idledevgame;

import classes.Developer;
import classes.Game;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;
import javafx.util.converter.IntegerStringConverter;

import java.awt.*;

public class GameController {


    //Game variables
    private Game game = new Game("Macrosoft", 1000);
    private Timeline timeline;



    //region FXML properties
    @FXML
    public Label dev0_name;
    @FXML
    public Label dev0_level;
    @FXML
    public Label dev0_salary;
    @FXML
    public Button dev_0_upgrade_quality;
    @FXML
    public Button dev_0_upgrade_codeSpeed;
    @FXML
    private Label currentDay;
    @FXML
    private Label currentCash;
    @FXML
    private TextField CompName;
    @FXML
    private Label levelCodingSpeed;
    @FXML
    private Label levelQualityOfCode;
    @FXML
    private Label levelCodingSpeed1;
    @FXML
    private Label levelQualityOfCode1;
    @FXML
    private Label levelCodingSpeed2;
    @FXML
    private Label levelQualityOfCode2;
    @FXML
    private Label levelCodingSpeed3;
    @FXML
    private Label levelQualityOfCode3;
    @FXML
    private GridPane dev1;
    @FXML
    private GridPane dev2;
    @FXML
    private GridPane dev3;
    @FXML
    private GridPane dev4;

    //endregion

    @FXML
    private Tooltip dev_0_upgradeCodingSpeedTooltip = new Tooltip();
    @FXML
    private Tooltip dev_0_upgradeQualityOfCodeTooltip = new Tooltip();

    @FXML
    protected void upgradeCodingSpeed() {
        Developer dev0 = game.developers.get(0);
        if(game.currentCapital.get() > dev0.getcodingSpeed().getNextUpgradeCost()){
            dev0.upgradeCodingSpeed();
        }
        else{
            //todo: flash money or something
        }
    }

    @FXML
    protected void upgradeQualityOfCode() {
        int lvl = Integer.parseInt(levelQualityOfCode.getText().substring(6));
        lvl++;
        levelQualityOfCode.setText("Stufe " + lvl);
    }

    @FXML
    protected void upgradeCodingSpeed1() {
        int lvl = Integer.parseInt(levelCodingSpeed1.getText().substring(6));
        lvl++;
        levelCodingSpeed1.setText("Stufe " + lvl);
    }

    @FXML
    protected void upgradeQualityOfCode1() {
        int lvl = Integer.parseInt(levelQualityOfCode1.getText().substring(6));
        lvl++;
        levelQualityOfCode1.setText("Stufe " + lvl);
    }

    @FXML
    protected void upgradeCodingSpeed2() {
        int lvl = Integer.parseInt(levelCodingSpeed2.getText().substring(6));
        lvl++;
        levelCodingSpeed2.setText("Stufe " + lvl);
    }

    @FXML
    protected void upgradeQualityOfCode2() {
        int lvl = Integer.parseInt(levelQualityOfCode2.getText().substring(6));
        lvl++;
        levelQualityOfCode2.setText("Stufe " + lvl);
    }

    @FXML
    protected void upgradeCodingSpeed3() {
        int lvl = Integer.parseInt(levelCodingSpeed3.getText().substring(6));
        lvl++;
        levelCodingSpeed3.setText("Stufe " + lvl);
    }

    @FXML
    protected void upgradeQualityOfCode3() {
        int lvl = Integer.parseInt(levelQualityOfCode3.getText().substring(6));
        lvl++;
        levelQualityOfCode3.setText("Stufe " + lvl);
    }

    @FXML
    protected void hireNewDev() {
        if (!dev1.isVisible()) {
            dev1.setVisible(true);
        } else if (!dev2.isVisible()) {
            dev2.setVisible(true);
        } else if (!dev3.isVisible()) {
            dev3.setVisible(true);
        } else {
            dev4.setVisible(true);
        }
    }

    @FXML
    protected void fireDev1() {
        dev1.setVisible(false);
    }

    @FXML
    protected void fireDev2() {
        dev2.setVisible(false);
    }

    @FXML
    protected void fireDev3() {
        dev3.setVisible(false);
    }

    @FXML
    protected void fireDev4() {
        dev4.setVisible(false);
    }

    private void initUI(){
        Tooltip.install(dev_0_upgrade_codeSpeed, dev_0_upgradeCodingSpeedTooltip);
        Tooltip.install(dev_0_upgrade_quality, dev_0_upgradeQualityOfCodeTooltip);

        dev_0_upgrade_codeSpeed.setOnMouseEntered(e -> {
            dev_0_upgradeCodingSpeedTooltip.setText(
                    "Upgrade cost: " + game.developers.get(0).getcodingSpeed().getNextUpgradeCost()
            );
        });

        dev_0_upgrade_quality.setOnMouseExited(e -> {
            dev_0_upgradeCodingSpeedTooltip.setText(
                    "Upgrade cost: 1000" //todo: + something
            );
        });

    }


    //Initialize UI with game values
    @FXML
    private void initialize(){

        //UI fields
        initUI();
        //Set company name
        CompName.textProperty().bind(game.companyNameProperty());
        //Set cash
        currentCash.textProperty().bind(game.currentCapital.asString());
        //Set starting day
        currentDay.textProperty().bind(game.currentDay.asString());

        //Add starting developer
        if(!game.developers.isEmpty()){
            Developer dev0 = game.developers.getFirst();

            dev0_name.textProperty().bind(dev0.getDeveloperNameProperty());
            dev0_salary.textProperty().bind(dev0.getSalaryProperty().asString());
            dev0_level.textProperty().bind(dev0.getDeveloperTitle());

            levelCodingSpeed.textProperty().bind(dev0.getCodingSpeedProperty().asString());
            levelQualityOfCode.textProperty().bind(dev0.getSuccessRateProperty().asString());
        }

        //Initialize timeline
        timeline = new Timeline(
                new KeyFrame(Duration.seconds(1), e-> game.advanceHour())
        );
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    public void pauseGame(){
        timeline.pause();
    }

    public void resumeGame(){
        timeline.play();
    }

    @FXML
    private void updateContracts(){
        //update developers fields
        //update contract fields


    }

    @FXML
    private void updateDevelopers(){
        //increase stat/whatever
        //update values in game
        //refresh UI?

    }

    @FXML
    private void progressOneHour(){
        //check dev progress against contract
        //check for contract finished

    }





}
