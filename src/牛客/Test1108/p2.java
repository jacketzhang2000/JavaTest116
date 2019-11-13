package 牛客.Test1108;

import java.util.Stack;

public class p2 {
    public static  boolean chk(String s,int n){
        Stack<Character> left=new Stack<>();
        if(s==null|| s.length()!=n){
            return false;
        }
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='('){
                left.push(s.charAt(i));
            }else if(s.charAt(i)==')'){
                if(left.isEmpty()){
                    return false;
                }else{
                    left.pop();
                }
            }

        }
        if(left.isEmpty()){
            return true;
        }else{
            return false;
        }

    }
    public static void main(String[] args) {
        String s="()(()()";
        System.out.println(chk(s,s.length()));
    }
}
