package controller;

import exception.DataNotFoundException;
import model.Book;
import model.Rent;
import utils.Message;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Objects;

import static controller.Main.*;

public class RentController {
    public static void rentBook(){
        System.out.println("1.Open Rent\t2.Close Rent\t3.Extra functions about rent\t0.Exit");
        String command = scanStr.nextLine();
        switch (command){
            case "1" -> openRent();
            case "2" -> closeRent();
            case "3" -> extraFunctionsAboutRent();
            case "0" -> mainMenu();
            default -> rentBook();
        }
    }

    private static void extraFunctionsAboutRent() {
        String textBlock = """
                    1. The Reader of The Month (top 3)
                	2. Top 3 Readers of past 30 days
                	3. Top 3 of all time
                	4. Show open/closed rents in period
                """;
    }

    private static void closeRent() {
        ArrayList<Rent> rents = new ArrayList<>();
        try {
            System.out.print("Enter phone number: ");
            String phoneNumber = scanStr.nextLine();
            int i = 1;
            for (Rent rent : rentService.getActive()) {
                if(Objects.equals(rent.getPhoneNumber(),phoneNumber) && rent.isOpen()){
                    rents.add(rent);
                    System.out.println(i++ + ". " + rent);
                }
            }
            if(rents.isEmpty()){
                rentBook();
            }
            System.out.print("Enter choice one: ");
            int choice = scanInt.nextInt() -1;
            LocalDate now = LocalDate.now();
            int fine = 0;
            if(now.isAfter(rents.get(choice).getDueDate())) {
                int i1 =now.getDayOfMonth()- rents.get(choice).getDueDate().getDayOfMonth();
                 fine = i1 * 100;
            }

                rents.get(choice).setOpen(false);
                Book byId = bookService.findById(rents.get(choice).getBookId());
                byId.setAmount(byId.getAmount() + 1);
                System.out.println("Rent closed | "+ "your penalty-> " + fine);
                rentBook();
        }catch (InputMismatchException  | DataNotFoundException e){
            System.out.println(e.getMessage());
        }
        rentBook();
    }

    private static void openRent() {
        ArrayList<Book> books = BookController.read();
        if(books.isEmpty()){
            System.out.println(Message.EMPTY);
            rentBook();
        }
        try{
            System.out.print("Enter phone number: ");
            String phone = scanStr.nextLine();

            System.out.print("Enter name: ");
            String name = scanStr.nextLine();

            System.out.print("Enter due data(dd/MM/yyyy): ");
            String date = scanStr.nextLine();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate localDate = LocalDate.parse(date,formatter);
            System.out.print("Enter code of book: ");
            Integer code = scanInt.nextInt();
            Book byCode = bookService.getByCode(code);
            rentService.add(new Rent(phone,name,byCode.getId(),localDate));
            byCode.setAmount(byCode.getAmount()-1);
            System.out.println(Message.SUCCESSFULLY);
            rentBook();
        }catch (DateTimeParseException | InputMismatchException |
                IndexOutOfBoundsException | DataNotFoundException e){
            System.out.println(e.getMessage());
        }

    }
}
