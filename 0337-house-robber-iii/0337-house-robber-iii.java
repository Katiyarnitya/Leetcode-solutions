/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int[] solve(TreeNode root){
        if(root==null) return new int[2];
        
        int[] leftChoice = solve(root.left);
        int[] rightChoice = solve(root.right);

        int[] choice = new int[2];
        choice[0] = root.val + leftChoice[1] + rightChoice[1];
        choice[1] = Math.max(leftChoice[0],leftChoice[1]) + Math.max(rightChoice[0],rightChoice[1]);

        return choice;
    }
    public int rob(TreeNode root) {
        int[] ans = solve(root);
        return Math.max(ans[0],ans[1]);
    }
}