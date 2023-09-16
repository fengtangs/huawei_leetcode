

import java.util.*;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static int maxtime(int[]tasks,int fenge,int xiaobainum,int xiaomingnum){
        ArrayList<Integer> xiaomi=new ArrayList<>();
        ArrayList<Integer> xiaobai=new ArrayList<>();

        for (int i = 0; i <tasks.length ; i++) {
                    if(i<fenge){
                        xiaomi.add(tasks[i]);
                    }else{
                        xiaobai.add(tasks[i]);
                    }
        }
        Collections.sort(xiaomi);
        Collections.sort(xiaobai);
        int maxxiaoming=0;
        int maxxiaobai=0;
        for (int i = 0; i <xiaomingnum ; i++) {
            maxxiaoming+=xiaomi.get(i);
        }
        for (int i = 0; i <xiaobainum ; i++) {
            maxxiaobai+=xiaobai.get(i);
        }
        return Math.max(maxxiaobai,maxxiaoming);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T=in.nextInt();
        while (T>0){
            T--;
            int n = in.nextInt();
            int k = in.nextInt();
            int[] tasks=new int[n];
            for (int i = 0; i < n; i++) {
                tasks[i]=in.nextInt();
            }
            int mintime=Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j <= k; j++) {
                    int xiaomingnum=j;
                    int xiaobainum=k-j;
                    if(xiaomingnum>i||xiaobainum>(n-i)){
                        continue;
                    }
                    else{
                        mintime=Math.min(mintime,maxtime(tasks,i,xiaobainum,xiaomingnum));
                    }
                }
            }

            System.out.println(mintime);
        }
    }
}

//import java.util.*;
//
//public class Main {
//    static class Friend {
//        int level;
//        int num;
//
//        public Friend(int a, int b) {
//            level = a;
//            num = b;
//        }
//    }
//        public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int k = in.nextInt();
//        Friend[] friends=new Friend[n];
//        for (int i = 0; i < n; i++) {
//            int level=in.nextInt();
//            int num= in.nextInt();
//            friends[i]=new Friend(level,num);
//        }
//        int res=0;
//        Arrays.sort(friends, new Comparator<Friend>() {
//            @Override
//            public int compare(Friend o1, Friend o2) {
//                return o1.level-o2.level;
//            }
//        });
//        for (int i = 0; i < n; i++) {
//            int nowmax=friends[i].num;
//            int nowmaxnum=k+friends[i].level;
//            for (int j = i+1; j < n; j++) {
//                if(friends[j].level<=nowmaxnum){
//                    nowmax+=friends[j].num;
//                }
//                else{
//                    res=Math.max(res,nowmax);
//                }
//            }
//
//        }
//        System.out.println(res);
//        }
//
//}




//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Scanner;
//
//// 注意类名必须为 Main, 不要有任何 package xxx 信息
//public class Main {
//    public static  String get_substr (String st) {
//        // write code here
//        boolean flag=true;
//        StringBuffer s=new StringBuffer(st);
//        while (flag){
//            flag=false;
//            StringBuffer tmp=new StringBuffer();
//            int nownums=1;
//            char pre=s.charAt(0);
//            for (int i = 1; i <s.length() ; i++) {
//                if(pre==s.charAt(i)){
//                    nownums++;
//                }else{
//                    if(nownums<3){
//                        while (nownums>0){
//                            tmp.append(pre);
//                            nownums--;
//                        }
//
//                        pre=s.charAt(i);
//                        nownums=1;
//
//                    }else{
//                        flag=true;
//                        pre=s.charAt(i);
//                        nownums=1;
//                    }
//                }
//            }
//            if(nownums<3){
//                while (nownums>0){
//                    tmp.append(pre);
//                    nownums--;
//                }
//
//
//            }else{
//                flag=true;
//            }
//            s=tmp;
//
//        }
//        return s.toString();
//
//    }
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        String st = in.next();
//        System.out.println(get_substr(st));
//
//    }
//}