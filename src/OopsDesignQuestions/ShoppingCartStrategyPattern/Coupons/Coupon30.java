package OopsDesignQuestions.ShoppingCartStrategyPattern.Coupons;

public class Coupon30 implements Coupon {
    @Override
    public float discount(float total) {
        return total-(total*0.30f);
    }
}
