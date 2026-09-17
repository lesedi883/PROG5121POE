import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the Login class.
 *
 * I used the exact test data given in the PROG5121 Part 1 brief
 * (e.g. "kyl_1", "Ch&&sec@ke99!", "+27838968976") so that these tests
 * match what will be used to mark this task.
 */
public class LoginTest {

    // ---------- checkUserName() tests ----------

    @Test
    public void testUsername_CorrectlyFormatted() {
        Login login = new Login("kyl_1", "Ch&&sec@ke99!", "+27838968976", "Kyle", "Smith");
        assertTrue(login.checkUserName("kyl_1"));
    }

    @Test
    public void testUsername_IncorrectlyFormatted() {
        Login login = new Login("kyle!!!!!!!", "Ch&&sec@ke99!", "+27838968976", "Kyle", "Smith");
        assertFalse(login.checkUserName("kyle!!!!!!!"));
    }

    // ---------- checkPasswordComplexity() tests ----------

    @Test
    public void testPassword_MeetsComplexity() {
        Login login = new Login("kyl_1", "Ch&&sec@ke99!", "+27838968976", "Kyle", "Smith");
        assertTrue(login.checkPasswordComplexity("Ch&&sec@ke99!"));
    }

    @Test
    public void testPassword_DoesNotMeetComplexity() {
        Login login = new Login("kyl_1", "password", "+27838968976", "Kyle", "Smith");
        assertFalse(login.checkPasswordComplexity("password"));
    }

    // ---------- checkCellPhoneNumber() tests ----------

    @Test
    public void testCellPhoneNumber_CorrectlyFormatted() {
        Login login = new Login("kyl_1", "Ch&&sec@ke99!", "+27838968976", "Kyle", "Smith");
        assertTrue(login.checkCellPhoneNumber("+27838968976"));
    }

    @Test
    public void testCellPhoneNumber_IncorrectlyFormatted() {
        Login login = new Login("kyl_1", "Ch&&sec@ke99!", "08966553", "Kyle", "Smith");
        assertFalse(login.checkCellPhoneNumber("08966553"));
    }

    // ---------- registerUser() tests ----------

    @Test
    public void testRegisterUser_UsernameIncorrect() {
        Login login = new Login("kyle!!!!!!!", "Ch&&sec@ke99!", "+27838968976", "Kyle", "Smith");
        assertEquals(
            "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.",
            login.registerUser()
        );
    }

    @Test
    public void testRegisterUser_PasswordIncorrect() {
        Login login = new Login("kyl_1", "password", "+27838968976", "Kyle", "Smith");
        assertEquals(
            "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.",
            login.registerUser()
        );
    }

    @Test
    public void testRegisterUser_Success() {
        Login login = new Login("kyl_1", "Ch&&sec@ke99!", "+27838968976", "Kyle", "Smith");
        assertEquals(
            "Username successfully captured.\nPassword successfully captured.",
            login.registerUser()
        );
    }

    // ---------- loginUser() tests ----------

    @Test
    public void testLoginUser_Successful() {
        Login login = new Login("kyl_1", "Ch&&sec@ke99!", "+27838968976", "Kyle", "Smith");
        assertTrue(login.loginUser("kyl_1", "Ch&&sec@ke99!"));
    }

    @Test
    public void testLoginUser_Failed() {
        Login login = new Login("kyl_1", "Ch&&sec@ke99!", "+27838968976", "Kyle", "Smith");
        assertFalse(login.loginUser("kyl_1", "wrongPassword1!"));
    }

    // ---------- returnLoginStatus() tests ----------

    @Test
    public void testReturnLoginStatus_Successful() {
        Login login = new Login("kyl_1", "Ch&&sec@ke99!", "+27838968976", "Kyle", "Smith");
        assertEquals(
            "Welcome Kyle, Smith it is great to see you again.",
            login.returnLoginStatus(true)
        );
    }

    @Test
    public void testReturnLoginStatus_Failed() {
        Login login = new Login("kyl_1", "Ch&&sec@ke99!", "+27838968976", "Kyle", "Smith");
        assertEquals(
            "Username or password incorrect, please try again.",
            login.returnLoginStatus(false)
        );
    }
}
