package 牛客.Test1108;


import java.util.Scanner;

public class p1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str = sc.nextLine();
            if(str.length() == 0 || str == null || str.length() > 255){
                throw new UnsupportedOperationException("输入的字符串不合法！");
            }
            StringBuffer sb = new StringBuffer();
            for (char ch:str.toCharArray()) {
                if(ch >= '0' && ch <= '9'){
                    sb.append(ch);
                }else{
                    sb.append(" ");
                }
            }
            String str1 = sb.toString();
            String[] nums = str1.split("\\s+");
            String maxStr=" ";
            for (int i = 0; i < nums.length; i++) {
                if(maxStr.length()<nums[i].length()){
                    maxStr=nums[i];
                }
            }
            System.out.println(maxStr);
        }
    }
}
