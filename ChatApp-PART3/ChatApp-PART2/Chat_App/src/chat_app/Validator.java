/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chat_app;

/**
 *
 * @author RC_Student_Lab
 */
public class Validator {
     //Validates user input fields.
    //ensures username, password, and phone number conform to given rules.
 // checks if username is valid which includes an underscore and has a max length of 5 characters
   public boolean checkUserName(String username) {
        return username != null && username.contains("_") && username.length() <= 5;
    }
//validates password complexity
   //password must be at leats 8 chars, contain uppercase letter, digit and special char.
   
    public boolean checkPasswordComplexity(String password) {
        if (password == null) {
            return false;
        }//null password is invalid 
        String regex = "^(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,}$";// regex for complexity
        return password.matches(regex);
    }
    //validates the phone number format, must be in south african interrnational format +27 follwed by 9 digits

    public boolean checkPhoneNumber(String phone) {
        if (phone == null) {
            return false;// null phone number is invalid
        }
        String regex = "^\\+27\\d{9}$";// regex fro +27xxxxxxxxx format
        return phone.matches(regex);
    }
}

