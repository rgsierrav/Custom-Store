import java.util.Scanner;
import java.io.Serializable;

public abstract class User implements Serializable {
    private static final long serialVersionUID = 1L;
    protected String username;
    protected String password;

    // Constructor initializes the username and password
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getter method to retrieve the username
    public String getUsername() {
        return username;
    }

    // Setter method to update the username
    public void setUsername(String username) {
        this.username = username;
    }

    // Getter method to retrieve the password
    public String getPassword() {
        return password;
    }

    // Setter method to update the password
    public void setPassword(String password) {
        this.password = password;
    }

    // Abstract method to be implemented by subclasses for displaying user-specific menus
    public abstract void displayMenu(Scanner scanner);
}
