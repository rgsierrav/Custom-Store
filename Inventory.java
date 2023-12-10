import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private Map<String, Product> products;

    // Constructor
    public Inventory() {
        this.products = new HashMap<>();
    }

    // Method to add a product to the inventory
    public void addProduct(Product product) {
        if (products.containsKey(product.getName())) {
            System.out.println("Error: product already exists in inventory");
        } else {
            products.put(product.getName(), product);
            System.out.println("Success: Product has been added to inventory");
        }
    }

    // Method to remove a product from the inventory
    public void removeProduct(String productName) {
        if (products.containsKey(productName)) {
            products.remove(productName);
            System.out.println("Success: Product has been removed from inventory");
        } else {
            System.out.println("Error: product does not exist in inventory");
        }
    }

    // Method to update a product's quantity
    public void updateProductQuantity(String productName, int newQuantity) {
        if (products.containsKey(productName)) {
            Product product = products.get(productName);
            product.setQuantity(newQuantity);
            System.out.println("Success: Product quantity has been updated");
        } else {
            System.out.println("Error: product does not exist in inventory");
        }
    }

    // Method to display all products in the inventory
    public void listAllProducts() {
        if (products.isEmpty()) {
            System.out.println("Inventory is empty");
        } else {
            for (Product product : products.values()) {
                product.displayInfo();
            }
        }
    }

    // Additional methods related to inventory management can be added
    // ...

    // Getters and Setters if needed
    // ...
}
