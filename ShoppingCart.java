import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class ShoppingCart {
    private Map<Product, Integer> items;

    // Constructor
    public ShoppingCart() {
        this.items = new HashMap<>();
    }

    // Method to add an item to the cart
    public void addItem(Product product, int quantity) {
        if (items.containsKey(product)) {
            items.put(product, items.get(product) + quantity);
        } else {
            items.put(product, quantity);
        }
        System.out.println("Added " + quantity + " of " + product.getName() + " to the cart.");
    }

    // Method to remove an item from the cart
    public void removeItem(Product product) {
        if (items.containsKey(product)) {
            items.remove(product);
            System.out.println("Removed " + product.getName() + " from the cart.");
        } else {
            System.out.println("Product not found in the cart.");
        }
    }

    // Method to calculate the total cost of items in the cart
    public double calculateTotal() {
        double total = 0.0;
        for (Entry<Product, Integer> entry : items.entrySet()) {
            total += entry.getKey().getPrice() * entry.getValue();
        }
        return total;
    }

    // Method to clear the cart
    public void clear() {
        items.clear();
        System.out.println("The shopping cart has been cleared.");
    }

    // Method to display cart contents
    public void displayCartContents() {
        if (items.isEmpty()) {
            System.out.println("The shopping cart is empty.");
        } else {
            System.out.println("Shopping Cart:");
            for (Entry<Product, Integer> entry : items.entrySet()) {
                Product product = entry.getKey();
                int quantity = entry.getValue();
                System.out.println("Product: " + product.getName() + ", Quantity: " + quantity + ", Price: $" + product.getPrice());
            }
        }
    }

    // Additional methods related to shopping cart management can be added
    // ...

    // Getters and Setters if needed
    // ...
}
