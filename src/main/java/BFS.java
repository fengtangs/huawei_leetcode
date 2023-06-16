import javax.lang.model.element.NestingKind;
import java.util.*;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.ConcurrentHashMap;

public class BFS {


    /**
     * https://leetcode.cn/problems/shortest-path-in-binary-matrix/
     * @param grid
     * @return
     */
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid==null||grid.length==0||grid[0].length==0){
            return -1;
        }
        if(grid[0][0]==1){
            return -1;
        }

        int m=grid.length;
        int n=grid[0].length;
        int [][]dir=new int[][]{{1, -1}, {1, 0}, {1, 1}, {0,-1},{0,1},{-1,-1},{-1,0},{-1,1}};

        Queue<int []> queue=new LinkedList<>();
        queue.add(new int[]{0,0});
        grid[0][0]=1;
        int path=1;
        while(queue.isEmpty()){
            int size=queue.size();
            while(size-->0){
                int[] cur = queue.poll();
                int x  = cur[0];
                int y  = cur[1];

                //能放进队列里的都是为0可以走的（这一点在后面保证了）
                // 如果等于终点则返回
                if (x == m-1 && y == n-1){    //
                    return path;
                }

                //开始八个方向的判断
                for (int[] d : dir){
                    int x1 = x + d[0];
                    int y1 = y + d[1];
                    //这里开始过滤
                    if (x1 < 0 || x1 >= m || y1 < 0||y1>=n || grid[x1][y1]==1){
                        continue;
                    }
                    //把在数组范围内 并且为0不阻塞的放入队列中
                    queue.add(new int[]{x1,y1});
                    grid[x1][y1] = 1; // 标记
                }
            }
            path++;  //遍历完一层 这时候要 ++啦


        }

        return -1;
    }

    /**
     * BFS：LeetCode127、139、130、529、815
     *130. 被围绕的区域
     * https://leetcode.cn/problems/surrounded-regions/
     * @param board
     * 思路是这个样子的，因为跟边上相连的O不能算，所以，我们首先用 dfs方法将与边上相连的O都变成-，然后，我们就可以把矩阵中的O都变成X，最后，再把-变回O。
     */
    public void solve(char[][] board) {
        if(board==null||board.length==0){
            return;
        }
        int row=board.length,col=board[0].length;

        for (int i = 0; i < row; i++) {
            dfs(board,i,0);
            dfs(board,i,col-1);
        }
        for (int i = 0; i < col; i++) {
            dfs(board,0,i);
            dfs(board,row-1,i);
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(board[i][j]=='O'){
                    board[i][j]='X';
                }
                else if(board[i][j]=='-'){
                    board[i][j]='O';
                }
            }
        }

        return ;

    }

    private void dfs(char[][] board, int i, int j) {
        if(i<0||j<0||i>=board.length||j>= board[0].length||board[i][j]!='O'){
            return ;
        }
        board[i][j]='-';
        dfs(board,i-1,j);
        dfs(board,i+1,j);
        dfs(board,i,j-1);
        dfs(board,i,j+1);
        return ;
    }


    /**
     * https://leetcode.cn/problems/word-break/
     *  BFS：LeetCode127、139、130、529、815
     *  139. 单词拆分
     *用dp的方法
     * dp[i]表示，字符串s的前i个串可以被字典中的数据表示。
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        int length=s.length();
        int maxlengthindict=0;
        Set<String> set=new HashSet<>();

        boolean [] dp=new boolean[length+1];
        dp[0]=true;
        for (String t:wordDict) {
          set.add(t);
          maxlengthindict=Math.max(maxlengthindict,t.length());
        }

        for (int i = 1; i < length+1; i++) {
            for (int j = i; j >=0 &&j>=i-maxlengthindict ; j--) {
                if(dp[j]&&set.contains(s.substring(j,i))){
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[length];

    }
    /**
     * https://leetcode.cn/problems/minesweeper/
     *  BFS：LeetCode127、139、130、529、815
     *  529. 扫雷游戏
     *
     */
    int [][]dic=new int[][]{{1,0},{-1,0},{0,-1},{0,1},{1,-1},{-1,-1},{1,1},{-1,1}};
    public char[][] updateBoard(char[][] board, int[] click) {
        int x=click[0],y=click[1];
        if (board[x][y]=='M'){
            //挖到了地雷，结束游戏
            board[x][y]='X';
            return board;
        }
        else {
            dfs_saolei(board,x,y);
        }
        return board;
    }

    private void dfs_saolei(char[][] board, int x, int y) {
        int cnt=0;
        int row=board.length;
        int col= board[0].length;
        for (int[] t: dic) {
            int t_x=x+t[0],t_y=y+t[1];
            if(isLegal(row,col,t_x,t_y)){
                if(board[t_x][t_y]=='M'){
                    ++cnt;
                }
            }
        }

        if(cnt>0){//规则3
            board[x][y]=(char)(cnt+'0');
        }else {
            //规则2
            board[x][y]='B';
            for (int[] t : dic) {
                int t_x=x+t[0],t_y=y+t[1];
                if(isLegal(row,col,t_x,t_y)){
                    if(board[t_x][t_y]=='E'){   //只有这里是没有揭露过的，才能继续dfs。
                       dfs_saolei(board,t_x,t_y);
                    }
                }
            }

        }

    }
    public boolean isLegal(int x_l,int y_l, int x, int y){
        if(x<0||y<0||x>=x_l||y>=y_l){
            return false;
        }
        return true;
    }


    /**
     * https://leetcode.cn/problems/word-ladder/
     *127. 单词接龙
     *BFS：LeetCode127、139、130、529、815
     * 困难
     *我这种方法超时
     * 因为相当用我用了dfs
     * 正解使用BFS
     * BFS要想到用队列
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int res=wordList.size()+1;
        boolean f=false;
        for (int i = 0; i < wordList.size(); i++) {
            if(endWord.equals(wordList.get(i))){
                f=true;
                break;
            }
        }
        if(!f) return 0;
        List<List<String>> res_list=new ArrayList<>();
        List<String> tmp=new ArrayList<>();
        boolean [] used = new boolean[wordList.size()+1];
        tmp.add(beginWord);
        huisu_jielong(res_list,tmp,used,beginWord,endWord,wordList);

        if(res_list.size()==0) return 0;
        for (int i = 0; i < res_list.size(); i++) {
            if(res>res_list.get(i).size()){
                res=res_list.get(i).size();
            }
        }
        return res;
    }

    private void huisu_jielong(List<List<String>> resList, List<String> tmp, boolean[] used, String beginWord, String endWord, List<String> wordList) {
    if(beginWord.equals(endWord)){
        tmp.add(beginWord);
        resList.add(new ArrayList<>(tmp));
        tmp.remove(tmp.size()-1);
    }
        for (int i = 0; i < wordList.size(); i++) {
            if(!used[i]&&Legal(beginWord,wordList.get(i))){
                tmp.add(wordList.get(i));
                beginWord=wordList.get(i);
                used[i]=true;
                huisu_jielong(resList, tmp, used, beginWord, endWord, wordList);
                used[i]=false;
                tmp.remove(tmp.size()-1);
                beginWord=tmp.get(tmp.size()-1);

            }
        }
        return;

    }

    private boolean Legal(String beginWord, String s) {
        int t=0;
        if(beginWord.length()!=s.length()) return false;
        for (int i = 0; i < beginWord.length(); i++) {
            if(beginWord.charAt(i)!=s.charAt(i)){
                t++;
            }
            if(t>=2){
                return false;
            }
        }
        if(t<=1) return true;
        return false;
    }

    /**
     * https://leetcode.cn/problems/word-ladder/
     *127. 单词接龙
     *BFS：LeetCode127、139、130、529、815
     * 困难
     * 正解使用BFS
     * BFS要想到用队列
     * 我用队列进行bfs遍历，一层一层的，一层就是当前beginword变换一步能到达的所有的单词情况。
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength_1(String beginWord, String endWord, List<String> wordList) {
        int res=0;
        boolean f=false;
        for (int i = 0; i < wordList.size(); i++) {
            if(endWord.equals(wordList.get(i))){
                f=true;
                break;
            }
        }
        if(!f) return 0;
        Queue<String> tmp=new ArrayDeque();
        boolean[] used=new boolean[wordList.size()];
        tmp.add(beginWord);
        while (!tmp.isEmpty()){
            res++;
            int size=tmp.size();
            while(size>0){
                size--;
                String bstring=tmp.poll();
                if(bstring.equals(endWord)) return res;
                for (int i = 0; i < wordList.size(); i++) {
                    if(!used[i]&&Legal(bstring,wordList.get(i))){
                        tmp.add(wordList.get(i));
                        used[i]=true;
                    }
                }
            }
        }
        return 0;
    }


    /**
     * https://leetcode.cn/problems/bus-routes/
     * 815. 公交路线
     *BFS：LeetCode127、139、130、529、815
     * 困难
     *
     * 终于A了，
     * 非常容易理解的算法。
     * BFS算法，首先使用map记录每一站都有哪些公交车能够到达。
     * 然后使用used数组记录这个车辆是否被使用过。
     * 然后先将始发站对应的车辆加入队列
     * 进行循环，
     * 如果队列不为空，那么取出队列里存放的车辆
     * 遍历车辆，如果这个车没有使用过，就把这个车辆能到达的站点进行遍历，
     * 每遍历一个站点，就从map中取出能到达这个站点的车辆加入队列。
     * 如果遍历的这个站点正好是目的地，就结束。
     *
     * 如果队列空了还没有到达目的地，就返回-1

     * @param routes
     * @param source
     * @param target
     * @return
     */
    public int numBusesToDestination(int[][] routes, int source, int target) {
        int res=0;
        //特殊情况处理
        if(source==target) return 0;
        //used数组，判断车辆是否做过
        boolean[]used=new boolean[routes.length];
        //map映射，key为站点，value为能够到达该站点的所有车辆
        Map<Integer,List<Integer>>map=new HashMap<>();
            for (int i = 0; i < routes.length; i++) {
                for (int j = 0; j < routes[i].length; j++) {
                    int xianlu=routes[i][j];
                    if(map.containsKey(xianlu)){
                        List<Integer> t=map.get(xianlu);
                        t.add(i);
                        map.put(xianlu,t);
                    }else{
                        List<Integer> t=new ArrayList<>();
                        t.add(i);
                        map.put(xianlu,t);
                    }

                }
        }
            //queue bfs使用
       Queue<List<Integer>> queue=new ArrayDeque<>();
            //将始发站的车辆加入
       queue.add(map.get(source));
       while(!queue.isEmpty()){
           res++;
           int size=queue.size();
           //遍历这一“层”
           while (size>0){
               size--;
               //取出车辆信息
               List<Integer> t= queue.poll();

               for (int i = 0; i < t.size(); i++) {
                   int carid=t.get(i);
                   //如果这个车还没有做过
                   if(!used[carid]){
                       //遍历这个车能到达的站点
                       for (int j = 0; j < routes[carid].length; j++) {
                           //如果站点为目的地，就返回，说明到了
                           if(routes[carid][j]==target){
                               return res;
                           }
                           //否则就将能够到达这个站点的车辆加入队列
                           queue.add(map.get(routes[carid][j]));
                       }
                       //标记车辆，做过了
                       used[carid]=true;
                   }
               }

           }
       }
       return -1;

    }


    /**
     * https://leetcode.cn/problems/number-of-islands/
     * 200. 岛屿数量
     * 并查集：LeetCode547、200、684
     * 遍历这个数组，碰到1，就递归遍历这个周围的，把相邻的1都变成2，同时岛屿数量++；
     * @param grid
     * @return
     */

    int [][] d_index=new int[][]{{1,0},{-1,0},{0,-1},{0,1}};
    public int numIslands(char[][] grid) {
        int res=0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j]=='1'){
                    res++;
                    dfs_gaoyu(grid,i,j);
                }
            }
        }
        return res;

    }

    private void dfs_gaoyu(char[][] grid, int i, int j) {
        for (int[] c: d_index) {
            if(is_legal(grid,grid.length,grid[0].length,i+c[0],j+c[1])){
                grid[i+c[0]][j+c[1]]='2';
                dfs_gaoyu(grid, i+c[0], j+c[1]);
            }
        }
    }

    public boolean is_legal(char[][]grid ,int row,int col,int x,int y){
        if(x<0||y<0||x>=row||y>=col||grid[x][y]!='1'){
            return false;
        }
        return true;
    }

    /**
     * https://leetcode.cn/problems/number-of-provinces/
     *547. 省份数量
     * 并查集：LeetCode547、200、684
     * 感觉还是dFS
     * @param isConnected
     * @return
     */

    public int findCircleNum(int[][] isConnected) {
        int res=0;
        int n=isConnected.length;
        boolean[] used=new boolean[n];
        for (int i = 0; i < n; i++) {
            if(!used[i]){
                res++;
                dfs_sheng(isConnected,used,i,n);

            }

        }
        return res;
    }

    private void dfs_sheng(int[][] isConnected, boolean[] used, int i, int n) {
        for (int j = 0; j < n; j++) {
            if(!used[j]&&isConnected[i][j]==1){
               used[j]=true;
               dfs_sheng(isConnected,used,j,n);
            }
        }

    }

    /**
     * https://leetcode.cn/problems/redundant-connection/
     *684. 冗余连接
     * 并查集：LeetCode547、200、684
     * @param edges
     * @return
     */
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        int[]num=new int[n+1];
        //初始化连通分量
        for (int i = 1; i <=n; i++) {
            num[i]=i;
        }

        //开始遍历边
        for (int i = 0; i < n; i++) {
           int start=edges[i][0],end=edges[i][1];
           while(num[start]!=start){
               start=num[start];
           }

           while(num[end]!=end){
               end=num[end];
           }
           if(start==end) return edges[i];
           num[start]=end;
           num[end]=end;

        }
        return new int[]{0,0};
    }




    public static void main(String[] args) {
        BFS bfs=new BFS();
//            Queue<String> list=new ArrayDeque();
        List<String> list=new ArrayList<String >();
        list.add("hot");
        list.add("dot");
        list.add("dog");
        list.add("lot");
        list.add("log");
        list.add("cog");

        bfs.numBusesToDestination(new int[][]{{7,12},{4,5,15},{6},{15,19},{9,12,13}
            },15,12);
//        bfs.ladderLength_1( "hit",
//                "cog", list);

    }

}
