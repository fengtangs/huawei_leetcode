public class Beibao {
    /**
     * 动态规划获得结果
     * @param weights  物品的重量
     * @param values   物品的价值
     * @param bag_weight 背包的容量
     */
    public int zero_one_beibao(int[] weights,int [] values,int bag_weight){
        int n= weights.length;
        int[][]dp=new int[n][bag_weight+1];
        for (int i = weights[0]; i < n;  i++) {
                dp[0][i]=weights[0];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <=bag_weight; j++) {
                if(j<weights[i])dp[i][j]=dp[i-1][j];
                else {
                    dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-weights[i]]+values[i]);
                }
            }
        }
        return 0;
    }
}

