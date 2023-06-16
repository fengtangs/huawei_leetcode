import sun.nio.cs.ext.MacHebrew;

import java.util.*;

/**
 *
 *
 * 机考参考：
 * 递归：LeetCode70、112、509
 * 分治：LeetCode23、169、240
 * 单调栈：LeetCode84、85、739、503
 * 并查集：LeetCode547、200、684
 * 滑动窗口：LeetCode209、3、1004、1208
 * 前缀和：LeetCode724、560、437、1248
 * 差分：LeetCode1094、121、122
 * 拓扑排序：LeetCode210
 * 字符串：LeetCode5、20、43、93
 * 二分查找：LeetCode33、34
 * BFS：LeetCode127、139、130、529、815
 * DFS&回溯：：LeetCode934、685、1102、531、533、113、332、337
 * 动态规划：LeetCode213、123、62、63、361、1230
 * 贪心算法：LeetCode55、435、621、452
 * 字典树：LeetCode820、208、648
 */

public class leetcode {


    /**
     * https://leetcode.cn/problems/climbing-stairs/
     * 爬楼梯70
     * 动态规划
     */
    public int climbStairs(int n) {
        int []dp=new int[n+1];
        dp[1]=1;
        dp[2]=2;
        for (int i = 3; i <=n ; i++) {
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }

    /**
     * 112 https://leetcode.cn/problems/path-sum/
     * 路径总和
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null) return false;
        List<Integer> res=new ArrayList<>();
        huisu(res,root,0,targetSum);
        if(res.size()!=0){
            return true;
        }
        return false;
    }

    public void  huisu(List<Integer>res,TreeNode root,int sum,int targetSum){
        sum+=root.val;
        if (root.left==null&&root.right==null){
            if(targetSum==sum){
                res.add(sum);
            }
            return;
        }

        if(root.left!=null){
            huisu(res,root.left,sum,targetSum);
        }
        if(root.right!=null){
            huisu(res,root.right,sum,targetSum);
        }


    }


    /**
     * 斐波那契数列 509
     * https://leetcode.cn/problems/fibonacci-number/
     */
    public int fib(int n) {
        if(n==1||n==0) return n;
        int []dp=new int[n+1];
        dp[0]=0;
        dp[1]=1;
        for (int i = 2; i <=n; i++) {
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }

    /**
     * 分治：LeetCode23、169、240
     * 23 合并K个升序链表
     * 有点难
     * https://leetcode.cn/problems/merge-k-sorted-lists/
     */
    public ListNode mergeKLists(ListNode[] lists) {
            if(lists.length==0||lists==null) return null;
            return fenzhi_merge(lists,0,lists.length-1);
    }
    public ListNode fenzhi_merge(ListNode[] lists,int start,int end){
        if(start==end) return lists[start];
        int mid=start+(end-start)/2;
        ListNode l1=fenzhi_merge(lists,start,mid);
        ListNode l2=fenzhi_merge(lists,mid+1,end);
        return merage_two(l1,l2);
    }
    ListNode merage_two(ListNode l1,ListNode l2){
        if(l1==null) return l2;
        if(l2==null) return l1;
        ListNode p1=l1;
        ListNode p2=l2;
        ListNode res=new ListNode();
        ListNode pre=res;
        while(p1!=null&&p2!=null){
            if(p1.val> p2.val){
                pre.next=p2;
                pre=p2;
                p2=p2.next;
            }else{
                pre.next=p1;
                pre=p1;
                p1=p1.next;
            }
        }
        while (p1!=null){
            pre.next=p1;
            pre=p1;
            p1=p1.next;
        }
        while (p2!=null){
            pre.next=p2;
            pre=p2;
            p2=p2.next;
        }
        return res.next;
    }

    /**
     * 169
     * 多数元素
     * 简单
     * https://leetcode.cn/problems/majority-element/
     */
    public int majorityElement(int[] nums) {
        int num=1;
        int t=nums[0];
        for (int i = 1; i < nums.length; i++) {
            if(t!=nums[i]){
                num--;
                if(num==0){
                    t=nums[i];
                    num=1;
                }
            }else{
                num++;
            }
        }
        return t;
    }

    /**
     * 240
     * https://leetcode.cn/problems/search-a-2d-matrix-ii/
     * 中等
     * 搜索二维矩阵2
     *我觉得是二分查找
     *
     */
    public boolean searchMatrix(int[][] matrix, int target) {
            int i=matrix.length-1,j=0;
            boolean flag=false;
            while (j<matrix[0].length&&i>=0){
                    if(target>matrix[i][j]){
                        j--;
                    }
                    if(target<matrix[i][j]){
                        i++;
                    }
                    if(target==matrix[i][j]){
                        return true;
                    }
            }
            return false;
    }


    /**
     * 单调栈：LeetCode84、85、739、503
     *https://leetcode.cn/problems/largest-rectangle-in-histogram/
     * 84  柱状图中最大的矩形
     */
    public int largestRectangleArea(int[] heights) {
        //暴力解法
        //不行，过不了，超时
        int res=0;
        for (int i = 0; i < heights.length; i++) {
            int height = heights[i];
            int left = i,right = i;
            while ( left >= 1&&height <= heights[left-1] ) {
                left--;
            }
            while (right+1 < heights.length&&height <= heights[right+1]) {
                right++;
            }
            int r = 0;

            r = (right - left+1) * height;

            res = res > r ? res : r;
        }
        return res;

    }

    //单调栈解法
    public int largestRectangleArea_1(int[] heights) {
        int n=heights.length;
        if(n==0) return 0;
        if(n==1) return heights[0];
        //单调栈，存放升序的下标
        Stack<Integer> stack=new Stack<>();
        int res=0;
        stack.push(0);
        for (int i = 1; i < heights.length; i++) {
            //如果当前元素比栈顶元素小
            while(!stack.isEmpty()&&heights[stack.peek()]>heights[i]){
                int index=stack.pop();
                int stack_height=heights[index];
                int w;
                if(stack.isEmpty()){
                    w=i;
                }else{
                    w=i-stack.peek()-1;
                }
                res= Math.max(res,w*stack_height);
            }
            stack.push(i);

        }
        while(!stack.isEmpty()){
            int index=stack.pop();
            int stack_height=heights[index];
            int w;
            if(stack.isEmpty()){
                w=n;
            }else{
                w=n-stack.peek()-1;
            }
            res= Math.max(res,w*stack_height);
        }
        return res;
    }

    /**
     * 单调栈：LeetCode84、85、739、503
     * https://leetcode.cn/problems/maximal-rectangle/
     * 85. 最大矩形
     * 大佬的思路，把每一层看成是柱状图，然后求最大值，这样就成了第84题。
     * @param matrix
     * @return
     */
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int col = matrix.length;
        int row = matrix[0].length;
        int[] heights = new int[row];
        int ans = 0;
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                if (matrix[i][j] == '1') {
                    heights[j] += 1;
                } else {
                    heights[j] = 0;
                }
            }
            ans = Math.max(ans, largestRectangleArea_1(heights));
        }
        return ans;

    }


    /**
     * 单调栈：LeetCode84、85、739、503
     *https://leetcode.cn/problems/daily-temperatures/
     * 739
     * 中等
     * 从后面往前看，
     */
    public static int[] dailyTemperatures(int[] temperatures) {

        int [] res=new int[temperatures.length];
        if(temperatures.length==1) return res;
        for (int i = temperatures.length-2; i >= 0; i--) {
            if(temperatures[i]==temperatures[i+1]){
                if(res[i+1]==0){
                    res[i]=0;
                }else{
                    res[i]=res[i+1]+1;
                }
            }
            else if(temperatures[i]<temperatures[i+1]){
                res[i]=1;
            }
            else if(temperatures[i]>temperatures[i+1]){
                if(res[i+1]==0){
                    res[i]=0;
                }else{
                    int t=i+1+res[i+1];
                    boolean f=false;
                    while(t<res.length){
                        if(temperatures[i]>temperatures[t]){
                            if(res[t]==0){
                                res[i]=0;
                                break;
                            }else{
                                t=t+res[t];
                            }
                        }
                        else if(temperatures[i]<temperatures[t]){
                            res[i]=t-i;
                            break;
                        }
                        else{
                            if(res[t]==0){

                                res[i]=0;
                                break;
                            }else{
                                res[i]=res[t]+t-i;
                                break;
                            }
                        }

//                        if(t==temperatures.length-1&&){
//                            res[i]=0;
//                            break;
//                        }
                    }

                }

            }

        }

        return res;

    }


    /**
     * 单调栈：LeetCode84、85、739、503
     *https://leetcode.cn/problems/next-greater-element-ii/
     * 503
     * 中等
     * 下一个更大元素'
     * 还可以不是很难，能做出来
     */
    public static int[] nextGreaterElements(int[] nums) {
        if(nums.length==1) return new int[]{0};
        int n= nums.length;
        Stack<int[]> stack=new Stack<>();
        stack.push(new int[]{nums[0],0});
        int[] res=new int[n];
        for (int i = 1; i < n*2-1; i++) {
            int j=i;
            if(j>=n){
              j-=n;
            }
            if(nums[j]<=stack.peek()[0]){
                stack.push(new int[]{nums[j],i});
            }else{
                while(!stack.isEmpty()&&stack.peek()[0]<nums[j]){
                    int []t= stack.pop();
                    if(t[1]<n){
                        res[t[1]]=nums[j];
                    }
                }
                stack.push(new  int[]{nums[j],i});
            }

        }
        while(!stack.isEmpty()){
            int []t= stack.pop();
            if(t[1]<n){
                res[t[1]]=-1;
            }
        }
        return res;
    }


    /**
     * 并查集：LeetCode547、200、684
     * 547
     */

    /**
     * 滑动窗口：LeetCode209、3、1004、1208
     * 3
     *https://leetcode.cn/problems/longest-substring-without-repeating-characters/?favorite=2cktkvj
     *
     * @param args
     */

    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0) return 0;
        if(s.length()==1) return 1;
        HashMap<Character,Integer> set=new HashMap<>();
        set.put(s.charAt(0),0);
        int j=1;
        int max=1;
        int now=1;
        while(j<s.length()){
            if(set.containsKey(s.charAt(j))){
                 int index=set.get(s.charAt(j));
                 set=new HashMap<>();
                for (int k = index+1; k <=j ; k++) {
                    set.put(s.charAt(k),k);
                }
                now=set.size();
            }else{
                set.put(s.charAt(j),j);
                now++;
                max=max>now?max:now;
            }
            j++;

        }
        return max;
    }


    /**
     * 滑动窗口：LeetCode209、3、1004、1208
     * 209
     * https://leetcode.cn/problems/minimum-size-subarray-sum/
     * 长度最小的子数组
     * @param args
     */
    public  static  int minSubArrayLen(int target, int[] nums) {
        int res=Integer.MAX_VALUE;
        int n=nums.length;
        if(n==1){
            if(nums[0]==target)
                return 1;
            return 0;
        }
        int i=0,j=1;
        int sum=nums[0];
        if(sum>=target){
            return 1;
        }
        while(i<j&&j<n){
            sum+=nums[j];

            while(sum>=target) {
                sum -= nums[i];
                res = res > (j - i+1) ? (j - i+1) : res;
                i++;
            }

                j++;

        }
        if(res==Integer.MAX_VALUE)
            return 0;
        return res;
    }


    /**
     * 滑动窗口：LeetCode209、3、1004、1208
     * 1004
     * 最大连续1的个数 III
     * https://leetcode.cn/problems/max-consecutive-ones-iii/
     * @param args
     */
    public static int longestOnes(int[] nums, int k) {
        int res=0;
        int n=nums.length;
        int left=0,right=0;
        int zeros=0;
        while(right<n){
            if(nums[right]==0){
                zeros++;
            }
            while(zeros>k){
                if(nums[left++]==0){
                   zeros--;
                }

            }
            res=Math.max(res,right-left+1);
            right++;
        }

        return res;
    }

    /**
     * 滑动窗口：LeetCode209、3、1004、1208
     * 1208
     *  尽可能使字符串相等
     * https://leetcode.cn/problems/get-equal-substrings-within-budget/
     * @param args
     */
    public static int equalSubstring(String s, String t, int maxCost) {

        int res=0;
        int n=s.length();
        int left=0,right=0;
        int zeros=maxCost;
        while(right<n){
            int cost=Math.abs(s.charAt(right)-t.charAt(right));
            if(cost>maxCost){
                right++;
                left=right;
                continue;
            }
//            else if (cost==maxCost) {
//                res=Math.max(1,res);
//                right++;
//                left=right;
//                continue;
//
//            }
            if(zeros-cost<0){
                int temp=0;
                while(temp<cost){
                        temp+=Math.abs(s.charAt(left)-t.charAt(left));
                        zeros+=Math.abs(s.charAt(left)-t.charAt(left));
                        left++;
                        if(left==right){
                            zeros=maxCost;
                            break;
                        }

                }
            }
            zeros-=cost;
            res=Math.max(res,right-left+1);
            right++;
        }

        return res;

    }


    /**
     *  前缀和：LeetCode724、560、437、1248
     * 724
     * https://leetcode.cn/problems/find-pivot-index/
     * 寻找数组的中心下标
     * 简单
     * @param args
     */
    public int pivotIndex(int[] nums) {
        int total = Arrays.stream(nums).sum();
        int sum = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (2 * sum + nums[i] == total) {
                return i;
            }
            sum += nums[i];
        }
        return -1;
    }

    /**
     * 前缀和：LeetCode724、560、437、1248
     * 1248. 统计「优美子数组」
     * 1248
     * https://leetcode.cn/problems/count-number-of-nice-subarrays/
     */
    public static int numberOfSubarrays(int[] nums, int k) {
        int res=0;
        int n=nums.length;
        int left=0,right=0;
        int zeros=0;
        while(right<n){
            int f=nums[right++]%2;
            if(f==1){
                zeros++;
            }
            if(zeros==k){
                int tmp=right;
                while (right<n&&(nums[right]&1)==0){
                    right++;
                }
                int rightnums=right-tmp;
                int leftnum=0;
                while((nums[left]&1)==0){
                    leftnum++;left++;
                }
                res+=(leftnum+1)*(rightnums+1);
                left++;
                zeros--;
            }
        }
        return res;
    }

    /**
     * 前缀和：LeetCode724、560、437、1248
     * 560
     * 和为 K 的子数组
     * https://leetcode.cn/problems/subarray-sum-equals-k/
     * @param root
     * @param  targetSum
     */
    public int pathSum(TreeNode root, int targetSum) {
        if(root==null){
            return 0;
        }
        int res=huisu_path(root,targetSum,0);
        res+=pathSum(root.left,targetSum);
        res+=pathSum(root.right,targetSum);
        return res;
    }

    private int huisu_path(TreeNode root, int targetSum,long  now_sum) {
        int res=0;
        if(root==null){
            return 0;
        }
        if(now_sum+root.val==targetSum){
            res++;
        }
        now_sum+= root.val;
        if(root.left!=null){
            res+=huisu_path(root.left, targetSum, now_sum);
        }
        if(root.right!=null){
            res+=huisu_path(root.right, targetSum, now_sum);
        }
        now_sum-= root.val;
        return res;

    }

    /**
     * 前缀和：LeetCode724、560、437、1248
     * 560
     * 和为 K 的子数组
     * https://leetcode.cn/problems/subarray-sum-equals-k/
     * @param args
     */
    public static int subarraySum(int[] nums, int k) {
        int len = nums.length;
        // 计算前缀和数组
        int[] preSum = new int[len];
        preSum[0] = nums[0];
        int count = 0;
        if(preSum[0]==k) count++;
        for (int i = 1; i < len; i++) {
            preSum[i] = preSum[i-1] + nums[i];
            if(preSum[i]==k){
                count++;
            }
        }


        for (int left = 0; left < len-1; left++) {
            for (int right = left+1; right < len; right++) {
                // 区间和 [left..right]，注意下标偏移
                if (preSum[right ] - preSum[left] == k) {
                    count++;
                }
            }
        }
        return count;

    }


    /**
     *LeetCode1094、121、122
     *121. 买卖股票的最佳时机
     * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/
     * 其实就是找i天中，的最大差值，但是要求最小值要在 取最大值之前。
     */
    public int maxProfit(int[] prices) {
        int min=prices[0];
        int res=0;
        for(int i=1;i<prices.length;i++){
            res=Math.max(res,prices[i]-min);
            min=Math.min(min,prices[i]);
        }
        return res;
    }

    /**
     *LeetCode1094、121、122
     *122. 买卖股票的最佳时2
     * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/
     */
    public int maxProfit2(int[] prices) {
        int res=0;
        for (int i = 1; i < prices.length; i++) {
            if(prices[i]>prices[i-1]){
                res+=(prices[i]-prices[i-1]);
            }
        }
        return res;
    }

    /**
     *LeetCode1094、121、122
     *1094. 拼车
     *  https://leetcode.cn/problems/car-pooling/
     */


    public static  boolean carPooling(int[][] trips, int capacity) {
        int now_nums=0;
        Arrays.sort(trips, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });
        Map<Integer,Integer> record=new HashMap<>();
        int now_stop=0;
        for (int i = 0; i < trips.length; i++) {
            while(now_stop<=trips[i][1]){
                //先下车
                if(record.containsKey(now_stop)){
                    now_nums-= record.get(now_stop);

                }
                now_stop++;
            }
            int nums=trips[i][0]+now_nums;
            //如果可以上车，
            if(nums<=capacity){
                now_nums=nums;
                int t=trips[i][0];
                if(record.containsKey(trips[i][2])){
                     t+= record.get(trips[i][2]);

                }
                record.put(trips[i][2],t);
            }
            //else，拉不了
            else{
                return false;
            }

        }
        return true;
    }


    /**
     *拓扑排序‘
     * 拓扑排序：LeetCode210
     * 210
     * 课程表 II
     *https://leetcode.cn/problems/course-schedule-ii/
     *
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
            int rudu[]=new int[numCourses];
            Map<Integer,List<Integer>> adj=new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            rudu[prerequisites[i][0]]++;
            if(!adj.containsKey(prerequisites[i][1])){
                List<Integer> t=new ArrayList<>();
                t.add(prerequisites[i][0]);
                adj.put(prerequisites[i][1],t);
            }else{
                adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
            }
        }
        
        int[] res=new int[numCourses];
        Queue<Integer> queue=new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if(rudu[i]==0){
                    queue.add(i);
            }
        }
        int index=0;
        while(!queue.isEmpty()){
                int node=queue.poll();
                res[index++]=node;
                if(adj.containsKey(node)){
                    for (Integer i: adj.get(node)) {
                        rudu[i]--;
                        if(rudu[i]==0){
                            queue.add(i);
                        }
                    }
                }
        }
        for (int i = 0; i < numCourses; i++) {
            if(rudu[i]!=0){
                return new int[0];
            }
        }
        return res;
    }

    /**
     *
     *  字符串：LeetCode5、20、43、93
     * 5. 最长回文子串
     * https://leetcode.cn/problems/longest-palindromic-substring/
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        //思路，暴力解法
        String res=new String();
        int max=0;
        for (int i = 0; i < s.length()-1; i++) {
            for (int j = i+1; j <= s.length(); j++) {
                if(huiwen(s.substring(i,j))){
                  if(max<j-i){
                      res=s.substring(i,j);
                      max=j-i;
                  }
                }
            }
        }
        return res;
    }

    private boolean huiwen(String substring) {
        if(substring.length()==1) return true;
        int i=0,j=substring.length()-1;
        while(i<j){
            if(substring.charAt(i)==substring.charAt(j)){
                i++;
                j--;
            }
            else{
                return false;
            }
        }
        return true;
    }

    public String longestPalindrome_1(String s) {
        //暴力解法会超时，用动态规划，对于一个字符串s[i,j]`如果他是字符串，那么对于s[i-1,j+1]，只要s[i-1]==s[j+1]那么他就是回文串
        int len=s.length();
        int max=0;
        String res=new String();
        if(len==1) return s;
        boolean[][] dp=new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i]=true;
        }
        //右边界
        for (int i = 1; i < len; i++) {
            //左边界
            for (int j = 0; j <= i; j++) {
                if(s.charAt(j)!=s.charAt(i)){
                    dp[j][i]=false;
                }else{
                    if(i-j<3){
                        dp[j][i]=true;
                    }else{
                        dp[j][i]=dp[j+1][i-1];
                    }
                }
                if(dp[j][i]&&max<(i-j+1)){
                    max=i-j+1;
                    res=s.substring(j,i+1);
                }
            }
        }
        return res;
    }


    /**
     *
     *  字符串：LeetCode5、20、43、93
     * 20
     * 有效的括号
     * https://leetcode.cn/problems/valid-parentheses/comments/
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c=='('){
                stack.push(')');
            }else if(c=='['){
                stack.push(']');
            }else if(c=='{'){
                stack.push('}');
            }
            else if(stack.isEmpty()||stack.pop()!=c){
                return  false;
            }
        }
        return stack.isEmpty();
    }

    /**
     * 字符串：LeetCode5、20、43、93
     * 43
     * https://leetcode.cn/problems/multiply-strings/
     * @param num1
     * @param num2
     * @return
     */

    public String multiply(String num1, String num2) {
//            int t1=stringtoint(num1);
//            int t2=stringtoint(num2);
//            return inttostring(t1*t2);

        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        String ans = "0";
        int m = num1.length(), n = num2.length();
        for (int i = n - 1; i >= 0; i--) {
            StringBuffer curr = new StringBuffer();
            int add = 0;
            for (int j = n - 1; j > i; j--) {
                curr.append(0);
            }
            int y = num2.charAt(i) - '0';
            for (int j = m - 1; j >= 0; j--) {
                int x = num1.charAt(j) - '0';
                int product = x * y + add;
                curr.append(product % 10);
                add = product / 10;
            }
            if (add != 0) {
                curr.append(add % 10);
            }
            ans = addStrings(ans, curr.reverse().toString());
        }
        return ans;
    }
    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1, j = num2.length() - 1, add = 0;
        StringBuffer ans = new StringBuffer();
        while (i >= 0 || j >= 0 || add != 0) {
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int result = x + y + add;
            ans.append(result % 10);
            add = result / 10;
            i--;
            j--;
        }
        ans.reverse();
        return ans.toString();
    }

    public static int stringtoint(String s){
        int res=0;
        for (int i = 0; i < s.length(); i++) {
            res*=10;
            res+=s.charAt(i)-'0';
        }
        return res;
    }
    public static String inttostring(int num){
        StringBuffer s=new StringBuffer();
        if (num==0) return "0";
        while (num>0){
            s.append((char)(num%10+'0'));
            num/=10;
        }
        StringBuffer res=new StringBuffer();
        for (int i = s.length()-1; i >=0 ; i--) {
            res.append(s.charAt(i));
        }
        return new String(res);
    }

    /**
     * 字符串：LeetCode5、20、43、93
     * 93  复原 IP 地址
     * https://leetcode.cn/problems/restore-ip-addresses/
     * @param s
     * @return
     */
    public  List<String> restoreIpAddresses(String s) {
        List<String> res=new ArrayList<>();
        String tmp =new String();
        if(s.length()>12) return res;
        int num_duan=0;
        int index=0;
        huisu_ip(res,tmp,num_duan,index,s);
        TreeSet<String> set=new TreeSet<>();
        List<String> stringLi=new ArrayList<>();
        for (int i = 0; i < res.size(); i++) {
            if(set.contains(res.get(i))){
                continue;
            }else{
                set.add(res.get(i));
                stringLi.add(res.get(i));
            }
        }
        return stringLi;

    }

    private static void huisu_ip(List<String> res, String tmp, int numDuan, int index,String s) {
        if(numDuan==4){
            res.add(new String(tmp));
            tmp=new String();
            return ;
        }
        for (int i = index; i <s.length() ; i++) {
            String sub=s.substring(index,i+1);
            if(numDuan==3){
                sub=s.substring(index,s.length());
            }
            if(ip_isLegal(sub)){
                int l=0;
                if(tmp.length()!=0){
                    tmp+=".";
                    l=sub.length()+1;
                }else{
                    l=sub.length();
                }

                tmp+=sub;
                huisu_ip(res, tmp, numDuan+1, i+1, s);
                tmp=tmp.substring(0,tmp.length()-l);

            }else{
                break;
            }
        }
    }

    private static boolean ip_isLegal(String s) {
        int sum=0;
        if(s.length()>1&&s.charAt(0)=='0'){
            return false;
        }
        for (int i = 0; i <s.length(); i++) {
            sum*=10;
            sum+=(int)(s.charAt(i)-'0');
        }
        if(sum<=255){
            return true;
        }
        return false;
    }

//    public static void main(String[] args) {
//        leetcode l=new leetcode();
//        List<String > res=l.restoreIpAddresses("25525511135");
//        for (int i = 0; i < res.size(); i++) {
//            System.out.println(res.get(i));
//        }
//    }

    /**
     * https://leetcode.cn/problems/search-in-rotated-sorted-array/
     *二分查找：LeetCode33、34
     * 33
     * @param nums
     * @param target
     * @return
     */

    public static int search(int[] nums, int target) {
        int n=nums.length;
        if(n==1){
            return nums[0]==target? 0:-1;
        }
        if(n==2){
            if(nums[0]==target||nums[1]==target){
                if(nums[0]==target) return 0;
                return 1;
            }
            return -1;
        }
        int i=0,j=n-1;
        while(i<=j){
            int mid=i+(j-i)/2;
            //case1 左边有序，那么右边有可能有序
            if(nums[i]<=nums[mid]){
                //
                if (target==nums[mid]){
                    return mid;
                }
                //目标值在这个区间
                if(target<nums[mid]&&target>=nums[i]){
                    j=mid-1;
                }
                //目标值不在这个区间
                else{
                    i=mid+1;
                }
            }else{
                //
                if (target==nums[mid]){
                    return mid;
                }
                //目标值在这个区间
                if(target<=nums[j]&&target>nums[mid]){
                    i=mid+1;
                }
                //目标值不在这个区间
                else{
                    j=mid-1;
                }
            }
        }
        return -1;

    }


    /**
     * https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/
     * 二分查找：LeetCode33、34
     * 34
     */
    public int[] searchRange(int[] nums, int target) {

        int left = bsearch(nums, target, true);
        int right = bsearch(nums, target, false) - 1;
        if (left <= right && right <= nums.length - 1 && nums[left] == target && nums[right] == target) {
            return new int[]{left, right};
        } else {
            return new int[]{-1, -1};
        }
    }

    private int bsearch(int[] nums, int target, boolean flag) {
        int i=0,j=nums.length-1;
        int ans=j;
        while(i<=j){
            int mid=i+(j-i)/2;
            if(nums[mid]>target||(flag&&nums[mid]>=target)){
                j=mid-1;
                ans=mid;
            }else{
                i=mid+1;
            }
        }
        return ans;

    }


    /**
     * BFS：LeetCode127、139、130、529、815
     *
     *
     * @param args
     */

    /**
     *
     * DFS&回溯：：LeetCode934、685、1102、531、533、113、332、337
     * https://leetcode.cn/problems/path-sum-ii/
     * 113. 路径总和 II
     * @param root
     * @param targetSum
     * @return
     */
    public List<List<Integer>> pathSum_(TreeNode root, int targetSum) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> tmp=new ArrayList<>();
        int sum=0;
        huisu_1(res,tmp,root,targetSum,sum);
        return res;
    }

    private void huisu_1(List<List<Integer>> res, List<Integer> tmp, TreeNode root, int targetSum, int sum) {
        if(root==null){
            return;
        }
        if(sum+root.val==targetSum&&root.left==null&&root.right==null){
            tmp.add(root.val);
            res.add(new ArrayList<>(tmp));
            tmp.remove(tmp.size()-1);

            return ;
        }
        //有负数！！！
        // if(sum+root.val>targetSum){
        //     return;
        // }
        tmp.add(root.val);
        sum+=root.val;
        if(root.left!=null){
            huisu_1(res, tmp, root.left, targetSum, sum);
        }

        if(root.right!=null){
            huisu_1(res, tmp, root.right, targetSum, sum);
        }
        sum-=root.val;
        tmp.remove(tmp.size()-1);

    }

    /**
     * 62是他的简化版。不做了
     *动态规划：LeetCode213、123、62、63、361、1230
     *63
     * https://leetcode.cn/problems/unique-paths-ii/
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        int dp[][] = new int[m][n];

        for(int i=0;i<m&&obstacleGrid[i][0]==0;i++){
            dp[i][0]=1;
        }
        for(int j=0;j<n&&obstacleGrid[0][j]==0;j++){
            dp[0][j]=1;

        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(obstacleGrid[i][j]==1) continue;
                dp[i][j]=dp[i][j-1]+dp[i-1][j];

            }
        }

        return dp[m-1][n-1];


    }



    /**
     * 动态规划：LeetCode213、123、62、63、361、1230
     * 123. 买卖股票的最佳时机 III
     * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-iii/
     * @param prices
     * @return
     *
     * 下面这个方法有bug
     * [1,2,4,2,5,7,2,4,9,0]这中就过不了
     * 所以贪心不行
     */
    public static int maxProfit_3(int[] prices) {
        int []maxnums=new int[2];
        int pre=prices[0];
        int begin=pre;
        for (int i  = 1; i <prices.length ; i++) {
            if(pre>prices[i]){
                int tmp=pre-begin;
                if(tmp>Math.min(maxnums[0],maxnums[1])){
                    int t=Math.min(maxnums[0],maxnums[1]);
                    if(t==maxnums[0]){
                        maxnums[0]=tmp;
                    }else {
                        maxnums[1]=tmp;
                    }
                }

                begin=prices[i];
            }
            pre=prices[i];
        }
        if(pre-begin>Math.min(maxnums[0],maxnums[1])){
            int t=Math.min(maxnums[0],maxnums[1]);
            if(t==maxnums[0]){
                maxnums[0]=pre-begin;
            }else {
                maxnums[1]=pre-begin;
            }
        }
        return maxnums[0]+maxnums[1];
    }
    /**
     * 动态规划：LeetCode213、123、62、63、361、1230
     * 123. 买卖股票的最佳时机 III
     * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-iii/
     * @param prices
     * @return
     *
     * 下面这个方法是官方题解
     * 用动态规划
     */
    public int maxProfit_2(int[] prices) {
        int n = prices.length;
        int buy1 = -prices[0], sell1 = 0;
        int buy2 = -prices[0], sell2 = 0;
        for (int i = 1; i < n; ++i) {
            buy1 = Math.max(buy1, -prices[i]);
            sell1 = Math.max(sell1, buy1 + prices[i]);
            buy2 = Math.max(buy2, sell1 - prices[i]);
            sell2 = Math.max(sell2, buy2 + prices[i]);
        }
        return sell2;
    }
    /**
     * 动态规划：LeetCode213、123、62、63、361、1230
     * 213. 打家劫舍 II
     * https://leetcode.cn/problems/house-robber-ii/
     * @param nums
     * @return
     *
     * 用动态规划
     */
    public int rob(int[] nums) {
        /**
         * 思路，偷了第一家，就不能偷最后一家，同理，偷了最后一家，就不能偷取第1家
         * 那我就分成两个来求，偷第一家即[0,n-2]
         * 偷最后一家 [1,n-1]
         * 边界问题，只有一家，偷他！
         * 有两家，偷个贵的！
         */
        int n=nums.length;
        if(n==1) return nums[0];
        if(n==2)return Math.max(nums[1],nums[0]);
        return Math.max(subrob(nums,0,n-2),subrob(nums,1,n-1));
    }

    private int subrob(int[] nums, int i, int i1) {
        int first=nums[i];
        int second=Math.max(nums[i], nums[i + 1]);
        for (int j = i+2; j <=i1 ; j++) {
            int tmp=second;
            second=Math.max(first+nums[j],second);
            first=tmp;
        }
        return second;
    }


    /**
     *
     *贪心算法：LeetCode55、435、621、452
     *55
     * 55. 跳跃游戏
     * @param args
     */
    public static boolean canJump(int[] nums) {

        int now_max=nums[0];
        // if(nums.length==1){
        //     return true;
        // }
        for (int i = 1; i <nums.length ; i++) {
            now_max--;
            if(now_max<0){
                return false;
            }
            now_max=now_max>nums[i]?now_max:nums[i];
            if(now_max>=nums.length-1){
                return true;
            }

        }
        return true;

    }


    /**
     *
     *贪心算法：LeetCode55、435、621、452
     *435. 无重叠区间
     * https://leetcode.cn/problems/non-overlapping-intervals/
     * @param
     */
    public static int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> o1[0]==o2[0]?o1[1]-o2[1]:o1[0]-o2[0]);
        int res=0;
        int end=intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if(end>intervals[i][0]){
                res++;
                end=Math.min(intervals[i][1],end);
            }else{
                end=intervals[i][1];
            }
        }
        return res;

    }


    /**
     *
     *贪心算法：LeetCode55、435、621、452
     *452. 用最少数量的箭引爆气球
     * https://leetcode.cn/problems/minimum-number-of-arrows-to-burst-balloons/
     * @param
     */
    public static  int findMinArrowShots(int[][] points) {
        //注意这里不能用减法，因为这里有个数可以溢出
        Arrays.sort(points, (o1, o2) -> Integer.compare(o1[0], o2[0]));
        int res=1;
        int end=points[0][1];
        for (int i = 1; i < points.length; i++) {
            if(end>=points[i][0]){
                end=Math.min(end,points[i][1]);
            }else {
                res++;
                end=points[i][1];
            }
        }
        return res;
    }

    /**
     *
     *贪心算法：LeetCode55、435、621、452
     *621. 任务调度器
     * https://leetcode.cn/problems/task-scheduler/
     * @param
     */
    public int leastInterval(char[] tasks, int n) {
        int[] sorts=new int[26];
        for (int i = 0; i < tasks.length; i++) {
            sorts[tasks[i]-'A']++;
        }
        Arrays.sort(sorts);
        int maxlength=sorts[25];
        //把顺序弄成AXXXAXXXA
        //x代表随便别的任务
        int retlength=(maxlength-1)*(n+1)+1;
        //这边是处理与A一样长的任务，与A一样=长，在每次循环中占据一个X，最终还会剩下一个任务，所以要把结果+1
        for (int i = 24; i >=0 ; i--) {
            if(sorts[i]==maxlength){
                retlength++;
            }else{
                break;
            }
        }
        //排序完了，如果还有任务，就随便找地方插进去就行了，也就是说，如果我算的处理时间要小于任务长度，说明我插完之后还有任务剩余，因为
        //我是按照从大到小的顺序插入的，所以随便找地方插入就行，不用担心间隔问题
        return Math.max(retlength,tasks.length);

    }


    /**
     *
     * https://leetcode.cn/problems/robot-bounded-in-circle/
     * @param instructions
     * @return
     */
    public boolean isRobotBounded(String instructions) {
        int weizhi[]=new int[]{0,0};
        if(instructions.length()==1&&instructions.charAt(0)=='G') return false;
        char[] fangxiang=new char[]{'u','r','d','l'};
        int now=0;
        int t=10;
        while(t>0){
            for (int i = 0; i < instructions.length(); i++) {
                char c=instructions.charAt(i);
                if(c=='R'){
                    now=(now+1)%4;
                }else if(c=='L'){
                    if(now==0)now=3;
                    else{
                        now=(now-1)%4;
                    }

                } else if (c=='G') {
                    if(now==0){
                        weizhi[1]++;
                    } else if (now==1) {
                        weizhi[0]++;
                    } else if (now==2) {
                        weizhi[1]--;
                    }else {
                        weizhi[0]--;
                    }
                }
            }
            if(weizhi[0]==0&weizhi[1]==0){
                return true;
            }
            t--;
        }

        return false;

    }

    public static void main(String[] args) {
       leetcode l=new leetcode();
       l.isRobotBounded("LLGRL");
    }

//    public static void main(String[] args) {
////        dailyTemperatures(new int[]{35,56,56,53,43,88,40,82,55,43,35,43,41,75,91,83,60,94,44,50,42,51,63,88,45,70,42,77,47,51,70,69,89,41,50,81,46,54,99,54,44,76,44,34,37,83,35,96,58,75,99,70,32,81,75,77,81,91,60,51,54,62,99,54,62,88,45,87,96,62,63,98,37,54,100,69,58,95,37,53,56,91,35,97,80,72,37,43,35,75,90,79,35,42,68,44,82,74,77,92});
////    int[] t=nextGreaterElements(new int[]{1,2,1});
////        int res=longestOnes(new int[]{1,1,1,0,0,0,1,1,1,1,0},2);
////        int res=subarraySum(new int[]{1,1,1},2);
////        carPooling(new int[][]{{3,3,7},{2,1,5}},4);
////        String r=multiply("123","456");
////        int t=search(new int[]{4,5,6,7,0,1,2},0);
////        canJump(new int[]{3,2,1,0,4});
////        eraseOverlapIntervals(new int[][]{{-52,31},{-73,-26},{82,97},{-65,-11},{-62,-49},{95,99},{58,95},{-31,49},{66,98},{-63,2},{30,47},{-40,-26}});
////          findMinArrowShots(new int[][]{{-2147483646,-2147483645},{2147483646,2147483647}});
//        maxProfit_3(new int[]{1,2,4,2,5,7,2,4,9,0});
////        System.out.println(t);
//
//    }

}

class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
 }

