package WeBank;
import java.util.*;

public class Main {
    static int a[] = new int[10004];

    public static int getBoss(int x) {
        if (a[x] == x)
            return x;
        a[x] = getBoss(a[x]);
        return a[x];
    }

    public static void link(int x, int y) {
        if (x > y) {
            int t = x;
            x = y;
            y = t;
        }
        a[getBoss(y)] = getBoss(x);
        return;
    }
    public static int rob(int[] nums) {
        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        if (nums.length == 2)
            return nums[0] > nums[1] ? nums[0] : nums[1];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[1], dp[0]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
        }
        return dp[nums.length - 1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] numString = s.split(" ");
        int n = numString.length;
        int[] nums = new int[n];
        int[] dp = new int[nums.length];
        dp[0] = Integer.parseInt(numString[0]);
        dp[1] = Math.max(Integer.parseInt(numString[1]), dp[0]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], Integer.parseInt(numString[i]) + dp[i - 2]);
        }


        System.out.println(dp[n-1]);
    }
}
//        int n, m, s, t;
//        Scanner sc=new Scanner(System.in);
//        n= sc.nextInt();
//        m= sc.nextInt();
//        s= sc.nextInt();
//        t= sc.nextInt();
//        for(int i = 1; i <n; i++){
//            a[i] = i;
//        }
//
//
//        int x, y;
//        while(m-->0)
//        {
//            x= sc.nextInt();
//            y= sc.nextInt();
//            link(x, y);
//        }
//        for (int i = 1; i <= n; i++) {
//            System.out.println(a[i]);
//        }
//        long  res = 0;
//        if(getBoss(s) == getBoss(t))    res = n*(n-1)/2;
//        else
//        {
//            x = 0;y = 0;
//            for(int i = 1; i <= n; i++)
//            {
//                if(getBoss(i) == a[s])  x++;
//                if(getBoss(i) == a[t])  y++;
//            }
//            res = x * y;
//        }
//
//        System.out.println(res);



//
//    }
//}


//
//import java.util.*;
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner sc=new Scanner(System.in);
//        int n=sc.nextInt();
//        Deque<Integer> deque =new ArrayDeque<>();
//        for(int i=0;i<n;i++){
//            deque.offer(sc.nextInt());
//        }
//    while (!deque.isEmpty()){
//        if(deque.size()==1){
//            System.out.println(deque.poll());
//            break;
//        }
//        System.out.print(deque.poll()+" ");
//        int temp= deque.poll();
//        deque.offer(temp);
//    }
////        ArrayList<Integer> list=new ArrayList<>(n);
////        ArrayList<Integer> tmp=new ArrayList<>();
////        for (int i = 0; i <n ; i++) {
////           if(i%2==0){
////               list.add(nums[i]);
////           }else{
////               tmp.add(nums[i]);
////           }
////        }
////        while(tmp.size()>2){
////            ArrayList<Integer> t=new ArrayList<>();
////            for (int i = 0; i < tmp.size(); i++) {
////                if(i%2==0){
////                    list.add(tmp.get(i));
////                }else{
////                    t.add(tmp.get(i));
////                }
////            }
////            tmp=t;
////        }
////        if(tmp.size()==1){
////            list.add(tmp.get(0));
////        }else{
////            list.add(tmp.get(1));
////            list.add(tmp.get(0));
////        }
////
////        for (int i = 0; i < list.size() ; i++) {
////            if(i== 0){
////                System.out.print(list.get(i));
////            }else{
////                System.out.print(" "+list.get(i));
////            }
////
////        }
////        System.out.println();
//    }
//}
