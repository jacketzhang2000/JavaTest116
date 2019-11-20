package 牛客.Test1115;

import java.util.Scanner;

public class p1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cnt = 0;
        for (int i = n;i>=5;i--) {
            int x=i;
            int t=i%5;
            while (t==0){
                cnt++;
                x=x/5;
               t=x%5;
            }
        }
        System.out.println(cnt);
    }
}
