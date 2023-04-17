package linkactivity.linkactivity;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class AddThingsListCellFactory extends ListCell<EventBean> {
    private Parent parentNode = null;
    private int i=0;


    //TODO FARE DAO PER ACCEDERE AL FILESYSTEM:
    // cg chiama ca chiama dao ritorna ca parsa stringa ritorna a cg che al mercato mio padre comprò
    public StringBuilder parseSlash(String nomeaz) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Reliq\\Desktop\\ISPW\\1Progetto\\LinkActivity\\Codice\\Link-Activity\\src\\main\\CompanyLogo-Filesystem.txt"));

        String line;
        boolean foundCompany = false;
        String companyString = "";
        StringBuilder sb = new StringBuilder();

        // Lettura del file riga per riga
        while ((line = reader.readLine()) != null) {
            // Se la riga contiene "IBM", copia la stringa successiva
            if (!foundCompany && line.contains(nomeaz)) {
                companyString = line.substring(line.indexOf(nomeaz) + nomeaz.length()+1).trim();
                foundCompany = true;
            } else if (foundCompany) {
                // Scandisce la stringa per cercare il carattere "\" e aggiunge un secondo "\"

                for (char h : companyString.toCharArray()) {
                    sb.append(h);
                    if (h == '\\') {
                        sb.append('\\');
                    }
                }
                break;
            }
        }
        reader.close();
        return sb;
    }

    @Override
    protected void updateItem(EventBean item, boolean empty) {
        super.updateItem(item, empty);
        if (item != null) {
            try {
                if (parentNode == null) {
                    parentNode = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Singolo.fxml")));
                }
                Text titleText = (Text) parentNode.lookup("#" + "titleText") ;
                Text descriptionText = (Text) parentNode.lookup("#" + "descriptionText") ;
                Text eventDateText = (Text) parentNode.lookup("#" + "eventDateText");
                Text expirationDateText= (Text) parentNode.lookup("#"+"expirationDateText");
                Text participantNumberText= (Text) parentNode.lookup("#"+"participantNumberText");
                Text tagText= (Text) parentNode.lookup("#"+"tagText");
                ImageView immToChange= (ImageView) parentNode.lookup("#"+"immToChange");

                titleText.setText(item.getEventName());
                descriptionText.setText(item.getDescription());
                eventDateText.setText(String.valueOf(item.getDataEvento()));
                expirationDateText.setText(String.valueOf(item.getExpirationDate()));
                participantNumberText.setText(String.valueOf(item.getPartecipantNumber()));
                tagText.setText(item.getTag());

                String nomeaz= item.getNomeAzienda();
                StringBuilder sb= parseSlash(nomeaz);

                String ttt= String.valueOf(sb);
                //Image imm= new Image("C:\\Users\\Reliq\\Desktop\\ISPW\\1Progetto\\\\Codice\\Codice\\Link-Activity\\src\\main\\resources\\linkactivity\\linkactivity\\Images\\IBM.png");
                Image imm= new Image("file:"+ ttt);
                immToChange.setImage(imm);

                i++;

                setGraphic(parentNode);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {
            setGraphic(null);
        }
    }
}