//import linkactivity.linkactivity.*;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//
//
//public class TestEventCreateController {
//    /*@author Testing: Giada Pica
//            Matricola 0280050
//     */
//
//    private EventBean eventBean;
//    @BeforeEach
//            public void setUp() {
//        eventBean = new EventBean("NomeEvento", "Nuovo Evento Test", "2023-12-11", "2023-12-10", 15, "Apple", "Java");
//
//    }
//    @Test
//    public void testAddEvent() throws DuplicatedEventException, IOExceptionHandler {
//
//
//       EventCreateController eventCreateController1= new EventCreateController();
//       eventCreateController1.newEvent(eventBean);
//        EventDAO eventDAO =new EventDAO();
//        List<EventModel> eventModel;
//      // eventModel =eventDAO.getEventByName("NomeEvento");
//        //while(!(eventModel.isEmpty())) {
//          //  assertNotNull(eventModel);
//
//            //assertEquals(eventBean.getEventName(), eventModel.get(0).getEventModelName());
//        }
//        }
//
//}
