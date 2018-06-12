package comp3350.bookworm.Business;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import comp3350.bookworm.BusinessLogic.AccountManager;
import comp3350.bookworm.Objects.DuplicateUsernameException;
import comp3350.bookworm.Objects.InvalidCredentialException;
import comp3350.bookworm.Objects.Account;
import comp3350.bookworm.Objects.InvalidEmailAddressException;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
import static junit.framework.Assert.fail;


public class AccountManagerTest {
    private AccountManager accountManager;

    @Before
    public void setup() {
        accountManager = new AccountManager();
    }

    @After
    public void tearDown() {
        accountManager = null;
    }

    @Test
    public void testInvalidCredential() {
        System.out.println("\nStarting testInvalidCredential");

        String username = "SomeInvalidUsername";
        String password = "SomeInvalidPassword";

        try {
            accountManager.login(new Account(username, password));
            fail("Exception expected.");
        }
        catch (InvalidCredentialException e) {

        }

        System.out.println("Finishing testInvalidCredential");
    }

    @Test
    public void testValidCredential() {
        System.out.println("\nStarting testValidCredential");

        assertFalse(accountManager.anyLoggedInUser());

        String username = "admin";
        String password = "admin";

        try {
            accountManager.login(new Account(username, password));
        }
        catch (InvalidCredentialException e) {
            fail("Exception not expected.");
        }

        assertTrue(accountManager.anyLoggedInUser());
        assertEquals(username, accountManager.getLoggedInUsername());

        System.out.println("Finishing testValidCredential");

    }

    @Test
    public void testEmailValidator() {
        System.out.println("\nStarting testEmailValidator");

        String invalidEmail = "this is invalid email";
        String validEmail = "admin@bookworm.ca";

        assertFalse(accountManager.isValidEmailAddress(invalidEmail));
        assertTrue(accountManager.isValidEmailAddress(validEmail));

        System.out.println("Finishing testEmailValidator");
    }

    @Test
    public void testInvalidEmail() {
        System.out.println("\nStarting testInvaliEmail");

        String username = "userName1";
        String password = "passWord1";
        String email = "this is invalid email";

        try {
            accountManager.singup(new Account(username, password, email));
            fail("Exception expected.");
        } catch (DuplicateUsernameException e) {
            fail("Exception not expected.");
        } catch (InvalidEmailAddressException e) {

        }

        System.out.println("Finishing testValidCredential");
    }

    @Test
    public void testDuplicateUser() {
        System.out.println("\nStarting testDuplicateUser");

        String username = "admin";
        String password = "admin";
        String email = "admin@bookworm.ca";

        try {
            accountManager.singup(new Account(username, password, email));
            fail("Exception expected.");
        } catch (DuplicateUsernameException e) {

        } catch (InvalidEmailAddressException e) {
            fail("Exception not expected.");
        }

        System.out.println("Finishing testDuplicateUser");
    }

    @Test
    public void testValidSignup() {
        System.out.println("\nStarting testValidSignup");

        String username = "user1";
        String password = "pass1";
        String email = "user1@bookworm.ca";

        try {
            accountManager.singup(new Account(username, password, email));
        } catch (DuplicateUsernameException e) {
            fail("Exception not expected.");
        } catch (InvalidEmailAddressException e) {
            fail("Exception not expected.");
        }

        System.out.println("Finishing testValidSignup");
    }

    @Test
    public void testLogout() {
        System.out.println("\nStarting testLogout");

        accountManager.logout();
        assertFalse(accountManager.anyLoggedInUser());

        String username = "admin";
        String password = "admin";

        try {
            accountManager.login(new Account(username, password));
        }
        catch (InvalidCredentialException e) {
            fail("Exception not expected.");
        }

        assertTrue(accountManager.anyLoggedInUser());
        assertEquals(username, accountManager.getLoggedInUsername());

        accountManager.logout();

        assertFalse(accountManager.anyLoggedInUser());

        System.out.println("Finishing testLogout");
    }



}
