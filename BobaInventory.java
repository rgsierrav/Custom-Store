import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

public class BobaInventory implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<BobaProduct> products;

    public BobaInventory() {
        this.products = new ArrayList<>();
    }

    // Method to add a product to the inventory
    public void addProduct(BobaProduct product) {
        for (BobaProduct existingProduct : products) {
            if (existingProduct.getName().equals(product.getName())) {
                System.out.println("Error: Product already exists in inventory");
                return;
            }
        }
        products.add(product);
        System.out.println("Success: Product has been added to inventory");
    }    

    // Method to remove a product from the inventory
    public boolean removeProduct(String name) {
        int initialSize = products.size();
        products.removeIf(p -> p.getName().equals(name));
        return products.size() < initialSize;
    }    

    // Method to restock a specific product
    public boolean restockProduct(String name, int additionalCount) {
        for (BobaProduct product : products) {
            if (product.getName().equals(name)) {
                product.setCount(product.getCount() + additionalCount);
                return true;
            }
        }
        return false;
    }    

    // Getter to access the list of products
    public List<BobaProduct> getProducts() {
        return products;
    }

    // Method to view all products in the inventory
    public void viewInventory() {
        System.out.println("******** View Inventory ********");
        for (BobaProduct product : products) {
            System.out.println("\nName: " + product.getName());
            System.out.println("Count: " + product.getCount());
            System.out.printf("Price: $%.2f\n", product.getPrice());
        }
    }
}
