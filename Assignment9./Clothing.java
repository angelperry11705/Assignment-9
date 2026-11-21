public class Clothing extends Product {
    public static final String CATEGORY = "Clothing";
    public static final double TAX_RATE = 0.06;

    private String size;

    public Clothing(String name, double price, int quantity, String size) {
        super(name, price, quantity);
        this.size = size;
    }

    public String getSize() {
        return size;
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
        return super.toString() + String.format(" (size %s)", size);
    }
}
