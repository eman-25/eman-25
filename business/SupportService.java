package support.business;

import support.data.SupportRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

/**
 * Support Service - Business Layer
 * Handles processing of customer support requests.
 */
public class SupportService {
    private static final Logger logger = LoggerFactory.getLogger(SupportService.class);
    private final SupportRepository supportRepository = new SupportRepository();

    /**
     * Processes user requests based on selected menu option.
     */
    public void processRequest(int type, Scanner scanner) {
        switch (type) {
            case 1, 2, 3, 4, 5 -> handleSupportRequest(type, scanner);
            case 6 -> showCommonQuestions(scanner);
            case 7 -> System.out.println("📞 Contact Technical Support at: 123456789");
            default -> System.out.println("⚠️ Invalid choice! Please try again.");
        }
    }

    private void handleSupportRequest(int type, Scanner scanner) {
        String issueType = switch (type) {
            case 1 -> "Application Issues";
            case 2 -> "Website Issues";
            case 3 -> "Warranty Inquiries";
            case 4 -> "Driver Assistance";
            case 5 -> "Complaint Management";
            default -> "";
        };

        logger.info("User selected: {}", issueType);
        System.out.println("\n🔹 You selected: " + issueType);
        System.out.print("Please describe your issue: ");
        String problemDescription = scanner.nextLine();

        System.out.print("Would you like to upload images/videos? (yes/no): ");
        String uploadChoice = scanner.nextLine();

        if (uploadChoice.equalsIgnoreCase("yes")) {
            System.out.println("📂 Please attach files in the next step.");
            logger.info("User opted to upload files.");
        }

        supportRepository.saveIssue(issueType, problemDescription);
        System.out.println("✅ Your request has been sent to technical support!");
    }

    private void showCommonQuestions(Scanner scanner) {
        while (true) {
            System.out.println("\n🔹 Common Questions & Solutions:");
            System.out.println("1️⃣ Is the driver late?");
            System.out.println("2️⃣ Are you facing payment problems?");
            System.out.println("3️⃣ Are you facing vehicle problems?");
            System.out.println("0️⃣ Back to Main Menu");

            System.out.print("Select an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter Order Number: ");
                    String orderNumber = scanner.nextLine();
                    logger.info("Driver delay reported. Order Number: {}", orderNumber);
                    System.out.println("📲 Message sent to driver: 'Customer is waiting for Order " + orderNumber + "'.");
                }
                case 2, 3 -> {
                    System.out.print("Please describe your problem: ");
                    String problem = scanner.nextLine();
                    logger.info("Customer reported issue: {}", problem);
                    System.out.println("📩 Technical Support has been notified. They will contact you soon.");
                }
                case 0 -> {
                    return;
                }
                default -> System.out.println("⚠️ Invalid choice! Please try again.");
            }
        }
    }
}
