public class Admin extends User {
    public Admin(String username, String password) {
        super(username, password);
    }

    @Override
    public void displayMenu() {
        // Implementation of admin menu
    }

    // Admin-specific methods
    public void createCustomerAccount(/* parameters */) {
        // Implementation
    }

    public void removeCustomerAccount(/* parameters */) {
        // Implementation
    }

    // Other admin functionalities...
}
