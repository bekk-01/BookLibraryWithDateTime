package service;

import exception.DataNotFoundException;
import model.Book;
import repository.BookRepository;

import java.util.*;

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
    public Book getByCode(Integer bookCode) throws DataNotFoundException {
        return repository.getByCode(bookCode).orElseThrow(
                () -> new DataNotFoundException("Data not found")
        );
    }

    public Book getById(UUID bookId) throws DataNotFoundException{
        return repository.getById(bookId).orElseThrow(
                () -> new DataNotFoundException("Data not found")
       );
    }
}
