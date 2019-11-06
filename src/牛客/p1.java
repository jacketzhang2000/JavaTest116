package 牛客;

import java.util.*;
public class p1 {
    public static int countNumberOf2s(int n) {
        int y=0;
       for(int i=0;i<n;i++) {
            while (i > 10) {
                int x = i % 10;
                i = i / 10;
                if(x==2){
                    y++;
                }
            }
           if(i==2){
                y++;
           }
       }
        return y;

    }

    public static void main(String[] args) {
        System.out.println(countNumberOf2s(20));
    }
}