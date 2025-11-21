/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package chat_app;

import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author RC_Student_Lab
 */
public class MessageManagerTest {
    
    public MessageManagerTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of populateArrays method, of class MessageManager.
     */
    @Test
    public void testPopulateArrays() {
        System.out.println("populateArrays");
        MessageManager instance = new MessageManager();
        instance.populateArrays();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sendMessage method, of class MessageManager.
     */
    @Test
    public void testSendMessage() {
        System.out.println("sendMessage");
        Message message = null;
        MessageManager instance = new MessageManager();
        boolean expResult = false;
        boolean result = instance.sendMessage(message);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of storeMessage method, of class MessageManager.
     */
    @Test
    public void testStoreMessage() {
        System.out.println("storeMessage");
        Message message = null;
        MessageManager instance = new MessageManager();
        instance.storeMessage(message);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of disregardMessage method, of class MessageManager.
     */
    @Test
    public void testDisregardMessage() {
        System.out.println("disregardMessage");
        Message message = null;
        MessageManager instance = new MessageManager();
        instance.disregardMessage(message);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of displaySentMessagesRecipients method, of class MessageManager.
     */
    @Test
    public void testDisplaySentMessagesRecipients() {
        System.out.println("displaySentMessagesRecipients");
        MessageManager instance = new MessageManager();
        String expResult = "";
        String result = instance.displaySentMessagesRecipients();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findAndDisplayLongestSentMessage method, of class MessageManager.
     */
    @Test
    public void testFindAndDisplayLongestSentMessage() {
        System.out.println("findAndDisplayLongestSentMessage");
        MessageManager instance = new MessageManager();
        String expResult = "";
        String result = instance.findAndDisplayLongestSentMessage();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchMessageByID method, of class MessageManager.
     */
    @Test
    public void testSearchMessageByID() {
        System.out.println("searchMessageByID");
        String messageId = "";
        MessageManager instance = new MessageManager();
        String expResult = "";
        String result = instance.searchMessageByID(messageId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchMessagesByRecipient method, of class MessageManager.
     */
    @Test
    public void testSearchMessagesByRecipient() {
        System.out.println("searchMessagesByRecipient");
        String recipient = "";
        MessageManager instance = new MessageManager();
        String expResult = "";
        String result = instance.searchMessagesByRecipient(recipient);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteMessageByHash method, of class MessageManager.
     */
    @Test
    public void testDeleteMessageByHash() {
        System.out.println("deleteMessageByHash");
        String messageHash = "";
        MessageManager instance = new MessageManager();
        String expResult = "";
        String result = instance.deleteMessageByHash(messageHash);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of displaySentMessagesReport method, of class MessageManager.
     */
    @Test
    public void testDisplaySentMessagesReport() {
        System.out.println("displaySentMessagesReport");
        MessageManager instance = new MessageManager();
        String expResult = "";
        String result = instance.displaySentMessagesReport();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSentMessages method, of class MessageManager.
     */
    @Test
    public void testGetSentMessages() {
        System.out.println("getSentMessages");
        MessageManager instance = new MessageManager();
        List<Message> expResult = null;
        List<Message> result = instance.getSentMessages();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllMessages method, of class MessageManager.
     */
    @Test
    public void testGetAllMessages() {
        System.out.println("getAllMessages");
        MessageManager instance = new MessageManager();
        List<Message> expResult = null;
        List<Message> result = instance.getAllMessages();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMessageHashes method, of class MessageManager.
     */
    @Test
    public void testGetMessageHashes() {
        System.out.println("getMessageHashes");
        MessageManager instance = new MessageManager();
        List<String> expResult = null;
        List<String> result = instance.getMessageHashes();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMessageContentList method, of class MessageManager.
     */
    @Test
    public void testGetMessageContentList() {
        System.out.println("getMessageContentList");
        List<Message> list = null;
        MessageManager instance = new MessageManager();
        List<String> expResult = null;
        List<String> result = instance.getMessageContentList(list);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
