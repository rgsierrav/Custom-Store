import java.io.Serializable;

public class BobaProduct implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name; // The name of the Boba product
    private double price; // The price of the Boba product
    private int count; // The count of available units of the Boba product

    // Constructor to initialize a BobaProduct object
    public BobaProduct(String name, int count, double price) {
        this.name = name;
        this.count = count; // Initialize the count of available units
        this.price = price; // Initialize the price of the Boba product
    }

    // Getter and Setter for Count
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count; // Set the count of available units
    }

    // Getter and Setter for Name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name; // Set the name of the Boba product
    }

    // Getter and Setter for Price
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price; // Set the price of the Boba product
    }

    // toString method for easy display of BobaProduct information
    @Override
    public String toString() {
        return "BobaProduct{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", count=" + count +
                '}';
    }
}
