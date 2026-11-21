public abstract class Product implements Comparable<Product> {
    private String name;
    private double price;
    private int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public abstract String getCategory();

    public abstract double getTaxRate();

    public double getStockValueWithTax() {
        return price * (1 + getTaxRate()) * quantity;
    }

    @Override
    public int compareTo(Product other) {
        int priceCompare = Double.compare(this.price, other.price);
        if (priceCompare != 0) {
            return priceCompare;
        }
        return this.name.compareToIgnoreCase(other.name);
    }

    @Override
    public String toString() {
        return String.format("%s: $%.2f, %d in stock", name, price, quantity);
    }
}
