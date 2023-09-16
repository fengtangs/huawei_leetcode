package bytedance;
//import java.math.BigDecimal;
//import java.util.*;
//import java.util.HashMap;
//
//public class Main {
//    static Map<Operator, IComputer> computers;
//    static {
//        computers = new HashMap<Operator, IComputer>() {{
//            put(Operator.ADD, new IComputer() {
//
//                @Override
//                public BigDecimal compute(BigDecimal num1, BigDecimal num2) {
//                    return num1.add(num2);
//                }
//            });
//            put(Operator.SUB, ((num1, num2) -> num1.subtract(num2)));
//            put(Operator.MULTI, ((num1, num2) -> num1.multiply(num2)));
//            put(Operator.DIVIDE, ((num1, num2) -> num1.divide(num2)));
//        }};
//    }
//
//    public static void main(String[] args) {
//        //测试验证 1+2
//        BigDecimal result = compute(Operator.SUB, BigDecimal.valueOf(1),BigDecimal.valueOf(2));
//        //输出结果3
//        System.out.println(result);
//    }
//
//    public static BigDecimal compute(Operator operator, BigDecimal num1, BigDecimal num2) {
//        BigDecimal result = computers.get(operator).compute(num1, num2);
//        return result;
//    }
//
//
//    enum Operator {
//        ADD,SUB,MULTI,DIVIDE;
//    }
//
//    interface IComputer {
//        BigDecimal compute(BigDecimal num1, BigDecimal num2);
//    }
//}


import java.util.*;

public class Kaoshi{

    static class A  {

        int start=0;
        int end=0;
        int chixu=0;
        public A(int a,int b,int c){
            start=a;
            end=b;
            chixu=c;
        }

        @Override
        public int hashCode() {
            return super.hashCode();
        }
    }
    public static void main (String[] args){
        Object o=new Object();
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        A[] array=new A[n];
        for(int i=0;i<n;i++){
            int start=sc.nextInt();
            int end=sc.nextInt();
            array[i]=new A(start,end,end-start);
        }
        Arrays.sort(array, new Comparator<A>() {
            @Override
            public int compare(A o1, A o2) {
                if(o1.chixu!=o2.chixu){
                    return o1.chixu-o2.chixu;
                }
                else{
                    if(o1.start==o2.start){
                        return o1.end-o2.end;
                    }
                    else{
                        return o1.start-o2.start;
                    }
                }
            }
        });
        int res=0;
        boolean[] times=new boolean[24];
        for(int i=0;i<n;i++){
            boolean f=false;
            for(int j=array[i].start;j<array[i].end;j++){
                if(times[j]==true){
                    f=true;
                    break;
                }
            }
            if(!f){
                res++;
                for(int j=array[i].start;j<array[i].end;j++){
                    times[j]=true;
                }

            }

        }

        System.out.println(res);
    }



}
abstract class BBB{
    int a;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        System.out.println(111);
        this.a = a;
    }
    private int sss(){
        return 1;
    }
}
interface CCC{
    int aaa = 0;
    abstract void hello();
    void hhh();


}
