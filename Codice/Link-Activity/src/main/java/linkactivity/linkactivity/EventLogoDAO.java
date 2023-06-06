package linkactivity.linkactivity;

import java.io.*;

public class EventLogoDAO {

    public static EventModel getLogo(EventModel eventModel) throws IOException {
        String nomeaz= eventModel.getEventModelNomeAzienda();
        File file= new File("src/main/CompanyLogo-Filesystem.txt");

        try(BufferedReader reader = new BufferedReader(new FileReader(file))) {

            String line;
            boolean foundCompany = false;
            String companyString = "";
            StringBuilder sb = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                if (!foundCompany && line.contains(nomeaz)) {
                    companyString = line.substring(line.indexOf(nomeaz) + nomeaz.length() + 1).trim();
                    foundCompany = true;
                } else if (foundCompany) {
                    for (char h : companyString.toCharArray()) {
                        sb.append(h);
                        if (h == '\\') {
                            sb.append('\\');
                        }
                    }
                    break;
                }
            }
            eventModel = new EventModel(String.valueOf(sb)) {
            };
            return eventModel;
        }
    }

    public void insertLogo(String imagePath, CompanyBean companyName) throws IOExceptionHandler {
        String content= companyName.getNomeAzienda() +" " + imagePath;
        try (FileWriter fileWriter = new FileWriter("src/main/CompanyLogo-Filesystem.txt ", true)) {
            fileWriter.write(content);
            fileWriter.write(System.lineSeparator());
        } catch (IOException e) {
            throw new IOExceptionHandler("IOException error");
        }
    }
}
