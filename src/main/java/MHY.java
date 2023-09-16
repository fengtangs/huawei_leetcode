import java.math.BigDecimal;
import java.util.*;
import java.math.BigDecimal;
import java.util.Scanner;

class MMM{
    private static MMM instance;
    private MMM(){

    }
    public  static MMM getinstance(){
        synchronized (MMM.class){
            if(instance==null){
                instance=new MMM();
            }
            return instance;
        }
    }

}
abstract class Person{
    String name;
    public String getname(){
        return name;
    }
    public abstract String getNickname();
}
public class MHY {
    @Override
    public boolean equals(Object obj) {
        return true;
    }

//        static BigDecimal p = BigDecimal.ZERO;
//        public static void main(String[] args) {
//            Scanner sc = new Scanner(System.in);
//            p = sc.nextBigDecimal();
//            System.out.println(
//                    recursion(BigDecimal.ONE, BigDecimal.ONE)
//                            .multiply(BigDecimal.valueOf(1.5))
//                            .setScale(7, BigDecimal.ROUND_HALF_UP)
//            );
//        }
//
//        public static BigDecimal recursion(BigDecimal time, BigDecimal np) {
//            if (time.equals(BigDecimal.valueOf(90))) return np.multiply(BigDecimal.valueOf(90));
//            BigDecimal newNp = np.multiply(BigDecimal.ONE.subtract(p));
//            return recursion(time.add(BigDecimal.ONE), newNp).add(time.multiply(p).multiply(np));
//        }

//
//        static  double p; //抽到当期五星概率
//    public static void main(String[] args) {
//       Scanner scanner=new Scanner(System.in);
//        p=scanner.nextDouble(); //获取输入
//
//        double res= cal(1,1)*1.5;//计算结果
//
//        System.out.println(res);
//    }
//
//    private static double cal(double time, double np) {
//        if(time==90){
//            return np*90;
//        }
//        double Newnp= np*(1-p);
//        return cal(time+1,Newnp)+time*p*np;
//    }
    boolean is_sub(int start,int length,String s,String s1){
        if(start+length>s.length()){
            return false;
        }
        for (int i = start; i <start+length; i++) {
            if(s.charAt(i)!=s1.charAt(i-start)){
                return false;
            }
        }
        return true;
    }
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {

        int n = s.length(), m = indices.length;

        Map<Integer, List<Integer>> ops = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < m; ++i) {
            ops.putIfAbsent(indices[i], new ArrayList<Integer>());
            ops.get(indices[i]).add(i);
        }

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < n;) {
            boolean succeed = false;
            if (ops.containsKey(i)) {
                for (int pt : ops.get(i)) {//有可能在一个下标中有好几个替换。所以挨个判断
//                    if (s.substring(i, Math.min(i + sources[pt].length(), n)).equals(sources[pt])) {
                    if(is_sub(i,sources[pt].length(),s,sources[pt])){
                        succeed = true;
                        ans.append(targets[pt]);
                        i += sources[pt].length();
                        break;
                    }
                }
            }
            if (!succeed) {
                ans.append(s.charAt(i));
                ++i;
            }
        }
        return ans.toString();

    }


    public static void main(String[] args) {
            MHY o=new MHY();
            BigDecimal a= new BigDecimal(0.2);
            BigDecimal b=new BigDecimal(0.1);
        System.out.println(a.add(b).doubleValue());
    }

//    public static void main(String[] args) {
//        Scanner scanner=new Scanner(System.in);
//        double p=scanner.nextDouble();
//        double exp=0;

//        for (int i = 1; i <=180 ; i++) {
//            if(i<=89){
//                exp+=i*p/2*Math.pow((1-p),i-1);//这一抽抽到了当期5星,并且前i抽没有抽到
//
//                //前i抽有j抽抽到了常驻5星,并且第i抽抽到
//                for (int j = 1; j <i ; j++) {
//                    exp+=i*p/2*Math.pow(p/2,j)*Math.pow((1-p),i-1-j);
//                }
//
//        }else if(i<180){
//
//                //没有触发大堡底,也就是说前i抽都没抽到5星
//                //1.这次抽到了
//                exp+=i*Math.pow((1-p),89)*Math.pow(0.5,i-89);
//                //触发了大堡底，抽中了j次常驻5星。
//                for (int j = 1; j <i-89 ; j++) {
//                    for (int k = 0; k <=j ; k++) {
//                        exp+=i*Math.pow(1-p,89)*Math.pow(0.5,j-k)*Math.pow(p/2,k);
//                    }
//
//                }
//
//
//
//            }
//            else {
//                    exp+=i*Math.pow(1-p,89)*Math.pow(0.5,90);
//
//            }
//    }
//        double [] tmp=new double[181];
//        double cur=1;
//        for (int i = 1; i <90 ; i++) {
//            tmp[i]+=cur*p/2;
//            wai(cur*p/2,p,i,tmp);
//            cur=cur*(1-p);
//        }
//        tmp[90]+=cur/2;
//        wai(cur/2,p,90,tmp);
//        for (int i = 0; i <tmp.length; i++) {
//            exp+=i*tmp[i];
//        }
//        System.out.println(exp);
//}
//static void wai(double cur,double p, int index,double[] tmp){
//    for (int i = 1; i <90 ; i++) {
//        tmp[index+i]+=cur*p;
//        cur = cur*(1-p);
//    }
//    tmp[index+90]+=cur;
//}
//public class MHY {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n= in.nextInt();
//        int m= in.nextInt();
//        int a[][]=new int[3][2];
//        for (int i = 0; i < 3; i++) {
//            a[i][0]=in.nextInt();
//            a[i][1]= in.nextInt();
//        }
//        int m1=minjuli(a[0][0],a[0][1],a[1][0],a[1][1],m,n);
//        int m2=minjuli(a[1][0],a[1][1],a[2][0],a[2][1],m,n);
//        System.out.println(m1+m2);
//
//
//    }
//    static  int minjuli(int x1,int y1,int x2,int y2,int m,int n){
//        int t1= Math.abs(x1-x2);
//        int z1= Math.abs(y1-y2);
//
//        int t2=x1-1+n-x2+1;
//        int t3=x2-1+n-x1+1;
//        int z2=y1-1+m-y2+1;
//        int z3=y2-1+m-y1+1;
//        t2=Math.min(t2,t3);
//        z2=Math.min(z2,z3);
//        return Math.min(t1,t2)+Math.min(z1,z2);
//
////
//    }
//static class Node{
//    int id;
//    ArrayList<Node> childNode;
//    Node(int id){
//        this.id=id;
//        this.childNode=new ArrayList<>();
//    }
//}
//public static void main(String[] args) {
//
//    Scanner sc=new Scanner(System.in);
//    int n=sc.nextInt();
//    int k= sc.nextInt();
//    Node[] nodes=new Node[n+1];
//    for (int i = 1; i <=n ; i++) {
//        nodes[i]=new Node(i);
//    }
//    for (int i = 1; i < n; i++) {
//        int u= sc.nextInt();
//        int v= sc.nextInt();
//        nodes[u].childNode.add(nodes[v]);
//        nodes[v].childNode.add(nodes[u]);
//    }
//    int maxcount=dfs(nodes[1],null,0,k);
//    System.out.println(maxcount);
//
//    }
//
//    public static int dfs(Node node,Node parent,int depth,int k){
//        int count=0;
//        if(depth<=k){
//            count++;
//        }
//        for (Node c:node.childNode) {
//            if(c!=parent){
//                count+=dfs(c,node,depth+1,k);
//            }
//        }
//        return count;
//    }



}
