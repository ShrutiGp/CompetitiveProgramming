package OopsDesignQuestions.Train.Payment;

public interface PaymentStrategy {

    public void pay(double amount);
    public void refund(double amount);
}
