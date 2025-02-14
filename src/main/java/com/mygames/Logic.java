package com.mygames;

import java.util.ArrayList;
import javafx.scene.paint.Color;

public class Logic {

    private final SecondaryController controller;
    private int score = 0;
    private ArrayList<Integer> gameKey = new ArrayList<>();
    private int currentIndex = 0;

    public Logic(SecondaryController controller) {
        this.controller = controller;
    }

    public void generateRandomNumber() {
        int randomNumber = (int)(Math.random() * 4) + 1;
        gameKey.add(randomNumber);
        displaySequence();
    }

    private void displaySequence() {
        new Thread(() -> {
            try {
                for (int number : gameKey) {
                    switch (number) {
                        case 1:
                            controller.updateRectangleColor(Color.RED);
                            break;
                        case 2:
                            controller.updateRectangleColor(Color.YELLOW);
                            break;
                        case 3:
                            controller.updateRectangleColor(Color.BLUE);
                            break;
                        case 4:
                            controller.updateRectangleColor(Color.GREEN);
                            break;
                    }
                    Thread.sleep(500);

                    controller.updateRectangleColor(Color.BLACK);
                    Thread.sleep(100); 
                }
                controller.updateRectangleColor(Color.WHITE);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    public void check(int num) {
        if (num == gameKey.get(currentIndex)) {
            currentIndex++;
            if (currentIndex == gameKey.size()) {
                score++;
                controller.updateScoreText("Score: " + score);
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