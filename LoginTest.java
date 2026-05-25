import com.mycompany.login.Login;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class LoginTest {

    // Valid test object
    Login user = new Login("ab_cd", "Password1!", "+27831234567", "Nyiko", "Nomvela");

    @BeforeAll
    public static void setUpClass() throws Exception {
    }

    @AfterAll
    public static void tearDownClass() throws Exception {
    }

    @BeforeEach
    public void setUp() throws Exception {
    }

    @AfterEach
    public void tearDown() throws Exception {
    }

    // Username Tests
    @Test
    public void testValidUsername() {
        assertTrue(user.checkUsername());
    }

    @Test
    public void testInvalidUsername() {
        Login invalidUser = new Login("abcd", "Password1!", "+27831234567", "Test", "User");
        assertFalse(invalidUser.checkUsername());
    }

    // Password Tests
    @Test
    public void testValidPassword() {
        assertTrue(user.checkPasswordComplexity());
    }

    @Test
    public void testInvalidPassword() {
        Login invalidUser = new Login("ab_cd", "pass", "+27831234567", "Test", "User");
        assertFalse(invalidUser.checkPasswordComplexity());
    }

    // Phone Number Tests
    @Test
    public void testValidPhoneNumber() {
        assertTrue(user.checkCellPhoneNumber());
    }

    @Test
    public void testInvalidPhoneNumber() {
        Login invalidUser = new Login("ab_cd", "Password1!", "0831234567", "Test", "User");
        assertFalse(invalidUser.checkCellPhoneNumber());
    }

    // Login Tests
    @Test
    public void testLoginSuccess() {
        assertTrue(user.loginUser("ab_cd", "Password1!"));
    }

    @Test
    public void testLoginFailure() {
        assertFalse(user.loginUser("wrongUser", "wrongPass"));
    }

    // Output Message Test
    @Test
    public void testLoginMessage() {
        String message = user.returnLoginStatus(true);
        assertEquals("Welcome Nyiko, Nomvela it is nice to see you again.", message);
    }

    /**
     * Test of checkUsername method, of class Login.
     */
    @Test
    public void testCheckUsername() {
        System.out.println("checkUsername");
        Login instance = null;
        boolean expResult = false;
        boolean result = instance.checkUsername();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of registerUsername method, of class Login.
     */
    @Test
    public void testRegisterUsername() {
        System.out.println("registerUsername");
        Login instance = null;
        String expResult = "";
        String result = instance.registerUsername();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkPasswordComplexity method, of class Login.
     */
    @Test
    public void testCheckPasswordComplexity() {
        System.out.println("checkPasswordComplexity");
        Login instance = null;
        boolean expResult = false;
        boolean result = instance.checkPasswordComplexity();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of registerPassword method, of class Login.
     */
    @Test
    public void testRegisterPassword() {
        System.out.println("registerPassword");
        Login instance = null;
        String expResult = "";
        String result = instance.registerPassword();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkCellPhoneNumber method, of class Login.
     */
    @Test
    public void testCheckCellPhoneNumber() {
        System.out.println("checkCellPhoneNumber");
        Login instance = null;
        boolean expResult = false;
        boolean result = instance.checkCellPhoneNumber();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of registerCellPhoneNumber method, of class Login.
     */
    @Test
    public void testRegisterCellPhoneNumber() {
        System.out.println("registerCellPhoneNumber");
        Login instance = null;
        String expResult = "";
        String result = instance.registerCellPhoneNumber();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of loginUser method, of class Login.
     */
    @Test
    public void testLoginUser() {
        System.out.println("loginUser");
        String enteredUsername = "";
        String enteredPassword = "";
        Login instance = null;
        boolean expResult = false;
        boolean result = instance.loginUser(enteredUsername, enteredPassword);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of returnLoginStatus method, of class Login.
     */
    @Test
    public void testReturnLoginStatus() {
        System.out.println("returnLoginStatus");
        boolean loginStatus = false;
        Login instance = null;
        String expResult = "";
        String result = instance.returnLoginStatus(loginStatus);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}