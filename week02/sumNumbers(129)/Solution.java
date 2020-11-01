/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    /**
     *  求根到叶子节点数字之和
     *  https://leetcode-cn.com/problems/sum-root-to-leaf-numbers/
     *  时间复杂度 O(n)
     *  空间复杂度 O(n)
     *
     */
    public int sumNumbers(TreeNode root) {
        return dfs(root,0);
    }

    private int dfs(TreeNode root, int num){
        if(root == null){
            return 0;
        }

        int temp = num * 10 + root.val;
        if(root.left == null && root.right == null){
            return temp;
        }
        return dfs(root.left, temp) + dfs(root.right, temp);

    }

}