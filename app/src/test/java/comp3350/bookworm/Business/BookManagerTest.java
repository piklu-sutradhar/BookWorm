package comp3350.bookworm.Business;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import comp3350.bookworm.BusinessLogic.BookManager;
import comp3350.bookworm.Objects.Book;
import comp3350.bookworm.Objects.BookNotFoundException;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
import static junit.framework.Assert.fail;

public class BookManagerTest {
    private BookManager bookManager;

    @Before
    public void setup() {
        bookManager = new BookManager();
    }

    @After
    public void tearDown() {
        bookManager = null;
    }

    @Test
    public void testValidSearchBook() {
        System.out.println("\nStarting test valid SearchBook");
        Book bookToTest = null;
        try
        {
            bookToTest = bookManager.SearchBook("Java");
        }
        catch (BookNotFoundException e)
        {
            fail("Failed not expected");
        }
         assertTrue(bookToTest.getBookName().equals("Java"));

        System.out.println("Finishing test valid SearchBook");
    }
    @Test
    public void testInalidSearchBook() {
        System.out.println("\nStarting test invalid SearchBook");
        Book bookToTest = null;

        try{
            bookToTest = bookManager.SearchBook("");
            //fail("Failed expected");
        }
        catch (BookNotFoundException e)
        {

        }
        assertTrue(bookToTest == null);

        System.out.println("Finishing test invalid SearchBook");
    }
    @Test
    public void testAddBook()
    {
        System.out.println("\nStarting test add Book");
        Book bookToAdd = new Book("Bengali", "Shamoresh","Bangali book", "10.0",5.0);

        bookManager.AddBook(bookToAdd);

        Book bookFound = null;

        try{
            bookFound = bookManager.SearchBook("Bengali");
            //fail("Failed expected");
        }
        catch (BookNotFoundException e)
        {

        }
        assertTrue(bookFound.getBookName().equals("Bengali"));

        System.out.println("Finishing test add Book");
    }
}
