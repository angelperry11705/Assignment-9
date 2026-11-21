import java.util.ArrayList;
import java.util.Scanner;

public class StoreMain {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Store store = buildStore();

        System.out.println("All products:");
        printProducts(store.getProducts());
        System.out.println();

        System.out.print("Enter a product name to look up: ");
        String name = input.nextLine();
        Product found = store.find(name);
        System.out.println("Lookup result: " + (found == null ? "Not found" : found));
        System.out.println();

        System.out.print("Enter a category: ");
        String category = input.nextLine();
        System.out.println("Products in category \"" + category + "\":");
        printProducts(store.getByCategory(category));
        System.out.println();

        store.sortByPrice();
        System.out.println("All products from cheapest to most expensive:");
        printProducts(store.getProducts());
        System.out.println();

        System.out.println("Cheapest: " + store.cheapest());
        System.out.println("Most expensive: " + store.mostExpensive());
        System.out.println();

        int removed = store.removeSoldOut();
        System.out.println("Sold-out products removed: " + removed);
        System.out.printf("Stock value of remaining products (including tax): $%.2f%n",
                store.getTotalStockValue());

        input.close();
    }

    public static Store buildStore() {
        Store store = new Store();

        store.add(new Grocery("Apples", 2.49, 10, 5));
        store.add(new Grocery("Bread", 2.49, 20, 3));
        store.add(new Grocery("Milk", 3.19, 0, 2));
        store.add(new Electronics("Charger", 19.99, 15, 24));
        store.add(new Electronics("Headphones", 49.99, 5, 12));
        store.add(new Electronics("Mouse", 24.99, 0, 18));
        store.add(new Clothing("T-Shirt", 12.50, 8, "M"));
        store.add(new Clothing("Jeans", 39.99, 4, "32"));
        store.add(new Clothing("Jacket", 59.99, 2, "L"));
        store.add(new Grocery("Eggs", 4.29, 12, 14));

        return store;
    }

    public static void printProducts(ArrayList<Product> products) {
        if (products.isEmpty()) {
            System.out.println("  (none)");
            return;
        }
        for (Product p : products) {
            System.out.println("  " + p);
        }
    }
}
