import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PasswordManager manager = new PasswordManager();
        Scanner scanner = new Scanner(System.in);
        int choice;

        System.out.println("Welcome to Password Manager");

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Add Credentials");
            System.out.println("2. View Credentials");
            System.out.println("3. Generate Strong Password");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter website: ");
                    String website = scanner.next();
                    System.out.println("Enter username: ");
                    String username = scanner.next();

                    // Prompt user to choose between custom or strong password
                    System.out.println("Choose password option: ");
                    System.out.println("1. Enter your own password");
                    System.out.println("2. Generate a strong password");
                    System.out.println("Enter your choice: ");
                    int passwordChoice = scanner.nextInt();

                    String password = "";

                    if (passwordChoice == 1) {
                        // Own password
                        System.out.println("Enter password: ");
                        password = scanner.next();
                    } else if (passwordChoice == 2) {
                        // Generate password
                        password = manager.generateStrongPassword();
                        System.out.println("Generated strong password: " + password);
                    } else {
                        System.out.println("Invalid choice. Please try again.");
                        break;
                    }

                    // Add the new credential
                    Credential credential = new Credential(website, username, password);
                    manager.addCredentials(credential);
                    break;

                case 2:
                    manager.displayCredentials();
                    break;

                case 3:
                    String strongPassword = manager.generateStrongPassword();
                    System.out.println("Generated strong password: " + strongPassword);
                    break;

                case 4:
                    System.out.println("Exiting Password Manager. Goodbye");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again");
            }
        } while (choice != 4);
        scanner.close();
    }
}
