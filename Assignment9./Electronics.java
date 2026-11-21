public class Electronics extends Product {
    public static final String CATEGORY = "Electronics";
    public static final double TAX_RATE = 0.08;

    private int warrantyMonths;

    public Electronics(String name, double price, int quantity, int warrantyMonths) {
        super(name, price, quantity);
        this.warrantyMonths = warrantyMonths;
    }

    public int getWarrantyMonths() {
        return warrantyMonths;
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
        return super.toString() + String.format(" (%d-month warranty)", warrantyMonths);
    }
}
