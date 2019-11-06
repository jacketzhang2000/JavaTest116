package classes;

import java.util.Comparator;

public class PriceComparator implements Comparator<Book> {
    private boolean b;
    public PriceComparator(boolean b) {
        this.b=b;
    }
    @Override
    public int compare(Book o1, Book o2) {
        if(b){
            return (int)((o1.getPrice()-o2.getPrice())*100);
        }else{
            return (int)((o2.getPrice()-o1.getPrice())*100);
        }
    }
}
