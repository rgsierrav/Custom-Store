import java.util.Scanner;
import java.util.Random;

public class Customer extends User {
    private ShoppingCart shoppingCart;
    private double balance;

    // Constructor initializes a customer with a username, password, an empty shopping cart, and a default balance of 0.0
    public Customer(String username, String password) {
        super(username, password);
        this.shoppingCart = new ShoppingCart();
        this.balance = 0.0; // Initial balance can be set to a default value
    }

    // Customer-specific methods

    // Method for shopping in the store
    public void shop(Inventory inventory, String productName, int quantity) {
        Product product = inventory.getProduct(productName);
        if (product != null && quantity <= product.getQuantity()) {
            double totalCost = product.getPrice() * quantity;
            if (this.balance >= totalCost) {
                addToCart(product, quantity);
            } else {
                System.out.println("Insufficient balance to add this product to the cart.");
            }
        } else {
            System.out.println("Product not found or insufficient quantity in inventory.");
        }
    }

    // Method to add an item to the shopping cart
    public void addToCart(Product product, int quantity) {
        shoppingCart.addItem(product, quantity);
        System.out.println("Success: The product has been added to your shopping cart");
    }

    // Method to remove an item from the shopping cart
    public void removeFromCart(Product product) {
        shoppingCart.removeItem(product);
        System.out.println("The product has been removed from your shopping cart");
    }

    // Method to checkout
    public boolean checkout() {
        double totalCost = shoppingCart.calculateTotal();
        if (balance >= totalCost) {
            balance -= totalCost;
            System.out.println("Checkout successful. Total cost: $" + totalCost);
            shoppingCart.clear();
            return true;
        } else {
            System.out.println("Checkout failed. Insufficient balance.");
            return false;
        }
    }  

    // Method to view balance
    public double getBalance() {
        return balance;
    }

    // Method to add balance
    public void addBalance(double amount) {
        if (amount > 0) {
            this.balance += amount;
            System.out.println("Your balance has been updated. New balance: $" + balance);
        } else {
            System.out.println("Error: Cannot add a negative amount to balance.");
        }
    }    

    // Getters and Setters
    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void viewCart() {
        shoppingCart.displayCartContents();
    }
    
    public void playBalanceGame(Scanner scanner) {
        Random random = new Random();
        int winningNumber = random.nextInt(10) + 1; // Random number between 1 and 10
        int numberOfTries = 3; // Number of attempts the customer gets
        double rewardAmount = 100.0; // Reward for guessing correctly

        System.out.println("Guess the number (between 1 and 10) to win $" + rewardAmount + "!");
        for (int i = 0; i < numberOfTries; i++) {
            System.out.print("Enter your guess: ");
            int userGuess = scanner.nextInt();

            if (userGuess == winningNumber) {
                System.out.println("Congratulations! You've guessed the number!");
                this.balance += rewardAmount;
                System.out.println("Your balance has been updated. New balance: $" + this.balance);
                return;
            } else {
                System.out.println("Wrong guess. Try again.");
            }
        }
        System.out.println("Sorry, you've used all your tries. The correct number was " + winningNumber + ".");
    }
}