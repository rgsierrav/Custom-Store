public class Product {
    private String name;
    private double price;
    private int quantity;
    private String teaType; // New attribute for tea type
    private String sweetnessLevel; // New attribute for sweetness level
    private String milkType; // New attribute for milk type
    private String toppings; // New attribute for toppings

    // Constructor to initialize product properties
    public Product(String name, double price, int quantity, String teaType, String sweetnessLevel, String milkType, String toppings) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.teaType = teaType;
        this.sweetnessLevel = sweetnessLevel;
        this.milkType = milkType;
        this.toppings = toppings;
    }

    // Getters and setters for new attributes
    public String getTeaType() {
        return teaType;
    }

    public void setTeaType(String teaType) {
        this.teaType = teaType;
    }

    public String getSweetnessLevel() {
        return sweetnessLevel;
    }

    public void setSweetnessLevel(String sweetnessLevel) {
        this.sweetnessLevel = sweetnessLevel;
    }

    public String getMilkType() {
        return milkType;
    }

    public void setMilkType(String milkType) {
        this.milkType = milkType;
    }

    public String getToppings() {
        return toppings;
    }

    public void setToppings(String toppings) {
        this.toppings = toppings;
    }

    // Existing getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // Method to display product information
    public void displayInfo() {
        System.out.println("Name: " + name + ", Price: $" + price + ", Quantity: " + quantity +
                           ", Tea Type: " + teaType + ", Sweetness: " + sweetnessLevel +
                           ", Milk Type: " + milkType + ", Toppings: " + toppings);
    }

    // Override toString method for easy printing
    @Override
    public String toString() {
        return "Product{" +
               "name='" + name + '\'' +
               ", price=" + price +
               ", quantity=" + quantity +
               ", teaType='" + teaType + '\'' +
               ", sweetnessLevel='" + sweetnessLevel + '\'' +
               ", milkType='" + milkType + '\'' +
               ", toppings='" + toppings + '\'' +
               '}';
    }
}