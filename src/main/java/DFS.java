import java.util.*;

public class DFS {

    /**
     * https://leetcode.cn/problems/path-sum-ii/
     * 113. 路径总和 II
     * DFS&回溯：：LeetCode934、685、1102、531、533、113、332、337
     * @param root
     * @param targetSum
     * @return
     */
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> tmp=new ArrayList<>();
        int sum=0;
        huisu_1(res,tmp,root,targetSum,sum);
        return res;
    }

    private void huisu_1(List<List<Integer>> res, List<Integer> tmp, TreeNode root, int targetSum, int sum) {
        if(root==null){
            return ;
        }
        if(root.val+sum==targetSum&&root.left==null&&root.right==null){
            tmp.add(root.val);
            res.add(new ArrayList<>(tmp));
            tmp.remove(tmp.size()-1);
            return;
        }
        tmp.add(root.val);
        sum+= root.val;
        if(root.left!=null){
            huisu_1(res, tmp, root.left, targetSum, sum);
        }
        if(root.right!=null){
            huisu_1(res,tmp,root.right,targetSum,sum);
        }
        tmp.remove(tmp.size()-1);
        sum-= root.val;
    }
    /**
     * https://leetcode.cn/problems/house-robber-iii/
     *337. 打家劫舍 III
     * DFS&回溯：：LeetCode934、685、1102、531、533、113、332、337
     * @param root
     * @return
     */
    public int rob(TreeNode root) {
        /**
         * 思路，就是分为两种情况，第一种就是我选择当前节点，意味着不能选择当前节点的孩子，但是可以选择孩子的孩子，我们用f来表示选择当前节点
         * 第二种就是我们不选择选择当前节点，那么可以选择左右孩子，左右孩子可以选也可以不选，选择就成了第一类，不选择就成了第二类，我们用g来表示不选择当前节点
         * 递归
         * f(x)=x.val+g(x.left)_g(x.right)
         * g(x)=max(max(f(x.left),g(x.left))，max(f(x.right),g(x.right)))
         *
         */
        Map<TreeNode,Integer> f=new HashMap<>();

        Map<TreeNode,Integer>g=new HashMap<>();
        dfs(root,f,g);
        return Math.max(f.getOrDefault(root,0), g.getOrDefault(root,0));

    }

    private void dfs(TreeNode root, Map<TreeNode, Integer> f, Map<TreeNode, Integer> g) {
        if(root==null){
            return;
        }
        dfs(root.left,f,g);
        dfs(root.right, f, g);
        f.put(root, root.val+g.getOrDefault(root.left,0)+g.getOrDefault(root.right,0));
        g.put(root,Math.max(f.getOrDefault(root.left,0),g.getOrDefault(root.left,0))+Math.max(f.getOrDefault(root.right,0),g.getOrDefault(root.right,0)));
    }

    /**
     * https://leetcode.cn/problems/reconstruct-itinerary/
     *332. 重新安排行程
     * DFS&回溯：：LeetCode934、685、1102、531、533、113、332、337
     * @param tickets
     * @return
     */
    public List<String> findItinerary(List<List<String>> tickets) {
        List<List<String>> res=new ArrayList<>();
        List<String> tmp=new ArrayList<>();
        tmp.add("JFK");
        Collections.sort(tickets, Comparator.comparing(o -> o.get(1)));
        boolean[] used =new boolean[tickets.size()];
        huisu_2(res,tmp,tickets,used);
        return res.get(0);
    }

    private boolean huisu_2(List<List<String>> res, List<String> tmp, List<List<String>> tickets, boolean[] used) {
        if(tmp.size()==tickets.size()+1){
            res.add(new ArrayList<>(tmp));
            return true;
        }
        for (int i = 0; i < tickets.size(); i++) {
            if(!used[i]&&tickets.get(i).get(0).equals(tmp.get(tmp.size()-1))){
                used[i]=true;
                tmp.add(tickets.get(i).get(1));
                if(huisu_2(res, tmp, tickets, used)){
                    return true;
                }
                used[i]=false;
                tmp.remove(tmp.size()-1);


            }
        }
        return false;

    }


    /**
     * https://leetcode.cn/problems/redundant-connection-ii/
     *685. 冗余连接 II
     * DFS&回溯：：LeetCode934、685、1102、531、533、113、332、337
     * @param edges
     * @return
     */
    public int[] findRedundantDirectedConnection(int[][] edges) {
    return null;
    }

    /**
     * https://leetcode.cn/problems/shortest-bridge/
     * 934. 最短的桥
     * DFS&回溯：：LeetCode934、685、1102、531、533、113、332、337
     * @param grid
     * @return
     *
     * 这个还不会，先深度，再广度，第一次深度是为了找到一个岛屿，
     * 找到岛屿后，对岛屿最外围的水域进行遍历，一层一层遍历，每遍历一层，就会导致桥的长度+1，直到遍历到另外一个桥。
     */
    int[][] grid, coordinates = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}}; // 上、下、右、左四个方向
    Deque<int[]> edges; // 用户存储边缘格子
    public int shortestBridge(int[][] grid) {
    int res=0;
    this.edges=new ArrayDeque<>();
    this.grid=grid;
    boolean findisland=false;
        //找出第一个岛屿
        for (int i = 0; i < grid.length &&(!findisland); i++) {
            for (int j = 0; !findisland && j < grid[0].length; j++) {
                if(findisland==(grid[i][j]==1)){
                    markIsland(i,j);
                }
            }
        }

        //遍历队列，开始往外扩岛屿
        while (!edges.isEmpty()){
            res++;
            int num=edges.size();
            for (int i = 0; i < num; i++) {
                int[] tmp=edges.removeFirst();
                for (int [] c :coordinates) {
                    int x=tmp[0]+c[0],y=tmp[1]+c[1];
                    if (isLegal(x, y)) {
                        if(grid[x][y]==0){
                            edges.addLast(new int[]{x,y});
                            grid[x][y]=2;
                        } else if (grid[x][y]==1) {
                            return res;
                        }
                    }
                }
            }
        }
        return res;
    }
    public void markIsland(int row, int column) {
        if (!isLegal(row, column) || grid[row][column] == 2) {
            return;
        }
        if (grid[row][column] == 0) {
            grid[row][column] = 2; // 将边界向外扩展1层岛屿（val=2)
            edges.addLast(new int[]{row, column});
            return;
        }
        grid[row][column] = 2; // 为岛屿打标记（val=2）
        for (int[] c : coordinates){
            markIsland(row + c[0], column + c[1]); // 深度遍历某个格子的四个方向
        }
    }

    public boolean isLegal(int row, int column) {
        return row >= 0 && row < grid.length && column >= 0 && column < grid[0].length;
    }

}