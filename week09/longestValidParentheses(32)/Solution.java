class Solution {
    /**
     * 最长有效括号
     * https://leetcode-cn.com/problems/longest-valid-parentheses/
     */
    public int longestValidParentheses(String s) {
         if (s == null || s.length() < 2){
            return 0;
         }
        int[] dp = new int[s.length()];
        int max = 0; 
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                int preLen = dp[i - 1]; 
                int pre = i - 1 - preLen; 

                if (pre >= 0 && s.charAt(pre) == '(') { 
                    dp[i] = dp[i-1] + 2; 
                    if (pre-1 >= 0) {
                        dp[i] += dp[pre-1];
                    }
                }
                max = Math.max(max, dp[i]);
            }
        }
        return max;
    }
}