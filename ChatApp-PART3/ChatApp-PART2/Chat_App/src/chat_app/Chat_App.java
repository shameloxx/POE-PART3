/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package chat_app;
import javax.swing.JOptionPane;

/**
 *
 * @author RC_Student_Lab
 */
public class Chat_App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Validator validator = new Validator();
        
        //  REGISTRATION & LOGIN
        // Existing registration and login logic remains here
        String username = JOptionPane.showInputDialog("Enter username (max 5 chars, must contain '_'): ");
        if (!validator.checkUserName(username)) {
            JOptionPane.showMessageDialog(null, "Invalid username.");
            return;
        }
        
        String password = JOptionPane.showInputDialog("Enter password (min 8 chars, uppercase, digit & special char): ");
        if (!validator.checkPasswordComplexity(password)) {
            JOptionPane.showMessageDialog(null, "Invalid password.");
            return;
        }

        String phoneNumber = JOptionPane.showInputDialog("Enter cell number (+27xxxxxxxxx): ");
        if (!validator.checkPhoneNumber(phoneNumber)) {
            JOptionPane.showMessageDialog(null, "Invalid phone number.");
            return;
        }

        User user = new User(username, password, phoneNumber);
        Login login = new Login();
        login.register(user);

        JOptionPane.showMessageDialog(null, "Registration successful!");

        String loginUsername = JOptionPane.showInputDialog("Login - enter username: ");
        String loginPassword = JOptionPane.showInputDialog("Login - enter password: ");
        if (!login.login(loginUsername, loginPassword)) {
            JOptionPane.showMessageDialog(null, "Login failed.");
            return;
        }
        JOptionPane.showMessageDialog(null, "Welcome " + user.getUsername() + "!");
        
        // MESSAGE MANAGEMENT 
        MessageManager messageManager = new MessageManager();

        while (true) {
            String menu = """
                          Choose Option:
                          1. Add New Message (Send/Store/Discard)
                          2. Display Sent Messages Report (2f)
                          3. Display Sent Message Recipients (2a)
                          4. Find Longest Sent Message (2b)
                          5. Search Message by ID (2c)
                          6. Search Messages by Recipient (2d)
                          7. Delete Message by Hash (2e)
                          8. Exit""";
                        
            String option = JOptionPane.showInputDialog(menu);
            
            if (option == null || option.equals("8")) {
                JOptionPane.showMessageDialog(null, "Goodbye, its sad to see you leave!");
                break;
            }

            switch (option) {
                case "1" -> { 
                    int count;
                    try {
                        count = Integer.parseInt(JOptionPane.showInputDialog("How many messages?"));
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Invalid number");
                        continue;
                    }

                    for (int i = 0; i < count; i++) {
                        String recipient = JOptionPane.showInputDialog("Message " + (i+1) + " Recipient (+27xxxxxxx): ");
                        if (!validator.checkPhoneNumber(recipient)) {
                            JOptionPane.showMessageDialog(null, "Invalid phone number");
                            i--;
                            continue;
                        }
                        
                        String messageText = JOptionPane.showInputDialog("Message " + (i+1) + " Content (max 250 chars): ");
                        if (messageText == null || messageText.length() > 250) {
                            JOptionPane.showMessageDialog(null, "Message too long or cancelled.");
                            i--;
                            continue;
                        }

                        Message msg = new Message(recipient, messageText);
                        String[] options = {"Send (Sent)", "Save (Stored)", "Discard (Disregard)"};
                        int choice = JOptionPane.showOptionDialog(null, "Choose action for Message " + (i+1) + ":",
                                "Message Action", JOptionPane.DEFAULT_OPTION,
                                JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

                        switch (choice) {
                            case 0 -> messageManager.sendMessage(msg); 
                            case 1 -> messageManager.storeMessage(msg); 
                            default -> messageManager.disregardMessage(msg); 
                        }
                    }
                }
                case "2" -> { // Display Full Report (2f)
                     JOptionPane.showMessageDialog(null, messageManager.displaySentMessagesReport());
                }
                case "3" -> { // Display Sender/Recipient (2a)
                     JOptionPane.showMessageDialog(null, messageManager.displaySentMessagesRecipients());
                }
                case "4" -> { // Find Longest Message (2b)
                    JOptionPane.showMessageDialog(null, messageManager.findAndDisplayLongestSentMessage());
                }
                case "5" -> { // Search Message by ID (2c)
                    String id = JOptionPane.showInputDialog("Enter Message ID to search (e.g., 4444444444):");
                    JOptionPane.showMessageDialog(null, messageManager.searchMessageByID(id));
                }
                case "6" -> { // Search Messages by Recipient (2d)
                    String recipient = JOptionPane.showInputDialog("Enter Recipient number (+27xxxxxxxxx) (e.g., +27838884567):");
                    JOptionPane.showMessageDialog(null, messageManager.searchMessagesByRecipient(recipient));
                }
                case "7" -> { // Delete Message by Hash (2e)
                    String hash = JOptionPane.showInputDialog("Enter Message Hash to delete (e.g., 22:WHERETIME.):");
                    JOptionPane.showMessageDialog(null, messageManager.deleteMessageByHash(hash));
                }
                default -> JOptionPane.showMessageDialog(null, "Invalid option");
            }
        }
    }
}