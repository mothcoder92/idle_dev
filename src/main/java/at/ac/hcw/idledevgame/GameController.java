package at.ac.hcw.idledevgame;

import classes.Contract;
import classes.Developer;
import classes.Game;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.control.ProgressBar;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;
import javafx.util.Duration;
import javafx.util.converter.IntegerStringConverter;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

import java.awt.*;
import java.io.IOException;

public class GameController {

    //Game variables
    private Game game = new Game("Idle Macrop", 2000);
    private Timeline timeline;
    private int newestHire = 0;

    //region FXML properties
    //region Dev0
    @FXML public Label dev_0_name;
    @FXML public Label dev_0_level;
    @FXML public Label dev_0_salary;
    @FXML public Button dev_0_upgrade_quality;
    @FXML public Button dev_0_upgrade_codeSpeed;
    @FXML public Label dev_0_cost_codeSpeed;
    @FXML public Label dev_0_cost_quality;
    @FXML private Label levelCodingSpeed_0;
    @FXML private Label levelQualityOfCode_0;
    @FXML public ProgressBar dev_0_progress;
    @FXML public Label dev_0_lastWork;
    @FXML private Tooltip dev_0_upgradeCodingSpeedTooltip = new Tooltip();
    @FXML private Tooltip dev_0_upgradeQualityOfCodeTooltip = new Tooltip();
    //endregion
    //region Dev1
    @FXML public Label dev_1_name;
    @FXML public Label dev_1_level;
    @FXML public Label dev_1_salary;
    @FXML public Button dev_1_upgrade_quality;
    @FXML public Button dev_1_upgrade_codeSpeed;
    @FXML public Label dev_1_cost_codeSpeed;
    @FXML public Label dev_1_cost_quality;
    @FXML private Label levelCodingSpeed_1;
    @FXML private Label levelQualityOfCode_1;
    @FXML public ProgressBar dev_1_progress;
    @FXML public Label dev_1_lastWork;
    @FXML private Tooltip dev_1_upgradeCodingSpeedTooltip = new Tooltip();
    @FXML private Tooltip dev_1_upgradeQualityOfCodeTooltip = new Tooltip();
    //endregion
    //region Dev2
    @FXML public Label dev_2_name;
    @FXML public Label dev_2_level;
    @FXML public Label dev_2_salary;
    @FXML public Button dev_2_upgrade_quality;
    @FXML public Button dev_2_upgrade_codeSpeed;
    @FXML public Label dev_2_cost_codeSpeed;
    @FXML public Label dev_2_cost_quality;
    @FXML private Label levelCodingSpeed_2;
    @FXML private Label levelQualityOfCode_2;
    @FXML public ProgressBar dev_2_progress;
    @FXML public Label dev_2_lastWork;
    @FXML private Tooltip dev_2_upgradeCodingSpeedTooltip = new Tooltip();
    @FXML private Tooltip dev_2_upgradeQualityOfCodeTooltip = new Tooltip();
    //endregion
    //region Dev3
    @FXML public Label dev_3_name;
    @FXML public Label dev_3_level;
    @FXML public Label dev_3_salary;
    @FXML public Button dev_3_upgrade_quality;
    @FXML public Button dev_3_upgrade_codeSpeed;
    @FXML public Label dev_3_cost_codeSpeed;
    @FXML public Label dev_3_cost_quality;
    @FXML private Label levelCodingSpeed_3;
    @FXML private Label levelQualityOfCode_3;
    @FXML public ProgressBar dev_3_progress;
    @FXML public Label dev_3_lastWork;
    @FXML private Tooltip dev_3_upgradeCodingSpeedTooltip = new Tooltip();
    @FXML private Tooltip dev_3_upgradeQualityOfCodeTooltip = new Tooltip();
    //endregion

    //Game UI Labels
    @FXML private Label currentDay;
    @FXML private Label currentCash;
    @FXML private TextField CompName;

    //Game UI components
    @FXML private GridPane dev1;
    @FXML private GridPane dev2;
    @FXML private GridPane dev3;
    @FXML private GridPane dev4;

    //Contract fields
    @FXML public TextField contract_title;
    @FXML public TextArea contract_description;
    @FXML public Label contract_lines;
    @FXML public Label contract_payout;
    @FXML public Button contract_finish;
    //endregion

    //Grouping properties
    private List<Label> developerNames;
    private List<Label> developerTitles;
    private List<Label> developerSalaries;
    private List<Label> upgradeCodingSpeed;
    private List<Label> costCodingSpeed;
    private List<Label> upgradeQualityOfCode;
    private List<Label> costQualityOfCode;
    private List<GridPane> developerGrids;
    private List<ProgressBar> developerProgressBars;
    private List<Label> developerLastWorkLabels;

    //region Code
    @FXML protected void upgradeCodingSpeed() { upgradeCodingSpeedHelper(0);}
    @FXML protected void upgradeQualityOfCode() { upgradeSuccessRateHelper(0);}
    @FXML protected void upgradeCodingSpeed1() { upgradeCodingSpeedHelper(1);}
    @FXML protected void upgradeQualityOfCode1() { upgradeSuccessRateHelper(1);}
    @FXML protected void upgradeCodingSpeed2() { upgradeCodingSpeedHelper(2);}
    @FXML protected void upgradeQualityOfCode2() { upgradeSuccessRateHelper(2);}
    @FXML protected void upgradeCodingSpeed3() { upgradeCodingSpeedHelper(3);}
    @FXML protected void upgradeQualityOfCode3() { upgradeSuccessRateHelper(3);}

    /**
     * Helper to call the events tied to the button
     * of developer number x
     * @param devNumber x
     */
    protected void upgradeCodingSpeedHelper(int devNumber){
        Developer dev = game.developers.get(devNumber);
        if(game.currentCapital.get() > dev.getcodingSpeed().getNextUpgradeCost().get()){
            dev.upgradeCodingSpeed();
        }
        else{
            flashLabel(currentCash);
        }
    }

    /**
     * Helper to call the events tied to the button
     * of developer number x
     * @param devNumber x
     */
    protected void upgradeSuccessRateHelper(int devNumber){
        Developer dev = game.developers.get(devNumber);
        if(game.currentCapital.get() > dev.getsuccessRate().getNextUpgradeCost().get()){
            dev.upgradeSuccessRate();
        }
        else{
            flashLabel(currentCash);
        }
    }


    @FXML
    protected void hireNewDev() throws IOException {
        pauseGame();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("hire-window-view.fxml"));
        Parent root = fxmlLoader.load();

        //pass game object to new controller
        hireController controller = fxmlLoader.getController();
        controller.setGameObject(game);
        controller.initUI();

        //set callback
        controller.setOnHireFinished(() -> {
            //show new Dev
            developerGrids.get(game.developers.size()-1).setVisible(true);
            //bindings
            bindNewDeveloper(game.developers.getSize()-1);
            //turn visible
            //update daily costs
            //todo: update daily cost
            resumeGame();
        });

        //set scene
        Stage stage = new Stage();
        stage.setTitle("Hire Developer");
        stage.setScene(new Scene(root, 700, 300));
        stage.show();

        //If window is closed game will be fortgesetzt
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                //todo: happens only when x is pressed on window, what to do?
                //todo: resumeGame?
            }
        });
    }

    @FXML
    protected void fireDev1() {
        dev1.setVisible(false);
        //todo: remove from game object
    }

    @FXML
    protected void fireDev2() {
        dev2.setVisible(false);
        //todo: remove from game object
    }

    @FXML
    protected void fireDev3() {
        dev3.setVisible(false);
        //todo: remove from game object
    }

    @FXML
    protected void fireDev4() {
        dev4.setVisible(false);
        //todo: remove from game object
    }

    @FXML
    public void completeContract(ActionEvent actionEvent) {
        //add money
        game.currentCapital.set(game.getCurrentCapital() + game.currentContract.get().getPayout());
        //get new contract
        game.currentContract.set(new Contract(2));
        //update ui
        //todo: cycle through 10 contracts to win game
        //todo: show win popup
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

        bindDeveloperProgress();

        //bind contract fields
        contract_title.textProperty().bind(game.getContractProperty().flatMap(Contract::getContractNameProperty));
        contract_description.textProperty().bind(game.getContractProperty().flatMap(Contract::getContractDescriptionProperty));
        contract_lines.textProperty().bind(game.getContractProperty().flatMap(Contract::getContractLinesProperty));
        contract_payout.textProperty().bind(game.getContractProperty().flatMap(Contract::getContractPayoutProperty));
        contract_finish.disableProperty().bind(game.getContractProperty().flatMap(Contract::isCompletedProperty));

    }

    private void bindDeveloperProgress() {
        for (int i = 0; i < game.developers.size(); i++) {
            bindNewDeveloper(i);
        }
    }

    //Initialize UI with game values
    @FXML
    private void initialize(){

        //debugging
        //System.out.println("hire_0_name = " + dev_0_name);
        //System.out.println("hire_1_name = " + dev_1_name);
        //System.out.println("hire_2_name = " + dev_2_name);
        //System.out.println("hire_3_name = " + dev_3_name);

        //Initialize Lists
        upgradeCodingSpeed = List.of(levelCodingSpeed_0, levelCodingSpeed_1,
                levelCodingSpeed_2, levelCodingSpeed_3);
        upgradeQualityOfCode = List.of(levelQualityOfCode_0, levelQualityOfCode_1,
                levelQualityOfCode_2, levelQualityOfCode_3);
        developerNames = List.of(dev_0_name, dev_1_name, dev_2_name, dev_3_name);
        developerTitles = List.of(dev_0_level, dev_1_level, dev_2_level, dev_3_level );
        developerSalaries = List.of(dev_0_salary, dev_1_salary, dev_2_salary, dev_3_salary);
        developerGrids = List.of(dev1, dev2, dev3, dev4);
        costCodingSpeed = List.of(dev_0_cost_codeSpeed, dev_1_cost_codeSpeed, dev_2_cost_codeSpeed, dev_3_cost_codeSpeed);
        costQualityOfCode = List.of(dev_0_cost_quality, dev_1_cost_quality, dev_2_cost_quality, dev_3_cost_quality);

        developerProgressBars = List.of(dev_0_progress, dev_1_progress, dev_2_progress, dev_3_progress);
        developerLastWorkLabels = List.of(dev_0_lastWork, dev_1_lastWork, dev_2_lastWork, dev_3_lastWork);

        //UI fields
        initUI();
        //Set company name
        CompName.textProperty().bind(game.companyNameProperty());
        //Set cash
        currentCash.textProperty().bind(game.currentCapital.asString());
        //Set starting day
        currentDay.textProperty().bind(game.currentDay.asString());

        //Add bindings for starting developer
        if(!game.developers.isEmpty()){
            bindNewDeveloper(0);    //position 0
        }

        //Hide other (empty) Devs
        dev2.setVisible(false);
        dev3.setVisible(false);
        dev4.setVisible(false);

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

    private void bindNewDeveloper(int position){
        Developer dev = game.developers.get(position);
        developerNames.get(position).textProperty().bind(dev.getDeveloperNameProperty());
        developerTitles.get(position).textProperty().bind(dev.getDeveloperTitle());
        developerSalaries.get(position).textProperty().bind(dev.getSalaryProperty().asString());
        upgradeCodingSpeed.get(position).textProperty().bind(dev.getCodingSpeedProperty().asString());
        upgradeQualityOfCode.get(position).textProperty().bind(dev.getSuccessRateProperty().asString());
        costCodingSpeed.get(position).textProperty().bind(dev.getcodingSpeed().getNextUpgradeCost().asString());
        costQualityOfCode.get(position).textProperty().bind(dev.getsuccessRate().getNextUpgradeCost().asString());


        developerProgressBars.get(position).progressProperty().bind(dev.getProgress());
        developerLastWorkLabels.get(position).textProperty().bind(dev.getWrittenLinesInLastWorkstepProperty().asString());

    }


    //endregion Code


    //region Animations
    @FXML
    private void flashLabel(Label label){
        //todo: disable button
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
