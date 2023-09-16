import java.sql.SQLOutput;
import java.util.*;

public class Days_question {
    public static void main(String[] args) {

//        Days_question sss=new Days_question();
//        sss.countAndSay();

//        int n=2,m=2,k=2;
//        //第一个矩阵的列数以及第二个矩阵的行数
//        int Maze[][]=new int[][]{{2,1},{1,1}};
//        int Maze1[][]=new int[][]{{2,1},{1,1}};
//        int Maze2[][]=new int[][]{{2,1},{1,1}};
//
//        for(int i=0;i<n;i++)
//        {
//            for(int u=0;u<k;u++)
//            {
//                for(int j=0;j<m;j++)
//                {
//
//                    Maze2[i][u]+=Maze[i][j]*Maze1[j][u];
//                }
//            }
//        }
//
//        for(int i=0;i<n;i++)//将第三个矩阵输出出来
//        {
//            for(int j=0;j<k;j++)
//            {
//                System.out.print(Maze2[i][j]+" ");
//
//            }
//            System.out.println();
//        }



//        Solution1 solution1=new Solution1();
//        ListNode head=new ListNode(1);
//        ListNode q=new ListNode(2);
//        ListNode w=new ListNode(3);
//        ListNode e=new ListNode(4);
//        head.next=q;
//        q.next=w;
//        w.next=e;
//[]
//[]
//        System.out.println(solution1.vowelStrings(new String[]{"aba","bcb","ece","aa","e"},new int[][]{{0,2},{1,4},{1,1}}
//                ));
    }
}
class  Solution1 {
    public static  int thisis=0;
    public static void main(String[] args) {
        String a="abc";
        String c="abc";

        String b=new String("abc");
        System.out.println(c==a);
        System.out.println(a==b);
//        ListNode head=new ListNode(1);
//        ListNode q=new ListNode(4);
//        ListNode w=new ListNode(3);
//        ListNode e=new ListNode(2);
//        ListNode r=new ListNode(5);
//        ListNode t=new ListNode(2);
//        head.next=q;
//        q.next=w;
//        w.next=e;
//        e.next=r;
//        r.next=t;
//        Solution1.partition(head,3);

        //Solution1.addStrings("11","123");
    }
    public static String addStrings(String num1, String num2) {
        Stack<Character> stack=new Stack<>();
        int i=num1.length()-1,j=num2.length()-1;
        int jinwei=0;
        while(i>=0&&j>=0){
            int tmp=jinwei+num1.charAt(i--)+num2.charAt(j--)-2*'0';
            if(tmp>9){
                jinwei=1;
                tmp-=10;
            }else{
                jinwei=0;
            }
            stack.push((Character.valueOf((char)tmp)));
        }
        while (i>=0){
            int tmp=jinwei+num1.charAt(i--)-'0';
            if(tmp>9){
                jinwei=1;
                tmp-=10;
            }else{
                jinwei=0;
            }
            stack.push((Character.valueOf((char)tmp)));
        }
        while (j>=0){
            int tmp=jinwei+num2.charAt(j--)-'0';
            if(tmp>9){
                jinwei=1;
                tmp-=10;
            }else {
                jinwei=0;
            }
            stack.push((Character.valueOf((char)tmp)));
        }
        char[] res=new char[stack.size()];
        i=0;
        while(!stack.isEmpty()) {
            res[i++]= stack.pop();

        }
        return new String(res);
    }
    public long maxAlternatingSum(int[] nums) {
        int n=nums.length;
        int[] tmp = new int[nums.length + 2];
        tmp[0]=0;
        tmp[nums.length+1]=0;
        boolean plus = true;
        long res = 0;
        System.arraycopy(nums, 0, tmp, 1, n);
        for (int i = 1; i <=nums.length ; i++) {
            if (plus) {
                if (tmp[i-1] <= tmp[i] && tmp[i] > tmp[i+1]) {
                    res += tmp[i];
                    plus = !plus;
                }
            } else {
                if (tmp[i-1] >= tmp[i] && tmp[i] < tmp[i+1]) {
                    res -= tmp[i];
                    plus = !plus;
                }
            }
        }
        return  res;

    }
    public int threeSumClosest(int[] nums, int target) {

        int res=target;
        int min=Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-2; i++) {
            int l=i+1,r=nums.length-1;
            while(l<r){
                int sum=nums[i]+nums[l]+nums[r];
                if(Math.abs(sum-target)<min){
                    min=Math.abs(sum-target);
                    res=sum;
                }
                if(sum>target){
                    r--;
                }
                else if(sum<target) {
                    l++;
                }else{
                    return target;
                }
            }
        }

        return res;
    }

    public static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> res=new ArrayList<>();
        Arrays.sort(nums);
        HashSet<String> set=new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
             int target=-nums[i];
             int  f=0;
            for (int start = 0, end = nums.length-1; start<end;) {
                int sum=nums[start]+nums[end];
                if(sum==target){
                    if(start!=i&&end!=i){
                        int []tep=new int[]{-target,nums[start],nums[end]};
                        Arrays.sort(tep);
                        String S=String.valueOf(tep[0])+" "+String.valueOf(tep[1])+" "+String.valueOf(tep[2]);
                        if(!set.contains(S)){
                            set.add(S);
                            res.add(Arrays.asList(tep[0],tep[1],tep[2]));
                        }

                    }
                    f=0;
                    start++;
                    end--;
                }
                else if(sum>target){
                    if(f==2){
                        break;
                    }
                    end--;
                    f=1;
                }
                else {
                    if(f==1){
                        break;
                    }
                    f=2;
                    start++;
                }
            }
        }

        return res;

    }

    public static ListNode partition(ListNode head, int x) {

        if(head==null||head.next==null)
            return head;
        ListNode small = new ListNode(0);
        ListNode smallHead = small;
        ListNode large = new ListNode(0);
        ListNode largeHead = large;
        while (head != null) {
            if (head.val < x) {
                small.next = head;
                small = small.next;
            } else {
                large.next = head;
                large = large.next;
            }
            head = head.next;
        }
        large.next = null;
        small.next = largeHead.next;
        return smallHead.next;
    }

        /**
         * https://leetcode.cn/problems/count-and-say/
         */
        public static String countAndSay(int n) {
            StringBuffer pre=new StringBuffer("1");
            StringBuffer now=new StringBuffer();
            if(n==1){
                return pre.toString();
            }
            for (int i = 1; i <n ; i++) {
                char c=pre.charAt(0);
                int num=1;
                for (int j = 1; j < pre.length(); j++) {
                    if(c==pre.charAt(j)){
                        num++;
                    }
                    else{
                        now.append(num);
                        now.append(c);
                        c=pre.charAt(j);
                        num=1;

                    }
                }
                now.append(num);
                now.append(c);
                pre=now;
                System.out.println(i+":"+pre.toString());
                now=new StringBuffer();
            }

            return pre.toString();




        }




    /**
     * https://leetcode.cn/problems/number-of-distinct-averages/
     * @param nums
     * @return
     */

    public int distinctAverages(int[] nums) {
        int res=0;
        HashSet<Double> set=new HashSet<>();
        int length=nums.length;
        if(length==2){
            return 1;
        }
        Arrays.sort(nums);
        int begin=0,end=length-1;
        while (begin<end){
            double sum=nums[begin]+nums[end];

            set.add(sum/2*1.0);
            begin++;
            end--;

        }
        return set.size();


    }


    /**
     * https://leetcode.cn/problems/count-vowel-strings-in-ranges/
     * @param words
     * @param queries
     * @return
     */
        public int[] vowelStrings(String[] words, int[][] queries) {
            int n= words.length;
            int [] nums=new int[n+1];
            int []res=new int[queries.length];
            nums[0]=0;
            Set<Character> set=new HashSet<>();
            set.add('a');
            set.add('e');
            set.add('i');
            set.add('o');
            set.add('u');
            for (int i = 0; i < n; i++) {
                if(set.contains(words[i].charAt(0))&&set.contains(words[i].charAt(words[i].length()-1))){
                    nums[i+1]=nums[i]+1;
                }
                else{
                    nums[i+1]=nums[i];
                }
            }
            for (int i = 0; i < queries.length; i++) {
                int begin=queries[i][0];
                int end= Math.min(n,queries[i][1]);
//                if(begin==end){
//                    res[i]=nums[]
//                }
                res[i]=nums[end+1]-nums[begin];
            }
            return res;
        }
        /**
         * https://leetcode.cn/problems/minimum-cost-tree-from-leaf-values/
         */
        public int mctFromLeafValues(int[] arr) {
            int n=arr.length;
            if(n<=2){
                if(n==2){
                    return arr[0]+arr[1];
                }
                return 0;
            }
            int [][]dp=new int[n][n];
            for (int i = 0; i < n; i++) {
                Arrays.fill(dp[i],Integer.MAX_VALUE);
            }
            int[][]mval=new int[n][n];
            for (int i = 0; i < n; i++) {
                mval[i][i]=arr[i];
                dp[i][i]=0;
                for (int j = i-1; j >=0 ; j--) {
                    mval[j][i]=Math.max(arr[j],mval[j+1][i]);
                    for (int k = j; k < i; k++) {
                        dp[j][i]=Math.min(dp[j][i],dp[j][k]+dp[k+1][i]+mval[j][k]*mval[k+1][i]);
                    }
                }
            }
            return dp[0][n-1];
        }


    /**
     * https://leetcode.cn/problems/odd-string-difference/
     * @param words
     * @return
     */
        public String oddString(String[] words) {
            int[] diff0 = get(words[0]);
            int[] diff1 = get(words[1]);
            if (Arrays.equals(diff0, diff1)) {
                for (int i = 2; i < words.length; i++) {
                    if (!Arrays.equals(diff0, get(words[i]))) {
                        return words[i];
                    }
                }
            }
            return Arrays.equals(diff0, get(words[2])) ? words[1] : words[0];
        }

        public int[] get(String word) {
            int[] diff = new int[word.length() - 1];
            for (int i = 0; i + 1 < word.length(); i++) {
                diff[i] = word.charAt(i + 1) - word.charAt(i);
            }
            return diff;
        }


    public boolean haveConflict(String[] event1, String[] event2) {
        int e1_begin=0;
        int e1_end=0;
        int e2_begin=0;
        int e2_end=0;
        e1_begin+=Integer.valueOf(event1[0].split(":")[0])*60+Integer.valueOf(event1[0].split(":")[1]);
        e1_end+=Integer.valueOf(event1[1].split(":")[0])*60+Integer.valueOf(event1[1].split(":")[1]);
        e2_begin+=Integer.valueOf(event2[0].split(":")[0])*60+Integer.valueOf(event2[0].split(":")[1]);
        e2_end+=Integer.valueOf(event2[1].split(":")[0])*60+Integer.valueOf(event2[1].split(":")[1]);
        if(e1_end<e2_begin||e1_begin>e2_end||(e1_begin<e2_begin&&e2_end<e1_end)||(e2_begin<e1_begin&&e1_end<e2_end)){
            return  false;
        }
        return true;


    }

    /**
     * https://leetcode.cn/problems/dota2-senate/?envType=study-plan-v2&id=leetcode-75
     * @param senate
     * @return
     */
    public String predictPartyVictory(String senate) {
        boolean R=true;
        boolean D=true;
        int f=0;

        char[] s=senate.toCharArray();
        while(R&&D){
            R=false;
            D=false;
            for (int i=0;i<senate.length();i++) {
                char c=s[i];
                if(c=='R'){
                   R=true;
                   if(f<0){
                       s[i]='0';
                   }
                   f++;
                }else if(c=='D'){
                    D=true;
                    if(f>0){
                        s[i]='0';
                    }
                    f--;
                }
            }
        }

        if(f>0){
            return "Radiant";
        }
        return "Dire";
    }

    /**
     * https://leetcode.cn/problems/brick-wall/
     * @param wall
     * @return
     */
    public int leastBricks(List<List<Integer>> wall) {
        int res=0;
        HashMap<Integer,Integer> cnt=new HashMap<>();
        for (List<Integer> list:wall) {
            int n=list.size();
            int sum=0;
            for (int i = 0; i < n - 1; i++) {
                sum+=list.get(i);
                cnt.put(sum,cnt.getOrDefault(sum,0)+1);
            }

        }
        for(Map.Entry<Integer,Integer>entry: cnt.entrySet()){
            res=Math.max(res,entry.getValue());
        }
        List<HashSet<Integer>> list=new ArrayList<>();

        return wall.size()-res;
    }

    /**
     * https://leetcode.cn/problems/pairs-of-songs-with-total-durations-divisible-by-60/
     * @return
     */

    public int numPairsDivisibleBy60() {
        int [] time =new int[]{60,120,150};
        long res=0;
        int []cnt=new int[60];
        for (int t:time) {
            cnt[t%60]++;
        }
        for (int i = 1; i < 30; i++) {
            res+=cnt[i]*cnt[60-i];
        }
        res += (long) cnt[0] * (cnt[0] - 1) / 2 + (long) cnt[30] * (cnt[30] - 1) / 2;
        return (int )res;
    }

    public int minNumberOfFrogs(String croakOfFrogs) {
        int length=croakOfFrogs.length();
        if(length%5!=0){
            return -1;
        }
        int[] cnt = new int[128];
        int res=0;
        for (int i = 0; i < length; i++) {
            char c=croakOfFrogs.charAt(i);
            cnt[c]++;
            if(c=='c'){
                    if(cnt['k']>0) {
                        cnt['k']--;
                    }

            }else if(c=='r'){
                    if(cnt['c']==0){
                        return -1;
                    }
                    cnt['c']--;

            } else if (c=='o') {
                if(cnt['r']==0){
                    return -1;
                }
                cnt['r']--;

            }else if(c=='a'){
                if(cnt['o']==0){
                    return -1;
                }
                cnt['o']--;

            } else if (c=='k') {
                if(cnt['a']==0){
                    return -1;
                }
                cnt['a']--;
            }


        }
        res=cnt['c']+cnt['r']+cnt['o']+cnt['a'];
        return res>0?-1:cnt['k'];

    }

    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> set=new HashSet<>();
        int value1=1;
        for (int i = 0; i < 21; i++) {
            int value2=1;
            for (int j = 0; j < 21; j++) {
                int value=value1+value2;
                if(bound>=value){
                    set.add(value);
                }else{
                    break;
                }
                value2*=y;
            }
            if(value1>bound){
                break;
            }
            value1*=x;
        }
        return new ArrayList<Integer>(set);
    }


    /**
     * https://leetcode.cn/problems/maximum-fruits-harvested-after-at-most-k-steps/
     * @param fruits
     * @param startPos
     * @param k
     * @return
     */
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int length=fruits.length;
        int[]sum=new int[length+1];
        int[] indices = new int[length];
        indices[0]=fruits[0][0];
        for (int i = 0; i < fruits.length; i++) {
                sum[i+1]=sum[i]+fruits[i][1];
                indices[i]=fruits[i][0];
        }
        int res=0;
        for (int i = 0; i <=k/2; i++) {
           int y=k-2*i;
           int left=startPos-i;
           int right=startPos+y;
           int start_index=lowerbound(indices,0,length-1,left);
           int end_index=uperbound(indices,0,length-1,right);
            res=Math.max(sum[end_index]-sum[start_index],res);

            int x=k-2*i;
            left=startPos-x;
            right=startPos+i;
            start_index=lowerbound(indices,0,length-1,left);
            end_index=uperbound(indices,0,length-1,right);
            res=Math.max(sum[end_index]-sum[start_index],res);

        }
        return res;

    }

    private int lowerbound(int[] indices, int left, int right, int val) {
        int res=right+1;
        while (left<=right){
            int mid=left+(right-left)/2;
            if(indices[mid]>=val){
                res=mid;
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return res;
    }

    private int uperbound(int[] indices, int left, int right, int val) {
        int res=right+1;
        while (left<=right){
            int mid=left+(right-left)/2;
            if(indices[mid]>val){
                res=mid;
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return res;
    }

    public String lastSubstring(String s) {

        int index=0;
        for(int i=1,k=0;i+k<s.length();){
            int d=s.charAt(index+k)-s.charAt(i+k);
            if(d==0){
                k++;
            }else if(d<0){
                index+=k+1;
                k=0;
                if(index>=i){
                    i=index+1;
                }
            }else{
                i+=k+1;
                k=0;
            }
        }
        return s.substring(index,s.length());
    }

    /**
     * https://leetcode.cn/problems/maximum-level-sum-of-a-binary-tree/?envType=study-plan-v2&id=leetcode-75
     * @param root
     * @return
     */
    public int maxLevelSum(TreeNode root) {
        if(root.left==null&&root.right==null){
            return 1;
        }
        int max_index=1;
        int max=root.val;
        LinkedList<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        int ceng=0;
        while (!queue.isEmpty()){
            int sum=0;
            ceng++;
            int size=queue.size();
            int i=0;
            while(i<size){
                TreeNode t=queue.removeFirst();
                sum+=t.val;
                if(t.left!=null){
                    queue.add(t.left);
                }
                if(t.right!=null){
                    queue.add(t.right);
                }
                i++;
            }
            if(sum>max){
                max=sum;
                max_index=ceng;
            }
        }
        return max_index;

    }

    public int goodNodes(TreeNode root) {
        if(root==null) return 0;
        List<Integer> res;
        int now_max= Integer.MIN_VALUE;
        int []nums=new int[]{0};
        huisu_tree(nums,now_max,root);
        return nums[0];
    }

    private void huisu_tree(int[] nums, int nowMax, TreeNode root) {
        if(root==null){
            return;
        }
        if (root.val >= nowMax) {
                nums[0]++;
                nowMax= root.val;
        }
        huisu_tree(nums, nowMax, root.left);
        huisu_tree(nums, nowMax, root.right);
    }

    public int pairSum(ListNode head) {
        Stack<Integer> stack=new Stack<>();
        ListNode cur=head;
        int n=0;
        while(cur!=null){
            stack.push(cur.val);
            cur=cur.next;
            n++;
        }
        cur=head;
        int res=Integer.MIN_VALUE;
        int i=0;
        while(cur!=null&&i<=n/2){
            res=Math.max(res, cur.val+stack.pop());
            cur=cur.next;
            i++;
        }
        return res;
    }
    /**
     *
     * @param head
     * @return
     */
    public ListNode oddEvenList(ListNode head) {
        if(head==null) return head;
        if(head.next==null) return head;
        if(head.next.next==null) return head;
        ListNode cur=head.next.next;
        ListNode ji=head;
        ListNode oddhead=head.next;
        ListNode odd=oddhead;
        int f=0;
        while(cur!=null){
            if(f==0){
                ji.next=cur;
                ji=cur;
                f=1;
            }else{
                odd.next=cur;
                odd=cur;
                f=0;
            }
            cur=cur.next;

        }
        ji.next=oddhead;
        odd.next=null;
        return head;
    }
    /**
     *https://leetcode.cn/problems/asteroid-collision/?envType=study-plan-v2&id=leetcode-75
     */
    public int[] asteroidCollision(int[] asteroids) {
        LinkedList<Integer> res=new LinkedList<>();
        int n=asteroids.length;

        for (int i = 0; i < n; i++) {
            if(asteroids[i]>0){
                res.add(asteroids[i]);
            }else{
                if(res.size()==0||res.getLast()<0){
                    res.add(asteroids[i]);
                }
                else if(res.getLast()==Math.abs(asteroids[i])){
                        res.removeLast();
                }
                else if(res.getLast()<Math.abs(asteroids[i])){
                    while(res.size()>0&&res.getLast()>0&&res.getLast()<Math.abs(asteroids[i])){
                        res.removeLast();
                    }
                    if(res.size()>0&&res.getLast()==Math.abs(asteroids[i])){
                        res.removeLast();
                    }
                    else if(res.size()==0||(res.getLast()<0)){
                        res.add(asteroids[i]);
                    }
                }

            }
        }
        if(res.size()==0) return new int[0];
        else{
            int[] r=new int[res.size()];
            for (int i = 0; i < res.size(); i++) {
                r[i]=res.get(i);
            }
            return r;
        }
    }
    /**
     * https://leetcode.cn/problems/removing-stars-from-a-string/?envType=study-plan-v2&id=leetcode-75
     * @param s
     * @return
     */
    public String removeStars(String s) {
        LinkedList<Character> res=new LinkedList<>();
        int need=0;
        for (int i = 0; i <s.length() ; i++) {
            char c=s.charAt(i);
            if(c=='*'){
                if(res.size()==0){
                    need++;
                } else {
                    need++;
                    while(need>0){
                        if(res.size()>0){
                            res.removeLast();
                            need--;
                        }else break;
                    }
                }
            }else{
                res.add(c);
            }
        }
        if(res.size()==0) return "";
        else {StringBuffer stringBuffer=new StringBuffer();
            for (int i = 0; i <res.size() ; i++) {
                stringBuffer.append(res.get(i));
            }
            return stringBuffer.toString();
        }
    }
    /**
     * https://leetcode.cn/problems/equal-row-and-column-pairs/?envType=study-plan-v2&id=leetcode-75
     * @param grid
     * @return
     */
    public int equalPairs(int[][] grid) {
        int n=grid.length;
        if(n==1) return 1;
        Map<String,Integer> map=new HashMap<>();
        //放进所有行
        for (int i = 0; i < n; i++) {
            StringBuffer s=new StringBuffer();
            for (int j = 0; j < n; j++) {
                s.append(String.valueOf(grid[i][j])+",");
            }
            map.put(s.toString(),map.getOrDefault(s.toString(),0)+1);
        }
        int res=0;
        //开始检查列
        for (int i = 0; i < n; i++) {
            StringBuffer s=new StringBuffer();
            for (int j = 0; j < n; j++) {
                s.append(String.valueOf(grid[j][i])+",");
            }
            if(map.containsKey(s.toString())){
                res+=map.get(s.toString());
            }
        }
        return res;

    }

    /**
     * https://leetcode.cn/problems/determine-if-two-strings-are-close/?envType=study-plan-v2&id=leetcode-75
     * @param word1
     * @param word2
     * @return
     */
    public boolean closeStrings(String word1, String word2) {
        if(word1.length()!=word2.length()) return false;
        Map<Character,Integer> map= new HashMap<>();
        Map<Character,Integer> map1= new HashMap<>();
        int nums=0;
        for (int i = 0; i < word1.length(); i++) {
            if(!map.containsKey(word1.charAt(i))){
                map.put(word1.charAt(i),1);
                nums++;
            }else{
                map.put(word1.charAt(i),map.get(word1.charAt(i))+1);
            }
        }
        for (int i = 0; i < word2.length(); i++) {
            if(!map1.containsKey(word2.charAt(i))){
                map1.put(word2.charAt(i),1);
                nums--;
            }else{
                map1.put(word2.charAt(i),map1.get(word2.charAt(i))+1);
            }
            if(!map.containsKey(word2.charAt(i))){
                return false;
            }
        }
        if(nums!=0) return false;

        int []num=new int[map.size()];
        int []num1=new int[map1.size()];
        Iterator  iterator=map.entrySet().iterator();
        int index=0;
        while(iterator.hasNext()){
            Map.Entry< String, Integer > entry = (Map.Entry<String, Integer>) iterator.next();
            num[index++]=entry.getValue();
        }
        Iterator  iterator1=map1.entrySet().iterator();
        index=0;
        while(iterator1.hasNext()){
            Map.Entry< String, Integer > entry = (Map.Entry<String, Integer>) iterator1.next();
            num1[index++]=entry.getValue();
        }
        Arrays.sort(num);
        Arrays.sort(num1);
        if(!Arrays.equals(num,num1)){
            return false;
        }

        return true;
    }
    /**
     * https://leetcode.cn/problems/longest-subarray-of-1s-after-deleting-one-element/?envType=study-plan-v2&id=leetcode-75
     * @param nums
     * @return
     */
    public int longestSubarray(int[] nums) {
        int n= nums.length;
        int max=0;
        int index_0=-1;
        boolean flag=false;
        int t=0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==1){
                t++;
            } else if (nums[i]==0&&flag==false) {
                flag=true;
                index_0=i;
                t++;
            }else{
                max=Math.max(max,t);
                t=i-index_0;
               index_0=i;
            }
        }
        return Math.max(max,t)-1;
    }

    public int maxVowels(String s, int k) {
        int res=0;
        Set<Character> set=new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        int n=0;
        for (int j = 0; j < k&& j<s.length(); j++) {
            if(set.contains(s.charAt(j))){
                n++;
            }
        }
        res=Math.max(n,res);
        if(k>=s.length()) return res;
        int pre_index=0;
        int index=k;
        while(index<s.length()){
            if(set.contains(s.charAt(index++))){
                n++;
            }
            if(set.contains(s.charAt(pre_index++))){
                n--;
            }
            res=Math.max(res,n);
        }
        return res;
    }

    /**
     * https://leetcode.cn/problems/max-number-of-k-sum-pairs/
     * @param nums
     * @param k
     * @return
     */
    public int maxOperations(int[] nums, int k) {
        int n= nums.length;
        Arrays.sort(nums);
        int i=0;
        int j=n-1;
        int res=0;
        while(i<j){
            if(nums[i]+nums[j]==k){
                i++;
                j--;
                res++;
            }else if(nums[i]+nums[j]>k){
                j--;
            }else{
                i++;
            }
        }
        return res;
    }

    /**
     * https://leetcode.cn/problems/string-compression/?envType=study-plan-v2&id=leetcode-75
     * @param chars
     * @return
     */
    public int compress(char[] chars) {
        int res=0;
        int n=chars.length;
        if(n==0||n==1) return n;
        char pre=chars[0];
        int pre_index=0;
        int t=1;
        for (int i = 1 ; i < n; i++) {
            if(pre==chars[i]){
                t++;
            }else{
                chars[pre_index++]=pre;

                if(t==1){
                    res+=1;
                }else{
                    String s=Integer.valueOf(t).toString();
                    res+=s.length()+1;
                    for (int j = pre_index; j <pre_index+ s.length(); j++) {
                        chars[j]=s.charAt(j-pre_index);
                    }
                    pre_index+=s.length();
                }
                t=1;
                pre=chars[i];
            }
        }
        chars[pre_index++]=pre;
        if(t==1){
            res+=1;
        }else{
            String s=Integer.valueOf(t).toString();
            res+=s.length()+1;
            for (int j = pre_index; j < pre_index+s.length(); j++) {
                chars[j]=s.charAt(j-pre_index);
            }
            pre_index+=s.length();
        }
        return res;
    }
    /**
     * https://leetcode.cn/problems/burst-balloons/?favorite=2cktkvj
     *
     * @param nums
     * @return
     */
    public int maxCoins(int[] nums) {
        int n= nums.length;
        if(n==1) return nums[0];
        int min=Integer.MAX_VALUE;
        int min_index=-1;
        LinkedList<Integer> list=new LinkedList<>();
        for (int i = 0; i < n; i++) {

                list.add(nums[i]);

        }
        int res=0;
        while(list.size()>1){
            min=Integer.MAX_VALUE;
            for (int i = 0; i < list.size(); i++) {
                if(min>list.get(i)){
                    min=list.get(i);
                    min_index=i;
                }
            }
            if(min_index==0||min_index==list.size()-1){
                if(min_index==0){
                    res+=min*list.get(1);
                }else{
                    res+=min* list.get(min_index-1);
                }
            }else{
                res+= list.get(min_index-1)*min* list.get(min_index+1);
            }
            list.remove(min_index);
        }
        if(list.get(0)>list.get(1)){
            res+= list.get(1)*list.get(0)+ list.get(0);
        }else{
            res+= list.get(1)*list.get(0)+ list.get(1);
        }

        return res;
    }

    /**
     * https://leetcode.cn/problems/minimum-window-substring/solution/zui-xiao-fu-gai-zi-chuan-by-leetcode-solution/
     * @param s
     * @param t
     * @return
     */
    public String minWindow(String s, String t) {
        int []map=new int[128];
        for (char c : t.toCharArray()) {
            map[c]++;
        }
        int l=0,r=0,min=Integer.MAX_VALUE;
        int counter=t.length();
        int begin=0;
        while(r<s.length()){
            int num=map[s.charAt(r)];
            if(num>0){
                counter--;
            }
            map[s.charAt(r)]--;
            r++;
            while(counter==0){
                if(r-l<min){
                    min=r-l;
                    begin=l;
                }
//                map[s.charAt(l)]++;
                int tt= ++map[s.charAt(l++)];
                if(tt==1){
                    counter++;
                }
            }

        }
        return min==Integer.MAX_VALUE? "" :s.substring(begin,begin+min);
    }
    /**
     * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-cooldown/?favorite=2cktkvj
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int length=prices.length;
        if(length<=1) return 0;
        int[][] dp=new int[length][3];
        dp[0][0]=0; //代表不持有本i天的股票
        dp[0][1]=-prices[0];    //持有第i天的股票
        dp[0][2]=0; //过渡期
        for (int i = 1; i < length; i++) {
            //第i天不持有股票，前一天也不持有股票，前一天是过渡期。
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][2]);
            //第i天持有股票，
            // 1.前一天持有股票，
            // 2.今天持有股票，前一天没有股票，
            dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);
            //第i天是过渡期，
            //只有一种情况，就是昨天有股票且卖出了
            dp[i][2]=dp[i-1][1]+prices[i];

        }
        return Math.max(dp[length-1][0],dp[length-1][2]);

    }

    /**
     * https://leetcode.cn/problems/shortest-unsorted-continuous-subarray/?favorite=2cktkvj
     * @param nums
     * @return
     */
    public int findUnsortedSubarray(int[] nums) {
        int length = nums.length;
        if(length<=1) return 0;
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        int end=0;
        int begin=0;
        for (int i = 0; i < length; i++) {
            if(max>nums[i]){
                end=i;
            }
            max=Math.max(max,nums[i]);
        }
        for (int i = end; i >=0 ; i--) {
            if(min<nums[i]){
                begin=i;
            }
            min=Math.min(min,nums[i]);
        }
        return begin==end? 0:end-begin+1;


    }


    private static final int[] DAYS = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    private int calcDays(String S) {
        char[] s = S.toCharArray();
        int day = (s[3] - '0') * 10 + s[4] - '0';
        int month = (s[0] - '0') * 10 + s[1] - '0';
        for (int i = 0; i < month - 1; ++i) // 除了最后一个月份，前面的月份直接累加
            day += DAYS[i];
        return day;
    }
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int left = calcDays(arriveAlice.compareTo(arriveBob) > 0 ? arriveAlice : arriveBob); // 直接比较字符串再计算
        int right = calcDays(leaveAlice.compareTo(leaveBob) < 0 ? leaveAlice : leaveBob);
        return Math.max(right - left + 1, 0); // 答案不能为负数
    }
    public String decodeString(String s) {
        Stack<String> stack=new Stack<>();
        int pr=0;
        int num=0;
        while (pr<s.length()){
            char c=s.charAt(pr);
            if(c>='0'&&c<='9'){
                num=num*10+c-'0';
                pr++;
            }else if(Character.isLetter(c)||c=='['){
                if(c=='['){
                    stack.push(String.valueOf(num));
                    num=0;
                }
                stack.push(String.valueOf(c));
                pr++;
            }else{
                pr++;
                LinkedList<String > tmp=new LinkedList<>();
                while (!"[".equals(stack.peek())){
                    tmp.addLast(stack.pop());
                }
                Collections.reverse(tmp);
                stack.pop();
                int nums=Integer.parseInt(stack.pop());
                StringBuffer t=new StringBuffer();

                String o =getString(tmp);


                while(nums>0){
                    nums--;
                    t.append(o);
                }
                stack.push(t.toString());
            }
        }
        LinkedList<String > tmp=new LinkedList<>();
        while (!stack.isEmpty()){
            tmp.addLast(stack.pop());
        }
        Collections.reverse(tmp);
        return getString(tmp);
    }


    public String getString(LinkedList<String> v) {
        StringBuffer ret = new StringBuffer();
        for (String s : v) {
            ret.append(s);
        }
        return ret.toString();
    }

    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j]==word.charAt(0)){
                    if(word.length()==1){
                        return true;
                    }
                    if(huisu(board,i,j,word,visited,0)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean huisu(char[][] board, int i, int j, String word, boolean[][] visited, int i1) {
        if (board[i][j] != word.charAt(i1)) {
            return false;
        } else if (i1== word.length() - 1) {
            return true;
        }
        visited[i][j] = true;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        boolean result = false;
        for (int[] dir : directions) {
            int newi = i + dir[0], newj = j + dir[1];
            if (isLegal(newi,newj, board.length, board[0].length)) {
                if (!visited[newi][newj]) {
                    boolean flag = huisu (board, newi, newj, word, visited, i1+1);
                    if (flag) {
                        result = true;
                        break;
                    }
                }
            }
        }
        visited[i][j] = false;
        return result;

    }


    public boolean isLegal(int row, int column,int n,int m) {
        return row >= 0 && row < n && column >= 0 && column < m;
    }

/**
 * 这个不行，超时，还是动态规划吧
 */
//    public int minPathSum(int[][] grid) {
//        int[]min=new int[]{Integer.MAX_VALUE};
//        int row=grid.length;
//        int col= grid[0].length;
//        boolean [][] used=new boolean[row][col];
//        huisu_min(grid,used,0,0,row,col,min,0);
//        return min[0];
//    }
//
//    private void huisu_min(int[][] grid, boolean[][] used, int i, int j, int row, int col, int[] min, int now_sum) {
//         if (i== row-1&&j==col-1) {
//             if(now_sum+grid[i][j]<min[0]){
//                 min[0]=now_sum+grid[i][j];
//             }
//            return;
//        }
//        used[i][j] = true;
//         now_sum+=grid[i][j];
//        int[][] directions = {{0, 1}, {1, 0}};
//        boolean result = false;
//        for (int[] dir : directions) {
//            int newi = i + dir[0], newj = j + dir[1];
//            if (isLegal(newi,newj, row, col)) {
//                if (!used[newi][newj]) {
//                   huisu_min (grid, used,newi, newj,row,col , min, now_sum);
//                }
//            }
//        }
//        used[i][j] = false;
//        now_sum-=grid[i][j];
//
//    }

public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int row=grid.length;
        int col=grid[0].length;
        int[][]dp=new int[row][col];
        dp[0][0]=grid[0][0];
    for (int i = 1; i < row; i++) {
        dp[i][0]=dp[i-1][0]+grid[i][0];
    }
    for (int i = 1; i < col; i++) {
        dp[0][i]=dp[0][i-1]+grid[0][i];
    }

    for (int i = 1; i < row; i++) {
        for (int j = 1; j < col; j++) {
            dp[i][j]=Math.min(dp[i-1][j],dp[i][j-1])+grid[i][j];
        }
    }
    return dp[row-1][col-1];

    }
    public List<Integer> findAnagrams(String s, String p) {
        char[] pp=p.toCharArray();
        Arrays.sort(pp);
        String ppp=new String(pp);
        int p_length=p.length();
        int length=s.length();
        List<Integer> res=new ArrayList<>();

        for(int i=0;i<=length-p_length;i++){
            char[] t=s.substring(i,i+p_length).toCharArray();
            Arrays.sort(t);
            String tt=new String(t);
            if(ppp.equals(tt)){
                res.add(i);
            }

        }
        return res;
    }

    public int countSubstrings(String s) {
        int res=0;
        for (int i = 0; i < s.length()-1; i++) {
            for (int j = i; j < s.length(); j++) {
                    if(huiwen(s,i,j)){
                        res++;
                    }
            }
        }
        return res;
    }

    private boolean huiwen(String s, int i, int j) {
        while(i<j){
            if(s.charAt(i++)!=s.charAt(j--)){
                return false;
            }
        }
        return true;
    }

    public int maxAncestorDiff(TreeNode root) {
        if(root==null)
            return 0;
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        int []res=new int[]{0};
        dfs(root,max,min,res);
        return res[0];
    }

    private void dfs(TreeNode root, int max, int min, int[] res) {
    if(root==null){
        return;
    }
    max=Math.max(max,root.val);
    min=Math.min(min, root.val);
    dfs(root.left, max, min, res);
    dfs(root.right, max, min, res);
    res[0]=Math.max(max-min,res[0]);
    }

}