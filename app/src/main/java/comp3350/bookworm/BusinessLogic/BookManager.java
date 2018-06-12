package comp3350.bookworm.BusinessLogic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import comp3350.bookworm.Application.Service;
import comp3350.bookworm.Objects.Book;
import comp3350.bookworm.Objects.BookNotFoundException;
import comp3350.bookworm.Objects.DuplicateBookException;
import comp3350.bookworm.Objects.InvalidAccountException;
import comp3350.bookworm.Objects.InvalidBookException;
import comp3350.bookworm.Persistence.stubs.BookListStub;

public class BookManager {
    private BookListStub bookListStub;

    public BookManager(){
        bookListStub = Service.getBookListStub();
    }

    public void AddBook(Book bookToadd) throws DuplicateBookException, InvalidBookException {
        bookListStub.insertBook(bookToadd);
    }

    public Book SearchBook(String bookName) throws BookNotFoundException{
        return bookListStub.getBook(bookName);
    }

    public void DeleteBook(String bookName) throws BookNotFoundException {
        bookListStub.deleteBook(bookName);
    }

    public ArrayList<Book> getBookList()
    {
       return bookListStub.getBookList();
    }

    public static ArrayList<Book> getBestSellerList(ArrayList<Book> baseList) {
        Collections.sort(baseList);

        return baseList;
    }

    public ArrayList<Book> getOrderHistoryForCurrentUser() throws InvalidAccountException{
        return Service.getOrderHistoryStub().getOrderHistoryCurrentUser();
    }

}
