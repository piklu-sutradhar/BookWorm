package comp3350.bookworm.Persistence.stubs;

import java.util.ArrayList;
import java.util.List;

import comp3350.bookworm.Objects.Book;
import comp3350.bookworm.Persistence.BookListPersistence;

public class BookListStub implements BookListPersistence {
    private ArrayList<Book> bookList;

    public BookListStub()
    {
        this.bookList = new ArrayList<Book>();

        bookList.add(new Book("C++", "Daniel J. Fung", "Programming book", 5.0));
        bookList.add(new Book("Java", "Daniel J. Fung", "Programming book", 5.0));
        bookList.add(new Book("Rubi on Reils", "Daniel J. Fung", "Programming book", 5.0));
        bookList.add(new Book("C#", "Daniel J. Fung", "Programming book", 5.0));
    }

    @Override
    public void insertBook(Book book) {
        this.bookList.add(book);
    }

    public void setBookList(ArrayList<Book> bookList) {
        this.bookList = bookList;
    }

    @Override
    public Book searchBook(String bookName) {
        Book bookToreturn = null;

        for (int i = 0; i < bookList.size() && bookToreturn != null; i++) {
            if(bookList.get(i).getBookName().equalsIgnoreCase(bookName)) {
                bookToreturn = bookList.get(i);
            }
        }
        return bookToreturn;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void deleteBook(String bookName)
    {
        boolean deleted = false;
        for (int i = 0; i < bookList.size() && deleted == false; i++)
        {
            if(bookList.get(i).getBookName().equalsIgnoreCase(bookName))
            {
                bookList.remove(i);
                deleted = true;
            }
        }
    }
}
