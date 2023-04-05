import java.util.*;
public class zhongdeng {

    //字符串排序 HJ26 字符串排序
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        // 注意 hasNext 和 hasNextLine 的区别
//        String str = in.nextLine();
//        ListNode res=new ListNode();
//        ListNode com=new ListNode();
//        boolean[] flag=new boolean[str.length()];
//        for (int i = 0; i < str.length(); i++) {
//            char c=str.charAt(i);
//            if(c<='Z'&&c>='A'){
//                c=(char)(c-'A'+'a');
//            }
//            if (c>'z'||c<'a') {
//                flag[i]=true;
//            }else{
//                ListNode pre_res=res;
//                ListNode now_res=pre_res.m_pNext;
//                ListNode pre_com=com;
//                ListNode now_com=pre_com.m_pNext;
//                    if(now_res==null){
//                        ListNode t_res=new ListNode();
//                        ListNode t_com=new ListNode();
//                        t_res.m_nKey=str.charAt(i);
//                        t_com.m_nKey=c;
//                        res.m_pNext=t_res;
//                        com.m_pNext=t_com;
//                    }else{
//                        while(now_com!=null){
//                            if(c>=now_com.m_nKey){
//                                pre_com=now_com;
//                                pre_res=now_res;
//                                now_com=now_com.m_pNext;
//                                now_res=now_res.m_pNext;
//                            }else{
//                                ListNode t_res=new ListNode();
//                                ListNode t_com=new ListNode();
//                                t_res.m_nKey=str.charAt(i);
//                                t_com.m_nKey=c;
//                                pre_res.m_pNext=t_res;
//                                t_res.m_pNext=now_res;
//                                pre_com.m_pNext=t_com;
//                                t_com.m_pNext=now_com;
//                                break;
//                            }
//                        }
//                        if(now_com==null){
//                            ListNode t_res=new ListNode();
//                            ListNode t_com=new ListNode();
//                            t_res.m_nKey=str.charAt(i);
//                            t_com.m_nKey=c;
//                            pre_res.m_pNext=t_res;
//                            t_res.m_pNext=now_res;
//                            pre_com.m_pNext=t_com;
//                            t_com.m_pNext=now_com;
//                        }
//
//
//                    }
//
//            }
//        }
//        ListNode next=res.m_pNext;
//        int index=0;
//        while(next!=null){
//            if(flag[index]){
//                System.out.print(str.charAt(index));
//                index++;
//            }else{
//                System.out.print(next.m_nKey);
//                next=next.m_pNext;
//                index++;
//            }
//        }
//        while(index<str.length()){
//            if(flag[index]){
//                System.out.print(str.charAt(index));
//            }
//            index++;
//        }
//
//
//    }

//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        // 注意 hasNext 和 hasNextLine 的区别
//        char [] zimu=new char[26];
//        String a = in.next();
//        String mi = in.next();
//        int index=0;
//        HashSet<Character> set=new HashSet<>();
//        for (int i = 0; i < a.length(); i++) {
//            char c=a.charAt(i);
//            if(!set.contains(c)){
//                set.add(c);
//                zimu[index++]=c;
//            }
//        }
//        for (int i = 0; i < 26; i++) {
//            char c= (char)(i+'a');
//            if(!set.contains(c)){
//                set.add(c);
//                zimu[index++]=c;
//            }
//        }
//        for (int i = 0; i < mi.length(); i++) {
//            System.out.print(zimu[mi.charAt(i)-'a']);
//        }
//
//    }

    /**
     * HJ17 坐标移动
     */
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        // 注意 hasNext 和 hasNextLine 的区别
//        String str = in.nextLine();
//        int [] res=new int[]{0,0};
//        String[]caozuo=str.split(";");
//        for (int i = 0; i < caozuo.length; i++) {
//            String s=caozuo[i];
//            if(s.length()!=3&&s.length()!=2)
//                continue;
//            char c;
//            int num=0;
//            if(s.charAt(0)=='A'||s.charAt(0)=='D'||s.charAt(0)=='W'||s.charAt(0)=='S'){
//                c=s.charAt(0);
//            }else{
//                continue;
//            }
//            if(s.length()==2){
//                if(s.charAt(1)>='0'&&s.charAt(1)<='9')  {
//                    num=(int)(s.charAt(1)-'0');
//                }
//            }else{
//                if(s.charAt(1)>='0'&&s.charAt(1)<='9'&&s.charAt(2)>='0'&&s.charAt(2)<='9')  {
//                    num=(int)(s.charAt(1)-'0')*10+(s.charAt(2)-'0');
//                }
//            }
//            if(c=='A'){
//                res[0]-=num;
//            }else if (c=='D'){
//                res[0]+=num;
//            }else if (c=='W'){
//                res[1]+=num;
//            }else if (c=='S'){
//                res[1]-=num;
//            }
//
//        }
//        System.out.println(res[0]+","+res[1]);
//    }

    /**
     * 检查密码是否合法
     * @param args
     */
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        // 注意 hasNext 和 hasNextLine 的区别
//        while (in.hasNextLine()) { // 注意 while 处理多个 case
//            String str = in.next();
//            boolean[] flag=new boolean[5];
//            HashSet<String> map=new HashSet<>();
//            boolean zichuan;
//            if(str.length()<8){
//                System.out.println("NG");
//            }else{
//
//                for(int i=0;i<str.length();i++){
//                    char c=str.charAt(i);
//                    if(c<='Z'&&c>='A'){
//                        flag[0]=true;
//                    }else if(c<='z'&&c>='a'){
//                        flag[1]=true;
//                    }else if(c<='9'&&c>='0'){
//                        flag[2]=true;
//                    }else {
//                        flag[3]=true;
//                    }
//
//                    for(int j=i+3;j<=str.length();j++){
//                        String s=str.substring(i,j);
//                        if(map.contains(s)){
//                            flag[4]=true;
//                            break;
//                        }
//                        map.add(s);
//                    }
//                    if(flag[4]){
//                        break;
//                    }
//
//
//                }
//
//                if(flag[4]){
//                    System.out.println("NG");
//                    continue;
//                }
//
//                int t=0;
//                for(int i=0;i<4;i++){
//                    if(flag[i]) t++;
//                }
//                if(t>=3){
//                    System.out.println("OK");
//                }else{
//                    System.out.println("NG");
//                }
//
//
//
//
//
//
//
//            }
//
//        }
//    }

    /**
     * HJ48 从单向链表中删除指定值的节点
     */
//    public static void main(String[] args) {
//        Scanner in=new Scanner(System.in);
//        int n=in.nextInt();
//        ListNode head=new ListNode();
//        head.m_nKey=in.nextInt();
//        head.m_pNext=null;
//        for (int i = 2; i <=n ; i++) {
//            int node= in.nextInt();
//            int value= in.nextInt();
//            ListNode pre=head;
//            ListNode node1 = new ListNode();
//            node1.m_nKey=node;
//            while(pre.m_nKey!=value){
//                pre=pre.m_pNext;
//            }
//            node1.m_pNext=pre.m_pNext;
//            pre.m_pNext=node1;
//        }
//        int del= in.nextInt();
//        if(del== head.m_nKey){
//            head=head.m_pNext;
//        }else{
//            ListNode pre=head;
//            while(pre.m_pNext!=null){
//                if(pre.m_pNext.m_nKey==del){
//                    pre.m_pNext=pre.m_pNext.m_pNext;
//                    break;
//                }else{
//                    pre=pre.m_pNext;
//                }
//            }
//
//        }
//        while(head!=null){
//            System.out.print(head.m_nKey+" ");
//            head=head.m_pNext;
//        }
//    }

    /**
     * 回溯算法
     * 解决火车进站问题
     * @param args
     */
//    public static void huisu(List<List<Integer>> list,List<Integer> tmp,Stack<Integer> stack,int[] arr,int i,int j,int n){
//        if(j==n&&i==n){
//            list.add(new ArrayList<>(tmp));
//            tmp=new ArrayList<>();
//            return;
//        }
//        if(j!=n){
//            stack.push(arr[j]);
//            huisu(list,tmp,stack,arr,i,j+1,n);
//            stack.pop();
//        }
//        if(!stack.isEmpty()){
//            int x= stack.pop();
//            tmp.add(x);
//            huisu(list,tmp,stack,arr,i+1,j,n);
//            tmp.remove(tmp.size()-1);
//            stack.push(x);
//        }
//
//    }
//    public static void main(String[] args) {
//        Scanner in=new Scanner(System.in);
//        int n=in.nextInt();
//        int []arr =new  int[n];
//        for (int i = 0; i < n; i++) {
//            arr[i]= in.nextInt();
//        }
//        Stack<Integer> stack =new Stack<>();
//        List<List<Integer>> res=new ArrayList<>();
//        List<Integer> tmp=new ArrayList<>();
//        huisu(res,tmp,stack,arr,0,0,n);
//        String[] out=new String[res.size()];
//        for (int i = 0; i < res.size(); i++) {
//            StringBuffer t=new StringBuffer();
//            for (int j = 0; j < res.get(i).size(); j++) {
//                    t.append(res.get(i).get(j));
//            }
//            out[i]= t.toString();
//        }
//        Arrays.sort(out);
//        for (String s:out) {
//            for (int i = 0; i < s.length(); i++) {
//                System.out.print(s.charAt(i)+" ");
//            }
//            System.out.println();
//        }
//    }
//    public static void main(String[] args) {
//        int[] t=new int[]{1,2,3};
//        List<List<Integer>> res=new ArrayList<>();
//        List<Integer> tmp=new ArrayList<>();
//        boolean[] used=new boolean[t.length];
//        huisu(res,tmp,t,0,t.length,used);
//        for (List<Integer>l:res) {
//            for (Integer i: l) {
//                System.out.print(i+" ");
//            }
//            System.out.println();
//
//        }
//    }
//
//    private static void huisu(List<List<Integer>> res, List<Integer> tmp, int[] t,int i, int length,boolean[] used) {
//        if(i==length){
//            res.add(new ArrayList<>(tmp));
//            tmp=new ArrayList<>();
//            return;
//        }
//        for (int j = 0; j < length; j++) {
//            if(!used[j]){
//                tmp.add(t[j]);
//                used[j]=true;
//                huisu(res, tmp, t, i+1, length,used);
//                used[j]=false;
//                tmp.remove(tmp.size()-1);
//            }
//
//
//        }
//
//    }
    public static void main(String[] args) {

        List<List<Integer>>r=combine(4,2);
        for (List<Integer>t:r) {
            for (Integer i:t
                 ) {
                System.out.print(i);
            }
            System.out.println();
        }

    }
    public static void huisu( List<List<Integer>>res,List<Integer>tmp,int k,int n,boolean[] used,int[]nums){
        if(tmp.size()==k){
            res.add(new ArrayList<>(tmp));
            tmp=new ArrayList<>();
            return;
        }
        for(int i=0;i<n;i++){
            if(!used[i]){
                used[i]=true;
                tmp.add(nums[i]);
                huisu(res,tmp,k,n,used,nums);
                tmp.remove(tmp.size()-1);
                used[i]=false;
            }
        }



    }
    public static List<List<Integer>> combine(int n, int k) {
        int[]nums=new int[n];
        for(int i=0;i<n;i++){
            nums[i]=i+1;
        }
        List<List<Integer>>res=new ArrayList<>();
        List<Integer>tmp=new ArrayList<>();
        boolean[] used=new boolean[n];
        huisu(res,tmp,k,n,used,nums);
        return res;
    }
}
class ListNode{
    int m_nKey;
    ListNode m_pNext;
    public ListNode(){

    }
}
