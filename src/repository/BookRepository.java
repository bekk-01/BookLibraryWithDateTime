package repository;
import model.Book;

public class BookRepository extends BaseRepository<Book> {
    private static final BookRepository bookRepository = new BookRepository();
    public static BookRepository getInstance(){
        return bookRepository;
    }
    private BookRepository(){

    }
}
