import java.util.*;
public class Tmp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int [][] nums=new int[n][2];
        for (int i = 0; i <n ; i++) {
            nums[i][0]=sc.nextInt();
            nums[i][1]=sc.nextInt();
        }
        List<List<int[]>>res=new ArrayList<>();
        List<int[]> tmp=new ArrayList<>();
        boolean []used=new boolean[n];
        int num=0;
        huisu(res,tmp,used,0,nums);
        for (int i = 0; i < res.size(); i++) {
//            for (int j = 0; j < res.get(i).size(); j++) {
//                for (int k = 0; k < res.get(i).get(j).length; k++) {
//                    System.out.print(res.get(i).get(j)[k]+" ");
//                }
//                System.out.println();
//            }
            if(is_legal(res.get(i))){
                num++;
            }
        }
        System.out.println(num);

    }
    private static void huisu(List<List<int[]>> res, List<int[]> tmp, boolean[] used, int i, int[][] nums) {
        if(tmp.size()==4){
            res.add(new ArrayList<>(tmp));
            tmp=new ArrayList<>();
            return;
        }
        for (int j = i; j < nums.length ; j++) {
            if(!used[j]){
                tmp.add(new int[]{nums[j][0],nums[j][1]});
                used[j]=true;
                huisu(res, tmp, used, j+1, nums);
                used[j]=false;
                tmp.remove(tmp.size()-1);

            }
        }

    }

    private static boolean is_legal(List<int[]> integers) {
        int []a=integers.get(0);
        int []b= integers.get(1);
        int []c=integers.get(2);
        int []d= integers.get(3);
        double ab=Math.sqrt((a[0]-b[0])*(a[0]-b[0])+(a[1]-b[1])*(a[1]-b[1]));
        double ac=Math.sqrt((a[0]-c[0])*(a[0]-c[0])+(a[1]-c[1])*(a[1]-c[1]));
        double ad=Math.sqrt((a[0]-d[0])*(a[0]-d[0])+(a[1]-d[1])*(a[1]-d[1]));
        double cd=Math.sqrt((c[0]-d[0])*(c[0]-d[0])+(c[1]-d[1])*(c[1]-d[1]));
        double bd=Math.sqrt((b[0]-d[0])*(b[0]-d[0])+(b[1]-d[1])*(b[1]-d[1]));
        double bc=Math.sqrt((b[0]-c[0])*(b[0]-c[0])+(b[1]-c[1])*(b[1]-c[1]));
        if(((ab-ac)<=0.0001&&(ab-ac)>=-0.0001)&&((ab-bd)<=0.0001&&(ab-bd)>=-0.0001)&&((ab-cd)<=0.0001&&(ab-cd)>=-0.0001)&&((ad-bc)<=0.0001&&(ad-bc)>=-0.0001)){
            return true;
        }
        if(((ab-bc)<=0.0001&&(ab-bc)>=-0.0001)&&((ab-ad)<=0.0001&&(ab-ad)>=-0.0001)&&((ab-cd)<=0.0001&&(ab-cd)>=-0.0001)&&((ac-bd)<=0.0001&&(ac-bd)>=-0.0001)){
            return true;
        }
        if(((ad-ac)<=0.0001&&(ad-ac)>=-0.0001)&&((ad-bd)<=0.0001&&(ad-bd)>=-0.0001)&&((ad-bc)<=0.0001&&(ad-bc)>=-0.0001)&&((ab-cd)<=0.0001&&(ab-cd)>=-0.0001)){
            return true;
        }
        return false;
    }

}

