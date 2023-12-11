import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Customer extends User {
    private double balance;
    private List<BobaProduct> shoppingCart;
    private BobaInventory inventory;

    public Customer(String username, String password, BobaInventory inventory) {
        super(username, password);
        this.balance = 0;
        this.shoppingCart = new ArrayList<>();
        this.inventory = inventory;
    }

    @Override
    public void displayMenu(Scanner scanner) {
        int choice;
        do {
            System.out.println("* Customer Menu *");
            System.out.println("1- Shop the store");
            System.out.println("2- View and checkout shopping cart");
            System.out.println("3- View balance");
            System.out.println("4- Add balance");
            System.out.println("5- Logout");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline left-over

            switch (choice) {
                case 1:
                    shopStore(scanner);
                    break;
                case 2:
                    viewAndCheckoutCart(scanner);
                    break;
                case 3:
                    System.out.println("Your balance: $" + balance);
                    break;
                case 4:
                    addBalance(scanner);
                    break;
                case 5:
                    System.out.println("Logging out...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);
    }

    private void shopStore(Scanner scanner) {
        inventory.viewInventory();
    
        System.out.print("Enter the product name you want to add to your cart: ");
        String productName = scanner.nextLine();
        System.out.print("Enter size: ");
        String size = scanner.nextLine();
        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine(); // Consume the newline left-over
    
        // Find the product in inventory and add to the shopping cart
        boolean found = false;
        for (BobaProduct product : inventory.getProducts()) {
            if (product.getName().equals(productName) && product.getSize().equals(size)) {
                for (int i = 0; i < quantity; i++) {
                    shoppingCart.add(product);
                }
                found = true;
                System.out.println("Success: The product has been added to your shopping cart");
                break;
            }
        }
    
        if (!found) {
            System.out.println("Error: Product not found in inventory");
        }
    }    

    private void viewAndCheckoutCart(Scanner scanner) {
        double total = 0;
    
        System.out.println("Your balance: $" + balance);
        for (BobaProduct product : shoppingCart) {
            System.out.println(product);
            total += product.getPrice();
        }
    
        System.out.println("Total: $" + total);
        System.out.print("Checkout (Y/N)? ");
        String choice = scanner.next();
        scanner.nextLine(); // Consume the newline left-over
    
        if ("Y".equalsIgnoreCase(choice)) {
            if (balance >= total) {
                balance -= total;
                shoppingCart.clear();
                System.out.println("Thank you for shopping at The Detective Conan Store");
                System.out.println("Your new balance: $" + balance);
            } else {
                System.out.println("Insufficient balance to complete the purchase.");
            }
        }
    }    

    private void addBalance(Scanner scanner) {
        int secretNumber = (int) (Math.random() * 10) + 1; // Secret number between 1 and 10
        System.out.println("Guess a number between 1 and 10 to add $100 to your balance!");
    
        System.out.print("Enter your guess: ");
        int guess = scanner.nextInt();
        scanner.nextLine(); // Consume the newline left-over
    
        if (guess == secretNumber) {
            balance += 100; // Add $100 to balance if guessed correctly
            System.out.println("Congratulations! You guessed correctly. $100 has been added to your balance.");
        } else {
            System.out.println("Sorry, that's not correct. The correct number was " + secretNumber + ".");
        }
    
        System.out.println("Your new balance is: $" + balance);
    }    

    // Getters and setters for balance and shopping cart
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public List<BobaProduct> getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(List<BobaProduct> shoppingCart) {
        this.shoppingCart = shoppingCart;
    }
}
