package test;

import linkactivity.linkactivity.CompanyBean;
import linkactivity.linkactivity.EventCreateController;
import linkactivity.linkactivity.IOExceptionHandler;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TestRedeemCouponController {

    /*
        Responsabile testing: Alessandro Lori
        Matricola: 0280155
    */

    private static final String iomessage= "IOException error";

    @Test
    public void testredeemcoupon() throws FileNotFoundException, IOExceptionHandler {

        /*
            L'intento del test è verificare che ogni qual volta
            l'azieda riscatta un coupon tramite l'uso di punti accumulati
            quest'ultimo venga accreditato correttamente nel filesystem.
        */

        File file = new File("src/main/CompanyCoupon-Filesystem.txt");
        CompanyBean companyBean = new CompanyBean("Apple");
        int coupNumberBefore;
        int coupNumberAfter;
        int pts = 300;
        String cp1String= "cp1=";
        String nomeaz = "Apple";


        coupNumberBefore= ausfunct(cp1String,nomeaz,file);
        EventCreateController.removePoints(companyBean,pts);
        coupNumberAfter=ausfunct(cp1String,nomeaz,file);
        assert(coupNumberBefore==coupNumberAfter-1);
        originalfile(cp1String,nomeaz,file,0);
    }

    public static void originalfile(String cp1String, String nomeaz, File file, int i) throws IOExceptionHandler {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            StringBuilder sb = new StringBuilder();
            String line;
            int updatedNumber;

            while ((line = br.readLine()) != null) {
                if (line.contains(nomeaz)) {
                    int cp1Index = line.indexOf(cp1String);
                    if (cp1Index != -1) {
                        String numberString = line.substring(cp1Index + cp1String.length()).split("\\s+")[0];
                        int number = Integer.parseInt(numberString);
                        if(i==0){
                            updatedNumber = number - 1;
                        } else {
                            updatedNumber= number + 1;
                        }

                        line = line.replace(cp1String + numberString, cp1String + updatedNumber);
                    }
                }
                sb.append(line).append("\n");
            }
            writefile(sb, file);
        } catch (IOException e) {
            throw new IOExceptionHandler(iomessage);
        }
    }

    public static void writefile(StringBuilder sb, File file) throws IOExceptionHandler {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            bw.write(sb.toString());
        } catch (IOException e) {
            throw new IOExceptionHandler(iomessage);
        }
    }

    public static int ausfunct(String cp1String, String nomeaz, File file) throws IOExceptionHandler {
        int coupNumber=0;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = br.readLine()) != null) {
                if (line.contains(nomeaz)) {
                    int cp1Index = line.indexOf(cp1String);
                    if (cp1Index != -1) {
                        String numberString = line.substring(cp1Index + cp1String.length()).split("\\s+")[0];
                        coupNumber = Integer.parseInt(numberString);
                        break;
                    }
                }
            }

        } catch (IOException e) {
            throw new IOExceptionHandler(iomessage);
        }

        return coupNumber;
    }

}





