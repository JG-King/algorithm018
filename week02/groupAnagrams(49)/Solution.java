class Solution {
    /**
     * 字母异位词分组
     * https://leetcode-cn.com/problems/group-anagrams/
     * 时间复杂度：for O(N)+ 排序 O(K log K) = O(NKlogK)
     * 空间复杂度 O(NK)
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for(String str : strs){
            char[] strsArr = str.toCharArray();
            Arrays.sort(strsArr);
            String key = new String(strsArr);
            if(!map.containsKey(key)){
                map.put(key,new ArrayList<String>());
            }
            map.get(key).add(str);
        }
        return new ArrayList(map.values());
    }
}