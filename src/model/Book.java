package model;

import java.time.LocalDate;

public class Book extends BaseModel{
    private String title;
    private String author;
    private String numberOfPages;
    private LocalDate publishDate;
    private Double amount;
    private String code;
    private LocalDate writtenYear;
    private Double dailyRentCharge;


    public Book(String title, String author, String numberOfPages, LocalDate publishDate, Double amount,
                LocalDate writtenYear, Double dailyRentCharge) {
        this.title = title;
        this.author = author;
        this.numberOfPages = numberOfPages;
        this.publishDate = publishDate;
        this.amount = amount;
        this.writtenYear = writtenYear;
        this.dailyRentCharge = dailyRentCharge;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(String numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDate publishDate) {
        this.publishDate = publishDate;
    }

    public LocalDate getWrittenYear() {
        return writtenYear;
    }

    public void setWrittenYear(LocalDate writtenYear) {
        this.writtenYear = writtenYear;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Double getDailyRentCharge() {
        return dailyRentCharge;
    }

    public void setDailyRentCharge(Double dailyRentCharge) {
        this.dailyRentCharge = dailyRentCharge;
    }
}
