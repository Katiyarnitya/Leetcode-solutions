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
    public int getHeight(TreeNode root){
        if(root==null){
            return 0;
        }
        int l_ht = getHeight(root.left);
        int r_ht = getHeight(root.right);

        if(l_ht==-1 || r_ht==-1){
            return -1;
        }
        if(Math.abs(l_ht-r_ht)>1){
            return -1;
        }
        return 1+Math.max(l_ht,r_ht);
    }
    public boolean isBalanced(TreeNode root) {
        // For every node, height(left_subtree)-height(right_subtree)<=1
        int ht = getHeight(root);
        if(ht==-1){
            return false;
        }
        return true;
    }
}