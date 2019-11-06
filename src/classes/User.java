package classes;

import action.Action;
import databases.Where;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public abstract class User {
    private String id;
    private String name;
    User(String id,String name){
        this.id=id;
        this.name=name;
        }
        private static User currentUser =null;
    public static User login() throws Exception {
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入id：");
        String id=scanner.nextLine();
        System.out.println("请输入名字：");
        String name=scanner.nextLine();
        System.out.println("请输入角色：");
        String u=scanner.nextLine();//读掉回车
        if(u.equals("老师")){
            currentUser =new Teacher(id,name);
        }else if(u.equals("学生")){
            currentUser =new Student(id,name);
        }else {
            throw new Exception("错误的角色");
        }
        return currentUser;
    }
    public static User getCurrentUser(){
        return currentUser;
    }
    public abstract void menu();

    public abstract boolean input();

    public String getId() {
        return id;
    }
    public String getName(){
        return name;
    }
    private  static class Current implements Where<Book>{

        @Override
        public boolean test(Book book) {
            return book.getCurrentCount()>0;
        }
    }
    private static class BookTitle implements Where<Book>{
        private String title;
        BookTitle(String title){
            this.title=title;
        }
        @Override
        public boolean test(Book book) {
            return book.getTitle().equals(title);
        }
    }
    private enum OrderBy{
        OTHER,TITLE,PRICE_ASC,PRICE_DESC,AUTHOR
    }
    private static final HashMap<OrderBy,Comparator<Book>> compartors=new HashMap<>();
    static {
        compartors.put(OrderBy.TITLE,new TitleCompator());
        compartors.put(OrderBy.PRICE_ASC,new PriceComparator(true));
        compartors.put(OrderBy.PRICE_DESC,new PriceComparator(false));
        compartors.put(OrderBy.AUTHOR,new AuthorComparator());
    }
    private static Comparator<Book> getComparator(int selected){
        return compartors.get(selected);
    }
    protected void queryBooks() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入全查询还是条件查询");
        System.out.println("1.全查询");
        System.out.println("2.查询存量>0的");
        System.out.println("其他，根据书名查询");
        int selected = scanner.nextInt();
        List<Book> bookList;
        switch (selected) {
            case 1:
                System.out.println("请选择排序顺序");
                System.out.println(OrderBy.TITLE.ordinal()+"按标题排序");
                System.out.println("2.按价格（升序）");
                System.out.println("3.按价格（降序）");
                System.out.println("4.按作者排序");
                System.out.println("其他.按默认排序");
                int selected2=scanner.nextInt();
                scanner.nextLine();
                bookList = Action.queryBooks(getComparator(selected2));
                break;
            case 2:
                bookList = Action.queryBooksByWhere(new Current());
                break;
            default:
                System.out.println("请输入书名：");
                String title = scanner.nextLine();
                bookList = Action.queryBooksByWhere(new BookTitle(title));
                break;
        }
        for (Book book : bookList) {
            System.out.printf("《%s》by %s 价格：%.2f 存量：%d 借阅次数%d%n ",
                    book.getTitle(), book.getAnrhor(), book.getPrice(),
                    book.getCurrentCount(), book.getBorrowedCount());
        }
        System.out.println("共查询到" + bookList.size() + "本书");
    }
    protected void queryRecords(){
        List<Record> recordList=Action.queryRecords();
        for(Record record:recordList){
            System.out.printf("%s %s %s%n",
                    record.getUserId(),
                    record.getBookISBN(),
                    record.getBorrowedAt());
        }
        System.out.println("共查询到"+recordList.size()+"条借阅记录");
    }
}
