class Solution {
    public void moveZeroes(int[] nums) {
        //记录当前不为0的整数可以移动到的位置  初始时就是第一位,下标0
        int j = 0;
        for(int i = 0; i < nums.length; i++){

            if(nums[i] != 0){
                //当发现当前数字不为0且本身不在j的位置上。
                // 如果i = j 说明当前数不用挪动。
                if(i != j){
                    nums[j] = nums[i];
                    nums[i] = 0;
                   
                }
                //当前不为0整数交换完位置后,j往后挪一位，代表下一个可以放不为0整数的位置。
                j++;
            }
        }
    }
}