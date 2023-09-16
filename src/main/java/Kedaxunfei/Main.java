package Kedaxunfei;
import java.util.*;

public class Main {
    static class Person{
        int yewu;
        int goutong;
        int index;
        public Person(int a,int b,int c){
            yewu=a;
            goutong=b;
            index=c;
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Person []person=new Person[n];
        int yewu=0;
        int goutong=0;
        for (int i = 0; i <n ; i++) {

                int t1= in.nextInt();
                int t2= in.nextInt();
                person[i]=new Person(t1,t2,i+1);
                yewu+=person[i].yewu;
                goutong+=person[i].goutong;
        }
        Arrays.sort(person, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                if(o1.yewu==o2.yewu){
                    return o1.goutong-o2.goutong;
                }else{
                    return o1.yewu-o2.yewu;
                }
            }
        });
        if(yewu%2!=0||goutong%2!=0){
            System.out.println(-1);
            return;
        }
        yewu/=2;
        goutong/=2;
        ArrayList<Integer> firstgroup=new ArrayList<>();
        ArrayList<Integer>secondgroup=new ArrayList<>();
        secondgroup.add(person[n-1].index);
        yewu-=person[n-1].yewu;
        goutong-=person[n-1].goutong;
        if(yewu==0&&goutong==0){
            for (int i = 0; i < n-1; i++) {
                firstgroup.add(person[i].index);
            }
            System.out.println(firstgroup.size()+" "+secondgroup.size());
            Collections.sort(firstgroup);
            Collections.sort(secondgroup);
            for (int i = 0; i < firstgroup.size(); i++) {
                if(i==firstgroup.size()-1){
                    System.out.println(firstgroup.get(i));
                }else{
                    System.out.print(firstgroup.get(i)+" ");
                }

            }
            for (int i = 0; i < secondgroup.size(); i++) {
                if(i==secondgroup.size()-1){
                    System.out.println(secondgroup.get(i));
                }else{
                    System.out.print(secondgroup.get(i)+" ");
                }

            }
        } else if (yewu<=0||goutong<=0) {
            System.out.println(-1);
        }else{

            boolean flag=false;
            int index=n-2;
            if(index<0){
                System.out.println(-1);
            }
            firstgroup.add(person[index--].index);
            int times=1;
            while(index>=0){
                if(flag&&yewu>0&&goutong>0){
                    secondgroup.add(person[index].index);
                    yewu-=person[index].yewu;
                    goutong-=person[index].goutong;
                    if(times==2){
                        times=1;
                    }else{
                        flag=false;
                        times++;
                    }

                }
                else {
                    firstgroup.add(person[index].index);
                    if(times==2){
                        times=1;
                    }else{
                        flag=true;
                        times++;
                    }
                }

                index--;
                if(yewu<0||goutong<0){
                    System.out.println(-1);
                    return;
                }
            }
            System.out.println(firstgroup.size()+" "+secondgroup.size());
            Collections.sort(firstgroup);
            Collections.sort(secondgroup);
            for (int i = 0; i < firstgroup.size(); i++) {
                if(i==firstgroup.size()-1){
                    System.out.println(firstgroup.get(i));
                }else{
                    System.out.print(firstgroup.get(i)+" ");
                }

            }
            for (int i = 0; i < secondgroup.size(); i++) {
                if(i==secondgroup.size()-1){
                    System.out.println(secondgroup.get(i));
                }else{
                    System.out.print(secondgroup.get(i)+" ");
                }

            }

        }
    }
}


//
//public class Main {
//
//    public static void main(String[] args) {
//
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int k= in.nextInt();
//
//        if(k==n){
//            for (int i = 1; i <=n ; i++) {
//                if(i==n){
//                    System.out.print(i);
//                }else{
//                    System.out.print(i+" ");
//                }
//
//            }
//
//        }
//        else{
//            int t=n;
//            for (int i = 1; i <=n-k ; i++) {
//                System.out.print(t--+" ");
//            }
//            for (int i = 1; i <=k ; i++) {
//                if(i!=k){
//                    System.out.print(i+" ");
//                }else{
//                    System.out.print(i);
//                }
//
//            }
//        }
//
//
//    }
//
//}
