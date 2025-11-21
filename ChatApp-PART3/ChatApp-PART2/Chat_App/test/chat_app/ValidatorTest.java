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
public class ValidatorTest {
    

    @Test
    public void testCheckUserName() {
        Validator validator = new Validator();
        assertTrue(validator.checkUserName("a-b"));
        assertFalse(validator.checkUserName(null));
        assertFalse(validator.checkUserName("abcde"));
        assertFalse(validator.checkUserName("abcd-ef")); // length > 5
    }

    @Test
    public void testCheckPasswordComplexity() {
        Validator validator = new Validator();
        assertTrue(validator.checkPasswordComplexity("Abcdef1!"));
        assertFalse(validator.checkPasswordComplexity(null));
        assertFalse(validator.checkPasswordComplexity("abcdefg"));
    }

    @Test
    public void testCheckPhoneNumber() {
        Validator validator = new Validator();
        assertTrue(validator.checkPhoneNumber("+27123456789"));
        assertFalse(validator.checkPhoneNumber(null));
        assertFalse(validator.checkPhoneNumber("123456789"));
        assertFalse(validator.checkPhoneNumber("+2712345678a"));
    }
}

    