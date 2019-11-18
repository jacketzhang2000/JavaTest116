package 牛客.Test1109;

import java.util.Scanner;

public class p1 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
       int s=scanner.nextInt();
        System.out.println(count(s));
    }

    private static int count(int s) {
        if(s%2!=0 || s<6|| s==10){
        return -1;
        }else if(s%8==0){
            return s/8;
        }
        else return 1+s/8;
    }
}
