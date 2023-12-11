import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BobaShop bobaShop = new BobaShop();

        bobaShop.loadData();  // Load data at the start

        int choice;
        try {
            while (true) {
                displayWelcomeMessage();
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline left-over

                switch (choice) {
                    case 1:
                        bobaShop.login(scanner);
                        break;
                    case 2:
                        bobaShop.register(scanner);
                        break;
                    case 3:
                        System.out.println("Thank you for visiting our Boba Shop! See you next time!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }

                if (choice == 3) {
                    bobaShop.saveData();  // Save data before exiting
                    break;  // Break out of the while loop
                }
            }
        } finally {
            scanner.close();  // Close the scanner here
        }
    }

    private static void displayWelcomeMessage() {
        System.out.println("* Welcome to Our Cozy Boba Tea Shop! *");
        System.out.println("* 1 - Login *");
        System.out.println("* 2 - Register *");
        System.out.println("* 3 - Exit *");
        System.out.print("Enter your choice: ");
    }
}
