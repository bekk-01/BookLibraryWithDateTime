package model;

import java.time.LocalDate;

public class Book extends BaseModel{
    public static  Integer code1 = 1000;
    private String title;
    private String author;
    private String numberOfPages;
    private LocalDate publishDate;
    private Integer amount;
    private Integer code = code1++;
    private LocalDate writtenYear;
    private Double dailyRentCharge;


    public Book(String title, String author, String numberOfPages, LocalDate publishDate, Integer amount,
                LocalDate writtenYear, Double dailyRentCharge) {
        this.title = title;
        this.author = author;
        this.numberOfPages = numberOfPages;
        this.publishDate = publishDate;
        this.amount = amount;
        this.writtenYear = writtenYear;
        this.dailyRentCharge = dailyRentCharge;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
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

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Double getDailyRentCharge() {
        return dailyRentCharge;
    }

    public void setDailyRentCharge(Double dailyRentCharge) {
        this.dailyRentCharge = dailyRentCharge;
    }
    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", numberOfPages='" + numberOfPages + '\'' +
                ", publishDate=" + publishDate +
                ", amount=" + amount +
                ", code=" + code +
                ", writtenYear=" + writtenYear +
                ", dailyRentCharge=" + dailyRentCharge +
                '}';
    }
}
