import java.util.Scanner;

public abstract class User {
    protected String username;
    protected String password;

    // Constructor
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getter for Username
    public String getUsername() {
        return username;
    }

    // Setter for Username
    public void setUsername(String username) {
        this.username = username;
    }

    // Getter for Password
    public String getPassword() {
        return password;
    }

    // Setter for Password
    public void setPassword(String password) {
        this.password = password;
    }

    // Abstract method to display the user-specific menu
    public abstract void displayMenu(Scanner scanner);
}
