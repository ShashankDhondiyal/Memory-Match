package com.mygames;

import java.io.IOException;

import javafx.fxml.FXML;

public class HomeController {
   public HomeController() {
   }

   @FXML
   private void switchToEasy() throws IOException {
      App.setRoot("easy");
   }

   @FXML
   private void switchToMedium() throws IOException {
      App.setRoot("Medium");
   }

   @FXML
   private void switchToHard() throws IOException {
      App.setRoot("Hard");
   }
}
