package OopsDesignQuestions.Train;

public class TicketDetails {
    private Train train;
    private Station to;
    private Station from;
    private Passenger passenger;

    public TicketDetails(Train train, Station to, Station from, Passenger passenger) {
        this.train = train;
        this.to = to;
        this.from = from;
        this.passenger = passenger;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public Station getTo() {
        return to;
    }

    public void setTo(Station to) {
        this.to = to;
    }

    public Station getFrom() {
        return from;
    }

    public void setFrom(Station from) {
        this.from = from;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

}
