package com.mygames;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class SecondaryController {

    @FXML
    private Text displayText;

    @FXML
    private Text scoreText;

    @FXML
    private Rectangle colorRectangle;

    private Logic logic;

    @FXML
    public void initialize() {
        logic = new Logic(this);
        logic.generateRandomNumber();
    }

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }

    @FXML
    private void ButtonRedClick() {
        logic.check(1);
    }

    @FXML
    private void ButtonYellowClick() {
        logic.check(2);
    }

    @FXML
    private void ButtonGreenClick() {
        logic.check(3);
    }

    @FXML
    private void ButtonBlueClick() {
        logic.check(4);
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
