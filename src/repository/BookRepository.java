package repository;

import model.Book;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

public class BookRepository extends BaseRepository<Book> {
    private static final BookRepository bookRepository = new BookRepository();

    public static BookRepository getInstance() {
        return bookRepository;
    }

    private BookRepository() {

    }

    public ArrayList<Book> searchByTitle(String search) {
        ArrayList<Book> list = new ArrayList<>();
        for (Book book : getActive()) {
            if (book.getTitle().contains(search)) {
                list.add(book);
            }
        }
        return list;
    }

    public ArrayList<Book> searchByPublishDate(String search) {
        ArrayList<Book> list = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date = LocalDate.parse(search, formatter);
        for (Book book : getActive()) {
            if (book.getPublishDate().isEqual(date)) {
                list.add(book);
            }
        }
        return list;
    }

    public ArrayList<Book> searchByWrittenYear(String search) {
        ArrayList<Book> list = new ArrayList<>();
        int parseInt = Integer.parseInt(search);
        for (Book book : getActive()) {
            if (book.getPublishDate().getYear() == parseInt) {
                list.add(book);
            }
        }
        return list;
    }
    public Optional<Book> getByCode(Integer bookCode){
        for (Book book : getActive()) {
            if(Objects.equals(book.getCode(), bookCode)){
                return Optional.of(book);
            }
        }
        return Optional.empty();
    }


    public Optional<Book> getById(UUID bookId) {
        for (Book datum : data) {
            if(Objects.equals(datum.getId(),bookId)){
                return Optional.of(datum);
            }
        }
        return Optional.empty();
    }
}
