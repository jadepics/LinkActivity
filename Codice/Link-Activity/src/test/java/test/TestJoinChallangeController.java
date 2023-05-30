package test;

import linkactivity.linkactivity.EventBean;
import org.junit.jupiter.api.Test;

public class TestJoinChallangeController {

    /*
        Responsabile test: Alessandro Lori
        Matricola: 0280155
    */

    @Test
    public void testjoinchallange(){
        //TODO chiedere Giada query

        /*
            L'intento del test è quello di controllare se ogni qual volta
            vi sia l'iscrizione di un utente ad una challange il numero di
            posti disponibili per la challange in questione diminuisca di 1.
        */

        int availableSeatsBefore = 0;
        int availableSeatsAfter;

        // query per prendere availableSeatsBefore

        EventBean eventBean= new EventBean("C++ Challange", null, null, null, availableSeatsBefore, null, null );

        // simulazione prenotazione posto chiamando ItemController.joinEvent()

        // query per prendere availableSeatsAfter

        // assert per availabeSeatsAfter == availableSeatsBefore+1

    }

}
