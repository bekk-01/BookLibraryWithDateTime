package model;

import java.time.LocalDate;
import java.util.UUID;

public class Rent extends BaseModel{
    private String phoneNumber;
    private String name;
    private UUID bookId;
    boolean isOpen = true;
    private LocalDate dueDate;
    private LocalDate closedDate;
    private Double totalPrice;
    private Double fine;
    public Rent(String phoneNumber,String name,UUID bookId,LocalDate dueDate){
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.bookId = bookId;
        this.dueDate = dueDate;
    }

    public Rent(String phoneNumber, String name, UUID bookId, boolean isOpen,
                LocalDate dueDate, LocalDate closedDate,Double totalPrice, Double fine) {
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.bookId = bookId;
        this.isOpen = isOpen;
        this.dueDate = dueDate;
        this.closedDate = closedDate;
        this.totalPrice = totalPrice;
        this.fine = fine;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getBookId() {
        return bookId;
    }

    public void setBookId(UUID bookId) {
        this.bookId = bookId;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDate getClosedDate() {
        return closedDate;
    }

    public void setClosedDate(LocalDate closedDate) {
        this.closedDate = closedDate;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Double getFine() {
        return fine;
    }

    public void setFine(Double fine) {
        this.fine = fine;
    }

    @Override
    public String toString() {
        return "Rent{ "+" name=" + name +
                ", dueDate=" + dueDate +
                ", closedDate=" + closedDate +
                ", totalPrice=" + totalPrice +
                ", fine=" + fine +
                '}';
    }
}
