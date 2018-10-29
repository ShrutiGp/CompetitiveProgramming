package OopsDesignQuestions.ShoppingCartStrategyPattern;

import OopsDesignQuestions.ShoppingCartStrategyPattern.Coupons.Coupon;
import OopsDesignQuestions.ShoppingCartStrategyPattern.Payment.PaymentStrategy;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    List<Item> list = new ArrayList<>();
    private float total = 0.0f;
    public ShoppingCart() {

    }

    public void addItems(Item item) {
        list.add(item);
    }

    public void removeItem(Item item) {
        list.remove(item);
    }

    public float getTotal() {
        for(Item item: list) {
            total += item.getPrice();
        }
        return total;
    }

    public void pay(PaymentStrategy paymentStrategy) {
        paymentStrategy.pay(total);
    }

    public float applyCoupon(Coupon coupon) {
        total = coupon.discount(total);
        return total;
    }

}
