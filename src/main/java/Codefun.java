import java.util.*;
class Test2{

    public  int init(){
        return 1;
    }
    public int init(int i){
        return 1;
    }
    public void init(int i,int a){
    }

}
public class Codefun {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        HashMap<Integer,List<Integer>> map=new HashMap<>();
        for (int i = 0; i < m; i++) {
            int a=sc.nextInt();
            int b= sc.nextInt();
            if(map.containsKey(a)){
                map.get(a).add(b);
            }else{
                List<Integer> t=new ArrayList<>();
                t.add(b);
                map.put(a,t);
            }
        }
        Set<Integer>set=new HashSet<>();
        int k= sc.nextInt();
        for (int i = 0; i < k; i++) {
            set.add(sc.nextInt());
        }
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> tmp=new ArrayList<>();
        tmp.add(0);
        huisu(map,set,res,tmp,0);
        if(res.size()==0){
            System.out.println("NULL");
            return;
        }
        // 选择最短的边
        // 最短边下标
        if(res.size()==0){
            System.out.println("NULL");
            return;
        }
        List<Integer> ans = new ArrayList<>();
        int min_ed = Integer.MAX_VALUE;
        // 找到最短的路径的长度
        for(List<Integer> ll:res){
            min_ed = Math.min(min_ed,ll.size());
        }
        int count = 0;// 用于初始化下面遍历时第一个路径
        // 在这些相同长度的最短路径中选最优
        for(int i = 0;i<res.size();i++){
            if(res.get(i).size()==min_ed && count==0){
                ans = res.get(i);
                count++;continue;
            }
            if(res.get(i).size()==min_ed){
                if(comp(ans,res.get(i))){
                    ans = res.get(i);
                }
            }
        }
        //按照格式输出
        for(int i = 0;i<ans.size();i++){
            if(i==ans.size()-1){
                System.out.print(ans.get(i));
            }else{
                System.out.print(ans.get(i)+"->");
            }
        }
    }
    // 如果n1大 就输出true 比较两个相同长度路径谁更优
    public static boolean comp(List<Integer> n1,List<Integer> n2){
        int n = n1.size();
        for(int i = 0;i<n;i++){
            if(n1.get(i).equals(n2.get(i))) continue;
            if(n1.get(i)>n2.get(i)){
                return true;
            }
            return false;
        }
        return true;
    }


    private static void huisu(HashMap<Integer, List<Integer>> map, Set<Integer> set, List<List<Integer>> res, List<Integer> tmp, int point) {
        if(!map.containsKey(point)){
            if(set.contains(point)){
                return;
            }
            res.add(new ArrayList<>(tmp));
            return;
        }
        List<Integer> next=map.get(point);
        for (int i = 0; i < next.size(); i++) {
            int p= next.get(i);
            if(!set.contains(p)){

                tmp.add(p);
                huisu(map, set, res, tmp, p);
                tmp.remove(tmp.size()-1);

            }
        }
    }
}
//    public static void main(String[] args) {
//        Scanner scanner=new Scanner(System.in);
//        int n=scanner.nextInt();
////        int [][]nums=new int[n][2];
//        int []counter=new int[1000002];
//        int min=Integer.MAX_VALUE;
//        int max=Integer.MIN_VALUE;
//        for (int i = 0; i <n ; i++) {
//           int a = scanner.nextInt();
//            int b = scanner.nextInt();
//            min=Math.min(min,a);
//            max=Math.max(max,b);
//            counter[a]+=1;
//            counter[b+1]-=1;
//        }
//        int cur=0;
//        int res=0;
//        for (int i = min; i <=max; i++) {
//            cur+=counter[i];
//            if(cur==0)
//                res++;
//            if(cur==1)
//                res+=3;
//            else{
//                res+=4;
//            }
//        }
//        System.out.println(res);
//
//
//
//    }
//}
//    public static void main(String[] args) {
//        Scanner scanner=new Scanner(System.in);
//        String s= scanner.next();
//        int n=scanner.nextInt();
//        char [][] res=new char[n][n];
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                res[i][j]='0';
//            }
//        }
//        int index=0;
//        int f=0;
//        for (int i = 0; i < n; i++) {
//            if(f%2==0){
//                for (int j = 0; j <n ; j++) {
//                    if(index==s.length()){
//                        break;
//                    }
//                    res[j][i]=s.charAt(index++);
//
//                }
//                if(index==s.length()){
//                    break;
//                }
//            }else{
//                for (int j = n-1; j >=0 ; j--) {
//                    if(index==s.length()){
//                        break;
//                    }
//                    res[j][i]=s.charAt(index++);
//
//                }
//                if(index==s.length()){
//                    break;
//                }
//            }
//            f++;
//
//        }
//
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                if(res[i][j]!='0'){
//                    System.out.print(res[i][j]);
//                }
//
//            }
//            System.out.println();
//        }
//    }
//}
//    public static void main(String[] args) {
//        Scanner scanner=new Scanner(System.in);
//        int n=scanner.nextInt();
//        int []nums=new int[n];
//        int res=Integer.MAX_VALUE;
//        int sum=0;
//        int max=Integer.MIN_VALUE;
//        int min=Integer.MAX_VALUE;
//        for (int i = 0; i < n;  i++) {
//            nums[i]=scanner.nextInt();
//            sum+=nums[i];
//            max=Math.max(max,nums[i]);
//            min=Math.min(min,nums[i]);
//        }
//        if(n==1){
//            System.out.println(nums[0]);
//        } else if (n==2){
//            System.out.println(min);
//        }else {
//            for (int i = 0; i < max; i++) {
//                int tmp=0;
//                for (int j = 0; j < n; j++) {
//                    tmp+=Math.abs(nums[j]-i);
//                }
//                if(tmp<res){
//                    sum=i;
//                    res=tmp;
//                }
//            }
//            System.out.println(sum);
//        }
//
//
//    }
//}
