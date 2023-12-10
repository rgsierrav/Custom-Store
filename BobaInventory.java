import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BobaInventory {
    private List<BobaProduct> products;

    public BobaInventory() {
        this.products = new ArrayList<>();
        // Add default products
        this.products.add(new BobaProduct("Brown Sugar Boba", "Small", 10, 5.99));
        this.products.add(new BobaProduct("Thai Boba", "Medium", 20, 9.99));
        this.products.add(new BobaProduct("Matcha Boba", "Large", 15, 12.99));
    }

    // Method to add a product to the inventory
    public void addProduct(BobaProduct product) {
        // Check if the product already exists in the inventory
        for (BobaProduct existingProduct : products) {
            if (existingProduct.getName().equals(product.getName()) && existingProduct.getSize().equals(product.getSize())) {
                System.out.println("Error: Product already exists in inventory");
                return;
            }
        }

        products.add(product);
        System.out.println("Success: Product has been added to inventory");
    }

    // Method to remove a product from the inventory
    public void removeProduct(String name, String size) {
        products = products.stream()
                .filter(p -> !(p.getName().equals(name) && p.getSize().equals(size)))
                .collect(Collectors.toList());
        System.out.println("Success: Product has been removed from inventory");
    }

    // Method to restock a specific product
    public void restockProduct(String name, String size, int additionalCount) {
        for (BobaProduct product : products) {
            if (product.getName().equals(name) && product.getSize().equals(size)) {
                product.setCount(product.getCount() + additionalCount);
                System.out.println("Success: Product has been restocked");
                return;
            }
        }
        System.out.println("Error: Product not found in inventory");
    }

    public List<BobaProduct> getProducts() {
    return products;
    }

    // Method to view all products in the inventory
    public void viewInventory() {
        if (products.isEmpty()) {
            System.out.println("Inventory is empty");
        } else {
            for (BobaProduct product : products) {
                System.out.println(product);
            }
        }
    }
}