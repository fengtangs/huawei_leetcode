import java.util.ArrayList;

public class KS {

    class Data{
        int a;
        int b;
        Data(int a,int b){
            this.a=a;
            this.b=b;
        }
        Data(){
            a=0;
            b=0;
        }
    }
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int index=0;
        int len=intervals.length;
        ArrayList<int []> res=new ArrayList<>();
        for (;index<len&&intervals[index][1]<newInterval[0];index++){
            res.add(intervals[index]);
        }

        for (;index<len&&newInterval[1]>=intervals[index][0];index++){
            newInterval[0]=Math.min(newInterval[0],intervals[index][0] );
            newInterval[1]=Math.max(newInterval[1],intervals[index][1] );

        }
        res.add(newInterval);
        for (;index<len;index++){
            res.add(intervals[index]);
        }
        int[][]result=new int[res.size()][2];
        for (int i = 0; i < res.size(); i++) {
            result[i]= res.get(i);
        }
        return result;

    }
    public static void main(String[] args) {
        System.out.println("111");
    }
}
