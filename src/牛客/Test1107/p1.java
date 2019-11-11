package 牛客.Test1107;

import java.util.Scanner;

public class p1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();

            int count = 0;
            int qian = 0;
            while (n >= 3) {
                count += n / 3;
                qian = n / 3;
                n = (n % 3) + qian;
            }
            if (n == 2) {
                count++;
            }

            System.out.println(count);
        }
    }
}
