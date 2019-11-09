package 牛客;

import java.util.Scanner;

public class Test1106{
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String a=scanner.nextLine();
        String b=scanner.nextLine();
        int count=0;
        if(deng(b+a,0,a.length()+b.length()-1)){
            count++;
        }
        for(int i=1;i<a.length();i++){
            //public String substring(int beginIndex,int endIndex)子串开始于指定beginIndex并延伸到字符索引endIndex - 1 。
            //public String substring(int beginIndex) 子字符串以指定索引处的字符开头，并扩展到该字符串的末尾。
            if(deng(a.substring(0,i)+b+a.substring(i),0,a.length()+b.length()-1)){
                count++;
            }
        }
        if(deng(a+b,0,a.length()+b.length()-1)){
            count++;
        }
        System.out.println(count);
    }

    private static boolean deng(String s, int i, int j) {
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}

