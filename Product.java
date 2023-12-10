public class Product {
    private String name;
    private double price;
    private int quantity;

    // Constructor to initialize product properties
    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    // Getters and Setters for product properties

    public String getName() {
        return name;
    }

    public void setName(String name) {
        // Setter for the product name
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        // Setter for the product price
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        // Setter for the product quantity
        this.quantity = quantity;
    }

    // Method to display product information
    public void displayInfo() {
        // Display product information including name, price, and quantity
        System.out.println("Name: " + name + ", Price: $" + price + ", Quantity: " + quantity);
    }

    // Additional methods related to the product can be added here

    // Override toString method for easy printing
    @Override
    public String toString() {
        // Convert the product object to a string representation
        return "Product{" +
               "name='" + name + '\'' +
               ", price=" + price +
               ", quantity=" + quantity +
               '}';
    }
}
