package comp3350.bookworm.Objects;

import org.junit.Test;

import static org.junit.Assert.*;

public class AccountTest {
    @Test
    public void testAccount1()
    {
        Account account;

        System.out.println("\nStarting testAccount1");

        account = new Account("admin", "adminPassword");

        assertNotNull(account);
        assertTrue("admin".equals(account.getUserName()));
        assertTrue("adminPassword".equals(account.getPassword()));

        System.out.println("Finished testAccount1");
    }

    @Test
    public void testAccount2()
    {
        Account account;

        System.out.println("\nStarting testAccount2");

        account = new Account("admin", "adminPassword", "email@bookworm.ca");

        assertNotNull(account);
        assertTrue("admin".equals(account.getUserName()));
        assertTrue("adminPassword".equals(account.getPassword()));
        assertTrue("email@bookworm.ca".equals(account.getEmail()));

        System.out.println("Finished testAccount2");
    }

}
