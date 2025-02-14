module com.mygames {
    requires transitive javafx.controls;
    requires transitive javafx.fxml;

    opens com.mygames to javafx.fxml;
    exports com.mygames;
}