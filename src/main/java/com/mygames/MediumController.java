package com.mygames;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class MediumController {

    @FXML
    private Text displayText;

    @FXML
    private Text scoreText;

    @FXML
    private Rectangle colorRectangle;

    private MediumLogic logic;

    @FXML
    public void initialize() {
        logic = new MediumLogic(this);
        logic.generateRandomNumber();
    }

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("home");
    }

    @FXML
    private void ButtonRedClick() {
        logic.check('1');
    }

    @FXML
    private void ButtonOrangeClick() {
        logic.check('2');
    }

    @FXML
    private void ButtonYellowClick() {
        logic.check('3');
    }

    @FXML
    private void ButtonLimeClick() {
        logic.check('4');
    }

    @FXML
    private void ButtonGreenClick() {
        logic.check('5');
    }

    @FXML
    private void ButtonDarkGreenClick() {
        logic.check('6');
    }

    @FXML
    private void ButtonSkyBlueClick() {
        logic.check('7');
    }

    @FXML
    private void ButtonBlueClick() {
        logic.check('8');
    }

    @FXML
    private void ButtonDarkBlueClick() {
        logic.check('9');
    }

    public void updateDisplayText(String text) {
        displayText.setText(text);
    }

    public void updateScoreText(String text) {
        scoreText.setText(text);
    }

    public void updateRectangleColor(Color color) {
        colorRectangle.setFill(color);
    }
}
