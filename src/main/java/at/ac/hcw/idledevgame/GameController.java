package at.ac.hcw.idledevgame;

import classes.Contract;
import classes.Developer;
import classes.Game;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;
import javafx.util.converter.IntegerStringConverter;
import javafx.scene.paint.Color;

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
    public ProgressBar dev_0_progress;
    @FXML
    public Label dev_0_lastWork;
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
    @FXML
    public TextField contract_title;
    @FXML
    public TextArea contract_description;
    @FXML
    public Label contract_lines;
    @FXML
    public Label contract_payout;
    @FXML
    public Button contract_finish;

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
            flashLabel(currentCash);
        }
    }

    @FXML
    protected void upgradeQualityOfCode() {
        Developer dev0 = game.developers.get(0);
        if(game.currentCapital.get() > dev0.getsuccessRate().getNextUpgradeCost()){
            dev0.upgradeSuccessRate();
        }
        else{
            flashLabel(currentCash);
        }
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

    @FXML
    public void completeContract(ActionEvent actionEvent) {
        //add money
        game.currentCapital.set(game.getCurrentCapital() + game.currentContract.get().getPayout());
        //get new contract
        game.currentContract.set(new Contract(2));
        //update ui
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
                    "Upgrade cost: " + game.developers.get(0).getsuccessRate().getNextUpgradeCost()
            );
        });

        //bind progress bar to dev value
        dev_0_progress.progressProperty().bind(game.developers.get(0).getProgress());
        //bind last work
        dev_0_lastWork.textProperty().bind(game.developers.get(0).getWrittenLinesInLastWorkstepProperty().asString());

        //bind contract fields
        contract_title.textProperty().bind(game.getContractProperty().flatMap(Contract::getContractNameProperty));
        contract_description.textProperty().bind(game.getContractProperty().flatMap(Contract::getContractDescriptionProperty));
        contract_lines.textProperty().bind(game.getContractProperty().flatMap(Contract::getContractLinesProperty));
        contract_payout.textProperty().bind(game.getContractProperty().flatMap(Contract::getContractPayoutProperty));
        contract_finish.disableProperty().bind(game.getContractProperty().flatMap(Contract::isCompletedProperty));


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
                new KeyFrame(Duration.seconds(0.1), e-> game.advanceMinute())
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

    //region Animations
    @FXML
    private void flashLabel(Label label){
        final Color originalColor = (Color) label.getTextFill();
        final Color flashColor = Color.RED;

        Timeline timeline = new Timeline(
                new KeyFrame(Duration.ZERO, e -> {label.setTextFill(flashColor);}),
                new KeyFrame(Duration.seconds(0.25), e-> {label.setTextFill(originalColor);}),
                new KeyFrame(Duration.seconds(0.5), e-> {label.setTextFill(flashColor);}),
                new KeyFrame(Duration.seconds(0.75), e-> {label.setTextFill(originalColor);})
        );
        timeline.setCycleCount(1);
        timeline.play();
    }




    //endregion





}
