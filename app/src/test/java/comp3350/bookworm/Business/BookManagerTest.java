package comp3350.bookworm.Business;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

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
            fail("Failed not expected");
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
            fail("Failed not expected");
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
            fail("Failed not expected");
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

        }
        catch (BookNotFoundException e)
        {
            fail("Failed not expected");
        }


        assertTrue(bookFound == null);

        System.out.println("Finishing test delete Book");
    }

    @Test
    public void testBestSeller()
    {
        System.out.println("\nStarting test Best Seller list sort");
        ArrayList<Book> bookList = new ArrayList<Book>();
        ArrayList<Book> bestSellerList = new ArrayList<Book>();
        long booksAdded = 0;

        bookList.add(new Book("Franklin Goes to School", "Paulette Bourgeois", "Children's Book", "Childrens", 15.0, 5.0, 99));
        booksAdded++;
        bookList.add(new Book("Franklin Plays the Game", "Paulette Bourgeois", "Children's Book", "Childrens", 15.0, 5.0, 99));
        booksAdded++;
        bookList.add(new Book("Franklin's Bad Day", "Paulette Bourgeois", "Children's Book", "Childrens", 15.0, 5.0, -1));
        booksAdded++;
        bookList.add(new Book("Franklin Is Bossy", "Paulette Bourgeois", "Children's Book", "Childrens", 15.0, 5.0, 999999999));
        booksAdded++;
        bookList.add(new Book("Franklin Has a Sleepover", "Paulette Bourgeois", "Children's Book", "Childrens", 15.0, 5.0, 88));
        booksAdded++;
        bookList.add(new Book("Franklin Is Messy", "Paulette Bourgeois", "Children's Book", "Childrens", 15.0, 5.0, 3));
        booksAdded++;
        bookList.add(new Book("Franklin and the Tooth Fairy", "Paulette Bourgeois", "Children's Book", "Childrens", 15.0, 5.0, 2));
        booksAdded++;
        bookList.add(new Book("Franklin is Lost", "Paulette Bourgeois", "Children's Book", "Childrens", 15.0, 5.0, 1));
        booksAdded++;

        try{
            bestSellerList = BookManager.getBestSellerList(bookList);
        }
        catch (Exception e)
        {
            fail("Failed not expected");
        }

        for(int i = 0; i < bookList.size()-1; i++) {
            assertTrue(bestSellerList.get(i).getBookSoldNum() >= bestSellerList.get(i + 1).getBookSoldNum());
        }
        assertTrue(bestSellerList.size() == booksAdded);

        System.out.println("Finishing test Best Seller list sort");
    }
}
