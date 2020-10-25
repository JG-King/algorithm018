class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        //从后往前对比。

        int p1 = m - 1;
        int p2 = n - 1;
        int p = m + n - 1;

        while(p1 >= 0 && p2 >= 0){
            if(nums1[p1] <= nums2[p2]){
                nums1[p] = nums2[p2];
                p2--;
            }else{
                nums1[p] = nums1[p1];
                p1--;
            }
            p--;
        }

        //把num2 剩余数据拷贝到num1头部
         System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
        



    }
}