/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chat_app;

/**
 *
 * @author RC_Student_Lab
 */
public class User {
    // Represents a user with username, password and phone.
    //encapsulates user detials with private fields and public getters.

    private final String username; //unique identifier for user login.
    private final String password;  // user's password, validated for complexity.
    private final String cellPhone; // user's phone number in +27 format.
// constructs a user object withh given details.
    public User(String username, String password, String cellPhone) {
        this.username = username;
        this.password = password;
        this.cellPhone = cellPhone;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getCellPhone() {
        return cellPhone;
    }
}




