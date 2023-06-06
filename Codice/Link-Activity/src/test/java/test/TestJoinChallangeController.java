package test;

import linkactivity.linkactivity.*;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestJoinChallangeController {

    /*
        Responsabile test: Alessandro Lori
        Matricola: 0280155
    */

    @Test
    public void testjoinchallange() throws IOExceptionHandler {

        /*
            L'intento del test è quello di controllare se ogni qual volta
            vi sia l'iscrizione di un utente ad una challange il numero di
            posti disponibili per la challange in questione diminuisca di 1.
        */

        int availableSeatsBefore;
        int availableSeatsAfter;

        EventBean eventBean= new EventBean("C++Challange", null, null, null, 0, null, null );
        availableSeatsBefore= EventDAO.getPartecipantNumber(eventBean.getEventName());
        System.out.println(availableSeatsBefore);
        eventBean= new EventBean("C++Challange", null, null, null, availableSeatsBefore, null, null );
        ItemController itemController= new ItemController();
        itemController.joinEvent(eventBean,"remove");
        availableSeatsAfter= EventDAO.getPartecipantNumber(eventBean.getEventName());
        System.out.println(availableSeatsAfter);
        assert(availableSeatsBefore==availableSeatsAfter+1);
        itemController.joinEvent(eventBean,"");

    }


}
