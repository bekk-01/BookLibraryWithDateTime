package controller;
import model.Book;
import service.BookService;
import service.RentService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import static controller.BookController.bookLibrary;
import static controller.RentController.rentBook;

public class Main {
    public static final Scanner scanInt = new Scanner(System.in);
    public static final Scanner scanStr = new Scanner(System.in);
    public static final BookService bookService = BookService.getInstance();
    public static final RentService rentService = RentService.getInstance();
    public static void main(String[] args) {
        mainMenu();
    }
    static {
        bookService.add(new Book("olcha","axmat","10", LocalDate.parse("23/10/2000", DateTimeFormatter.ofPattern("dd/MM/yyyy")),3, LocalDate.parse("23/10/2005", DateTimeFormatter.ofPattern("dd/MM/yyyy")),100D));
        bookService.add(new Book("olma","jeck","10", LocalDate.parse("23/10/2001", DateTimeFormatter.ofPattern("dd/MM/yyyy")),3, LocalDate.parse("23/10/2006", DateTimeFormatter.ofPattern("dd/MM/yyyy")),100D));
        bookService.add(new Book("anor","azamat","10", LocalDate.parse("23/10/2002", DateTimeFormatter.ofPattern("dd/MM/yyyy")),3, LocalDate.parse("23/10/2007", DateTimeFormatter.ofPattern("dd/MM/yyyy")),100D));

    }

    public static void mainMenu(){
        System.out.println("1.Book Library\t2.Rent Book\t0.Exit");
        String command = scanStr.nextLine();
        switch (command){
            case "1" -> bookLibrary();
            case "2" -> rentBook();
            case "0" -> {
                return;
            }
            default -> mainMenu();
        }
    }
}