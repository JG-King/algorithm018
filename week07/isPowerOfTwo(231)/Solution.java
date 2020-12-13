class Solution {
    /**
     * 2的幂
     * https://leetcode-cn.com/problems/power-of-two/
     * @param n
     * @return
     */
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & n - 1) == 0;
    }
}