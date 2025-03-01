package support.presentation;

import support.business.SupportService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

/**
 * Customer Support Tools - Presentation Layer
 * Handles user interaction and displays the menu.
 */
public class CustomerSupportUI {
    private static final Logger logger = LoggerFactory.getLogger(CustomerSupportUI.class);
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        SupportService supportService = new SupportService();

        System.out.print("Enter your name: ");
        String username = scanner.nextLine();
        logger.info("User logged in: {}", username);
        System.out.println("Hello " + username + "! How can I assist you today?");

        while (true) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (choice == 0) {
                logger.info("User exited the system.");
                System.out.println("✅ Thank you for using our support system. Have a great day!");
                break;
            }

            supportService.processRequest(choice, scanner);
        }
    }

    /**
     * Displays the main menu options.
     */
    private static void displayMenu() {
        System.out.println("\n🔹 Select an option:");
        System.out.println("1️⃣ Application Issues");
        System.out.println("2️⃣ Website Issues");
        System.out.println("3️⃣ Warranty Inquiries");
        System.out.println("4️⃣ Driver Assistance");
        System.out.println("5️⃣ Complaint Management");
        System.out.println("6️⃣ Common Questions");
        System.out.println("7️⃣ Contact Technical Support (📞 123456789)");
        System.out.println("0️⃣ Exit");
        System.out.print("Your choice: ");
    }
}
