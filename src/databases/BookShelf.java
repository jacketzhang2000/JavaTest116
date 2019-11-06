package databases;

import classes.Book;
import exceptions.NoSuchBookException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BookShelf {
    private List<Book> bookList=new ArrayList<>();
    private static BookShelf instance =new BookShelf();
    public static BookShelf getInstance() {
        return instance;
    }

    public Book search(String isbn) throws NoSuchBookException {
    for(Book book:bookList){
        if(book.is(isbn)){
            return book;
        }
    }
    throw new NoSuchBookException(isbn);
    }

    public void putBook(Book book) {
        bookList.add(book);
    }

    public List<Book> queryBooks(Where<Book> where, Comparator<Book> b) {
        List<Book> ret =new ArrayList<>();
        for(Book book:bookList){
            if(where ==null||where.test(book)){
                ret.add(book);
            }
        }
        //外面更改不会影响书架的书籍情况
        return ret;
    }
}
