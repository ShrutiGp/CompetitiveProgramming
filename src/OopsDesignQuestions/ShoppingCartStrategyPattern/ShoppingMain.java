package OopsDesignQuestions.ShoppingCartStrategyPattern;

import OopsDesignQuestions.ShoppingCartStrategyPattern.Coupons.Coupon20;
import OopsDesignQuestions.ShoppingCartStrategyPattern.Payment.CardPayment;

public class ShoppingMain {

    public static void main(String... args) {

        ShoppingCart cart = new ShoppingCart();

        cart.addItems(new Item("A", 10.2f));
        cart.addItems(new Item("B", 12.2f));

        System.out.println(cart.getTotal());
        cart.pay(new CardPayment("3456", "818", "09/22", "Shruti Gupta"));

        System.out.println("Apply coupon 20");
        System.out.println(cart.applyCoupon(new Coupon20()));
    }
}
