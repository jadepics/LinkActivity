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

    @Override
    protected void updateItem(/*infoView*/EventBean item, boolean empty) {
        super.updateItem(item, empty);
        if (item != null) {
            try {
                System.out.println("eccomi3");
                if (parentNode == null) {
                    parentNode = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Singolo.fxml")));
                    System.out.println("eccomi5");
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
                //System.out.println(c+"1212212212121212121323412133214");

                BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Reliq\\Desktop\\ISPW\\1Progetto\\Codice\\Codice\\Link-Activity\\src\\main\\CompanyLogo-Filesystem.txt"));

                String line;
                boolean foundIBM = false;
                String ibmString = "";
                StringBuilder sb = new StringBuilder();

                // Lettura del file riga per riga
                while ((line = reader.readLine()) != null) {
                    // Se la riga contiene "IBM", copia la stringa successiva
                    if (!foundIBM && line.contains(nomeaz)) {
                        ibmString = line.substring(line.indexOf(nomeaz) + nomeaz.length()+1).trim();
                        foundIBM = true;
                    } else if (foundIBM) {
                        // Scandisce la stringa per cercare il carattere "\" e aggiunge un secondo "\"

                        for (char h : ibmString.toCharArray()) {
                            sb.append(h);
                            if (h == '\\') {
                                sb.append('\\');
                            }
                        }
                        System.out.println("Stringa con caratteri \\ raddoppiati: " + sb.toString());
                        break; // Esce dal ciclo while
                    }
                }

                reader.close();


                /*String company = "";

                try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Reliq\\Desktop\\ISPW\\1Progetto\\Codice\\Codice\\Link-Activity\\src\\main\\CompanyLogo-Filesystem.txt"))) {
                    String line;
                    while ((line = br.readLine()) != null) {
                        int index = line.indexOf(c);
                        if (index != -1) {
                            company = line.substring(index + 4);
                            int spaceIndex = company.indexOf(' ');
                            int newlineIndex = company.indexOf('\n');
                            int endIndex = spaceIndex == -1 ? newlineIndex : Math.min(spaceIndex, newlineIndex);
                            if (endIndex != -1) {
                                company = company.substring(0, endIndex);
                            }
                            break;
                        }
                    }
                }

                System.out.println(company);

                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < company.length(); i++) {
                    char h = company.charAt(i);
                    if (h == '\\') {
                        sb.append(h);
                    }
                    sb.append(h);
                }
                System.out.println(sb +" qwqwqwqwqwqqwqwqwqwqqwqw");
                */

                String ttt= String.valueOf(sb);
                System.out.println(ttt);
                System.out.println(ibmString);
                //Image imm= new Image("C:\\Users\\Reliq\\Desktop\\ISPW\\1Progetto\\\\Codice\\Codice\\Link-Activity\\src\\main\\resources\\linkactivity\\linkactivity\\Images\\IBM.png");
                Image imm= new Image("file:"+ ttt);
                immToChange.setImage(imm);

                /*try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Reliq\\Desktop\\ISPW\\1Progetto\\Codice\\Codice\\Link-Activity\\src\\main\\CompanyLogo-Filesystem.txt"))) {
                    String line;
                    boolean found = false;
                    while ((line = br.readLine()) != null) {
                        if (found) {
                            String[] words = line.split("\\s+");
                            System.out.println(words[0]+"rrrrrarrrrrrrrrrraraaaaaaaaaa");
                            break;
                        } else if (line.startsWith("IBM")) {
                            found = true;
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }*/

                /*if(item.getEventName().equals("ciao")) {
                    String x = "C:\\Users\\Reliq\\Desktop\\ISPW\\1Progetto\\Codice\\Codice\\Link-Activity\\src\\main\\resources\\linkactivity\\linkactivity\\Images\\IBM.png";
                    Image imm = new Image(x);
                    immToChange.setImage(imm);
                } else {
                    String y= "C:\\Users\\Reliq\\Desktop\\ISPW\\1Progetto\\Codice\\Codice\\Link-Activity\\src\\main\\resources\\linkactivity\\linkactivity\\Images\\IBM.png";
                    Image imm= new Image(y);
                    immToChange.setImage(imm);
                }*/

                i++;

                System.out.println("ciaoneeeeSSSS");
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