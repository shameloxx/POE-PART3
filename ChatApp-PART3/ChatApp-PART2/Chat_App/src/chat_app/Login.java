/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chat_app;

/**
 *
 * @author RC_Student_Lab
 */
public class Login {
    // Manages registration and login of users.
 
    private User registeredUser;

    public void register(User user) {
        this.registeredUser = user;  // Store the registered user
    }

    // authenticates by comparing input credentials to the registered user.
    //returns true if username and password match registered user.
    public boolean login(String username, String password) {
        if (registeredUser == null) {
             return false;
        }
        if (username == null || password == null) {
            return false;// no user registered or null  inputs
        }
        return registeredUser.getUsername().equals(username)
            && registeredUser.getPassword().equals(password);
    }
}

    
