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
            shoppingCart.clear();
            return true; // Checkout successful
        } else {
            return false; // Insufficient balance to complete the purchase.
        }
    }

    // Method to view balance
    public double getBalance() {
        return balance;
    }

    // Method to add balance
    public void addBalance(double amount) {
        this.balance += amount;
        System.out.println("Your balance has been updated. New balance: $" + balance);
    }

    // Getters and Setters
    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    // Additional methods for customer functionalities can be added
    // ...
}
