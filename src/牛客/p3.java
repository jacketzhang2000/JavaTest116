package 牛客;

import java.util.Scanner;

public class p3 {

    public static void main(String[] args) {

        inputStr();
        inputInteger();
        inputIntInLine();

    }
    //每行输入一个数值，输入多个数值
    public static void inputInteger() {
        Scanner scanner = new Scanner(System.in);
        String nextLine = scanner.nextLine();
        int sum = 0;

        while (nextLine != null && !nextLine.equals("")) {
            sum += Integer.parseInt(nextLine);
            System.out.println(sum);
            nextLine = scanner.nextLine();
        }

        System.out.println("end of input integer");
    }
    // 每行输入一个字符串，输入多个字符串
    public static void inputStr() {
        Scanner scanner = new Scanner(System.in);
        String nextLine = scanner.nextLine();
        while (nextLine != null && !nextLine.equals("")) {
            System.out.println(nextLine);
            nextLine = scanner.nextLine();
        }

        System.out.println("end of input string");
    }
    //输入多个数值，用空格隔开
    public static void inputIntInLine() {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] numstr = str.split(" ");
        int[] nums = new int[numstr.length];
        for(int i = 0; i < numstr.length; i ++) {
            nums[i] = Integer.parseInt(numstr[i]);
        }
        for(int n: nums) {
            System.out.println(n);
        }
        System.out.println("end of input int in a line");

    }
}
