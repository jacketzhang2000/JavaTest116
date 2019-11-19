package 牛客.Test1111;

import java.util.*;

public class p2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> list=new ArrayList<>();
        while (scanner.hasNext()) {
            list.add(scanner.nextInt());
        }
       Collections.sort(list);
        System.out.println(list.get(list.size()/2-1));
    }
}
