/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package chat_app;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author RC_Student_Lab
 */
public class MessageTest {
    
    @Test
    public void testMessageCreationAndHash() {
        String recipient = "+27123456789";
        String content = "Hello world";
        Message message = new Message(recipient, content);
        
        assertEquals(recipient, message.getRecipient());
        assertEquals(content, message.getMessageContent());

        String id = message.getMessageId();
        assertNotNull(id);
        assertEquals(10, id.length());

        String hash = message.getMessageHash();
        assertTrue(hash.startsWith(id.substring(0, 2) + ":"));
        assertTrue(hash.toUpperCase().contains("HELLO"));
        assertTrue(hash.toUpperCase().contains("WORLD"));
    }

    @Test
    public void testMessageLengthValidation() {
        String recipient = "+27123456789";
        String validContent = "a".repeat(250);
        String invalidContent = "a".repeat(251);

        Message validMessage = new Message(recipient, validContent);
        Message invalidMessage = new Message(recipient, invalidContent);

        assertTrue(validMessage.isValidLength());
        assertFalse(invalidMessage.isValidLength());
    }
}
