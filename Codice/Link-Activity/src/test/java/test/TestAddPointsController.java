package test;

import linkactivity.linkactivity.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestAddPointsController {

    /*
        Responsabile test: Alessandro Lori
        Matricola: 0280155
    */

    @Test
    public void testaddpoints() throws IOExceptionHandler, IOException {

        /*
            L'intento del test è quello di controllare se ogni qual volta
            vi sia il pagamento di una challange da parte di un'azienda
            vengano accreditati i punti correttamente nel filesystem.
        */
        CouponBean couponBean;
        int currentPointsBefore;
        int currentPointsAfter;
        CompanyBean companyBean= new CompanyBean("Apple");

        EventCreateController eventCreateController= new EventCreateController();
        couponBean= eventCreateController.getCurrentPoints(companyBean);
        currentPointsBefore= couponBean.getPoints();
        eventCreateController.addPoints(companyBean, "add");
        couponBean= eventCreateController.getCurrentPoints(companyBean);
        currentPointsAfter= couponBean.getPoints();
        assert(currentPointsBefore+100==currentPointsAfter);
        eventCreateController.addPoints(companyBean, "remove");
    }


}
