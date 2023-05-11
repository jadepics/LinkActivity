package linkactivity.linkactivity;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class MainClass extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("ChooseInterface.fxml")));
        Scene scene = new Scene(root, 690, 518);

        stage.setTitle("Link-Activity");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}

//TODO tutte le funzioni che tornano ad una stessa pagina fxml sono codice ripetuto, per risolvere forse si potrebbe
// usare il singleton, fare una classe normale che gestisce la creazione magari protected che viene estesa
// non dovrebbe andare bene


//TODO crere nelle dao funzionalità nuova riga azienda per i filesystem qual'ora azienda x decide di registrarsi alla
// piattaforma (azienda nuova)

//TODO ca to cg e viceversa comunicano SOLO tramite Bean niente stringhe singole, controllare e cambiarle tutte
// ca e DAO e viceversa comunicano SOLO tramite Model niente stringhe singole, controllare e cambiarle tutte