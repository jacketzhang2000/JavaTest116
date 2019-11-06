package classes;

import action.Action;

import java.util.List;
import java.util.Scanner;

public class Teacher extends User {
    Teacher(String id,String name){
        super(id,name);
    }
    @Override
    public void menu() {
        System.out.println("**老师，请选择**");
        System.out.println("0.退出");
        System.out.println("1.上架");
        System.out.println("2.借阅查询");
        System.out.println("3.查阅记录");
    }

    @Override
    public boolean input() {
        Scanner scanner=new Scanner(System.in);
        int s=scanner.nextInt();
        switch (s){
            case 0:
                return true;
            case 1:
                putBook();
                break;
            case 2:
                queryBooks();
                break;
            case 3:
                queryRecords();
        }
        return false;
    }



    private void putBook(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入书号：");
        String ISBN=scanner.nextLine();
        System.out.println("请输入标题：");
        String title=scanner.nextLine();
        System.out.println("请输入作者：");
        String anthor=scanner.nextLine();
        System.out.println("请输入价格：");
        double price=scanner.nextDouble();
        System.out.println("请输入数量：");
        int count=scanner.nextInt();
        Book book= Action.putBook(ISBN,title,anthor,price,count);
        System.out.printf("《%s》上架成功！%n",book.getTitle());
    }
}
