import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<User> users = new ArrayList<>();
    private static Inventory inventory = new Inventory(); // Assuming you have an Inventory class

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        // Pre-creating an admin account for demonstration
        users.add(new Admin("admin", "12345", inventory));

        while (isRunning) {
            System.out.println("******** Welcome to The Boba Shop ********");
            System.out.println("1- Login\n2- Register\n3- Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    handleLogin(scanner);
                    break;
                case 2:
                    handleRegistration(scanner);
                    break;
                case 3:
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }

    private static void handleLogin(Scanner scanner) {
        System.out.print("Enter username: ");
        String username = scanner.next();
        System.out.print("Enter password: ");
        String password = scanner.next();

        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                if (user instanceof Admin) {
                    displayAdminMenu(scanner, (Admin) user);
                } else if (user instanceof Customer) {
                    displayCustomerMenu(scanner, (Customer) user);
                }
                return;
            }
        }
        System.out.println("Invalid username or password");
    }

    private static void handleRegistration(Scanner scanner) {
        System.out.print("Enter username: ");
        String username = scanner.next();
        System.out.print("Enter password: ");
        String password = scanner.next();

        for (User user : users) {
            if (user.getUsername().equals(username)) {
                System.out.println("Error: This username already exists");
                return;
            }
        }

        users.add(new Customer(username, password));
        System.out.println("Success: customer account has been created");
    }

    private static void displayAdminMenu(Scanner scanner, Admin admin) {
        boolean isAdminMenuRunning = true;
        while (isAdminMenuRunning) {
            System.out.println("Admin Menu:");
            System.out.println("1- Create customer account\n2- Remove customer account\n3- View inventory\n4- Add product\n5- Remove product\n6- Restock product\n7- Logout");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    createCustomerAccount(scanner);
                    break;
                case 2:
                    removeCustomerAccount(scanner);
                    break;
                case 3:
                    admin.viewInventory();
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
                    isAdminMenuRunning = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void displayCustomerMenu(Scanner scanner, Customer customer) {
        boolean isCustomerMenuRunning = true;
        while (isCustomerMenuRunning) {
            System.out.println("Customer Menu:");
            System.out.println("1- Shop the store\n2- View and checkout shopping cart\n3- View balance\n4- Add balance\n5- Logout");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    shopStore(scanner, customer);
                    break;
                case 2:
                    viewAndCheckoutCart(scanner, customer);
                    break;
                case 3:
                    System.out.println("Your balance: $" + customer.getBalance());
                    break;
                case 4:
                    addBalance(scanner, customer);
                    break;
                case 5:
                    isCustomerMenuRunning = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Implement the methods createCustomerAccount, removeCustomerAccount, addProduct, removeProduct, restockProduct, shopStore, viewAndCheckoutCart, addBalance here
    private static void createCustomerAccount(Scanner scanner) {
        System.out.print("Enter new username: ");
        String username = scanner.next();
        System.out.print("Enter new password: ");
        String password = scanner.next();
    
        // Check if username already exists
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                System.out.println("Error: This username already exists");
                return;
            }
        }
    
        // Create new customer account
        users.add(new Customer(username, password));
        System.out.println("Success: customer account has been created");
    }

    private static void removeCustomerAccount(Scanner scanner) {
        System.out.print("Enter username to remove: ");
        String username = scanner.next();
    
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUsername().equals(username) && users.get(i) instanceof Customer) {
                users.remove(i);
                System.out.println("Success: customer account has been removed");
                return;
            }
        }
        System.out.println("Error: This username doesn't exist");
    }
    
    private static void addProduct(Scanner scanner) {
        System.out.print("Enter new product name: ");
        String name = scanner.next();
        System.out.print("Enter count: ");
        int count = scanner.nextInt();
        System.out.print("Enter price: ");
        double price = scanner.nextDouble();
    
        Product newProduct = new Product(name, price, count);
    
        // Check if the product already exists in the inventory
        if (inventory.getProduct(name) != null) {
            System.out.println("Error: Product already exists.");
            return;
        }
    
        // Add the new product to the inventory
        inventory.addProduct(newProduct);
        System.out.println("Success: Product has been added to inventory");
    }    
    
    private static void removeProduct(Scanner scanner) {
        System.out.print("Enter product name to remove: ");
        String name = scanner.next();
    
        // Remove the product from the inventory
        if (inventory.removeProduct(name)) {
            System.out.println("Success: Product has been removed from inventory");
        } else {
            System.out.println("Error: Product does not exist in inventory");
        }
    }    
    
    private static void restockProduct(Scanner scanner) {
        System.out.print("Enter product name to restock: ");
        String name = scanner.next();
        System.out.print("Enter new quantity: ");
        int quantity = scanner.nextInt();
    
        if (inventory.restockProduct(name, quantity)) {
            System.out.println("Product restocked successfully.");
        } else {
            System.out.println("Error: Product not found.");
        }
    }
    
    private static void shopStore(Scanner scanner, Customer customer) {
        // Display available products in the inventory
        inventory.listAllProducts();
        
        System.out.print("Enter the product name you want to add to your cart: ");
        String productName = scanner.next();
        
        // Check if the selected product exists in the inventory
        Product selectedProduct = inventory.getProduct(productName);
        if (selectedProduct != null) {
            System.out.print("Enter quantity: ");
            int quantity = scanner.nextInt();
    
            if (quantity <= 0) {
                System.out.println("Error: Quantity must be greater than zero.");
                return;
            }
    
            // Check if there are enough items in the inventory
            if (quantity > selectedProduct.getQuantity()) {
                System.out.println("Error: Not enough items in stock.");
            } else {
                // Add the product to the customer's shopping cart
                customer.getShoppingCart().addItem(selectedProduct, quantity);
                System.out.println("Product added to your shopping cart.");
            }
        } else {
            System.out.println("Error: Product not found in the inventory.");
        }
    }    
    
    private static void viewAndCheckoutCart(Scanner scanner, Customer customer) {
        ShoppingCart cart = customer.getShoppingCart();
        cart.displayCartContents();
        System.out.print("Checkout (Y/N)? ");
        String choice = scanner.next();
    
        if (choice.equalsIgnoreCase("Y")) {
            if (customer.checkout()) {
                System.out.println("Checkout successful. Your new balance: $" + customer.getBalance());
            } else {
                System.out.println("Checkout failed. Insufficient balance.");
            }
        }
    }
    
    private static void addBalance(Scanner scanner, Customer customer) {
        System.out.print("Enter amount to add to your balance: ");
        double amount = scanner.nextDouble();
        customer.addBalance(amount);
        System.out.println("Balance updated. Your new balance: $" + customer.getBalance());
    }    
}
