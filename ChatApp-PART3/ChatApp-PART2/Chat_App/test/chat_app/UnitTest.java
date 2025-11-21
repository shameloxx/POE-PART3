/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chat_app;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.List;


/**
 *
 * @author RC_Student_Lab
 */
public class UnitTest {
   
public class MessageManagerTest {

    private MessageManager manager;

    // This method runs before every test and resets the test data
    @BeforeEach
    public void setUp() {
        manager = new MessageManager();
    }

    /**
     * Test 1: Check Sent Messages array is correctly populated (Messages 1 & 4)
     * Corresponds to Rubric requirement 1 (Populate arrays).
     */
    @Test
    public void test1_SentMessagesArrayPopulation() {
        List<String> expectedMessages = Arrays.asList(
            "Did you get the cake?", 
            "It is dinner time!"
        );
        
        List<String> actualMessages = manager.getMessageContentList(manager.getSentMessages());

        assertEquals(expectedMessages, actualMessages, "Test 1 Failed: Sent Messages array should contain only Messages 1 and 4.");
    }

    /**
     * Test 2: Display the longest Sent Message (2b)
     */
    @Test
    public void test2_FindLongestSentMessage() {
        // The longest SENT message is Message 1 ("Did you get the cake?")
        String expectedContent = "Did you get the cake?"; 

        String result = manager.findAndDisplayLongestSentMessage();

        assertTrue(result.contains(expectedContent), "Test 2 Failed: The longest SENT message should be Message 1.");
    }
    
    /**
     * Test 3: Search for Message ID (2c)
     */
    @Test
    public void test3_SearchMessageByID() {
        String messageIdToSearch = "4444444444"; // ID for Message 4
        String expectedContent = "Message: It is dinner time!"; 
        
        String result = manager.searchMessageByID(messageIdToSearch);

        assertTrue(result.contains(expectedContent), "Test 3 Failed: Search by ID should return Message 4 details.");
    }
    
    /**
     * Test 4: Search all messages sent or stored regarding a particular recipient (2d)
     * Test Data Recipient: +27838884567 (Messages 2 and 5)
     */
    @Test
    public void test4_SearchMessagesByRecipient() {
        String recipientToSearch = "+27838884567";
        String expectedM2 = "Where are you? You are late! I have asked you to be on time.";
        String expectedM5 = "Ok, I am leaving without you.";

        String result = manager.searchMessagesByRecipient(recipientToSearch);

        assertTrue(result.contains(expectedM2), "Test 4 Failed: Result should contain Message 2.");
        assertTrue(result.contains(expectedM5), "Test 4 Failed: Result should contain Message 5.");
    }
    
    /**
     * Test 5: Delete a message using a message hash (2e)
     */
    @Test
    public void test5_DeleteMessageByHash() {
        String hashToDelete = "22:WHERETIME."; // Hash for Message 2
        int initialSize = manager.getAllMessages().size();
        String expectedConfirmation = "successfully deleted.";
        
        String result = manager.deleteMessageByHash(hashToDelete);
        int finalSize = manager.getAllMessages().size();
        
        assertTrue(result.contains(expectedConfirmation), "Test 5 Failed: Deletion should return a success message.");
        assertEquals(initialSize - 1, finalSize, "Test 5 Failed: The total message count should decrease by 1.");
        assertFalse(manager.getMessageHashes().contains(hashToDelete), "Test 5 Failed: The hash should no longer exist.");
    }

    /**
     * Test 6: Display Report (2f)
     */
    @Test
    public void test6_DisplayReport() {
        String report = manager.displaySentMessagesReport();
        
        // Check for content from Sent messages (M1 & M4)
        assertTrue(report.contains("Did you get the cake?"), "Test 6 Failed: Report must include Message 1 (Sent).");
        assertTrue(report.contains("It is dinner time!"), "Test 6 Failed: Report must include Message 4 (Sent).");
        
        // Check for required column headers
        assertTrue(report.contains("Message Hash"), "Test 6 Failed: Report must list Message Hash details.");
    }

}
}
