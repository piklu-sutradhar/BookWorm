package comp3350.bookworm.Business;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import comp3350.bookworm.BusinessLogic.AccountManager;
import comp3350.bookworm.BusinessLogic.BookManager;
import comp3350.bookworm.Objects.Account;
import comp3350.bookworm.Objects.Book;
import comp3350.bookworm.Objects.BookNotFoundException;
import comp3350.bookworm.Objects.DuplicateBookException;
import comp3350.bookworm.Objects.DuplicateUsernameException;
import comp3350.bookworm.Objects.InvalidAccountException;
import comp3350.bookworm.Objects.InvalidBookException;
import comp3350.bookworm.Objects.InvalidCredentialException;
import comp3350.bookworm.Objects.InvalidEmailAddressException;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNull;
import static junit.framework.Assert.assertTrue;
import static junit.framework.Assert.fail;

public class BookManagerTest {
    private BookManager bookManager;
    private AccountManager accountManager;

    @Before
    public void setup() {
        bookManager = new BookManager();
        accountManager = new AccountManager();
    }

    @After
    public void tearDown() {
        bookManager = null;
        accountManager = null;
    }

    @Test
    public void testGetBookList() {
        System.out.println("\nStarting test get BookList");

        ArrayList<Book> booklist = bookManager.getBookList();

        assertNotNull(booklist);

        System.out.println("\nFinishing test get BookList");
    }

    @Test
    public void testValidSearchBook() {
        System.out.println("\nStarting test valid searchBook");
        Book bookToTest = null;
        try {
            bookToTest = bookManager.searchBook("Java");
        }
        catch (BookNotFoundException e) {
            fail("Exception not expected");
        }
        assertTrue(bookToTest.getBookName().equals("Java"));

        System.out.println("Finishing test valid searchBook");
    }

    @Test
    public void testInvalidSearchBook() {
        System.out.println("\nStarting test invalid searchBook");
        Book bookToTest = null;

        try {
            bookToTest = bookManager.searchBook("");
            fail("Failed expected");
        }
        catch (BookNotFoundException e) {

        }
        assertTrue(bookToTest == null);

        System.out.println("Finishing test invalid searchBook");
    }
    @Test
    public void testValidAddBook()
    {
        System.out.println("\nStarting test valid Book add");
        Book bookToAdd = new Book("Bengali", "Shamoresh","Bangali book", "10.0",5.0, 5, 0);

        try {
            bookManager.addBook(bookToAdd);
        }
        catch (DuplicateBookException e) {
            fail("Exception not expected");
        }
        catch (InvalidBookException e) {
            fail("Exception not expected");
        }

        Book bookFound = null;

        try{
            bookFound = bookManager.searchBook("Bengali");
            assertTrue(bookFound.getBookName().equals("Bengali"));
            bookManager.deleteBook("Bengali");
        }
        catch (BookNotFoundException e)
        {
            fail("Exception not expected");
        }

        System.out.println("Finishing test valid Book add");
    }

    @Test
    public void testInvalidAddBook()
    {
        System.out.println("\nStarting test invalid Book add");
        Book bookToAdd = new Book("", "Shamoresh","Bangali book", "10.0",5.0, 5, 0);

        try {
            bookManager.addBook(bookToAdd);
            fail("Failed expected");
        }
        catch (DuplicateBookException e) {
            fail("Exception not expected");
        }
        catch (InvalidBookException e) {

        }

        Book bookFound = null;

        try{
            bookFound = bookManager.searchBook("");
            fail("Failed expected");
        }
        catch (BookNotFoundException e) {

        }
        assertTrue(bookFound == null);

        System.out.println("Finishing test invalid Book add");
    }

    @Test
    public void testInvalidAddBookDuplicate()
    {
        System.out.println("\nStarting test invalid Book add duplicate");
        Book bookToAdd = new Book("duplicate book", "Shamoresh","Bangali book", "10.0",5.0, 5, 0);

        try {
            bookManager.addBook(bookToAdd);
        }
        catch (DuplicateBookException e) {
            fail("Exception not expected");
        }
        catch (InvalidBookException e) {
            fail("Exception not expected");
        }

        try {
            bookManager.addBook(bookToAdd);
            fail("Failed expected");
        }
        catch (DuplicateBookException e) {

        }
        catch (InvalidBookException e) {
            fail("Exception not expected");
        }

        System.out.println("Finishing test invalid Book add duplicate");
    }

    @Test
    public void testDeleteBook()
    {
        System.out.println("\nStarting test delete Book");
        Book bookToAdd = new Book("Game of thrones", "Shamoresh","Bangali book", "10.0",5.0, 5, 0);

        try {
            bookManager.addBook(bookToAdd);
        }
        catch (DuplicateBookException e) {
            fail("Exception not expected");
        }
        catch (InvalidBookException e) {
            fail("Exception not expected");
        }

        Book bookFound = null;

        try{
            bookManager.deleteBook("Game of thrones");
            bookFound = bookManager.searchBook("Game of thrones");
            fail("Failed expected");
        }
        catch (BookNotFoundException e) {

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
            fail("Exception not expected");
        }

        for(int i = 0; i < bookList.size()-1; i++) {
            assertTrue(bestSellerList.get(i).getBookSoldNum() >= bestSellerList.get(i + 1).getBookSoldNum());
        }
        assertTrue(bestSellerList.size() == booksAdded);

        System.out.println("Finishing test Best Seller list sort");
    }

    @Test
    public void testInvalidGetOrderHistoryNoLogin() {
        System.out.println("\nStarting test invalid get order history no login");

        ArrayList<Book> booklist = null;
        accountManager.logout();

        try {
            booklist = bookManager.getOrderHistoryForCurrentUser();
            fail("Fail expected");
        }
        catch (InvalidAccountException e) {

        }
        catch (BookNotFoundException e) {
            fail("Exception not expected");
        }
        assertNull(booklist);
        System.out.println("\nFinishing test invalid get order history no login");
    }

    @Test
    public void testGetOrderHistoryNoHistory() {
        System.out.println("\nStarting test get order history when there is no history");

        ArrayList<Book> booklist = null;
        String username = "new account";
        String password = "new password";
        String email = "new@bookworm.ca";
        Account newAccount = new Account(username, password, email);

        try {
            accountManager.singup(newAccount);
            accountManager.login(newAccount);
            booklist = bookManager.getOrderHistoryForCurrentUser();
            fail("Fail expected");
        }
        catch (InvalidAccountException e) {
            fail("Exception not expected");
        }
        catch (DuplicateUsernameException e){
            fail("Exception not expected");
        }
        catch (InvalidCredentialException e) {
            fail("Exception not expected");
        }
        catch (InvalidEmailAddressException e) {
            fail("Exception not expected");
        }
        catch (BookNotFoundException e) {

        }
        assertNull(booklist);
        accountManager.logout();
        System.out.println("\nFinishing test get order history when this is no history");
    }

    @Test
    public void testValidGetOrderHistory() {
        System.out.println("\nStarting test valid get order history");

        ArrayList<Book> booklist = null;
        String username = "admin";
        String password = "admin";

        try {
            accountManager.login(new Account(username, password));
            booklist = bookManager.getOrderHistoryForCurrentUser();
        }
        catch (InvalidCredentialException e) {
            fail("Exception not expected");
        }
        catch (InvalidAccountException e) {
            fail("Exception not expected");
        }
        catch (BookNotFoundException e) {
            fail("Exception not expected");
        }
        assertNotNull(booklist);
        System.out.println("\nFinishing test valid get order history");
    }
}
