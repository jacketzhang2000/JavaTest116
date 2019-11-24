package 牛客.Test1116;

import java.util.Scanner;

public class p1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int a=0,b=1,c=1,left=0,right=0;
        int q=0;
        while (true) {
            a = b;
            b = c;
            c = a + b;
            if (c < n) {
                left = n - c;
            } else {
                right = c - n;
                break;
            }

        }
        q = Math.min(left, right);
        System.out.println(q);

    }
}
