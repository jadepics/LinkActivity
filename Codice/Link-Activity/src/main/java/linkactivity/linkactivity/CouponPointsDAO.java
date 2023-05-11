package linkactivity.linkactivity;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CouponPointsDAO {

    public static void addPoints(String nomeaz, String todo, int quantity) throws FileNotFoundException {

        try {
            // Apertura del file di testo
            File file = new File("C:\\Users\\Reliq\\Desktop\\ISPW\\1Progetto\\LinkActivity\\Codice\\Link-Activity\\src\\main\\CompanyCoupon-Filesystem.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));

            String line;
            StringBuilder result = new StringBuilder();
            int updatedNumber;

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
                        if(todo.equals("add")){
                            updatedNumber = number + 100;
                        } else {
                            updatedNumber= number-quantity;
                        }

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

    public static int getCurrentPoints(String nomeaz) { //TODO forse cambiare con una bean
        int points = 0; // Variabile per salvare il valore di "pts="

        try {
            // Apertura del file di testo
            File file = new File("C:\\Users\\Reliq\\Desktop\\ISPW\\1Progetto\\LinkActivity\\Codice\\Link-Activity\\src\\main\\CompanyCoupon-Filesystem.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));

            String line;

            // Lettura del file riga per riga
            while ((line = reader.readLine()) != null) {
                if (line.contains(nomeaz)) {
                    // Se la riga contiene la stringa cercata, cerca "pts=" e legge il valore successivo
                    int index = line.indexOf("pts=");
                    if (index >= 0) {
                        int startIndex = index + 4;
                        int endIndex = line.indexOf(' ', startIndex);
                        if (endIndex < 0) {
                            endIndex = line.length();
                        }
                        String numberString = line.substring(startIndex, endIndex);
                        points = Integer.parseInt(numberString);
                        break; // Esci dal ciclo una volta trovato il valore di "pts="
                    }
                }
            }

            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return points;
    }

    public static void redeemCoupon(String nomeaz, int points){
        String s;
        if(points==300){
            s= "cp1=";
        } else if(points==550){
            s="cp2=";
        } else {
            s="cp3=";
        }

        try {
            // Apertura del file di testo
            File file = new File("C:\\Users\\Reliq\\Desktop\\ISPW\\1Progetto\\LinkActivity\\Codice\\Link-Activity\\src\\main\\CompanyCoupon-Filesystem.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));

            String line;
            StringBuilder updatedContent = new StringBuilder();

            // Lettura del file riga per riga
            while ((line = reader.readLine()) != null) {
                if (line.contains(nomeaz)) {
                    // Se la riga contiene la stringa cercata, cerca "cp1=" e aggiorna il valore successivo
                    int index = line.indexOf(s);
                    if (index >= 0) {
                        int startIndex = index + 4;
                        int endIndex = line.indexOf(' ', startIndex);
                        if (endIndex < 0) {
                            endIndex = line.length();
                        }
                        String numberString = line.substring(startIndex, endIndex);
                        int number = Integer.parseInt(numberString);
                        number += 1;
                        line = line.substring(0, startIndex) + number + line.substring(endIndex);
                    }
                }
                updatedContent.append(line).append("\n");
            }

            reader.close();

            // Aggiornamento del file con il contenuto modificato
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(updatedContent.toString());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Integer> getAvailableCoupons(String nomeaz){ //TODO replace List<int> con model di coupon

        List<Integer> coupList = new ArrayList<>();

        try {
            // Apertura del file di testo
            File file = new File("C:\\Users\\Reliq\\Desktop\\ISPW\\1Progetto\\LinkActivity\\Codice\\Link-Activity\\src\\main\\CompanyCoupon-Filesystem.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));

            String line;

            // Lettura del file riga per riga
            while ((line = reader.readLine()) != null) {
                if (line.contains(nomeaz)) {
                    // Se la riga contiene la stringa cercata, cerca i numeri successivi a "cp1=", "cp2=" e "cp3="
                    int index = line.indexOf("cp1=");
                    if (index >= 0) {
                        int startIndex = index + 4;
                        int endIndex = line.indexOf(' ', startIndex);
                        if (endIndex < 0) {
                            endIndex = line.length();
                        }
                        String numberString = line.substring(startIndex, endIndex);
                        int number = Integer.parseInt(numberString);
                        assert coupList != null;
                        coupList.add(number);
                    }

                    index = line.indexOf("cp2=");
                    if (index >= 0) {
                        int startIndex = index + 4;
                        int endIndex = line.indexOf(' ', startIndex);
                        if (endIndex < 0) {
                            endIndex = line.length();
                        }
                        String numberString = line.substring(startIndex, endIndex);
                        int number = Integer.parseInt(numberString);
                        assert coupList != null;
                        coupList.add(number);
                    }

                    index = line.indexOf("cp3=");
                    if (index >= 0) {
                        int startIndex = index + 4;
                        int endIndex = line.indexOf(' ', startIndex);
                        if (endIndex < 0) {
                            endIndex = line.length();
                        }
                        String numberString = line.substring(startIndex, endIndex);
                        int number = Integer.parseInt(numberString);
                        assert coupList != null;
                        coupList.add(number);
                    }
                }
            }

            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(coupList.get(2)+"eooooooooooooooooo");
        return coupList;
    }

}