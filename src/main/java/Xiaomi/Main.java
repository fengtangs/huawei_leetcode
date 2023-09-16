package Xiaomi;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int []nums=new int[]{6,5,3,7,2,1,8};
        quick(nums,0,nums.length-1);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]+" ");
        }
    }

    private static void quick(int[] nums, int low, int high) {
        if(high<=low) return;
        int i=low;
        int j=high;
        int flag=nums[low];
        while (i<j){
            while(j>i&&nums[j]>flag){
                j--;
            }
            nums[i]=nums[j];
            while(i<j&&nums[i]<flag){
                i++;
            }
            nums[j]=nums[i];

        }
        nums[i]=flag;
        quick(nums,low,i-1);
        quick(nums,i+1,high);
    }
}
