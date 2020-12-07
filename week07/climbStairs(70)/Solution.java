class Solution {
    /**
     * 爬楼梯(dp)
     * https://leetcode-cn.com/problems/climbing-stairs/submissions/
     */
    public int climbStairs(int n) {
        int[] dp = new int[n];
        // dp[i] = dp[i - 1] + dp[i - 2]
        if(n <= 2){
            return n;
        }
        dp[0] = 1;
        dp[1] = 2;
        for(int i = 2; i < n; i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n - 1];
    }


    /**
     * 爬楼梯(dp 简化空间复杂度)
     * https://leetcode-cn.com/problems/climbing-stairs/submissions/
     */
    public int climbStairs1(int n) {
        if(n <= 2){
            return n;
        }

        int f1 = 1, f2 = 2;

        for(int i = 3; i <= n; i++){
            int temp = f1 + f2;
            f1 = f2;
            f2 = temp;
        }

        return f2;
    }
}