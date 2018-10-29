package OopsDesignQuestions.Train;

import OopsDesignQuestions.Train.Payment.CardPayment;

import java.util.HashMap;
import java.util.Map;

public class MainTrain {
    public static void main(String... args) {

        Map<Station, Double> map = new HashMap<>();
        map.put(new Station(1, "Banaras"), 300.0);
        map.put(new Station(2, "Delhi"), 700.0);
        Train train = new Train("Rajdhani", 12, map);

        ReservationSystem reservationSystem = new ReservationSystem();

        Passenger passenger = new Passenger("Shruti", 22, "Female");


        TicketDetails ticketDetails = new TicketDetails(train, new Station(1, "Banaras"), new Station(2, "Delhi"), passenger);

        Ticket reservedTicket = reservationSystem.reserveTicket(ticketDetails, new CardPayment("232434", "878", "09/22", "Shruti"));

        reservationSystem.cancelTicket(reservedTicket, new CardPayment("232434", "878", "09/22", "Shruti") );
    }
}
