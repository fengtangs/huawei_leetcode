package MeiTuan;

import java.util.*;

public class Main {
    static class Monster{
        long attack;
        long hp;
        public Monster (long attack,long hp){
            this.attack=attack;
            this.hp=hp;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long H = scanner.nextLong();
        long A = scanner.nextLong();

        long[] h = new long[n];
        long[] attack = new long[n];

        for (int i = 0; i < n; i++) {
            h[i] = scanner.nextLong();
        }

        for (int i = 0; i < n; i++) {
            attack[i] = scanner.nextLong();
        }
        Monster[] monsters=new Monster[n];
        for (int i = 0; i < n; i++) {
            monsters[i]=new Monster(attack[i],h[i]);
        }
        long res=0;

        //先按照血量来
        Arrays.sort(monsters, new Comparator<Monster>() {
            @Override
            public int compare(Monster o1, Monster o2) {
                if(o2.hp>= o1.hp){
                    return 1;
                }else{
                    return -1;
                }

            }
        });
        long nowhp=H;
        long nowattack=A;
        if(nowattack<monsters[0].attack||nowhp<monsters[0].hp){
            res=0;
        }else{
            for (int i = 0; i < n; i++) {
                if(nowattack>=monsters[i].attack&&nowhp>=monsters[i].hp){
                    nowhp=monsters[i].hp;
                    nowattack=monsters[i].attack;
                    res++;
                }
            }
        }


        //按照攻击力排序
        long res1=0;
        Arrays.sort(monsters, new Comparator<Monster>() {
            @Override
            public int compare(Monster o1, Monster o2) {
                if(o2.attack>= o1.attack){
                    return 1;
                }else{
                    return -1;
                }

            }
        });
        nowhp=H;
        nowattack=A;
        if(nowattack<monsters[0].attack||nowhp<monsters[0].hp){
            res1=0;
        }else{
            for (int i = 0; i < n; i++) {
                if(nowattack>=monsters[i].attack&&nowhp>=monsters[i].hp){
                    nowhp=monsters[i].hp;
                    nowattack=monsters[i].attack;
                    res1++;
                }
            }
        }
        System.out.println(Math.max(res,res1));





    }
}
