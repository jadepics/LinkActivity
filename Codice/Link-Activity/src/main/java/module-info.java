module linkactivity.linkactivity {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
  //  requires org.jetbrains.annotations;


    opens linkactivity.linkactivity to javafx.fxml;
    exports linkactivity.linkactivity;
    exports linkactivity.linkactivity.Pattern.Observer;
    opens linkactivity.linkactivity.Pattern.Observer to javafx.fxml;
    exports linkactivity.linkactivity.Pattern.Decorator;
    opens linkactivity.linkactivity.Pattern.Decorator to javafx.fxml;
}