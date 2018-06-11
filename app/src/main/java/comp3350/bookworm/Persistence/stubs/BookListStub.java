package comp3350.bookworm.Persistence.stubs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import comp3350.bookworm.Objects.Book;
import comp3350.bookworm.Persistence.BookListPersistence;

public class BookListStub implements BookListPersistence {
    private ArrayList<Book> bookList;

    public BookListStub()
    {
        this.bookList = new ArrayList<Book>();

        bookList.add(new Book("C++", "Daniel J. Fung", "Programming book", "Programming", 10.0, 5.0, 1));
        bookList.add(new Book("Java", "Daniel J. Fung", "Programming book", "Programming", 10.0, 5.0, 2));
        bookList.add(new Book("C#", "Daniel J. Fung", "Programming book", "Programming", 10.0, 5.0, 3));
        bookList.add(new Book("C++ : The Return of the C++ King", "Daniel J. Fung", "Programming book", "Programming", 10.0, 5.0, 4));
        bookList.add(new Book("Ruby on Rails", "Daniel J. Fung", "Programming book", "Programming", 10.0, 5.0, 5));
        bookList.add(new Book("ABC's For Kids", "Daniel J. Fung", "Children's book", "Children's", 10.0, 5.0, 6));
        bookList.add(new Book("Cooking with Fire: BBQ recipes", "Daniel J. Fung", "Cooking book", "Cooking", 10.0, 5.0, 7));
        bookList.add(new Book("Steamy Romance 5: The Reckoning", "Daniel J. Fung", "Romance book", "Romance", 10.0, 5.0, 8));
        bookList.add(new Book("How to Fix an ID10T error Vol 2", "Daniel J. Fung", "Programming book", "Programming", 10.0, 5.0, 9));
        bookList.add(new Book("How to Fix an ID10T error Vol 1", "Daniel J. Fung", "Programming book", "Programming", 10.0, 5.0, 10));
        bookList.add(new Book("Harry Potter and the Evil Potato", "Daniel J. Fung", "Fantasy book", "Fantasy", 10.0, 5.0, 11));
    }

    @Override
    public void insertBook(Book book) {
        this.bookList.add(book);
    }

    public void setBookList(ArrayList<Book> bookList) {
        this.bookList = bookList;
    }

    // TODO: this works!!!
    public Book getBook(String bookName) {
        for(Book book : bookList) {
            if(book.getBookName().equals(bookName))
                return book;
        }
        return null;
    }

    public ArrayList<Book> getBookList() {
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
    public List<Book> getSimilarBooks(String text)
    {
        List<Book> returnList = new ArrayList<Book>();

        for (Book current:bookList
             ) {
            int letterMatched = 0;
            for (int i = 0; i < text.length(); i++)
            {
                if(current.getBookName().contains(text.substring(i,1)))
                {
                  letterMatched++;
                }
            }
            if(letterMatched == text.length())
            {
                returnList.add(current);
            }
        }
        return returnList;
    }
}
