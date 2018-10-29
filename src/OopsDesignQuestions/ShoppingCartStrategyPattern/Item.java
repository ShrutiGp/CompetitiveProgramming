package OopsDesignQuestions.ShoppingCartStrategyPattern;

public class Item {

    private String unqId;
    private float price;

    public Item(String unqId, float price) {
        this.unqId = unqId;
        this.price = price;
    }

    public String getUnqId() {
        return unqId;
    }

    public void setUnqId(String unqId) {
        this.unqId = unqId;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
