package comp3350.bookworm.BusinessLogic;

import java.util.ArrayList;
import java.util.Collections;

import comp3350.bookworm.Application.Service;
import comp3350.bookworm.Objects.Book;
import comp3350.bookworm.Persistence.stubs.BookListStub;

public class BookManager {
    private BookListStub bookListStub;
    private ArrayList<Book> bookList;
    private Book book;

    public BookManager(){
        bookListStub = Service.getBookListStub();
        book = null;
        bookList = null;
    }

    public void AddBook(Book bookToadd)
    {
        bookListStub.insertBook(bookToadd);
    }

    public Book SearchBook(String bookName)
    {
        Book bookToReturn = bookListStub.searchBook(bookName);

        return bookToReturn;
    }
    public void DeleteBook(String bookName)
    {
        bookListStub.deleteBook(bookName);
    }

    public ArrayList<Book> GetBookList()
    {
       return bookListStub.getBookList();
    }



}
