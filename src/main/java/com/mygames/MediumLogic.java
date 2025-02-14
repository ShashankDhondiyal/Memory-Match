package com.mygames;

import java.util.ArrayList;

import javafx.scene.paint.Color;

public class MediumLogic {

    private final MediumController controller;
    private int score = 0;
    private ArrayList<Character> gameKey = new ArrayList<>();
    private int currentIndex = 0;

    public MediumLogic(MediumController controller) {
        this.controller = controller;
    }

    public void generateRandomNumber() {
        char randomChar = (char) ('1' + (int)(Math.random() * 9));
        gameKey.add(randomChar);
        displaySequence();
    }

    private void displaySequence() {
        controller.updateScoreText("Score: " + score);
        new Thread(() -> {
            try {
                for (char ch : gameKey) {
                    switch (ch) {
                        case '1':
                            controller.updateRectangleColor(Color.RED);
                            break;
                        case '2':
                            controller.updateRectangleColor(Color.ORANGE);
                            break;
                        case '3':
                            controller.updateRectangleColor(Color.YELLOW);
                            break;
                        case '4':
                            controller.updateRectangleColor(Color.LIME);
                            break;
                        case '5':
                            controller.updateRectangleColor(Color.GREEN);
                            break;
                        case '6':
                            controller.updateRectangleColor(Color.DARKGREEN);
                            break;
                        case '7':
                            controller.updateRectangleColor(Color.SKYBLUE);
                            break;
                        case '8':
                            controller.updateRectangleColor(Color.BLUE);
                            break;
                        case '9':
                            controller.updateRectangleColor(Color.NAVY);
                            break;
                        
                    }
                    Thread.sleep(700);

                    controller.updateRectangleColor(Color.BLACK);
                    Thread.sleep(50); 
                }
                controller.updateRectangleColor(Color.WHITE);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    public void check(char ch) {
        if (ch == gameKey.get(currentIndex)) {
            currentIndex++;
            if (currentIndex == gameKey.size()) {
                score++;
                currentIndex = 0;
                generateRandomNumber();
            }
        } else {
            controller.updateDisplayText("You Lost");
            gameKey.clear();
            currentIndex = 0;
        }
    }
}