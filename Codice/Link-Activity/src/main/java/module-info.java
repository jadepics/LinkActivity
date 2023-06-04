module linkactivity.linkactivity {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens linkactivity.linkactivity to javafx.fxml;
    exports linkactivity.linkactivity;
    exports linkactivity.linkactivity.pattern.observer;
    opens linkactivity.linkactivity.pattern.observer to javafx.fxml;
    exports linkactivity.linkactivity.pattern.decorator;
    opens linkactivity.linkactivity.pattern.decorator to javafx.fxml;
}