package bytedance;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n= sc.nextInt();
        int []nums=new int[n];
        int tmp=0;
        for (int i = 0; i < n; i++) {
            nums[i]= sc.nextInt();
            if(i+1==nums[i]){
                tmp++;
            }
        }
        int index=1;
        int count=0;
        for (int i = 0; i < n; i++) {
            if(nums[i]>index){
                count++;
            }else{
                index++;

            }
        }
        if(count==n&&tmp==0){
            System.out.println(-1);
        }
        else {
            if(count==n){
                System.out.println(tmp);
            }else {
                System.out.println(Math.max(count,tmp));
            }


        }

    }
}