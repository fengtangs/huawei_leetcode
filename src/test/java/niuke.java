import java.sql.SQLOutput;
import java.util.*;
public class niuke {
    /**
     * 华为第一题，牛客网，简单，注意获取带有空格的输入
     * @param args
     */
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        // 注意 hasNext 和 hasNextLine 的区别
//        String a = in.nextLine();
//        int res=0;
//        for(int i=a.length()-1;i>=0;i--){
//            if(a.charAt(i)!=' '){
//                res++;
//            }
//            else break;
//        }
//        System.out.println(res );
//    }

    /**
     * huawei第二题，简单，
     * @param args
     */
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        // 注意 hasNext 和 hasNextLine 的区别
//        String str=in.nextLine();
//        char[] a=in.next().toCharArray();
//        int res=0;
//        for (int i = 0; i < str.length(); i++) {
//            char t=str.charAt(i);
//            if(t<='9'&&t>='0'){
//                if(t==a[0]){
//                    res++;
//                }
//            }
//            else{
//                if(t<='z'&&t>='a'){
//                    if(t==a[0]||t==(char)((int)a[0]+32)){
//                        res++;
//                    }
//                }
//                else if(t<='Z'&&t>='A'){
//                    if(t==a[0]||t==(char)((int)a[0]-32)){
//                        res++;
//                    }
//                }
//            }
//
//        }
//        System.out.println(res);
//    }

    /**
     * 明明的随机数,感觉简单
     * @param args
     */
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        TreeSet<Integer> set=new TreeSet<>();
//        int n=in.nextInt();
//        for (int i = 0; i <n ; i++) {
//            set.add(in.nextInt());
//        }
//        Iterator<Integer> iterator= set.iterator();
//        while (iterator.hasNext()){
//            System.out.println(iterator.next());
//        }
//
//    }


/**
 * 分割字符串，还可以，只需要处理最后一个字符串
 */
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        String str = in.next();
//        int x = 0;
//        int yushu = str.length() % 8;
//        int cishu = str.length() / 8 + 1;
//        if (yushu == 0)
//            cishu = str.length() / 8;
//        for (int i = 0; i < cishu; i++) {
//
//            if (i == cishu - 1) {
//                StringBuffer sb = new StringBuffer();
//                sb.append(str.substring(8 * i, str.length()));
//                if(yushu!=0){
//                    for (int j = yushu; j < 8; j++) {
//                        sb.append('0');
//                    }
//                }
//
//
//                System.out.println(sb);
//            } else {
//
//                System.out.println(str.substring(8 * i, 8 * (i + 1)));
//
//            }
//
//        }
//
//    }

    /**
     *  进制转换 16->10
     */
//    public static void main(String[] args) {
//        Scanner in=new Scanner(System.in);
//        String str=in.nextLine();
//        int res=0;
//        int index=0;
//        for (int i = str.length()-1; i >1 ; i--) {
//            int tmp=0;
//            if(str.charAt(i)>='A'){
//                tmp=str.charAt(i)-'A'+10;
//            }else{
//                tmp=str.charAt(i)-'0';
//            }
//            res+=tmp*(int)Math.pow(16,index);
//            index++;
//
//        }
//        System.out.println(res);
//    }

    /**
     * 我对这段代码的理解 1. 从2开始，能第一个整除n的因子一定是质数 2. n除以一个质因子之后，如果结果是质数，说明找到全部质因子，
     * 程序结束；如果结果是合数，则该合数的质因子，也是n的质因子，目标变为寻找该合数的质因子；以此类推 3. 只遍历到根号n是为了节省资源；
     * 任意n，最多只有一个大于根号n的质因子，否则两个大于根号n的质因子相乘必大于n。
     * 如果存在大于根号n的质因子，靠遍历是找不到的；但它一定等于n除以所有小于根号n的质因子后，最终得到的那个质数
     * @param args
     */

//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int num=in.nextInt();
//        int i=2;
//        while(i<Math.sqrt(num)+1){
//            while(num%i==0){
//                System.out.print(i);
//                System.out.print(" ");
//                num=num/i;
//            }
//            i++;
//        }
//        if(num>2){
//            System.out.print(num);
//        }
//
//    }


//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        // 注意 hasNext 和 hasNextLine 的区别
//        String num= in.next();
//        HashSet<String> s=new HashSet<>();
//        StringBuffer stringBuffer=new StringBuffer();
//        String f = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
//
//        for (int i = num.length()-1; i >=0 ; i--) {
//            if(!s.contains(String.valueOf(num.charAt(i)))){
//                s.add(String.valueOf(num.charAt(i)));
//                stringBuffer.append(num.charAt(i));
//            }
//
//        } System.out.println(stringBuffer.toString());
//
////        Iterator<String> iterator=s.iterator();
////        while(iterator.hasNext()){
////            System.out.print(iterator.next());
////        }
//
//
//
//    }


    /**
     * 字符统计，重写compare函数
     * @param args
     */

//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        char[] a = in.next().toCharArray();
//        HashMap<Character,Integer> map=new HashMap<>();
//        for (char c:a) {
//            if(map.containsKey(c)){
//                map.put(c, map.get(c)+1);
//            }else{
//                map.put(c,1);
//            }
//        }
//        int[][]res=new int[map.size()][2];
//        int index=0;
//        for(Map.Entry<Character,Integer>entry: map.entrySet())
//        {
//            res[index][0]= entry.getValue();
//            res[index++][1]= entry.getKey();
//        }
//        Arrays.sort(res, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                if(o1[0]!=o2[0]){
//                    return o2[0]-o1[0];
//                }else{
//                    return o1[1]-o2[1];
//                }
//            }
//        });
//        for (int i = 0; i < map.size(); i++) {
//            System.out.print((char)(res[i][1]));
//        }
//
//    }


//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        String a = in.next();
//        for( int i=0;i<a.length();i++){
//            char c=a.charAt(i);
//            int f=1;
//            while(c>='0'&&c<='9'){
//                if(f==1){
//                    f=0;
//                    System.out.printf("*%c",c);
//                }else{
//                    System.out.print(c);
//                }
//                    i++;
//                    if(i==a.length()){
//                        if(f==0){
//                            System.out.printf("*");
//                        }
//                        return;
//                    }else{
//                        c=a.charAt(i);
//                    }
//
//
//            }
//            if(f==0){
//                System.out.printf("*%c",c);
//                f=1;
//            }else{
//                System.out.print(c);
//            }
//
//        }
//
//    }




//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        ListNode head=new ListNode();
//        ListNode pre=head;
//        for (int i = 0; i < n; i++) {
//            ListNode next=new ListNode();
//            int x= in.nextInt();
//            next.m_nKey=x;
//            pre.m_pNext=next;
//            pre=next;
//        }
//        int k = in.nextInt();
//        if(n-k<0) {
//            System.out.println("null");
//        }
//        int index=0;
//        ListNode temp=head.m_pNext;
//        while(index<(n-k)) {
//            temp = temp.m_pNext;
//            index++;
//        }
//
//
//        System.out.println(temp.m_nKey);
//    }

//    public static boolean huiwen(String str){
//
//        int i=0,j=str.length()-1;
//        while(i<=j){
//            if(str.charAt(i)!=str.charAt(j)){
//                return false;
//            }
//            i++;
//            j--;
//        }
//        return true;
//    }
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        // 注意 hasNext 和 hasNextLine 的区别
//            String  a = in.next();
//            int max=0;
//            for (int i = 0; i < a.length()-1; i++) {
//                for (int j = i+1; j <=a.length(); j++) {
//                    if(huiwen(a.substring(i,j))){
//                        max=max>(j-i)?max:(j-i);
//                    }
//                }
//            }
//            System.out.println(max);
//    }


}
//class ListNode{
//    int m_nKey;
//    ListNode m_pNext;
//    public ListNode(){
//
//    }
//}
