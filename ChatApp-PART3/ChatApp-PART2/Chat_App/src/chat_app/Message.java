/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chat_app;
import java.util.Random;
/**
 *
 * @author RC_Student_Lab
 */
public class Message {

    // Represents a chat message with unique ID, hash, recipient, content, and status flag.
    
    private static final int MAX_MESSAGE_LENGTH = 250;
    private final String messageId; 
    private final String messageHash; 
    private final String recipient; 
    private final String messageContent; 
    private String flag; // Added field to track status: "Sent", "Stored", "Disregard"

    // Constructor for a NEW message created by the user
    public Message(String recipient, String messageContent) {
        this.messageId = generateUniqueId();
        this.recipient = recipient;
        this.messageContent = messageContent;
        this.messageHash = createMessageHash();
        this.flag = "PENDING"; // Status is set later by MessageManager
    }
    
    // Constructor for LOADING Test Data/JSON messages (ID/Hash already known)
    public Message(String messageId, String messageHash, String recipient, String messageContent, String flag) {
        this.messageId = messageId;
        this.messageHash = messageHash;
        this.recipient = recipient;
        this.messageContent = messageContent;
        this.flag = flag;
    }

    // Generates a random unique 10-digits message ID.
    private String generateUniqueId() {
        Random rand = new Random();
        StringBuilder sb = new StringBuilder(10);
        for (int i = 0; i < 10; i++) {
            sb.append(rand.nextInt(10));
        }
        return sb.toString();
    }

    // Creates message hash: first two digits of ID + first and last word of message, uppercase.
    private String createMessageHash() {
        String[] words = messageContent.trim().split("\\s+");
        String firstWord = words.length > 0 ? words[0] : "";
        String lastWord = words.length > 1 ? words[words.length - 1] : firstWord;
        
        String firstTwoCharsOfId = messageId.substring(0, 2);
        
        // Hash format: ID_2chars:FIRSTWORDLASTWORD 
        return (firstTwoCharsOfId + ":" + firstWord + lastWord).toUpperCase();
    }

    // Getters and Setters
    public String getMessageId() { return messageId; }
    public String getMessageHash() { return messageHash; }
    public String getRecipient() { return recipient; }
    public String getMessageContent() { return messageContent; }
    public String getFlag() { return flag; }
    
    public boolean isValidLength() {
        return messageContent.length() <= MAX_MESSAGE_LENGTH;
    }
    
    public void setFlag(String flag) { this.flag = flag; }
}