public abstract class Mother {
    public int getAge() { return 45; }
    public abstract class Son {
        public int getAge() { return 38; }
    }

    public static void main(String[] args) {
        int[] da1 = new int[]{1, 3, 5};
        int[] da2 = new int[]{2, 4, 6};
        System.out.println(da1);
        System.out.println(da2);
        System.out.println(da2[da1[0]]);
        interchange(da1, da2);
        System.out.println(da1);
        System.out.println(da2);
        System.out.println(da1[da2[0]]);
    }
    static void interchange(int[] da1, int[] da2) {
//        int[] dat = da1;
//        System.out.println(dat);
//        da1 = da2;
//        da2 = dat;
        for (int i = 0; i <3; i++) {
            int t=da1[i];
            da1[i]=da2[i];
            da2[i]=t;
        }

        System.out.println(da1);
        System.out.println(da2);
    }

}
