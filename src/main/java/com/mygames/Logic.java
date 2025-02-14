package com.mygames;

public class Logic {

    private final SecondaryController controller;
    private int randomNumber;
    private int score = 0;

    public Logic(SecondaryController controller) {
        this.controller = controller;
    }

    public void generateRandomNumber() {
        randomNumber = (int)(Math.random() * 4) + 1;

        switch (randomNumber) {
            case 1:
                controller.updateDisplayText("Red");
                break;
            case 2:
                controller.updateDisplayText("Yellow");
                break;
            case 3:
                controller.updateDisplayText("Green");
                break;
            case 4:
                controller.updateDisplayText("Blue");
                break;
        }
    }

    public void check(int num) {
        if (num == randomNumber) {
            score++;
            generateRandomNumber();
        } else {
            controller.updateDisplayText("You Lost\nYour score: " + score);
        }
    }
}