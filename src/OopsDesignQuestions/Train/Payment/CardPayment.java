package OopsDesignQuestions.Train.Payment;

public class CardPayment implements PaymentStrategy {

    private String cardNumber;
    private String cvv;
    private String dateOfExpiry;
    private String name;

    public CardPayment(String cardNumber, String cvv, String dateOfExpiry, String name) {
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.dateOfExpiry = dateOfExpiry;
        this.name = name;
    }

    @Override
    public void pay(double amount) {
        System.out.print("Card payment complete");
    }
    public void refund(double amount) {System.out.print("Card refund complete");}
}
