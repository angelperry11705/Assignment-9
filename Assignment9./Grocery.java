public class Grocery extends Product {
    public static final String CATEGORY = "Grocery";
    public static final double TAX_RATE = 0.0;

    private int daysToExpire;

    public Grocery(String name, double price, int quantity, int daysToExpire) {
        super(name, price, quantity);
        this.daysToExpire = daysToExpire;
    }

    public int getDaysToExpire() {
        return daysToExpire;
    }

    @Override
    public String getCategory() {
        return CATEGORY;
    }

    @Override
    public double getTaxRate() {
        return TAX_RATE;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" (expires in %d days)", daysToExpire);
    }
}
