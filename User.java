public class User {
    protected String username;
    protected String password;

    // Constructor
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getters and Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        // Setter for username
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        // Setter for password
        this.password = password;
    }

    // You might want to override toString() method for debugging purposes
    @Override
    public String toString() {
        return "User{" +
               "username='" + username + '\'' +
               ", password='" + password + '\'' +
               '}';
    }

    // Additional methods like validatePassword can be added if needed
    // Additional methods, such as validatePassword, can be added here if required.
    // ...
}
