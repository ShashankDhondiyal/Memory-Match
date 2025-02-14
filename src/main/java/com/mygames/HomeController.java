package com.mygames;

import java.io.IOException;
import javafx.fxml.FXML;

public class HomeController {
   public HomeController() {
   }

   @FXML
   private void switchToSecondary() throws IOException {
      App.setRoot("easy");
   }
}
