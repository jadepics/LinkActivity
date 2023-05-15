module linkactivity.linkactivity {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
  //  requires org.jetbrains.annotations;


    opens linkactivity.linkactivity to javafx.fxml;
    exports linkactivity.linkactivity;
    exports linkactivity.linkactivity.Observer;
    opens linkactivity.linkactivity.Observer to javafx.fxml;
}