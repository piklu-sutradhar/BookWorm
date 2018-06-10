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
    public void testValidAddBook()
    {
        System.out.println("\nStarting test valid Book add");
        Book bookToAdd = new Book("Bengali", "Shamoresh","Bangali book", "10.0",5.0);

        bookManager.AddBook(bookToAdd);

        Book bookFound = null;

        try{
            bookFound = bookManager.SearchBook("Bengali");
            bookManager.DeleteBook("Bengali");
            //fail("Failed expected");
        }
        catch (BookNotFoundException e)
        {

        }
        assertTrue(bookFound.getBookName().equals("Bengali"));


        System.out.println("Finishing test valid Book add");
    }

    @Test
    public void testInvalidAddBook()
    {
        System.out.println("\nStarting test invalid Book add");
        Book bookToAdd = new Book("", "Shamoresh","Bangali book", "10.0",5.0);

        bookManager.AddBook(bookToAdd);

        Book bookFound = null;

        try{
            bookFound = bookManager.SearchBook("");
        }
        catch (BookNotFoundException e)
        {
            System.out.println(e.getMessage());
        }
        assertTrue(bookFound == null);

        System.out.println("Finishing test invalid Book add");
    }
    @Test
    public void testDeleteBook()
    {
        System.out.println("\nStarting test delete Book");
        Book bookToAdd = new Book("Game of thrones", "Shamoresh","Bangali book", "10.0",5.0);

        bookManager.AddBook(bookToAdd);

        Book bookFound = null;

        try{
            bookManager.DeleteBook("Game of thrones");
            bookFound = bookManager.SearchBook("Game of thrones");
            //fail("Failed expected");
        }
        catch (BookNotFoundException e)
        {

        }


        assertTrue(bookFound == null);

        System.out.println("Finishing test delete Book");
    }
}
