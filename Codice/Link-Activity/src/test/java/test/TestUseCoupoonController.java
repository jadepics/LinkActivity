package test;

import linkactivity.linkactivity.CompanyBean;
import linkactivity.linkactivity.CouponBean;
import linkactivity.linkactivity.EventCreateController;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TestUseCoupoonController {
    /*
        Responsabile testing: Alessandro Lori
        Matricola: 0280155
    */

    @Test
    public void testusecoupon(){
        File file = new File("src/main/CompanyCoupon-Filesystem.txt");
        CompanyBean companyBean = new CompanyBean("Apple");
        CouponBean couponBean= new CouponBean(5.0);
        List<CouponBean> couponBeans= new ArrayList<>();
        couponBeans.add(couponBean);
        int coupNumberBefore;
        int coupNumberAfter;
        String cp1String= "cp1=";
        String nomeaz= "Apple";

        coupNumberBefore= ausfunct(cp1String,nomeaz,file);
        EventCreateController.removeCoupon(couponBeans, companyBean);
        coupNumberAfter= ausfunct(cp1String, nomeaz, file);
        assert(coupNumberBefore==coupNumberAfter+1);
        originalfile(cp1String,nomeaz,file);
    }

    public void originalfile(String cp1String, String nomeaz, File file){
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            StringBuilder sb = new StringBuilder();
            String line;

            while ((line = br.readLine()) != null) {
                if (line.contains(nomeaz)) {
                    int cp1Index = line.indexOf(cp1String);
                    if (cp1Index != -1) {
                        String numberString = line.substring(cp1Index + cp1String.length()).split("\\s+")[0];
                        int number = Integer.parseInt(numberString);
                        int updatedNumber = number + 1;
                        line = line.replace(cp1String + numberString, cp1String + updatedNumber);
                    }
                }
                sb.append(line).append("\n");
            }
            writefile(sb, file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void writefile(StringBuilder sb,File file){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            bw.write(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int ausfunct(String cp1String, String nomeaz, File file){
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
            e.printStackTrace();
        }

        return coupNumber;
    }

}
