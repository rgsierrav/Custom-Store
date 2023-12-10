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
                    // Implement create customer account
                    break;
                case 2:
                    // Implement remove customer account
                    break;
                case 3:
                    admin.viewInventory();
                    break;
                case 4:
                    // Implement add product
                    break;
                case 5:
                    // Implement remove product
                    break;
                case 6:
                    // Implement restock product
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
                    // Implement shop the store
                    break;
                case 2:
                    // Implement view and checkout shopping cart
                    break;
                case 3:
                    System.out.println("Your balance: $" + customer.getBalance());
                    break;
                case 4:
                    // Implement add balance
                    break;
                case 5:
                    isCustomerMenuRunning = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
