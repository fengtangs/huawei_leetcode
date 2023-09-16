package Baidu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

//
//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner sc=new Scanner(System.in);
//        int n= sc.nextInt();
//        int []nums=new int[n];
//        for (int i = 0; i < n; i++) {
//            nums[i]= sc.nextInt();
//        }
//        int index=1;
//        int count=0;
//        for (int i = 0; i < n; i++) {
//            if(nums[i]>index){
//                count++;
//            }else{
//                index++;
//
//            }
//        }
//        if(count==n){
//            System.out.println(-1);
//        }
//        else {
//            System.out.println(count);
//
//        }
//
//    }
//}
public class Main {
    public static void main(String[] args) throws IOException {
//        Scanner sc=new Scanner(System.in);
//        int n=sc.nextInt();
//        int m=sc.nextInt();
//        int k= sc.nextInt();
//        int a= sc.nextInt();
//        int []days=new int[n+1];
        BufferedReader buf=null;
        buf=new BufferedReader(new InputStreamReader(System.in));
        String t1= buf.readLine();
        String t2 =buf.readLine();
        String t3= buf.readLine();
        String []tmp1=t1.split(" ");
        int n=Integer.parseInt(tmp1[0]);
        int m=Integer.parseInt(tmp1[1]);
        int k= Integer.parseInt(tmp1[2]);
        int a= Integer.parseInt(tmp1[3]);
        int []days=new int[n+1];
        String []tmp2=t2.split(" ");
        String[]tmp3=t3.split(" ");
        for (int i = 1; i <= m; i++) {
            int left= Integer.parseInt(tmp2[i-1]);
            int right=Integer.parseInt(tmp3[i-1]);
            for (int j = left; j <=right ; j++) {
                days[j]++;
            }
        }

        int count=0;
        for (int i = 1; i <=n-k+1 ; i++) {
            boolean flag=true;
            for (int j = i; j <i+k ; j++) {
                    if(days[j]>=a){
                        flag=false;
                        i=j;
                        break;
                    }
            }
            if(flag){
                count++;
            }
        }
        System.out.println(count);
    }
}