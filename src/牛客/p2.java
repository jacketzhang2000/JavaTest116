package 牛客;
import java.util.*;

public class p2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashSet<String> set = new HashSet<>();
        while(scanner.hasNext()){
            String s = scanner.nextLine();
            //将此字符串分割为给定的 regular expression的匹配。
            String[] arr =s.split(" ");
            for(int i=0;i<arr.length;i++){
                set.add(arr[i]);
            }
        }
        System.out.println(set.size());

    }
}