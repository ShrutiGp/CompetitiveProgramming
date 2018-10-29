package OopsDesignQuestions.Train.Payment;

public class PayPalPayment implements PaymentStrategy {

    private String username;
    private String password;

    public PayPalPayment(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public void pay(double amount) {
        System.out.print("PayPal payment done");
    }
    public void refund(double amount) {System.out.print("PayPal refund complete");}
}

