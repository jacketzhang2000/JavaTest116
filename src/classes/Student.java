package classes;

import action.Action;
import databases.BookShelf;
import databases.RecordShelf;
import exceptions.BorrowedOutException;
import exceptions.NoSuchBookException;
import exceptions.NotBorrowedException;
import exceptions.YetBorrowedException;

import java.util.Scanner;

public class Student extends User {
    public Student(String id, String name) {
        super(id, name);
    }

    @Override
    public void menu() {
        System.out.println("**学生，请选择**");
        System.out.println("0.退出");
        System.out.println("1.查询图书");
        System.out.println("2.借阅图书");
        System.out.println("3.归还图书");
        System.out.println("4.查询借阅情况");
    }

    @Override
    public boolean input() {
        Scanner scanner = new Scanner(System.in);
        int s = scanner.nextInt();
        switch (s) {
            case 0:
                return true;
            case 1:
                queryBooks();
                break;
            case 2:
                borrowBook();
                break;
            case 3:
                returnBook();
                break;
        }
        return false;
    }

    private void returnBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要归还的书籍的ISBN:");
        String ISBN = scanner.nextLine();
        User user = User.getCurrentUser();
        //还书前提条件
        //1.判断有没有这本书
        //2.用户借过这本书
        //1.删除借阅记录
        //2.书的存量+1
        try {
            Book book=Action.returnBook(user,ISBN);
            System.out.printf("《%s》归还成功！%n",book.getTitle());
        }catch (NoSuchBookException e){
            System.out.printf("错误！本馆没有这本书");
        }catch (NotBorrowedException e){
            System.out.printf("错误！没有借过这本书");
        }
    }
    private void borrowBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要借图书的ISBN:");
        String ISBN = scanner.nextLine();
        User user = User.getCurrentUser();
        try {
            Book book = Action.borrowBook(user, ISBN);
            System.out.printf("《%S》借阅成功！%n", book.getTitle());
        } catch (NoSuchBookException e) {
            System.out.println("错误！没有这本书");
        } catch (BorrowedOutException e) {
            System.out.println("错误！这本书已经被借完了");
        } catch (YetBorrowedException e) {
            System.out.println("错误！这本书你已经借过了");
        }
    }

}
