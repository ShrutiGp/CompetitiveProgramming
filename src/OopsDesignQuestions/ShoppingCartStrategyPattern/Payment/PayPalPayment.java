package OopsDesignQuestions.ShoppingCartStrategyPattern.Payment;

public class PayPalPayment implements PaymentStrategy {

    private String username;
    private String password;

    public PayPalPayment(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public void pay(float amount) {
        System.out.print("PayPal payment done");
    }
}

