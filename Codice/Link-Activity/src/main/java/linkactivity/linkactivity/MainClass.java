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


                        /*CouponApplier instance = new CouponApplier(new Priceable() {
                            @Override
                            public Double getPrice() {
                                return 10.0;
                            }
                        }) ;
                        instance.getFinalPrice() ;
                        */
//TODO risolvere errore quando utente si logga, partecipa e usa filtri (errore out of bound ma non so il perche)

//TODO qualsiasi errore di input tipo aggiungere un evento con campi vuoti o registrazione o login vanno risolti

//TODO ENORME rifare tutte le classi che sono in static non static, vedere esempio in EventCreateController riga 94
// metodi delle DAO vanno bene static, metodi del controller applicativo dipende dal caso, INFORMARSI