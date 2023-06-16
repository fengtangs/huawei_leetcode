
import java.util.Arrays;
import java.util.Scanner;

import java.util.*;

public  class Main {
    final int a;
    Main(int aa){
        this.a=aa;
    }
    public static void main(String[] args) {
        try {
            double a= 2D;
            System.out.println(a);
        }catch (Exception e){
            e.printStackTrace();
        }finally {

            System.out.println(2);
        }
    }

}
//public class Main{
//    public static void main(String[] args) {
//        Scanner sc=new Scanner(System.in);
//        String m=sc.next();
//        int n= sc.nextInt();
//        char f=sc.next().charAt(0);
//        int length=m.length();
//        List<Long> res=new ArrayList<>();
//        int weishus=weishu(n);
//        for (int i = length; i >=3 ; i--) {
//            String s=m.substring(i-3,i);
//            int value=Integer.valueOf(s);
//            int re=0;
//            if(f=='+') {
//                re = is_smae(value + n);
//            }
//            if(f=='-') {
//                re = is_smae(value - n);
//            }
//            if(f=='*') {
//                re = is_smae(value * n);
//            }
//                if(re==10){
//                    continue;
//                }else {
//
//                    int t=i-3-1;
//                    while(t>0){
//                        if(m.charAt(t)=='0'+re){
//                            t--;
//                        }else {
//                            break;
//                        }
//                    }
//                    res.add(Long.valueOf(m.substring(t+1,i)));
//
//                }
//        }
//        int max=0;
//        if(res.size()==0){
//            System.out.println(-1);
//        }else{
//            Collections.sort(res);
//            System.out.println(res.get(res.size()-1));
//        }
//
//
//    }
//    public static int is_smae(int n){
//        int lastDigit = n % 10;
//        while (n > 0) {
//            int digit = n % 10;
//            if (digit != lastDigit) {
//                return 10;
//            }
//            n /= 10;
//        }
//        return lastDigit;
//    }
//    public static int weishu(int n){
//        int res=0;
//        while (n > 0) {
//           res++;
//           n /= 10;
//        }
//        return res;
//    }
//}
//public class Main {
//    public static void main(String[] args) {
//        Scanner sc=new Scanner(System.in);
//        List<Integer> list=new ArrayList<>();
//        List<Integer> sum=new ArrayList<>();
//        int length=0;
//        while (sc.hasNext()){
//            int num=sc.nextInt();
//            list.add(num);
//            length++;
//            if(length==1){
//                sum.add(num);
//            }else{
//                sum.add(num+ sum.get(length-2));
//            }
//        }
//        int i=0;
//        Stack<Integer> res=new Stack<>();
//        int cishu=0;
//        while(i<length){
//            if(i==0){
//                res.add(list.get(i));
//            }else{
//                int now=list.get(i);
//                int t=i-1;
//                int f=0;
//                int pre=sum.get(t);
//                if(pre==now){
//                    f=1;
//                    res=new Stack<>();
//                    res.add(now*2);
//                }else{
//                    for (int j = i-2; j >=0 ; j--) {
//                        if(now==(pre-sum.get(j))){
//                            f=1;
//                            t-=cishu;
//                            cishu+=(t-j);
//                            while(t>j){
//                                res.pop();
//                                t--;
//                            }
//
//                            if(!res.empty()&&now*2==res.peek()){
//                                res.pop();
//                                res.add(now*4);
//                            }else{
//                                res.add(now*2);
//                            }
//                            break;
//                        }
//                    }
//                }
//                if(f==0){
//                    res.add(now);
//                }
//
//            }
//            i++;
//        }
//        i=0;
//        while(!res.empty()){
//            if(i==0){
//                System.out.print(res.pop());
//            }else {
//                System.out.print(" "+res.pop());
//            }
//            i++;
//
//        }
//
//
//    }
//}
//public class Main {
//    public static void main(String[] args) {
//        String[] names=new String[]{"Mary","John","Emma"} ;
//        int[] heights=new int[]{180,165,170};
//        sortPeople(names,heights);
//    }
//    public static String[] sortPeople(String[] names, int[] heights) {
//        int m= names.length;
//        Info[] infos=new Info[m];
//        for(int i=0;i<m;i++){
//            Info in=new Info(names[i],heights[i]);
//            infos[i]=in;
//        }
//        Arrays.sort(infos, new Comparator<Info>() {
//            @Override
//            public int compare(Info o1, Info o2) {
//                return o2.height-o1.height;
//            }
//        });
//        String[] res=new String[m];
//        for (int i = 0; i < m; i++) {
//            res[i]=(infos[i].name);
//        }
//        return res;
//    }
//}
//class Info{
//    String name;
//    int height;
//    Info(){}
//    Info(String name,int height){
//        this.name=name;
//        this.height=height;
//    }
//
//}
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int t = sc.nextInt();
//        while (t-- > 0) {
//            int n = sc.nextInt();
//            int x = sc.nextInt();
//            int[] a = new int[n];
//            for (int i = 0; i < n; i++) {
//                a[i] = sc.nextInt();
//            }
//            int[] b = a.clone();
//            Arrays.sort(b);  // 对数组 b 进行排序
//            int minIdx = 0;
//            for (int i = 1; i < n; i++) {  // 找到 a 中最小元素的下标
//                if (a[i] < a[minIdx]) {
//                    minIdx = i;
//                }
//            }
//            int cnt = 0;  // 计算旋转次数
//            for (int i = minIdx; i < n; i++) {
//                if (a[i] != b[cnt]) {
//                    cnt++;
//                }
//            }
//            System.out.println(n - cnt - x);
//        }
//    }
//}

//    public static void main(String[] args) {
//        Scanner sc=new Scanner(System.in);
//        int n= sc.nextInt();
//        int k= sc.nextInt();
//        int []nums=new int[n];
//        int []dp=new int[n];
//        Arrays.fill(dp,Integer.MAX_VALUE);
//        for (int i = 0; i < n; i++) {
//            nums[i]= sc.nextInt();
//        }
//        dp[0]=0;
//        int res=0;
//        for (int i = 1; i < n;i++) {
//            for (int j = i-1; j >=0&&j>=i-k ; j--) {
//                dp[i]=Math.min(dp[i],dp[j]+Math.max(0,nums[i]-nums[j]) );
//            }
//
//        }
//        System.out.println(dp[n-1]);
//    }
//}
//    public static void main(String[] args) {
//        Scanner sc=new Scanner(System.in);
//        int x1= sc.nextInt();
//        int x2= sc.nextInt();
//        int x3= sc.nextInt();
//        int x4= sc.nextInt();
//        int d= sc.nextInt();
//
//        int max;
//        int t=0;
//        for (int i = 0; i < x1; i++) {
//            int x= sc.nextInt();
//            if(x>=d){
//                t++;
//            }
//        }
//        max=t;
//        t=0;
//        for (int i = 0; i < x2; i++) {
//            int x= sc.nextInt();
//            if(x>=d){
//                t++;
//            }
//        }
//        max=Math.min(max,t);
//        t=0;
//        for (int i = 0; i < x3; i++) {
//            int x= sc.nextInt();
//            if(x>=d){
//                t++;
//            }
//        }
//        max=Math.min(max,t);
//        t=0;
//        for (int i = 0; i < x4; i++) {
//            int x= sc.nextInt();
//            if(x>=d){
//                t++;
//            }
//        }
//        max=Math.min(max,t);
//
//        System.out.println(max);
//    }
//}
//    public static void main(String[] args) {
//        Scanner sc=new Scanner(System.in);
//        int n= sc.nextInt();
//        String str=sc.next();
//        StringBuffer res=new StringBuffer();
//        for (int i = 0; i < str.length(); i++) {
//            char c=(char)((str.charAt(i)-'a'+23)%26+'a');
//            res.append(c);
//        }
//        System.out.println(res.toString());
//    }
//}
//        public static void main(String[] args) {
//            Scanner scanner = new Scanner(System.in);
//            int n = scanner.nextInt();
//            int m = scanner.nextInt();
//
//            int[] days = new int[n];
//            int[] costs = new int[n];
//            int[] prices = new int[n];
//
//            for (int i = 0; i < n; i++) {
//                days[i] = scanner.nextInt();
//            }
//
//            for (int i = 0; i < n; i++) {
//                costs[i] = scanner.nextInt();
//            }
//
//            for (int i = 0; i < n; i++) {
//                prices[i] = scanner.nextInt();
//            }
//
//            int[][] dp = new int[n][m + 1];
//            for (int i = 1; i < m+1; i++) {
//                if(i>=costs[0]){
//                    int ns=i/costs[0];
//                    dp[0][i]=ns*(prices[0]-costs[0]);
//
//                }
//
//            }
//            for (int i = 1; i < n; i++) {
//                for (int j = 1; j <m+1 ; j++) {
//                        if(j<days[i]){
//                            dp[i][j]=dp[i-1][j];
//                        }else{
//                            dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-days[i]]+prices[i]-costs[i]);
//                        }
//                }
//            }
//
//            System.out.println(dp[n-1][m]);
//        }
//}
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int X = sc.nextInt();
//        int Y = sc.nextInt();
//        sc.close();
//
//        int count = 0;
//        for (int i = 0; i <= X; i++) {      // 枚举菱形的中心点 x 坐标
//            for (int j = 0; j <= Y; j++) {  // 枚举菱形的中心点 y 坐标
//                for (int k = 1; i - k >= 0 && i + k <= X && j - k >= 0 && j + k <= Y; k++) {
//                    // 枚举菱形的半边长 k，保证菱形不越界
//                    count++;
//                }
//            }
//        }
//
//        System.out.println(count);
//        ;
//
//    }
//}

//import java.util.*;
//
///**
// * @author nsf
// *
// */
//public class Main {
//    public static void main(String[] args) {
//        Scanner sc=new Scanner(System.in);
//        int n=sc.nextInt();
//        int []id_values=new int[n];
//        int []id_parents=new int[n+1];
//        Arrays.fill(id_parents,-2);
//        int max=Integer.MIN_VALUE;
//        for (int i = 0; i < n; i++) {
//            int id= sc.nextInt();
//            int parent= sc.nextInt();
//            int value= sc.nextInt();
//            id_values[id]=value;
//            if(parent==-1){
//                id_parents[n]=id;
//            }else{
//                id_parents[parent]=id;
//            }
//            max=Math.max(max,value);
//
//        }
//
//        max=Math.max(max,path(id_parents,id_values,n,Integer.MIN_VALUE));
//
//
//        System.out.println(max);
//
//    }
//
//    private static int path(int[] idParents, int[] idValues, int id,int now_max) {
//        int max=Integer.MIN_VALUE;
//        if(idParents[id]==-2){
//            return 0;
//        }
//        if(now_max>max){
//            max=now_max;
//        }
//        max=Math.max(max,huisu_path(idParents,idValues,id,now_max));
//        max=Math.max(path(idParents,idValues,idParents[id],now_max),max);
//        return max;
//    }
//
//    private static int huisu_path(int[] idParents, int[] idValues, int id,int now_sum) {
//        int sum=0;
//        if(idParents[id]==-2){
//            return now_sum+idValues[id];
//        }
//        now_sum+=idValues[id];
//        huisu_path(idParents,idValues,idParents[id],now_sum);
//
//        return now_sum;
//
//
//    }
//}
//    public static void main(String[] args) {
//        Scanner sc=new Scanner(System.in);
//        int n= sc.nextInt();
//        int[][] pionts=new int[n][n];
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                pionts[i][j]= sc.nextInt();
//            }
//        }
//        int res=0;
//        Set<Integer> set=new HashSet<>();
//        for (int i = 0; i < n; i++) {
//            if(!set.contains(i)){
//                Set<Integer> tmp=new HashSet<>();
//                tmp.add(i);
//                handles(tmp,i,pionts);
//                set.addAll(tmp);
//                res++;
//            }
//        }
//        System.out.println(res);
//    }
//
//    private static void handles(Set<Integer> tmp, int i, int[][] pionts) {
//        for (int j = 0; j < pionts.length; j++) {
//            if(!tmp.contains(j)&&pionts[i][j]==1){
//                tmp.add(j);
//                handles(tmp,j,pionts);
//            }
//        }
//    }
//
//
//}
//    /**
//     * P1189. 2023.04.13-实习笔试-第一题-购物系统的降级策略
//     * @param args
//     */
//    public static void main(String[] args) {
//        Scanner sc=new Scanner(System.in);
//        String s=sc.nextLine();
//        int max=sc.nextInt();
//        String[] ss=s.split(" ");
//
//        int n = ss.length;
//        int []nums=new int[n];
//        long sum = 0;
//        for(int i = 0; i < n; i++){
//            nums[i] = Integer.parseInt(ss[i]);
//            sum += nums[i];
//        }
//        if(sum<=max){
//            System.out.println(-1);
//            return ;
//        }
//        Arrays.sort(nums);
//        int index=0;
//        while(nums[index]==0){
//            index++;
//        }
//        int res=0;
//        for (int i = index; i <n ; i++) {
//            double now=(double) max/(n-i);
//            if(now-nums[i]>=0.001){
//                max-=nums[i];
//            }else {
//                res=(int) now;
//                break;
//            }
//        }
//        if(res<0){
//            System.out.println(-1);
//            return;
//        }
//        System.out.println(res);
//
//
//
//
//    }
//}
//    /**
//     * #P1057. 2022.11.17-分奖金
//     * @param args
//     */
//    public static void main(String[] args) {
//        Scanner sx=new Scanner(System.in);
//        int n= sx.nextInt();
//        int [] nums=new int [n];
//        for (int i = 0; i < n; i++) {
//            nums[i]= sx.nextInt();
//        }
//
//        int[] res=new int[n];
//        for (int i = 0; i < n; i++) {
//            res[i]=nums[i];
//            for (int j = i+1; j <n ; j++) {
//                if(nums[j]>res[i]){
//                    res[i]=(i+1)*(nums[j]-res[i]);
//                    break;
//                }
//            }
//        }
//        System.out.print(res[0]);
//        for (int i = 1; i < n; i++) {
//            System.out.print(" "+res[i]);
//        }
//    }
//}
//    /**
//     * 滑动窗口+单调递增队列
//     * @param args
//     */
//    public static void main(String[] args) {
//        Scanner sc=new Scanner(System.in);
//        int m= sc.nextInt();
//        sc.nextLine();
//        String str= sc.nextLine();
//        String []tmp=str.split(",");
//        int []num=new int[tmp.length];
//        for (int i = 0; i < tmp.length; i++) {
//            num[i]=Integer.valueOf(tmp[i]);
//        }
//        Dqeue queue=new Dqeue();
//        for (int i = 0; i < m; i++) {
//             queue.add(num[i]);
//        }
//        System.out.print(queue.peek());
//        for (int i=m;i<tmp.length;i++){
//            queue.poll(num[i-m]);
//            queue.add(num[i]);
//            System.out.print( ","+queue.peek());
//        }
//
//    }
//
//}
//class Dqeue{
//    Deque<Integer> min = new LinkedList<>();
//    Dqeue(){}
//    public void add(int num){
//
//        while(!min.isEmpty()&&min.getLast()>num){
//            min.removeLast();
//        }
//        min.addLast(num);
//
//    }
//    public void poll(int num){
//        if (!min.isEmpty()&&num==min.peek()){
//            min.poll();
//        }
//    }
//      public  int peek(){
//        return min.peek();
//    }
//
//
//
//}
//    public static void main(String[] args) {
//        Scanner scanner=new Scanner(System.in);
//        int n=scanner.nextInt();
//        ListNode1 head=new ListNode1();
//        for (int i = 0; i < n; i++) {
//            String t=scanner.next();
//            if(t.equals("a")){
//                int num=scanner.nextInt();
//                int scoure=scanner.nextInt();
//                ListNode1 next=head.next;
//                if(next==null){
//                    ListNode1 node=new ListNode1(scoure,num);
//                    head.next=node;
//                }else{
//
//                    ListNode1 pre=head;
//                    while(next!=null){
//                        if(next.val<=scoure){
//                            pre=next;
//                            next=next.next;
//                        }else{
//                            ListNode1 node=new ListNode1(scoure,num);
//                            pre.next=node;
//                            node.next=next;
//                            break;
//                        }
//                    }
//                    if(next==null){
//                        ListNode1 node=new ListNode1(scoure,num);
//                        pre.next=node;
//                        node.next=next;
//                    }
//                }
//
//
//            }else{
//                System.out.println(head.next.num);
//                head.next=head.next.next;
//
//            }
//        }
//    }
//}
//class ListNode1 {
//    int val;
//    int num;
//    ListNode1 next;
//
//    ListNode1() {
//    }
//
//    ListNode1(int val, int num) {
//        this.val = val;
//        this.num=num;
//    }
//}

//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n=sc.nextInt();
//        int []num=new int[n];
//        for (int i = 0; i < n; i++) {
//            num[i]=sc.nextInt();
//        }
//        Arrays.sort(num);
//
//        int res=num[n-1]-1;
//        int pre=res;
//        for (int i = n-2; i >=0 ; i--) {
//            if(pre==num[i]){
//                continue;
//            }
//            if(res!=num[i]){
//                System.out.println(res);
//                return;
//            }
//            res--;
//        }
//        System.out.println(res);
//    }
//}

//    /**
//     * 判断正方形的数量
//     * @param args
//     */
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n=sc.nextInt();
//        int [][] nums=new int[n][2];
//        for (int i = 0; i <n ; i++) {
//            nums[i][0]=sc.nextInt();
//            nums[i][1]=sc.nextInt();
//        }
//        List<List<int[]>>res=new ArrayList<>();
//        List<int[]> tmp=new ArrayList<>();
//        boolean []used=new boolean[n];
//        int num=0;
//        huisu(res,tmp,used,0,nums);
//        for (int i = 0; i < res.size(); i++) {
////            for (int j = 0; j < res.get(i).size(); j++) {
////                for (int k = 0; k < res.get(i).get(j).length; k++) {
////                    System.out.print(res.get(i).get(j)[k]+" ");
////                }
////                System.out.println();
////            }
//            if(is_legal(res.get(i))){
//                num++;
//            }
//        }
//        System.out.println(num);
//
//
//    }
//
//    private static void huisu(List<List<int[]>> res, List<int[]> tmp, boolean[] used, int i, int[][] nums) {
//        if(tmp.size()==4){
//            res.add(new ArrayList<>(tmp));
//            tmp=new ArrayList<>();
//            return;
//        }
//        for (int j = i; j < nums.length ; j++) {
//            if(!used[j]){
//                tmp.add(new int[]{nums[j][0],nums[j][1]});
//                used[j]=true;
//                huisu(res, tmp, used, j+1, nums);
//                used[j]=false;
//                tmp.remove(tmp.size()-1);
//
//            }
//        }
//    }
//
//    private static boolean is_legal(List<int[]> integers) {
//        int []a=integers.get(0);
//        int []b= integers.get(1);
//        int []c=integers.get(2);
//        int []d= integers.get(3);
////        System.out.println(a[0]+"\t"+a[1]);
////        System.out.println(b[0]+"\t"+b[1]);
////        System.out.println(c[0]+"\t"+c[1]);
////        System.out.println(d[0]+"\t"+d[1]);
//
//        double ab=Math.sqrt((a[0]-b[0])*(a[0]-b[0])+(a[1]-b[1])*(a[1]-b[1]));
//        double ac=Math.sqrt((a[0]-c[0])*(a[0]-c[0])+(a[1]-c[1])*(a[1]-c[1]));
//        double ad=Math.sqrt((a[0]-d[0])*(a[0]-d[0])+(a[1]-d[1])*(a[1]-d[1]));
//        double cd=Math.sqrt((c[0]-d[0])*(c[0]-d[0])+(c[1]-d[1])*(c[1]-d[1]));
//        double bd=Math.sqrt((b[0]-d[0])*(b[0]-d[0])+(b[1]-d[1])*(b[1]-d[1]));
//        double bc=Math.sqrt((b[0]-c[0])*(b[0]-c[0])+(b[1]-c[1])*(b[1]-c[1]));
//        if(((ab-ac)<=0.0001&&(ab-ac)>=-0.0001)&&((ab-bd)<=0.0001&&(ab-bd)>=-0.0001)&&((ab-cd)<=0.0001&&(ab-cd)>=-0.0001)&&((ad-bc)<=0.0001&&(ad-bc)>=-0.0001)){
//            return true;
//        }
//        if(((ab-bc)<=0.0001&&(ab-bc)>=-0.0001)&&((ab-ad)<=0.0001&&(ab-ad)>=-0.0001)&&((ab-cd)<=0.0001&&(ab-cd)>=-0.0001)&&((ac-bd)<=0.0001&&(ac-bd)>=-0.0001)){
//            return true;
//        }
//        if(((ad-ac)<=0.0001&&(ad-ac)>=-0.0001)&&((ad-bd)<=0.0001&&(ad-bd)>=-0.0001)&&((ad-bc)<=0.0001&&(ad-bc)>=-0.0001)&&((ab-cd)<=0.0001&&(ab-cd)>=-0.0001)){
//            return true;
//        }
////        System.out.println(ab+"\t"+ac+"\t"+ad);
////        if(((ab-ac)<=0.0001&&(ab-ac)>=-0.0001)&&(ab-(ad/2)*Math.sqrt(2)<=0.0001&&ab-(ad/2)*Math.sqrt(2)>=-0.0001)){
////            return true;
////        }
////        if(((ad-ac)<=0.0001&&(ad-ac)>=-0.0001)&&(ad-(ab/2)*Math.sqrt(2)<=0.0001&&ad-(ab/2)*Math.sqrt(2)>=-0.0001)){
////            return true;
////        }
////        if(((ab-ad)<=0.0001&&(ab-ad)>=-0.0001)&&(ab-(ac/2)*Math.sqrt(2)<=0.0001&&ab-(ac/2)*Math.sqrt(2)>=-0.0001)){
////            return true;
////        }
//        return false;
//    }
//
//
//
//
//}
//    public static void main(String[] arg) {
//        Scanner sc = new Scanner(System.in);
//        char[] chs = sc.nextLine().toCharArray();
//        int count = 0;
//
//        for (int i = 0; i < chs.length; i++) {
//            if (chs[i] == 'M') {
//                if (i + 1 < chs.length && chs[i + 1] == 'I') {
//                    count++;
//                    i += 2;
//                } else if (i > 0 && chs[i - 1] == 'I') {
//                    count++;
//                } else {
//                    count = -1;
//                    break;
//                }
//            }
//
//        }
//        System.out.println(count);
//    }
//
//}
//    public static void main(String[] args) {
//        Scanner scanner=new Scanner(System.in);
//        int n=scanner.nextInt();
//        int[] nums=new int[n];
//        for (int i = 0; i < n; i++) {
//            nums[i]=scanner.nextInt();
//        }
//        int [] mins=new int[]{Integer.MAX_VALUE};
//        huisu(0,0,0,0,nums,mins);
//        if(mins[0]==Integer.MAX_VALUE){
//            System.out.println(0);
//        }else{
//            System.out.println(mins[0]);
//
//        }
//    }
//
//    private static void huisu(int index,int sum_x,int sum_y,int sum_z,int[] nums,int[]mins) {
//        if(index== nums.length){
//            if(sum_z>sum_y&&sum_y>sum_x&&sum_x>0){
//                mins[0]=Math.min(mins[0],(sum_z-sum_x));
//
//            }
//            return ;
//        }
//        huisu(index+1, sum_x+nums[index], sum_y, sum_z, nums,mins);
//        huisu(index+1, sum_x, sum_y+nums[index], sum_z, nums,mins);
//        huisu(index+1, sum_x, sum_y, sum_z+nums[index], nums,mins);
//    }
//}
//    /**
//     * 2022.10.11-字母加密
//     * @param args
//     */
//    public static void main(String[] args) {
//        Scanner scanner=new Scanner(System.in);
//        String str= scanner.next();
//        int n=str.length();
//        int []a=new int[n];
//        a[0]=1;
//        a[1]=2;
//        a[2]=4;
//        char[] res=new char[n];
//        for (int i = 3; i < n; i++) {
//            a[i]=(a[i-1]+a[i-2]+a[i-3])%26;
//        }
//        for (int i = 0; i < n; i++) {
//            res[i]= (char) ((char)(str.charAt(i)-'a'+a[i])%26+'a');
//        }
//        System.out.println(new String(res));
//    }
//}
//    /**
//     * 超时
//     */
//    static int tttt=0;
//    public static void main(String[] args) {
//        Scanner scanner=new Scanner(System.in);
//        int n = scanner.nextInt();
//        int [] num = new int[n];
//        int sum=0;
//        for (int i = 0; i < n; i++) {
//            num[i]=scanner.nextInt();
//            sum+=num[i];
//        }
//        if(n==1||sum%2==1){
//            System.out.println(0);
//            return ;
//        }
//        List<List<Integer>> res=new ArrayList<>();
//        List<Integer> tmp=new ArrayList<>();
//        boolean[] used=new boolean[n];
//        huisu(res,tmp,used,num,sum/2);
//        System.out.println(tttt);
//
//}
//
//    private static void huisu(List<List<Integer>> res, List<Integer> tmp, boolean[] used, int[] num, int sum) {
//        if(sum==0){
//            tttt++;
////            res.add(new ArrayList<>(tmp));
//            return;
//        }
//
//        for (int i = 0; i < num.length; i++) {
//            if(!used[i]){
//                used[i]=true;
//                sum+=num[i];
//                tmp.add(num[i]);
//                huisu(res, tmp, used, num, sum);
//                sum-=num[i];
//                tmp.remove(tmp.size()-1);
//                used[i]=false;
//            }
//        }
//    }
//}
//    /**
//     * 2022.11.2-检测热点字符
//     * @param args
//     */
//    public static void main(String[] args) {
//        int[] cnt = new int[256];
//        int M, num;
//        String str;
//        Scanner scanner = new Scanner(System.in);
//        M = scanner.nextInt();
//        num = scanner.nextInt();
//        str = scanner.next();
//        int nowcnt = 0; // 记录当前更新的第几个字符
//        for (int j = 0; j < str.length(); j++) {
//            int t = str.charAt(j);
//            cnt[t]++;
//            nowcnt++;
//            if (nowcnt == num) { // 如果记录的数量到达应该计算的增量时统计答案
//                List<int[]> tmparr = new ArrayList<>();
//                // 依次遍历数字，小写字母，大写字母，存入临时数组中
//                for (int i = 'a'; i <= 'z'; i++) {
//                    tmparr.add(new int[]{cnt[i], i});
//                }
//                for (int i = 'A'; i <= 'Z'; i++) {
//                    tmparr.add(new int[]{cnt[i], i});
//                }
//                for (int i = '0'; i <= '9'; i++) {
//                    tmparr.add(new int[]{cnt[i], i});
//                }
//                // 重载排序按第一维数量排，第一维相等时按第二维字母ascii码排
//                Collections.sort(tmparr, new Comparator<int[]>() {
//                    @Override
//                    public int compare(int[] o1, int[] o2) {
//                        if (o1[0] != o2[0]){
//                            return o1[0]-o2[0];
//                        }
//
//                        return o1[1]-o2[1];
//                    }
//
//                });
//                // 统计前 m 个输出
//                int tmp = M;
//                while (tmparr.size() > 0 && tmp != 0) {
//                    tmp--;
//                    System.out.print((char) tmparr.get(tmparr.size() - 1)[1]);
//                    tmparr.remove(tmparr.size() - 1);
//                }
//                nowcnt = 0;
//            }
//        }
//    }
//
//}
//    /**
//     * P1028. 2022.8.30-第k大字母
//     * @param args
//     */
//    public static void main(String[] args) {
//        Scanner sc=new Scanner(System.in);
//        String str= sc.nextLine();
//        int k= sc.nextInt();
//        char[] s= str.toCharArray();
//        Arrays.sort(s);
//        if(k> s.length){
//            char c=s[s.length-1];
//            for (int i = 0; i < s.length; i++) {
//                if(c==str.charAt(i)){
//                    System.out.println(i);
//                    break;
//                }
//            }
//        }else{
//            char c=s[k-1];
//            for (int i = 0; i < s.length; i++) {
//                if(c==str.charAt(i)){
//                    System.out.println(i);
//                    break;
//                }
//            }
//        }
//    }
//}
//    /**
//     * 没有全部ac。还差两个样例
//     * P1030. 2022.11.27-平均像素值
//     * @param args
//     */
//    public static void main(String[] args) {
//        Scanner scanner=new Scanner(System.in);
//        List<Integer> nums=new ArrayList<>();
//        int n=0;
//        int tmp=0;
//        while(!scanner.hasNext("A")){
//            int num=scanner.nextInt();
//            tmp+=(128-num);
//            nums.add(num);
//            n++;
//        }
//        double r=(double)tmp/n*1.0;
//        int r_1=tmp/n;
//        if(r<0){
//            if((r-r_1)*10>-5){
//                System.out.println(r_1);
//            }else{
//                System.out.println(r_1-1);
//            }
//
//        } else if (r==0) {
//            System.out.println(0);
//        }else {
//            if((r-r_1)<=0.5){
//                System.out.println(r_1);
//            }else{
//                System.out.println(r_1+1);
//            }
//        }
//
//    }
//    public static void main(String[] args) {
//        Scanner sc=new Scanner(System.in);
//        int n= sc.nextInt();
//        int[] nums=new int[n];
//        int tmp=0;
//        int sum=0;
//        int min=Integer.MAX_VALUE;
//        for (int i = 0; i < n; i++) {
//            nums[i]=sc.nextInt();
//            min=Math.min(min,nums[i]);
//            tmp^=nums[i];
//            sum+=nums[i];
//        }
//        if(tmp==0){
//            System.out.println(sum-min);
//        }
//        else {
//            System.out.println("No");
//        }
//
//    }


//    /**
//     *2022.9.21-数组取min
//     */
//    public static void main(String[] args) {
//        Scanner sc=new Scanner(System.in);
//        int n= sc.nextInt();
//        int tot=sc.nextInt();
//        int[] nums=new int[n];
//        int sum=0;
//        int res=tot/n;
//        for (int i = 0; i < n; i++) {
//            nums[i]=sc.nextInt();
//            sum+=nums[i];
//        }
//        Arrays.sort(nums);
//        if(sum<=tot){
//            System.out.println(-1);
//            return;
//        }
//        int size=n;
//        for (int i = 0; i < n; i++) {
//            if(nums[i]<=res){
//                size--;
//                tot-=nums[i];
//            }else {
//                break;
//            }
//
//        }
//        System.out.println((int)(tot/size) );
//    }
