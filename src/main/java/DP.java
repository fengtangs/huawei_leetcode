import java.util.Arrays;
import java.util.Collections;

public class DP {

    public int maxSumDivThree(int[] nums) {
        Arrays.sort(nums);
        int res= 0;
        for (int i = 0; i < nums.length; i++) {
            res+=nums[i];
        }
        int index=0;
        while(res%3!=0){
            res-=nums[index++];
        }
        return res;
    }
}
