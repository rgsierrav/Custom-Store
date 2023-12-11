import java.util.*;

public class Customer extends User {
    private double balance;
    private Map<BobaProduct, Integer> shoppingCart; // Changed to Map
    private BobaInventory inventory;

    // Constructor
    public Customer(String username, String password, BobaInventory inventory) {
        super(username, password);
        this.balance = 10.0; // Initialize with $10
        this.shoppingCart = new HashMap<>(); // Initialize as a HashMap
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
                    shopStore(scanner); // Call the method to shop the store
                    break;
                case 2:
                    viewAndCheckoutCart(scanner); // Call the method to view and checkout the shopping cart
                    break;
                case 3:
                    System.out.println("Your balance: $" + balance); // Display the customer's balance
                    break;
                case 4:
                    addBalance(scanner); // Call the method to add balance
                    break;
                case 5:
                    System.out.println("Logging out..."); // Display a logout message
                    break;
                default:
                    System.out.println("Invalid choice. Please try again."); // Display an error message for an invalid choice
            }
        } while (choice != 5);
    }

    private void shopStore(Scanner scanner) {
        // Display the inventory in the desired format
        System.out.println("******** Shop the Store ********");
        for (BobaProduct product : inventory.getProducts()) {
            System.out.println("\nName: " + product.getName());
            System.out.println("Count: " + product.getCount()); // Assuming you have a getCount method
            System.out.printf("Price: $%.2f\n", product.getPrice());
        }
    
        // Get user input for product selection
        System.out.print("\nEnter the product name you want to add to your cart: ");
        String productName = scanner.nextLine();
    
        // Get user input for quantity
        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine(); // Consume the newline left-over
    
        // Find the product and update the cart
        boolean found = false;
        for (BobaProduct product : inventory.getProducts()) {
            if (product.getName().equalsIgnoreCase(productName)) {
                shoppingCart.put(product, shoppingCart.getOrDefault(product, 0) + quantity);
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
    
        System.out.println("******** View and checkout shopping cart ********");
        System.out.println("\nYour balance: $" + String.format("%.2f", balance));
    
        for (Map.Entry<BobaProduct, Integer> entry : shoppingCart.entrySet()) {
            BobaProduct product = entry.getKey();
            int quantity = entry.getValue();
    
            System.out.println("\nName: " + product.getName());
            System.out.println("Count: " + quantity);
            System.out.printf("Price: $%.2f", product.getPrice());
            total += product.getPrice() * quantity;
        }
    
        System.out.println("\n\nTotal: $" + String.format("%.2f", total));
        System.out.print("Checkout (Y/N)? ");
        String choice = scanner.next();
        scanner.nextLine(); // Consume the newline left-over
    
        if ("Y".equalsIgnoreCase(choice)) {
            if (balance >= total) {
                balance -= total; // Deduct the total cost from the balance
                updateInventoryAfterPurchase(); // Update inventory counts
                shoppingCart.clear(); // Clear the shopping cart
                System.out.println("Thank you for shopping at The Cozy Boba Tea Shop!"); // Display a goodbye message
                System.out.println("Your new balance: $" + String.format("%.2f", balance));
            } else {
                System.out.println("Insufficient balance to complete the purchase.");
            }
        }
    }
    
    private void updateInventoryAfterPurchase() {
        for (Map.Entry<BobaProduct, Integer> entry : shoppingCart.entrySet()) {
            BobaProduct product = entry.getKey();
            int quantityPurchased = entry.getValue();
            int newCount = product.getCount() - quantityPurchased;
            product.setCount(newCount); // Update the product count in the inventory
        }
    }
    

    private void addBalance(Scanner scanner) {
        // Generate a simple math question
        int number1 = (int) (Math.random() * 10);
        int number2 = (int) (Math.random() * 10);
        int correctAnswer = number1 + number2;

        System.out.println("Solve the math question to add $10 to your balance:");
        System.out.println("What is " + number1 + " + " + number2 + "?");

        System.out.print("Enter your answer: ");
        int userAnswer = scanner.nextInt();
        scanner.nextLine(); // Consume the newline left-over

        if (userAnswer == correctAnswer) {
            balance += 10; // Add $10 to the balance if the answer is correct
            System.out.println("Correct! $10 has been added to your balance.");
        } else {
            System.out.println("Sorry, that's not correct. The correct answer was " + correctAnswer + ".");
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

    // Getter for shopping cart
    public Map<BobaProduct, Integer> getShoppingCart() {
        return shoppingCart;
    }

    // Setter for shopping cart
    public void setShoppingCart(Map<BobaProduct, Integer> shoppingCart) {
        this.shoppingCart = shoppingCart;
    }
}
