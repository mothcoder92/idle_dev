package at.ac.hcw.idledevgame;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class GameController {
    @FXML
    private Label levelCodingSpeed;

    @FXML
    private Label levelQualityOfCode;

    @FXML
    protected void upgradeCodingSpeed() {
        int lvl =  Integer.parseInt(levelCodingSpeed.getText().substring(6));
        lvl++;
        levelCodingSpeed.setText("Stufe " + lvl);
    }

    @FXML
    protected void upgradeQualityOfCode() {
        int lvl =  Integer.parseInt(levelQualityOfCode.getText().substring(6));
        lvl++;
        levelQualityOfCode.setText("Stufe " + lvl);
    }
}
