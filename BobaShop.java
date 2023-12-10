import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BobaShop {
    private BobaInventory inventory;
    private List<User> users;
    private User currentUser;

    // Constructor
    public BobaShop() {
        this.inventory = new BobaInventory();
        this.users = new ArrayList<>();
        // Default admin account for demonstration purposes
        this.users.add(new Admin("admin", "12345", inventory, users));
    }

    public void displayCurrentUserDetails() {
        if (currentUser != null) {
            System.out.println("Logged in as: " + currentUser.getUsername());
            // Add more details or functionalities specific to the currentUser
        } else {
            System.out.println("No user is currently logged in.");
        }
    }    

    public void saveData() {
        FileManager.serialize(users, "users.ser");
        FileManager.serialize(inventory, "inventory.ser");
    }    

    // Load data method (to be implemented for serialization/deserialization)
    public void loadData() {
        // Deserialize users
        Object usersData = FileManager.deserialize("users.ser");
        if (usersData instanceof List<?>) {
            List<?> rawList = (List<?>) usersData;
            for (Object o : rawList) {
                if (o instanceof User) {
                    users.add((User) o);
                }
            }
        }
    
        // Deserialize inventory
        Object inventoryData = FileManager.deserialize("inventory.ser");
        if (inventoryData instanceof BobaInventory) {
            inventory = (BobaInventory) inventoryData;
        }
    }      

    // Method for user login
    public void login() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter username: ");
            String username = scanner.nextLine();
            System.out.print("Enter password: ");
            String password = scanner.nextLine();

            for (User user : users) {
                if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                    currentUser = user;
                    user.displayMenu();
                    return;
                }
            }

            System.out.println("Invalid username or password");
        }
    }

    // Method for registering a new customer
    public void register() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter new username: ");
            String username = scanner.nextLine();
            System.out.print("Enter new password: ");
            String password = scanner.nextLine();

            // Check for existing username
            for (User user : users) {
                if (user.getUsername().equals(username)) {
                    System.out.println("Error: Username already exists");
                    return;
                }
            }

            // Create new customer account
            Customer newCustomer = new Customer(username, password, inventory);
            users.add(newCustomer);
            System.out.println("Customer account created successfully");
        }
    }
}
