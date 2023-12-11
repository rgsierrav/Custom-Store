import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BobaShop {
    private BobaInventory inventory;
    private List<User> users;
    private User currentUser;

    // Constructor to initialize the BobaShop
    public BobaShop() {
        this.inventory = new BobaInventory(); // Initialize the inventory
        initializeDefaultInventory(); // Initialize default inventory items
        this.users = new ArrayList<>(); // Initialize the list of users
    
        File usersFile = new File("users.ser");
        if (!usersFile.exists()) {
            // Initialize default users only if users.ser does not exist
            users.add(new Admin("admin", "12345", inventory, users, this));
            users.add(new Customer("BobaFan", "BobaFan1", this.inventory));
        }
        loadData(); // Load data after initialization
    }     

    // Initialize default inventory items
    private void initializeDefaultInventory() {
        // Add default products to the inventory
        this.inventory.addProduct(new BobaProduct("Brown Sugar Boba", "Small", 10, 5.99));
        this.inventory.addProduct(new BobaProduct("Thai Boba", "Medium", 20, 9.99));
        this.inventory.addProduct(new BobaProduct("Matcha Boba", "Large", 15, 12.99));
    }

    // Display the details of the current user
    public void displayCurrentUserDetails() {
        if (currentUser != null) {
            System.out.println("Logged in as: " + currentUser.getUsername());
            // Add more details or functionalities specific to the currentUser if needed
        } else {
            System.out.println("No user is currently logged in.");
        }
    }

    // Save user and inventory data to files
    public void saveData() {
        FileManager.serialize(users, "users.ser"); // Serialize and save user data
        FileManager.serialize(inventory, "inventory.ser"); // Serialize and save inventory data
    }

    // Load user and inventory data from files
    public void loadData() {
        File usersFile = new File("users.ser");
        File inventoryFile = new File("inventory.ser");
    
        if (usersFile.exists()) {
            Object usersData = FileManager.deserialize("users.ser");
            if (usersData instanceof List<?>) {
                users.clear(); // Clear existing users before adding deserialized ones
                List<?> rawList = (List<?>) usersData;
                for (Object o : rawList) {
                    if (o instanceof User) {
                        users.add((User) o);
                    }
                }
            }
        }
    
        if (inventoryFile.exists()) {
            Object inventoryData = FileManager.deserialize("inventory.ser");
            if (inventoryData instanceof BobaInventory) {
                inventory = (BobaInventory) inventoryData;
            }
        }
    }    

    // Method for user login
    public void login(Scanner scanner) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                currentUser = user;
                user.displayMenu(scanner); // Display the user-specific menu
                return;
            }
        }

        System.out.println("Invalid username or password");
    }

    // Method for registering a new customer
    public void register(Scanner scanner) {
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

        // Create a new customer account
        Customer newCustomer = new Customer(username, password, inventory);
        users.add(newCustomer);
        System.out.println("Customer account created successfully");
    }
}