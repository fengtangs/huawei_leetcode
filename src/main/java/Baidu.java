import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Baidu {
    static List<List<Integer>> res =new ArrayList<>();




    public static void main(String[] args) {
        ArrayList<Integer> list =new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        dfs(list,new ArrayList<Integer>(),0);

        for (int i = 0; i < res.size(); i++) {
            if(res.get(i).get(0)<res.get(i).get(1)&&res.get(i).get(1)<res.get(i).get(2)){
                for (int j = 0; j < res.get(i).size(); j++) {

                    System.out.print(res.get(i).get(j)+",");
                }
                System.out.println();
            }

        }

    }

    private static void dfs(ArrayList<Integer> list, ArrayList<Integer> t,int index) {
        ArrayList<Integer> temp=new ArrayList<>(t);
        if(3==t.size()){
            res.add(temp);
        }
        for (int i = index; i <list.size(); i++) {
            if(temp.contains(list.get(i))){
                continue;
            }
            temp.add(list.get(i));
            dfs(list,temp,index+1);
            temp.remove(temp.size()-1);
        }
    }


    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0||lists==null) return null;
        return fenzhi(lists,0,lists.length-1);

    }
    public ListNode fenzhi(ListNode[] l,int start,int end){
        if(start==end) return l[start];
        int mid=start+(end-start)/2;
        ListNode l1=fenzhi(l,start,mid);
        ListNode l2=fenzhi(l,mid+1,end);
        return moerge_two(l1,l2);
    }

    public ListNode moerge_two(ListNode l1,ListNode l2){
        if(l1==null) return l2;
        if(l2==null) return l1;
        ListNode p1=l1;
        ListNode p2=l2;
        ListNode res=new ListNode();
        ListNode pre=res;
        while(p1!=null&&p1!=null){
            if(p1.val>p2.val){
                pre.next=p2;
                pre=pre.next;
                p2=p2.next;
            }else{
                pre.next=p1;
                pre=pre.next;
                p1=p1.next;
            }
        }
        while(p1!=null){
            pre.next=p1;
            pre=pre.next;
            p1=p1.next;
        }
        while(p2!=null){
            pre.next=p2;
            pre=pre.next;
            p2=p2.next;
        }
        pre.next=null;
        return res.next;
    }

}
