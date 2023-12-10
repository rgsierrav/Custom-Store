public class Customer extends User {
    private double balance;
    // Define a shopping cart structure

    public Customer(String username, String password) {
        super(username, password);
        this.balance = 0; // Default balance
    }

    @Override
    public void displayMenu() {
        // Implementation of customer menu
    }

    // Customer-specific methods
    public void shopStore(/* parameters */) {
        // Implementation
    }

    public void viewAndCheckoutCart(/* parameters */) {
        // Implementation
    }

    // Other customer functionalities...
}
