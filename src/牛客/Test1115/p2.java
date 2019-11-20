package 牛客.Test1115;

import java.util.Arrays;
import java.util.Scanner;

public class p2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String s=scanner.nextLine();
        String[] str=s.split("");
        for(int i=str.length-1;i>=0;i--){
            System.out.print(str[i]);
        }

    }
}
