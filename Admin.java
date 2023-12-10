import java.util.List;

public class Admin extends User {

    private Inventory inventory;

    // Constructor
    public Admin(String username, String password, Inventory inventory) {
        super(username, password);
        this.inventory = inventory;
    }

    // Admin-specific methods

    // Method to create a customer account
    public void createCustomerAccount(List<Customer> customers, String username, String password) {
        // Check if username already exists
        for (Customer customer : customers) {
            if (customer.getUsername().equals(username)) {
                System.out.println("Error: This username already exists");
                return;
            }
        }
        // Create a new customer account
        customers.add(new Customer(username, password));
        System.out.println("Success: Customer account has been created");
    }

    // Method to remove a customer account
    public void removeCustomerAccount(List<Customer> customers, String username) {
        // Iterate through customers to find and remove the account
        for (Customer customer : customers) {
            if (customer.getUsername().equals(username)) {
                customers.remove(customer);
                System.out.println("Success: Customer account has been removed");
                return;
            }
        }
        System.out.println("Error: This username doesn't exist");
    }

    // Method to view inventory
    public void viewInventory() {
        // Assuming Inventory class has a method to list all products, display it
        inventory.listAllProducts();
    }

    // Method to add a product to the inventory
    public void addProduct(String name, double price, int quantity, String teaType, String sweetnessLevel, String milkType, String toppings) {
        Product newProduct = new Product(name, price, quantity, teaType, sweetnessLevel, milkType, toppings);
        inventory.addProduct(newProduct);
    }

    // Method to remove a product from the inventory
    public void removeProduct(String productName) {
        boolean success = inventory.removeProduct(productName);
        if (success) {
            System.out.println("Success: Product has been removed from inventory");
        } else {
            System.out.println("Error: Product does not exist in inventory");
        }
    }

    // Method to restock a product in the inventory
    public void restockProduct(String productName, int newQuantity) {
        boolean success = inventory.restockProduct(productName, newQuantity);
        if (success) {
            System.out.println("Success: Product quantity has been updated");
        } else {
            System.out.println("Error: Product does not exist in inventory");
        }
    }
}
