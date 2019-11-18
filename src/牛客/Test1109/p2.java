package 牛客.Test1109;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class p2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String s1;
        String s2;
        ArrayList<Character> list=new ArrayList<>();
        while(scanner.hasNext()){
            s1=scanner.nextLine();
            s2=scanner.nextLine();
            if(s1==null|| s2==null){
                return;
            }
            for(int i=0;i<s1.length();i++){
                if(!(s2.contains(s1.charAt(i)+""))){
                    list.add(s1.charAt(i));
                }
            }
            for(int i=0;i<list.size();i++){
                System.out.printf(list.get(i)+"");
            }
        }
    }
}
