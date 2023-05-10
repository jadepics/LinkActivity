package linkactivity.linkactivity;

import java.io.*;

public class CouponPointsDAO {

    public static void addPoints(String nomeaz) throws FileNotFoundException {

        try {
            // Apertura del file di testo
            File file = new File("C:\\Users\\Reliq\\Desktop\\ISPW\\1Progetto\\LinkActivity\\Codice\\Link-Activity\\src\\main\\CompanyCoupon-Filesystem.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));

            String line;
            StringBuilder result = new StringBuilder();

            // Lettura del file riga per riga
            while ((line = reader.readLine()) != null) {
                if (line.contains(nomeaz)) {
                    // Se la riga contiene la stringa cercata, cerca "pts=" e aggiorna il valore successivo
                    int index = line.indexOf("pts=");
                    if (index >= 0) {
                        int startIndex = index + 4;
                        int endIndex = line.indexOf(' ', startIndex);
                        if (endIndex < 0) {
                            endIndex = line.length();
                        }
                        String numberString = line.substring(startIndex, endIndex);
                        int number = Integer.parseInt(numberString);
                        int updatedNumber = number + 100;
                        String updatedLine = line.substring(0, startIndex) + updatedNumber + line.substring(endIndex);
                        result.append(updatedLine);
                    } else {
                        result.append(line);
                    }
                } else {
                    result.append(line);
                }
                result.append("\n");
            }

            reader.close();

            // Sovrascrittura del file con il contenuto modificato
            FileWriter writer = new FileWriter(file);
            writer.write(result.toString());
            writer.close();

            System.out.println("Operazione completata.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}