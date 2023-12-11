import java.util.List;
import java.util.Scanner;

public class Admin extends User {
    private BobaInventory inventory;
    private List<User> users;

    // Constructor
    public Admin(String username, String password, BobaInventory inventory, List<User> users) {
        super(username, password);
        this.inventory = inventory;
        this.users = users;
    }

    // Admin menu
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

    // Admin-specific methods
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
        // Now passing the inventory object along with username and password
        users.add(new Customer(username, password, this.inventory));
        System.out.println("Success: Customer account has been created");
    }   

    private void removeCustomerAccount(Scanner scanner) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        // Find and remove the user
        boolean found = false;
        for (User user : users) {
            if (user.getUsername().equals(username) && user instanceof Customer) {
                users.remove(user);
                found = true;
                System.out.println("Success: Customer account has been removed");
                break;
            }
        }
    
        if (!found) {
            System.out.println("Error: This username doesn't exist");
        }
    }

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

    private void removeProduct(Scanner scanner) {
        System.out.print("Enter product name: ");
        String name = scanner.nextLine();
        System.out.print("Enter size: ");
        String size = scanner.nextLine();
    
        inventory.removeProduct(name, size);
    }      

    private void restockProduct(Scanner scanner) {
        System.out.print("Enter product name: ");
        String name = scanner.nextLine();
        System.out.print("Enter size: ");
        String size = scanner.nextLine();
        System.out.print("Enter additional count: ");

        // Ensuring the input is a valid integer
        while (!scanner.hasNextInt()) {
            System.out.println("Please enter a valid number for additional count.");
            scanner.next(); // Clear the invalid input
            System.out.print("Enter additional count: ");
        }
        int additionalCount = scanner.nextInt();
    
        inventory.restockProduct(name, size, additionalCount);
    }
}       
