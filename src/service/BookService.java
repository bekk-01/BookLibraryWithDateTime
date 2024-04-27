package service;

import model.Book;
import repository.BaseRepository;
import repository.BookRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class BookService extends BaseService<Book, BookRepository> {
    private static final BookService bookService = new BookService();
    public static BookService getInstance(){
        return bookService;
    }
    private BookService(){
        super(BookRepository.getInstance());
    }
    public ArrayList<Book> searchByTitle(String search){
        ArrayList<Book> list = repository.searchByTitle(search);
        Comparator<Book> books = new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o2.getPublishDate().compareTo(o1.getPublishDate());
            }
        };
        Collections.sort(list,books);
        return list;
    }
    public ArrayList<Book> searchByPublishDate(String search){
        return repository.searchByPublishDate(search);
    }
    public ArrayList<Book> searchByWrittenYear(String search){
        return repository.searchByWrittenYear(search);
    }
}
