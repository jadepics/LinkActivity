package linkactivity.linkactivity;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CouponPointsDAO {

            //TODO creare funzione sottrazione coupon usati a coupon disponibili

    private static final File file= new File("src/main/CompanyCoupon-Filesystem.txt");

    public static void addPoints(CompanyModel company, String todo, int quantity) throws FileNotFoundException {
        String nomeaz= company.getCompanyNomeaz();

        try {
            // Apertura del file di testo
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
                        if(todo.equals("add")){ //TODO passare questo if e il relativo else in una funz dedicata (costo comp)
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

    public static int getCurrentPoints(CompanyModel company) { //TODO forse cambiare int con una bean
        String nomeaz= company.getCompanyNomeaz();
        int points = 0; // Variabile per salvare il valore di "pts="

        try {
            // Apertura del file di testo
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
                        if (endIndex < 0) { //TODO passare questo if e il relativo else in una funz dedicata (costo comp)
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

    public static void redeemCoupon(CompanyModel company, int points){
        String nomeaz= company.getCompanyNomeaz();

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

    public static List<Integer> getAvailableCoupons(CompanyModel company){ //TODO replace List<Integer> con model di coupon
        String nomeaz= company.getCompanyNomeaz();
        List<Integer> coupList = new ArrayList<>();

        try {
            // Apertura del file di testo
            BufferedReader reader = new BufferedReader(new FileReader(file));

            String line;

            // Lettura del file riga per riga
            while ((line = reader.readLine()) != null) {
                if (line.contains(nomeaz)) {
                    // Se la riga contiene la stringa cercata, cerca i numeri successivi a "cp1=", "cp2=" e "cp3="
                    List<Integer> index= new ArrayList<>();
                    index.add(line.indexOf("cp1="));
                    index.add(line.indexOf("cp2="));
                    index.add(line.indexOf("cp3="));

                    for(int i=0; i<=2; i++){
                        if (index.get(i) >= 0) {
                            int startIndex = index.get(i) + 4;
                            int endIndex = line.indexOf(' ', startIndex);
                            if (endIndex < 0) {
                                endIndex = line.length();
                            }
                            String numberString = line.substring(startIndex, endIndex);
                            int number = Integer.parseInt(numberString);
                            coupList.add(number);
                        }
                    }
                }
            }

            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return coupList;
    }

    public static void removeCoupons(List<CouponModel> couponModels, CompanyModel y) {
        String nomeaz = y.getCompanyNomeaz();
        List<Integer> numbers = new ArrayList<>(List.of(0, 0, 0)); // Esempio di lista di interi
        int i = 0;
        int j;

        while (i < couponModels.size()) {
            if (couponModels.get(i).getCouponDiscount().equals(5.0)) {
                j = numbers.get(0);
                j = j + 1;
                numbers.set(0, j);
            } else if (couponModels.get(i).getCouponDiscount().equals(10.0)) {
                j = numbers.get(1);
                j = j + 1;
                numbers.set(1, j);
            } else {
                j = numbers.get(2);
                j = j + 1;
                numbers.set(2, j);
            }
            i++;
        }
        System.out.println(numbers + " pirirurururu");

        String filePath = "src/main/CompanyCoupon-Filesystem.txt"; // Percorso del file da leggere

        try {
            File file = new File(filePath);
            BufferedReader reader = new BufferedReader(new FileReader(file));
            StringBuilder sb = new StringBuilder();
            String line;
            boolean foundSearchString = false;

            while ((line = reader.readLine()) != null) {
                if (line.contains(nomeaz)) {
                    foundSearchString = true;
                    String[] tokens = line.split(" ");

                    for (int g = 0; g < tokens.length; g++) {
                        if (tokens[g].startsWith("cp1=")) {
                            int number = Integer.parseInt(tokens[g].substring(4));
                            number -= numbers.get(0);
                            tokens[g] = "cp1=" + number;
                        } else if (tokens[g].startsWith("cp2=")) {
                            int number = Integer.parseInt(tokens[g].substring(4));
                            number -= numbers.get(1);
                            tokens[g] = "cp2=" + number;
                        } else if (tokens[g].startsWith("cp3=")) {
                            int number = Integer.parseInt(tokens[g].substring(4));
                            number -= numbers.get(2);
                            tokens[g] = "cp3=" + number;
                        }
                    }

                    line = String.join(" ", tokens);
                }

                sb.append(line).append(System.lineSeparator());
            }

            reader.close();

            // Sovrascrive il file originale con le modifiche
            FileWriter writer = new FileWriter(file);
            writer.write(sb.toString());
            writer.close();

            System.out.println("File modificato con successo.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void insertNewAzienda(String nomeAzienda) {
        String content= nomeAzienda +": pts=0 - cp1=0 - cp2=0 - cp3=0";
        try (FileWriter fileWriter = new FileWriter("src/main/CompanyCoupon-Filesystem.txt", true)) {
            fileWriter.write(content);
            fileWriter.write(System.lineSeparator());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}