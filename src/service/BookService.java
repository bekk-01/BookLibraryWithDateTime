package service;

import model.Book;
import repository.BaseRepository;
import repository.BookRepository;

public class BookService extends BaseService<Book, BookRepository> {
    private static final BookService bookService = new BookService();
    public static BookService getInstance(){
        return bookService;
    }
    private BookService(){
        super(BookRepository.getInstance());
    }
}
