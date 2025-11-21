/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chat_app;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;
/**
/**
 *
 * @author RC_Student_Lab
 */
public class MessageManager {

    // Required array: Main storage for all messages
    private final List<Message> allMessages = new ArrayList<>(); 

    // Required arrays/lists for Part 3 (populated by filtering allMessages)
    private final List<Message> sentMessages = new ArrayList<>(); 
    private final List<Message> disregardedMessages = new ArrayList<>(); 
    private final List<Message> storedMessages = new ArrayList<>(); 
    
    // Required parallel arrays for Hashes and IDs
    private final List<String> messageHashes = new ArrayList<>(); 
    private final List<String> messageIDs = new ArrayList<>(); 

    public MessageManager() {
        // Load test data to populate arrays at program start (Part 3 Requirement)
        loadTestData();
    }
    
    // --- Data Management and Storage ---

    /**
     * Loads test data messages 1-5 into the main list.
     */
    private void loadTestData() {
        // Hardcoding ID/Hash for consistency and testability
        
        // Message 1 (Sent)
        Message m1 = new Message("1111111111", "11:DIDTHECAKE?", "+27834557896", "Did you get the cake?", "Sent");
        // Message 2 (Stored) - Longest message overall
        Message m2 = new Message("2222222222", "22:WHERETIME.", "+27838884567", "Where are you? You are late! I have asked you to be on time.", "Stored");
        // Message 3 (Disregard)
        Message m3 = new Message("3333333333", "33:YOHOOOOGATE.", "+27834484567", "Yohoooo, I am at your gate.", "Disregard");
        // Message 4 (Sent)
        Message m4 = new Message("4444444444", "44:ITTIME!", "+27839990000", "It is dinner time!", "Sent");
        // Message 5 (Stored)
        Message m5 = new Message("5555555555", "55:OKYOU.", "+27838884567", "Ok, I am leaving without you.", "Stored");

        allMessages.add(m1);
        allMessages.add(m2);
        allMessages.add(m3);
        allMessages.add(m4);
        allMessages.add(m5);
        
        populateArrays();
        writeStoredMessagesToJSON(); // Ensure JSON file is created/updated
    }
    
    /**
     * Populates the five required arrays/lists by iterating through the main list. (Part 3 Requirement 1)
     */
    public void populateArrays() {
        // Clear all arrays to ensure they are up-to-date
        sentMessages.clear();
        disregardedMessages.clear();
        storedMessages.clear();
        messageHashes.clear();
        messageIDs.clear();

        for (Message m : allMessages) {
            String flag = m.getFlag().toLowerCase();
            
            // Populate the message arrays based on the flag
            switch (flag) {
                case "sent" -> sentMessages.add(m);
                case "stored" -> storedMessages.add(m);
                case "disregard" -> disregardedMessages.add(m);
                default -> {
                }
            }
            
            // Populate the parallel ID and Hash arrays
            messageIDs.add(m.getMessageId());
            messageHashes.add(m.getMessageHash());
        }
    }
    
    // --- Message Actions ---
    
    public boolean sendMessage(Message message) {
        if (!message.isValidLength()) {
            JOptionPane.showMessageDialog(null, "Failed to send: Message exceeds 250 characters.");
            return false;
        }
        message.setFlag("Sent");
        allMessages.add(message);
        populateArrays(); // Update arrays
        JOptionPane.showMessageDialog(null, "Message successfully sent:\nID: " + message.getMessageId() +
                "\nHash: " + message.getMessageHash() +
                "\nRecipient: " + message.getRecipient() +
                "\nMessage: " + message.getMessageContent());
        return true;
    }
    
    public void storeMessage(Message message) {
        message.setFlag("Stored");
        allMessages.add(message);
        populateArrays(); // Update arrays
        writeStoredMessagesToJSON(); // Write to JSON file
        JOptionPane.showMessageDialog(null, "Message successfully stored.");
    }
    
    public void disregardMessage(Message message) {
        message.setFlag("Disregard");
        allMessages.add(message);
        populateArrays(); // Update arrays
        JOptionPane.showMessageDialog(null, "Message successfully disregarded.");
    }

    // --- JSON Handling (Part 3 Requirement: Store Stored Messages in JSON) ---
    private void writeStoredMessagesToJSON() {
        String filename = "stored_messages.json";
        try (FileWriter file = new FileWriter(filename)) {
            file.write("[\n");
            for (int i = 0; i < storedMessages.size(); i++) {
                Message m = storedMessages.get(i);
                // Simple JSON format for first-year readability
                String jsonEntry = String.format(
                    "  {\n    \"id\": \"%s\",\n    \"hash\": \"%s\",\n    \"recipient\": \"%s\",\n    \"content\": \"%s\",\n    \"flag\": \"%s\"\n  }",
                    m.getMessageId(), m.getMessageHash(), m.getRecipient(), m.getMessageContent().replace("\"", "\\\""), m.getFlag()
                );
                file.write(jsonEntry);
                if (i < storedMessages.size() - 1) {
                    file.write(",\n");
                } else {
                    file.write("\n");
                }
            }
            file.write("]\n");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error writing to JSON file: " + e.getMessage());
        }
    }
    
    // --- New Functionalities (Part 3 Requirement 2a-2f) ---

    /**
     * Display the sender and recipient of all sent messages. (2a)
     * @return 
     */
    public String displaySentMessagesRecipients() {
        if (sentMessages.isEmpty()) {
            return "No sent messages to display.";
        }
        StringBuilder sb = new StringBuilder("Sent Messages Recipients:\n");
        sb.append("------------------------------------------\n");
        sb.append(String.format("| %-15s | %-18s |\n", "MESSAGE ID", "RECIPIENT"));
        sb.append("------------------------------------------\n");
        for (Message m : sentMessages) {
            sb.append(String.format("| %-15s | %-18s |\n", m.getMessageId(), m.getRecipient()));
        }
        sb.append("------------------------------------------\n");
        return sb.toString();
    }
    
    /**
     * Display the longest sent message. (2b)
     * Uses a simple for-loop to keep the code complexity low for a first-year student.
     * @return 
     */
    public String findAndDisplayLongestSentMessage() {
        if (sentMessages.isEmpty()) {
            return "No sent messages to compare.";
        }
        
        Message longestMessage = null;
        int maxLength = -1;
        
        // Simple for-loop to find the longest message content
        for (Message m : sentMessages) {
            int currentLength = m.getMessageContent().length();
            if (currentLength > maxLength) {
                maxLength = currentLength;
                longestMessage = m;
            }
        }
        
        if (longestMessage != null) {
            return String.format(
                "Longest Sent Message (Length: %d):\nRecipient: %s\nMessage: %s",
                longestMessage.getMessageContent().length(),
                longestMessage.getRecipient(),
                longestMessage.getMessageContent()
            );
        }
        return "Error: Could not find longest message.";
    }

    /**
     * Search for a message ID and display the corresponding recipient and message. (2c)
     * @param messageId
     * @return 
     */
    public String searchMessageByID(String messageId) {
        Message foundMessage = null;
        
        for (Message m : allMessages) {
            if (m.getMessageId().equals(messageId)) {
                foundMessage = m;
                break;
            }
        }

        if (foundMessage != null) {
            return String.format(
                "Message Found:\nStatus: %s\nID: %s\nRecipient: %s\nMessage: %s",
                foundMessage.getFlag(),
                foundMessage.getMessageId(),
                foundMessage.getRecipient(),
                foundMessage.getMessageContent()
            );
        }
        return "Message ID '" + messageId + "' not found.";
    }

    /**
     * Search for all the messages sent or stored regarding a particular recipient. (2d)
     * @param recipient
     * @return 
     */
    public String searchMessagesByRecipient(String recipient) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        
        for (Message m : allMessages) {
            String flag = m.getFlag().toLowerCase();
            // Check if recipient matches AND if the message was Sent OR Stored
            if (m.getRecipient().equals(recipient) && (flag.equals("sent") || flag.equals("stored"))) {
                sb.append(String.format("\t- [%s] %s\n", m.getFlag(), m.getMessageContent()));
                count++;
            }
        }

        if (count > 0) {
            return "Messages for Recipient " + recipient + ":\n" + sb.toString();
        }
        return "No Sent or Stored messages found for recipient " + recipient + ".";
    }

    /**
     * Delete a message using the message hash. (2e)
     * @param messageHash
     * @return 
     */
    public String deleteMessageByHash(String messageHash) {
        Message messageToDelete = null;
        
        // Find the message in the main list using a loop
        for (Message m : allMessages) {
            if (m.getMessageHash().equals(messageHash)) {
                messageToDelete = m;
                break;
            }
        }
        
        if (messageToDelete != null) {
            String deletedContent = messageToDelete.getMessageContent();
            allMessages.remove(messageToDelete); // Remove from main list
            populateArrays(); // Repopulate all required arrays
            writeStoredMessagesToJSON(); // Update JSON file
            
            return String.format("Message \"%s\" successfully deleted.", deletedContent);
        }
        return "Message Hash '" + messageHash + "' not found. Deletion failed.";
    }

    /**
     * Display a report that lists the full details of all the sent messages. (2f)
     * @return 
     */
    public String displaySentMessagesReport() {
        if (sentMessages.isEmpty()) {
            return "No sent messages to include in the report.";
        }

        StringBuilder sb = new StringBuilder("--- SENT MESSAGE REPORT ---\n");
        sb.append("Full details of all SENT messages (Hash, Recipient, Message):\n");
        sb.append("----------------------------------------------------------------------------------------------------------------\n");
        sb.append(String.format("| %-15s | %-15s | %-18s | %-40s |\n", "Message ID", "Message Hash", "Recipient", "Message Content"));
        sb.append("----------------------------------------------------------------------------------------------------------------\n");
        
        for (Message m : sentMessages) {
            // Trim message content for clean report display
            String contentSnippet = m.getMessageContent().substring(0, Math.min(m.getMessageContent().length(), 40)) + (m.getMessageContent().length() > 40 ? "..." : "");
            
            sb.append(String.format("| %-15s | %-15s | %-18s | %-40s |\n", 
                m.getMessageId(), m.getMessageHash(), m.getRecipient(), contentSnippet
            ));
        }
        sb.append("----------------------------------------------------------------------------------------------------------------\n");
        return sb.toString();
    }
    
    //  Getters for Unit Testing ONLY (to access the private lists) 
    public List<Message> getSentMessages() {
        return sentMessages;
    }
    public List<Message> getAllMessages() {
        return allMessages;
    }
    public List<String> getMessageHashes() {
        return messageHashes;
    }
    public List<String> getMessageContentList(List<Message> list) {
        List<String> contents = new ArrayList<>();
        for (Message m : list) {
            contents.add(m.getMessageContent());
        }
        return contents;
    }

}