public class BobaProduct {
    private String name;
    private String size; // Sizes like Small, Medium, Large
    private double price;
    private int count;  // New field to track the product count

    // Constructor
    public BobaProduct(String name, String size, int count, double price) {
        this.name = name;
        this.size = size;
        this.count = count;
        this.price = price;
    }    

    // Getter and Setter for Count
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    // Getter and Setter for Name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and Setter for Size
    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    // Getter and Setter for Price
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // toString method for easy display
    @Override
    public String toString() {
        return "BobaProduct{" +
                "name='" + name + '\'' +
                ", size='" + size + '\'' +
                ", price=" + price +
                '}';
    }
}
