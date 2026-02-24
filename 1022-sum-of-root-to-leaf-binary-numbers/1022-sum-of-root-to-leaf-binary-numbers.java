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
    static int sum;
    StringBuilder sb;
    public void solve(TreeNode root){
        if(root==null) return;
        sb.append(root.val);
        if(root.left==null && root.right==null){
            int decimal = Integer.parseInt(sb.toString(),2);
            sum+=decimal;
            return;
        }
        solve(root.left);
        if(sb.length()>0){
            sb.deleteCharAt(sb.length() - 1);
        }
        solve(root.right);
        if(sb.length()>0){
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    public int sumRootToLeaf(TreeNode root) {
        sum=0;
        sb = new StringBuilder();
        solve(root);
        return sum;
    }
}