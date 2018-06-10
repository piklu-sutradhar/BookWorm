package comp3350.bookworm;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import comp3350.bookworm.Business.AccountManagerTest;
import comp3350.bookworm.Business.BookManagerTest;
import comp3350.bookworm.Objects.Account;
import comp3350.bookworm.Objects.AccountTest;
import comp3350.bookworm.Objects.BookTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        AccountTest.class,
        AccountManagerTest.class,
<<<<<<< HEAD
        BookTest.class
=======
        BookManagerTest.class
>>>>>>> 796ba1d5e3bcba6ad59bad7b8161d18b4aad3f5b
})

public class AllTests
{

}
