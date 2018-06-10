package comp3350.bookworm.BusinessLogic;

import java.util.ArrayList;
import java.util.Collections;
<<<<<<< HEAD
=======
import java.util.List;
>>>>>>> 796ba1d5e3bcba6ad59bad7b8161d18b4aad3f5b

import comp3350.bookworm.Application.Service;
import comp3350.bookworm.Objects.Book;
import comp3350.bookworm.Objects.BookNotFoundException;
import comp3350.bookworm.Objects.NoBookNameFoundException;
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

    public boolean AddBook(Book bookToadd)
    {
        if(bookToadd.getBookName().length() > 0)
        {
            bookListStub.insertBook(bookToadd);
            return true;
        }
        else
        {
            return false;
        }

    }

    public Book SearchBook(String bookName) throws  BookNotFoundException{
        Book bookToReturn = bookListStub.getBook(bookName);
        return bookToReturn;
    }
    public void DeleteBook(String bookName) throws BookNotFoundException
    {
        bookListStub.deleteBook(bookName);
    }

    public ArrayList<Book> GetBookList()
    {
       return bookListStub.getBookList();
    }

<<<<<<< HEAD


=======
    public List<Book> searchSimilarBooks (String text){
        return (List<Book>)bookListStub.getSimilarBooks(text);
    }
>>>>>>> 796ba1d5e3bcba6ad59bad7b8161d18b4aad3f5b
}
