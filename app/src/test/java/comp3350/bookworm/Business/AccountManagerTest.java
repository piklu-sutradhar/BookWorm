package comp3350.bookworm.Business;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import comp3350.bookworm.BusinessLogic.AccountManager;
import comp3350.bookworm.Objects.InvalidCredentialException;
import comp3350.bookworm.Objects.Account;

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

        String username = "SomeUsername";
        String password = "SomePassword";

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

        System.out.println("Finishing testValidCredential");

    }

}
