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
public class LoginTest {
    

    @Test
    public void testRegisterAndLoginSuccess() {
        User user = new User("user-1", "Password1!", "+27123456789");
        Login login = new Login();
        login.register(user);
        assertTrue(login.login("user-1", "Password1!"));
    }

    @Test
    public void testLoginFailureWrongCredentials() {
        User user = new User("user-1", "Password1!", "+27123456789");
        Login login = new Login();
        login.register(user);
        assertFalse(login.login("wrong-user", "Password1!"));
        assertFalse(login.login("user-1", "wrongpass"));
    }

    @Test
    public void testLoginFailureNoUser() {
        Login login = new Login();
        assertFalse(login.login("anyuser", "anyPass"));
    }
}
