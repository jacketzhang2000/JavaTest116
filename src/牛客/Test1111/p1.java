package 牛客.Test1111;

import java.util.Scanner;

public class p1 {
    public static void main(String[] args) {

        int Y1, Y2, Y3, Y4;
        float a, b, c;
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            Y1 = scanner.nextInt();
            Y2 = scanner.nextInt();
            Y3 = scanner.nextInt();
            Y4 = scanner.nextInt();
            a = (Y1 + Y3) / 2;
            b = (Y3 - Y1) / 2;
            c = (Y2 - Y4) / 2;

            if (a - (Y1 + Y3) / 2 != 0) {
                System.out.println("NO");
                return;
            }
            if(b-(Y3-Y1)/2!=0 ||b-(Y2+Y4)/2!=0){
                System.out.println("NO");
                return;
            }
            if(c-(Y2-Y4)/2!=0){
                System.out.println("NO");
                return;
            }
            System.out.println((int)a+" "+(int)b+" "+(int )c);
        }
    }
}
