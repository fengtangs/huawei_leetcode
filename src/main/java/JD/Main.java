////package JD;
////
////import java.util.Arrays;
////import java.util.Scanner;
////
////public class Main {
////    public static void main(String[] args) {
////        Scanner sc=new Scanner(System.in);
////        int n= sc.nextInt();
////        int k=sc.nextInt();
////        int[] nums=new int[n];
////        for (int i = 0; i < n; i++) {
////            nums[i]=sc.nextInt();
////        }
////        Arrays.sort(nums);
////        int res=0;
////        int pre=nums[n-1];
////        for (int i = n-2; i >=0 ; i--) {
////            if(pre-nums[i]<=k){
////                res+=pre*nums[i];
////                if(i>0){
////                    pre=nums[i-1];
////                    i--;
////                }else{
////                    break;
////                }
////            }else{
////                if(i>0){
////                    pre=nums[i-1];
////                    i--;
////                }else{
////                    break;
////                }
////            }
////        }
////        System.out.println(res);
////    }
////}
//
//
//
//package JD;
////import java.util.*;
////
////public class Main {
////    public static int getMinEnergy(int[] a) {
////        int n = a.length;
////        int[] dp = new int[n];
////        dp[0] = a[0];
////        dp[1] = a[1];
////        for (int i = 2; i < n; i++) {
////            dp[i] = Math.min(dp[i-1] + a[i], dp[i-2] + a[i]);
////        }
////        return dp[n-1];
////    }
////
////    public static void main(String[] args) {
////        Scanner scanner = new Scanner(System.in);
////        int n = scanner.nextInt();
////        int[] a = new int[n];
////        for (int i = 0; i < n; i++) {
////            a[i] = scanner.nextInt();
////        }
////        int minEnergy = getMinEnergy(a);
////        System.out.println(minEnergy);
////    }
////}
//
//
//
//
//
//import java.util.*;
//
//public class Main {
//    private static long getSonset2(int[ ] arr, int length){
//
//        long res=0;
//        int mod = (int) (1e9 + 7);
//        for (int i = 0; i < length; i++) {
//            for (int j = i; j <length ; j++) {
//                int index=1;
//                for (int k = i; k <=j ; k++) {
//                    res=(res+arr[k]*index)%mod;
//                    index++;
//                }
//            }
//        }
//        return res;
//    }
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int[] a = new int[n];
//        for (int i = 0; i < n; i++) {
//            a[i] = scanner.nextInt();
//        }
//
//        System.out.println(getSonset2(a,n));
//    }
//}

package JD;
import java.util.*;

import java.util.*;

public class Main {
    private static long getSonset2(int[ ] arr, int length){

        long res=0;
        long mod = 1000000007;
        for (int i = 1; i <= length; i++) {
            res+=arr[i-1]*(i+1)*i/2*(length+1-i);
            res%=mod;
        }
        return res;
    }
    public static void main(String[] args) {
        int n=5;
        int m=2;
        boolean []flag=new boolean[n];
        int i=0;
        int count=0;
        int index=-1;
        while (count<n-1){
            index=(index+1)%n;
            if(flag[index]==false){
                i++;
                if(i==m){
                    i=0;
                    flag[index]=true;
                    count++;
                }
            }


        }

        for (int j = 0; j < n; j++) {
            if(flag[j]==false){
                System.out.println(j+1);
            }
        }


    }
}

