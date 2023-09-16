import java.util.Scanner;
import java.io.*;
        import java.util.*;
        import java.text.*;
        import java.math.*;
        import java.util.regex.*;

class Solution {

    /* Write Code Here */
    public int[] calculateFinalPositi(String instructions) {
            int res[]=new int[]{0,0};
        for (int i = 0; i < instructions.length(); i++) {
            char c=instructions.charAt(i);
            if(c=='U'){
                res[1]++;
            }else if(c=='D'){
                res[1]--;
            }else if(c=='L'){
                res[0]--;
            }else if(c=='R'){
                res[0]++;
            }
        }
        return res;

    }


    /* Write Code Here */
    public int res[]=new int[60];
    public int[] ThreeDigitNumbers (int[] selectedDigits) {
        int index=0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j <5 ; j++) {
                if(j!=i){
                    for (int k = 0; k <5 ; k++) {
                        if(k!=j&&k!=i){
                            int tmp=selectedDigits[i]*100+selectedDigits[j]*10+selectedDigits[k];
                            res[index++]=tmp;
                        }
                    }
                }

            }
        }
        Arrays.sort(res);
        return res;

    }
}

//public class DJ{
//    public static void main(String[] args){
//        Scanner in = new Scanner(System.in);
//        int[] res;
//
//        int selectedDigits_size = 0;
//        selectedDigits_size = in.nextInt();
//        int[] selectedDigits = new int[selectedDigits_size];
//        for(int selectedDigits_i = 0; selectedDigits_i < selectedDigits_size; selectedDigits_i++) {
//            selectedDigits[selectedDigits_i] = in.nextInt();
//        }
//
//        if(in.hasNextLine()) {
//            in.nextLine();
//        }
//
//        res = new Solution().ThreeDigitNumbers (selectedDigits);
//        for(int res_i=0; res_i < res.length; res_i++) {
//            System.out.println(String.valueOf(res[res_i]));
//        }
//
//    }
//}
