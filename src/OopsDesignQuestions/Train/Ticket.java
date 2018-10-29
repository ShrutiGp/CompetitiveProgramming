package OopsDesignQuestions.Train;

import OopsDesignQuestions.Train.Payment.PaymentStrategy;

import java.util.Map;

public class Ticket {

    private long ticketNo;
    private TicketDetails ticketDetails;
    private double fare;
    private double cancellationCharges = 20;


    public Ticket(long ticketNo, TicketDetails ticketDetails) {
        this.ticketDetails = ticketDetails;
        this.ticketNo = ticketNo;
    }

    public void calculateFare() {
        Map<Station,Double> map= ticketDetails.getTrain().getStationsWithFares();

        fare = Math.abs(map.get(ticketDetails.getTo()).doubleValue() - map.get(ticketDetails.getFrom()).doubleValue());
        System.out.print("Fare : " + fare);
    }

    public double cancelTicket(PaymentStrategy paymentStrategy) {
        paymentStrategy.refund(fare-cancellationCharges);
        return fare-cancellationCharges;
    }

    public void pay(PaymentStrategy paymentStrategy) {
        paymentStrategy.pay(fare);
    }

    public double getFare() {
        return fare;
    }

    public void setFare(double fare) {
        this.fare = fare;
    }

    public double getCancellationCharges() {
        return cancellationCharges;
    }

    public void setCancellationCharges(double cancellationCharges) {
        this.cancellationCharges = cancellationCharges;
    }
}
