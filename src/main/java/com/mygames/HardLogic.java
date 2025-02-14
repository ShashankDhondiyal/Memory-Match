package com.mygames;

import java.util.ArrayList;
import java.util.Random;
import javafx.scene.paint.Color;
import javafx.scene.control.Button;

public class HardLogic {

    private final HardController controller;
    private int score = 0;
    private ArrayList<Character> gameKey = new ArrayList<>();
    private int currentIndex = 0;
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOQRSTUVWXYZ$0123456789";

    public HardLogic(HardController controller) {
        this.controller = controller;
    }

    public void generateRandomNumber() {
        Random random = new Random();
        char randomChar = CHARACTERS.charAt(random.nextInt(CHARACTERS.length()));
        gameKey.add(randomChar);
        displaySequence();
    }

    private void displaySequence() {
        controller.updateScoreText("Score: " + score);
        new Thread(() -> {
            try {
                for (char ch : gameKey) {
                    Button button = getButtonByChar(ch);
                    if (button != null) {
                        Color color = controller.getButtonColor(button);
                        controller.updateRectangleColor(color);
                    }
                    Thread.sleep(500);

                    controller.updateRectangleColor(Color.BLACK);
                    Thread.sleep(50); 
                }
                controller.updateRectangleColor(Color.WHITE);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    private Button getButtonByChar(char ch) {
        switch (ch) {
            case 'A': return controller.buttonA;
            case 'B': return controller.buttonB;
            case 'C': return controller.buttonC;
            case 'D': return controller.buttonD;
            case 'E': return controller.buttonE;
            case 'F': return controller.buttonF;
            case 'G': return controller.buttonG;
            case 'H': return controller.buttonH;
            case 'I': return controller.buttonI;
            case 'J': return controller.buttonJ;
            case 'K': return controller.buttonK;
            case 'L': return controller.buttonL;
            case 'M': return controller.buttonM;
            case 'N': return controller.buttonN;
            case 'O': return controller.buttonO;
            case 'P': return controller.buttonP;
            case 'Q': return controller.buttonQ;
            case 'R': return controller.buttonR;
            case 'S': return controller.buttonS;
            case 'T': return controller.buttonT;
            case 'U': return controller.buttonU;
            case 'V': return controller.buttonV;
            case 'W': return controller.buttonW;
            case 'X': return controller.buttonX;
            case 'Y': return controller.buttonY;
            case 'Z': return controller.buttonZ;
            case '$': return controller.button$;
            case '0': return controller.button0;
            case '1': return controller.button1;
            case '2': return controller.button2;
            case '3': return controller.button3;
            case '4': return controller.button4;
            case '5': return controller.button5;
            case '6': return controller.button6;
            case '7': return controller.button7;
            case '8': return controller.button8;
            case '9': return controller.button9;
            default: return null;
        }
    }

    public void check(char ch) {
        if (ch == gameKey.get(currentIndex)) {
            currentIndex++;
            if (currentIndex == gameKey.size()) {
                score++;
                currentIndex = 0;
                controller.resetTimer();
                generateRandomNumber();
            }
        } else {
            controller.updateDisplayText("You Lost");
            controller.setTimerToMax();
            gameKey.clear();
            currentIndex = 0;
        }
    }

    public void timeOut() {
        controller.updateDisplayText("You Lost");
        gameKey.clear();
        currentIndex = 0;
    }
}