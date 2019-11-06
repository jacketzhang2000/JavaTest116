package 牛客;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Test1105 {
    public int findKth(int[] a, int n, int K) {
        Arrays.sort(a);
        if(a.length==n){
            return a[n-K];
        }
        return -1;
    }
    public static void main(String[] args) {
        Test1105 t=new Test1105();
        int a[]={1,5,7,2,3};
        System.out.println(t.findKth(a,5,3));
    }
}
