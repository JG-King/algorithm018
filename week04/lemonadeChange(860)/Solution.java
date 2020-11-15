class Solution {
    /**
     * 柠檬水找零
     * https://leetcode-cn.com/problems/lemonade-change/
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     */
    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;

        for(int i : bills){
            if(i == 5){
                five++;
            }else if(i == 10){
                ten++;
                five--;
            }else if(ten > 0){
                ten--;
                five--;
            }else{
                five-=3;
            }
            if(five < 0){
                return false;
            }
        }
        return true;

    }
}