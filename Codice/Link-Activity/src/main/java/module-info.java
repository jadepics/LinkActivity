module linkactivity.linkactivity {
    requires javafx.controls;
    requires javafx.fxml;


    opens linkactivity.linkactivity to javafx.fxml;
    exports linkactivity.linkactivity;
}