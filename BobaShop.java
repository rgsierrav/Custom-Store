public class BobaShop {
    private BobaInventory inventory;
    private List<User> users;
    private User currentUser;

    public BobaShop() {
        this.inventory = new BobaInventory();
        this.users = new ArrayList<>();
        // Default admin account and initial setup
    }

    // Methods for shop operations...
}
