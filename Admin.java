import java.util.List;
import java.util.Scanner;
import java.util.Iterator;

public class Admin extends User {
    private static final long serialVersionUID = 1L;
    private transient BobaInventory inventory; // Marked as transient if BobaInventory is not serializable
    private List<User> users; // Ensure User class is serializable

    // Constructor
    public Admin(String username, String password, BobaInventory inventory, List<User> users) {
        super(username, password);
        this.inventory = inventory;
        this.users = users;
    }

    // Display the admin menu and handle admin-specific actions
    @Override
    public void displayMenu(Scanner scanner) {
        int choice;

        do {
            System.out.println("* Admin Menu *");
            System.out.println("1- Create a customer account");
            System.out.println("2- Remove a customer account");
            System.out.println("3- View inventory");
            System.out.println("4- Add a product");
            System.out.println("5- Remove a product");
            System.out.println("6- Restock a product");
            System.out.println("7- Logout");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline left-over

            switch (choice) {
                case 1:
                    createCustomerAccount(scanner);
                    break;
                case 2:
                    removeCustomerAccount(scanner);
                    break;
                case 3:
                    inventory.viewInventory();
                    break;
                case 4:
                    addProduct(scanner);
                    break;
                case 5:
                    removeProduct(scanner);
                    break;
                case 6:
                    restockProduct(scanner);
                    break;
                case 7:
                    System.out.println("Logging out...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 7);
    }

    // Create a new customer account
    private void createCustomerAccount(Scanner scanner) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        // Check if username already exists
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                System.out.println("Error: This username already exists");
                return;
            }
        }

        // Check password length (5 characters as per requirement)
        if (password.length() != 5) {
            System.out.println("Error: Password should be exactly 5 characters");
            return;
        }

        // Creating and adding the new customer account
        users.add(new Customer(username, password, this.inventory));
        System.out.println("Success: Customer account has been created");
    }

    // Remove a customer account
    private void removeCustomerAccount(Scanner scanner) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        // Find and remove the user
        Iterator<User> iterator = users.iterator();
        boolean found = false;
        while (iterator.hasNext()) {
            User user = iterator.next();
            if (user.getUsername().equals(username) && user instanceof Customer) {
                iterator.remove(); // Safely remove the user
                found = true;
                System.out.println("Success: Customer account has been removed");
                break;
            }
        }

        if (!found) {
            System.out.println("Error: This username doesn't exist");
        }
    }

    // Add a new product to the inventory
    private void addProduct(Scanner scanner) {
        System.out.print("Enter new product name: ");
        String name = scanner.nextLine();
        System.out.print("Enter size: ");
        String size = scanner.nextLine();
        System.out.print("Enter price: ");
        double price = scanner.nextDouble();
        System.out.print("Enter count: ");
        int count = scanner.nextInt();

        BobaProduct newProduct = new BobaProduct(name, size, count, price);
        inventory.addProduct(newProduct);
    }

    // Remove a product from the inventory
    private void removeProduct(Scanner scanner) {
        System.out.print("Enter product name: ");
        String name = scanner.nextLine();
        System.out.print("Enter size: ");
        String size = scanner.nextLine();

        inventory.removeProduct(name, size);
    }

    // Restock an existing product in the inventory
    private void restockProduct(Scanner scanner) {
        System.out.print("Enter product name: ");
        String name = scanner.nextLine();
        System.out.print("Enter size: ");
        String size = scanner.nextLine();
        System.out.print("Enter additional count: ");

        // Ensure the input is a valid integer
        while (!scanner.hasNextInt()) {
            System.out.println("Please enter a valid number for additional count.");
            scanner.next(); // Clear the invalid input
            System.out.print("Enter additional count: ");
        }
        int additionalCount = scanner.nextInt();

        inventory.restockProduct(name, size, additionalCount);
    }
}
