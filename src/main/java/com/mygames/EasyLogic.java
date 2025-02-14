package com.mygames;

import java.util.ArrayList;
import javafx.scene.paint.Color;

public class EasyLogic {

    private final EasyController controller;
    private int score = 0;
    private ArrayList<Character> gameKey = new ArrayList<>();
    private int currentIndex = 0;

    public EasyLogic(EasyController controller) {
        this.controller = controller;
    }

    public void generateRandomNumber() {
        char randomChar = (char) ('1' + (int)(Math.random() * 4));
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
                            controller.updateRectangleColor(Color.YELLOW);
                            break;
                        case '3':
                            controller.updateRectangleColor(Color.BLUE);
                            break;
                        case '4':
                            controller.updateRectangleColor(Color.GREEN);
                            break;
                    }
                    Thread.sleep(750);

                    controller.updateRectangleColor(Color.BLACK);
                    Thread.sleep(300); 
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
            controller.updateDisplayText("You Lost\nYour score: " + score);
            gameKey.clear();
            currentIndex = 0;
        }
    }
}