public class Solution {
    /**
     * 位1的个数
     * https://leetcode-cn.com/problems/number-of-1-bits/
     * @param n
     * @return
     */
    public int hammingWeight(int n) {
        int num = 0;
        while(n != 0){
            num++;
            n = n & (n - 1);
        }
        return num;
    }
}