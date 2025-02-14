package com.mygames;

import java.io.IOException;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.util.Duration;

public class HardController {

    @FXML
    private Text displayText;

    @FXML
    private Text scoreText;

    @FXML
    private Rectangle colorRectangle;

    @FXML
    private ProgressBar timer;

    @FXML
    public Button buttonA, buttonB, buttonC, buttonD, buttonE, buttonF, buttonG, buttonH, buttonI, buttonJ, buttonK, buttonL, buttonM, buttonN, buttonO, buttonP, buttonQ, buttonR, buttonS, buttonT, buttonU, buttonV, buttonW, buttonX, buttonY, buttonZ, button$, button0, button1, button2, button3, button4, button5, button6, button7, button8, button9;

    private HardLogic logic;
    private Timeline timeline;

    @FXML
    public void initialize() {
        logic = new HardLogic(this);
        logic.generateRandomNumber();
        startTimer();
    }

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("home");
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

    public void startTimer() {
        timer.setProgress(0);
        timeline = new Timeline(
            new KeyFrame(Duration.seconds(1), event -> {
                double progress = timer.getProgress() + 0.2;
                timer.setProgress(progress);
                if (progress >= 1) {
                    timeline.stop();
                    logic.timeOut();
                }
            })
        );
        timeline.setCycleCount(5);
        timeline.play();
    }

    public void resetTimer() {
        if (timeline != null) {
            timeline.stop();
        }
        startTimer();
    }

    public void setTimerToMax() {
        if (timeline != null) {
            timeline.stop();
        }
        timer.setProgress(1);
    }

    public Color getButtonColor(Button button) {
        String style = button.getStyle();
        String colorString = style.substring(style.indexOf("-fx-background-color:") + 22, style.indexOf(";"));
        return Color.web(colorString.trim());
    }

    @FXML
    private void ButtonAClick() {
        logic.check('A');
    }

    @FXML
    private void ButtonBClick() {
        logic.check('B');
    }

    @FXML
    private void ButtonCClick() {
        logic.check('C');
    }

    @FXML
    private void ButtonDClick() {
        logic.check('D');
    }
    @FXML
    private void ButtonEClick() {
        logic.check('E');
    }

    @FXML
    private void ButtonFClick() {
        logic.check('F');
    }

    @FXML
    private void ButtonGClick() {
        logic.check('G');
    }

    @FXML
    private void ButtonHClick() {
        logic.check('H');
    }
    
    @FXML
    private void ButtonIClick() {
        logic.check('I');
    }

    @FXML
    private void ButtonJClick() {
        logic.check('J');
    }

    @FXML
    private void ButtonKClick() {
        logic.check('K');
    }

    @FXML
    private void ButtonLClick() {
        logic.check('L');
    }
    @FXML
    private void ButtonMClick() {
        logic.check('M');
    }

    @FXML
    private void ButtonNClick() {
        logic.check('N');
    }

    @FXML
    private void ButtonOClick() {
        logic.check('O');
    }

    @FXML
    private void ButtonPClick() {
        logic.check('P');
    }

    @FXML
    private void ButtonQClick() {
        logic.check('Q');
    }

    @FXML
    private void ButtonRClick() {
        logic.check('R');
    }

    @FXML
    private void ButtonSClick() {
        logic.check('S');
    }

    @FXML
    private void ButtonTClick() {
        logic.check('T');
    }
    @FXML
    private void ButtonUClick() {
        logic.check('U');
    }

    @FXML
    private void ButtonVClick() {
        logic.check('V');
    }

    @FXML
    private void ButtonWClick() {
        logic.check('W');
    }

    @FXML
    private void ButtonXClick() {
        logic.check('X');
    }
    
    @FXML
    private void ButtonYClick() {
        logic.check('Y');
    }

    @FXML
    private void ButtonZClick() {
        logic.check('Z');
    }

    @FXML
    private void Button$Click() {
        logic.check('$');
    }

    @FXML
    private void Button0Click() {
        logic.check('0');
    }
    @FXML
    private void Button1Click() {
        logic.check('1');
    }

    @FXML
    private void Button2Click() {
        logic.check('2');
    }

    @FXML
    private void Button3Click() {
        logic.check('3');
    }

    @FXML
    private void Button4Click() {
        logic.check('4');
    }

    @FXML
    private void Button5Click() {
        logic.check('5');
    }

    @FXML
    private void Button6Click() {
        logic.check('6');
    }

    @FXML
    private void Button7Click() {
        logic.check('7');
    }

    @FXML
    private void Button8Click() {
        logic.check('8');
    }

    @FXML
    private void Button9Click() {
        logic.check('9');
    }
}
