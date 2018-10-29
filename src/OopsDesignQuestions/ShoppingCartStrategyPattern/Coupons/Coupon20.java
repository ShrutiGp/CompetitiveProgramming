package OopsDesignQuestions.ShoppingCartStrategyPattern.Coupons;

public class Coupon20 implements Coupon{

    @Override
    public float discount(float total) {
        return total-(total*0.20f);
    }
}
