package controller;
import service.BookService;
import service.RentService;

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