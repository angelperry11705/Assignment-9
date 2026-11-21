import java.util.ArrayList;
import java.util.Collections;

public class Store {
    private ArrayList<Product> products;

    public Store() {
        products = new ArrayList<Product>();
    }

    public void add(Product p) {
        if (p == null) {
            throw new NullPointerException();
        }
        products.add(p);
    }

    public int size() {
        return products.size();
    }

    public Product find(String name) {
        for (Product p : products) {
            if (p.getName().equalsIgnoreCase(name)) {
                return p;
            }
        }
        return null;
    }

    public ArrayList<Product> getByCategory(String category) {
        ArrayList<Product> result = new ArrayList<Product>();
        for (Product p : products) {
            if (p.getCategory().equalsIgnoreCase(category)) {
                result.add(p);
            }
        }
        return result;
    }

    public double getTotalStockValue() {
        double total = 0.0;
        for (Product p : products) {
            total += p.getStockValueWithTax();
        }
        return total;
    }

    public void sortByPrice() {
        Collections.sort(products);
    }

    public Product cheapest() {
        if (products.isEmpty()) {
            return null;
        }
        return Collections.min(products);
    }

    public Product mostExpensive() {
        if (products.isEmpty()) {
            return null;
        }
        return Collections.max(products);
    }

    public int removeSoldOut() {
        int removed = 0;
        for (int i = products.size() - 1; i >= 0; i--) {
            if (products.get(i).getQuantity() == 0) {
                products.remove(i);
                removed++;
            }
        }
        return removed;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }
}
