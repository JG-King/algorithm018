class Solution {
    /**
     * 有效的字母异位词
     * https://leetcode-cn.com/problems/valid-anagram/
     * 时间复杂度 O(n)
     * 空间复杂度O(1)
     */
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        int[] arr = new int[26];
        for(int i = 0; i < s.length(); i++){
            arr[s.charAt(i) - 'a']++;
            arr[t.charAt(i) - 'a']--;
        }
        for(int num : arr){
            if(num != 0){
                return false;
            }
        }
        return true;

    }
}