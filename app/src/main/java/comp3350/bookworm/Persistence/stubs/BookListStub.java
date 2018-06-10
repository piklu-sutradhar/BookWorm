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

        bookList.add(new Book("C++", "Daniel J. Fung", "Programming book", "Programming", 5.0));
        bookList.add(new Book("Java", "Daniel J. Fung", "Programming book", "Programming",5.0));
        bookList.add(new Book("Rubi on Reils", "Daniel J. Fung", "Programming book", "Programming", 5.0));
        bookList.add(new Book("C#", "Daniel J. Fung", "Programming book","Programming", 5.0));
        bookList.add(new Book("C++", "Daniel J. Fung", "Programming", 5.0, 0, 7));
        bookList.add(new Book("C++ : The Return of the C++ King", "Daniel J. Fung", "Programming", 5.0, 1, 8));
        bookList.add(new Book("Java", "Daniel J. Fung", "Programming", 5.0, 19, 88));
        bookList.add(new Book("Ruby on Rails", "Daniel J. Fung", "Programming", 5.0, 2, 0));
        bookList.add(new Book("ABC's For Kids", "Daniel J. Fung", "Childrens", 5.0, 5, 1));
        bookList.add(new Book("Cooking with Fire: BBQ recipes", "Daniel J. Fung", "Cooking", 5.0, 88, 2));
        bookList.add(new Book("Steamy Romance", "Daniel J. Fung", "Romance", 5.0, 4, 3));
        bookList.add(new Book("How to Fix an ID10T error Vol 2", "Daniel J. Fung", "Programming", 5.0, 99, 4));
        bookList.add(new Book("How to Fix and ID10T error Vol 1", "Daniel J. Fung", "Programming", 5.0, 99, 5));
        bookList.add(new Book("Harry Potter and the Evil Potato", "Daniel J. Fung", "Fantasy", 5.0, 999, 6));
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

    public ArrayList<Book> getBestSellerList() {
        ArrayList<Book> bestSellerList = getBookList();
        Collections.sort(bestSellerList);

        return bestSellerList;
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
