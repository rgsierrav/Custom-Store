public class Customer extends User {
    private ShoppingCart shoppingCart;
    private double balance;

    public Customer(String username, String password) {
        super(username, password);
        this.shoppingCart = new ShoppingCart();
        this.balance = 0.0;
    }

    // Methods like addToCart, removeFromCart, checkout, addBalance, etc.
    // ...
}