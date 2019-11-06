package classes;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Record {
    private String userId;
    private String bookISBN;
    private Date borrowedAt;

    public Record(String id, String ISBN) {
        this.userId=id;
        this.bookISBN=ISBN;
        this.borrowedAt=new Date();
    }
    public boolean is(User user,String ISBN){
        return userId.equals(user.getId())
                &&bookISBN.equals(ISBN);
    }

    public Object getUserId() {
        return userId;

    }

    public Object getBookISBN() {
        return bookISBN;
    }

    public Object getBorrowedAt() {
        SimpleDateFormat fmt=new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        return fmt.format(borrowedAt);
    }
}
