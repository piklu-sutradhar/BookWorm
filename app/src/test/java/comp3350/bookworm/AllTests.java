package comp3350.bookworm;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import comp3350.bookworm.Business.AccountManagerTest;
import comp3350.bookworm.Objects.Account;
import comp3350.bookworm.Objects.AccountTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        AccountTest.class,
        AccountManagerTest.class
})

public class AllTests
{

}
