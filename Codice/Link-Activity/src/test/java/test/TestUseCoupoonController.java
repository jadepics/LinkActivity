package test;

import linkactivity.linkactivity.CompanyBean;
import linkactivity.linkactivity.CouponBean;
import linkactivity.linkactivity.EventCreateController;
import linkactivity.linkactivity.IOExceptionHandler;
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
    public void testusecoupon() throws IOExceptionHandler {
        File file = new File("src/main/CompanyCoupon-Filesystem.txt");
        CompanyBean companyBean = new CompanyBean("Apple");
        CouponBean couponBean= new CouponBean(5.0);
        List<CouponBean> couponBeans= new ArrayList<>();
        couponBeans.add(couponBean);
        int coupNumberBefore;
        int coupNumberAfter;
        String cp1String= "cp1=";
        String nomeaz= "Apple";

        coupNumberBefore= TestRedeemCouponController.ausfunct(cp1String,nomeaz,file);
        EventCreateController.removeCoupon(couponBeans, companyBean);
        coupNumberAfter= TestRedeemCouponController.ausfunct(cp1String, nomeaz, file);
        assert(coupNumberBefore==coupNumberAfter+1);
        TestRedeemCouponController.originalfile(cp1String,nomeaz,file,1);
    }
}
