import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Create a scanner to read user input
        BobaShop bobaShop = new BobaShop(); // Create an instance of the BobaShop class

        bobaShop.loadData();  // Load data at the start of the program

        int choice;
        try {
            while (true) {
                displayWelcomeMessage(); // Display a welcome message and menu options
                choice = scanner.nextInt(); // Read the user's choice
                scanner.nextLine(); // Consume the newline left-over after reading the choice

                switch (choice) {
                    case 1:
                        bobaShop.login(scanner); // Call the login method of the BobaShop
                        break;
                    case 2:
                        bobaShop.register(scanner); // Call the register method of the BobaShop
                        break;
                    case 3:
                        System.out.println("Thank you for visiting our Boba Shop! See you next time!"); // Display a goodbye message
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again."); // Display an error message for an invalid choice
                }

                if (choice == 3) {
                    bobaShop.saveData();  // Save data before exiting the program
                    break;  // Break out of the while loop to exit the program
                }
            }
        } finally {
            scanner.close();  // Close the scanner to release resources
        }
    }

    private static void displayWelcomeMessage() {
        System.out.println("* Welcome to Our Cozy Boba Tea Shop! *");
        System.out.println("* 1 - Login *");
        System.out.println("* 2 - Register *");
        System.out.println("* 3 - Exit *");
        System.out.print("Enter your choice: "); // Prompt the user for their choice
    }
}
