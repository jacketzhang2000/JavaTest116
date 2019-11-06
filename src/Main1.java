import classes.User;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) throws Exception {
        while (true) {
            User currentUser = User.login();
            boolean isQuit;
            do {
                currentUser.menu();
                isQuit = currentUser.input();
            } while (!isQuit);
            Scanner scanner=new Scanner((System.in));
            System.out.println("1.退出");
            System.out.println("2.切换用户");
            int selected=scanner.nextInt();
            if(selected==1){
                break;
            }

        }
    }
}
