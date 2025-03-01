package support.data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Support Repository - Data Layer
 * Handles storage and retrieval of support requests.
 */
public class SupportRepository {
    private static final Logger logger = LoggerFactory.getLogger(SupportRepository.class);

    /**
     * Simulates saving an issue to a database.
     */
    public void saveIssue(String issueType, String description) {
        logger.info("Saving issue: {} - {}", issueType, description);
        System.out.println("📌 Issue recorded: " + issueType + " - " + description);
    }
}
