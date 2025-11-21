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
public class UserTest {
    
    
    @Test
    public void testUserGetters() {
        User user = new User("user-1", "Pass1!", "+27123456789");
        assertEquals("user-1", user.getUsername());
        assertEquals("Pass1!", user.getPassword());
        assertEquals("+27123456789", user.getCellPhone());
    }
}
