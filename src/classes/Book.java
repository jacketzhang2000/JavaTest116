package classes;

public class Book {
    private String ISBN;
    private String title;
    private String auther;
    private double price;
    private int brrowedCount;
    private int currentCount;
    private int totalCount;
    public Book(String ISBN, String title, String auther, double price, int count){
        this.ISBN=ISBN;
        this.title=title;
        this.auther=auther;
        this.price=price;
        this.currentCount=count;
        this.totalCount=count;
        this.brrowedCount=0;
    }
    public void increaseCount(int count) {
        totalCount+=count;
        brrowedCount+=count;
    }

    public boolean is(String isbn) {
        return this.ISBN.equals(isbn);
    }
    public String getTitle() {
        return title;
    }
    public String  getAnrhor() {
        return auther;
    }

    public double getPrice() {
        return price;
    }

    public int getCurrentCount() {
        return currentCount;
    }

    public int getBorrowedCount() {
        return brrowedCount;
    }

    public void borrowBook() {
        currentCount--;
        brrowedCount++;
    }

    public void returnBook() {
        currentCount++;
    }
}
