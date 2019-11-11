package 牛客.Test1107;

public class p2 {
    public int count(int[] A, int n) {
        int num=0;
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                if(A[i]>A[j]){
                    num++;
                }
            }
        }
        return num;
    }

    public static void main(String[] args) {
        int[] a={1,2,3,4,5,6,7,0};
        p2 p=new p2();
        System.out.println(p.count(a,a.length));
    }

}
