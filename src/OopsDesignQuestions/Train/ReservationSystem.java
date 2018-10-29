package OopsDesignQuestions.Train;

import OopsDesignQuestions.Train.Payment.PaymentStrategy;

public class ReservationSystem {

    public Ticket reserveTicket(TicketDetails ticketDetails, PaymentStrategy paymentStrategy) {
        Passenger passenger = new Passenger("Shruti", 22, "Female");

        Ticket ticket = new Ticket(123, ticketDetails);

        ticket.calculateFare();
        ticket.pay(paymentStrategy);
        return ticket;
    }

    public void cancelTicket(Ticket ticket, PaymentStrategy paymentStrategy) {
        double afterRefund = ticket.cancelTicket(paymentStrategy);
        System.out.println( " got refund of " + afterRefund);
    }

    public Ticket modifyTicket(Ticket existingTicket, Ticket newTicket, PaymentStrategy paymentStrategy) {
        //modify
        return newTicket;
    }
}
