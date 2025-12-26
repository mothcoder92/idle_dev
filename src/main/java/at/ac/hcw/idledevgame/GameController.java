package at.ac.hcw.idledevgame;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import java.awt.*;

public class GameController {
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
    protected void upgradeCodingSpeed() {
        int lvl = Integer.parseInt(levelCodingSpeed.getText().substring(6));
        lvl++;
        levelCodingSpeed.setText("Stufe " + lvl);
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

}
