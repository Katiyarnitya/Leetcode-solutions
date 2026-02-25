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
    public int[] solve(TreeNode node){
        if(node==null){
            return new int[2];
        }
        int[] leftChoice = solve(node.left);
        int[] rightChoice = solve(node.right);

        int[] choice = new int[2];
        choice[0] = node.val+leftChoice[1] + rightChoice[1];
        choice[1] = 0 + Math.max(leftChoice[0],leftChoice[1]) + Math.max(rightChoice[0], rightChoice[1]);

        return choice;
    }
    public int rob(TreeNode root) {
        int[] choice  = solve(root);
        return Math.max(choice[0],choice[1]);
    }
}