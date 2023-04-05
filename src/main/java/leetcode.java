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




    public static void main(String[] args) {
//        dailyTemperatures(new int[]{35,56,56,53,43,88,40,82,55,43,35,43,41,75,91,83,60,94,44,50,42,51,63,88,45,70,42,77,47,51,70,69,89,41,50,81,46,54,99,54,44,76,44,34,37,83,35,96,58,75,99,70,32,81,75,77,81,91,60,51,54,62,99,54,62,88,45,87,96,62,63,98,37,54,100,69,58,95,37,53,56,91,35,97,80,72,37,43,35,75,90,79,35,42,68,44,82,74,77,92});
    int[] t=nextGreaterElements(new int[]{1,2,1});
    }

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

