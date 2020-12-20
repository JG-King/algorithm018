class Solution {
    /**
     * 验证回文字符串 Ⅱ
     * https://leetcode-cn.com/problems/valid-palindrome-ii/
     */
    public boolean validPalindrome(String s) {
        char[] ch = s.toCharArray(); 
        int l = 0, r = ch.length - 1;
        while(l < r){
            if(ch[l] != ch[r]){
                return isPalindrome(ch, l + 1, r) || isPalindrome(ch, l, r - 1);
            }
            l++;
            r--;
        }
        return true;
    }

    private boolean isPalindrome(char[] ch, int l, int r){
        while(l < r){
            if(ch[l] != ch[r]){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

}