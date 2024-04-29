package controller;

import model.Book;
import utils.Message;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;

import static controller.Main.*;

public class BookController {
    public static void bookLibrary(){
        String menu = """
                1. CRUD book
                2. Search by title
                3. search by publish date
                4. search by written year
                0. Exit
                """;
        System.out.println(menu);
        String command = scanStr.nextLine();
        switch (command){
            case "1" -> crudMenu();
            case "2" -> searchByTitle();
            case "3" -> searchByPublishDate();
            case "4" -> searchByWrittenYear();
            case "0" -> mainMenu();
            default -> bookLibrary();
        }
    }

    private static void searchByWrittenYear() {
        System.out.print("Search by written year: ");
        String year = scanStr.nextLine();
        try{
            ArrayList<Book> books = bookService.searchByWrittenYear(year);
            if(books.isEmpty()){
                System.out.println(Message.EMPTY);
                bookLibrary();
            }
            int i = 1;
            Iterator<Book> bookIterator = books.iterator();
            while (bookIterator.hasNext()){
                System.out.println(i++ + ". "+ bookIterator.next());
            }
        }catch (DateTimeParseException | InputMismatchException | NumberFormatException e){
            System.out.println(e.getMessage());
        }
        bookLibrary();
    }

    private static void searchByPublishDate() {
        System.out.print("Search by publish date(dd/MM/yyyy): ");
        String date = scanStr.nextLine();
        try {
            ArrayList<Book> books = bookService.searchByPublishDate(date);
            if(books.isEmpty()){
                System.out.println(Message.EMPTY);
                bookLibrary();
            }
            int i =1;
            Iterator<Book> ite = books.iterator();
            while (ite.hasNext()){
                System.out.println(i++ +". "+ ite.next());
            }
        }catch (DateTimeParseException | InputMismatchException e){
            System.out.println(e.getMessage());
        }
        bookLibrary();
    }

    private static void searchByTitle() {
        System.out.print("Search by title: ");
        String text = scanStr.nextLine();
        ArrayList<Book> list = bookService.searchByTitle(text);
        if(list.isEmpty()){
            System.out.println(Message.EMPTY);
            bookLibrary();
        }
        int i = 1;
        for (Book book : list) {
            System.out.println(i++ + ". " + book);
        }
        bookLibrary();
    }

    private static void crudMenu() {
        while (true) {
            System.out.println("1.Create\t2.Read\t3.Update\t4.Delete\t0.Exit");
            String command = scanStr.nextLine();
            switch (command) {
                case "1" -> create();
                case "2" -> read();
                case "3" -> update();
                case "4" -> delete();
                case "0" -> bookLibrary();
                default -> crudMenu();
            }
        }
    }

    private static void delete() {
        ArrayList<Book> books = read();
        if(books.isEmpty()){
            System.out.println("Empty!!!");
            crudMenu();
        }
        try{
            System.out.print("Enter choice: ");
            int choice = scanInt.nextInt() -1;
            bookService.delete(books.get(choice).getId());
            System.out.println(Message.SUCCESSFULLY);
        }catch (InputMismatchException | IndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }
    }

    private static void update() {
        ArrayList<Book> books = read();
        if(books.isEmpty()){
            System.out.println("Empty!!!");
            crudMenu();
        }
        try{
            System.out.print("Enter choice: ");
            int choice = scanInt.nextInt() -1;

            System.out.print("Enter new title: ");
            String title = scanStr.nextLine();

            System.out.print("Enter new author: ");
            String author = scanStr.nextLine();

            System.out.print("Enter new number of pages: ");
            String pages = scanStr.nextLine();

            System.out.print("Enter new publish date(dd/MM/yyyy): ");
            String publishDate = scanStr.nextLine();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            LocalDate date = LocalDate.parse(publishDate, formatter);
            System.out.print("Enter new written year(yyyy): ");
            String year2 = scanStr.nextLine();
            DateTimeFormatter yearFormatter = DateTimeFormatter.ofPattern("yyyy");
            LocalDate year = LocalDate.parse(year2,yearFormatter);
            System.out.print("Enter new amount: ");
            Integer amount = scanInt.nextInt();
            System.out.print("Enter new daily rent charge: ");
            Double dailyRentCharge = scanInt.nextDouble();
            bookService.update(books.get(choice).getId(),new Book(title,author,pages,date,amount,year,dailyRentCharge));
            System.out.println(Message.SUCCESSFULLY);
        }catch (InputMismatchException | DateTimeParseException | IndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }
    }

    public static ArrayList<Book> read() {
        ArrayList<Book> list = new ArrayList<>();
        int i =1;
        for (Book book : bookService.getActive()) {
            if(book.getAmount() != 0) {
                System.out.println(i++ + ". " + book);
                list.add(book);
            }
        }
        return list;
    }

    private static void create() {
        System.out.print("Enter title: ");
        String title = scanStr.nextLine();

        System.out.print("Enter author: ");
        String author = scanStr.nextLine();

        System.out.print("Enter number of pages: ");
        String pages = scanStr.nextLine();

        System.out.print("Enter publish date(dd/MM/yyyy): ");

        try {
            String publishDate = scanStr.nextLine();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate date = LocalDate.parse(publishDate, formatter);
            System.out.print("Enter written year(yyyy): ");
            String year2 = scanStr.nextLine();
            LocalDate year = LocalDate.from(formatter.parse("01/01/"+year2));
            System.out.print("Enter amount: ");
            Integer amount = scanInt.nextInt();
            System.out.print("Enter daily rent charge: ");
            Double dailyRentCharge = scanInt.nextDouble();
            bookService.add(new Book(title,author,pages,date,amount,year,dailyRentCharge));
            System.out.println(Message.SUCCESSFULLY);
        }catch (InputMismatchException | DateTimeParseException e){
            System.out.println(e.getMessage());
        }

    }
}
