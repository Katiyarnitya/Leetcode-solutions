/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {

   public int downPathSum(TreeNode root, int[] maxPath) {
      if (root == null) {
         return 0;
      }
      int leftSum = Math.max(0, downPathSum(root.left, maxPath));
      int rightSum = Math.max(0, downPathSum(root.right, maxPath));

      maxPath[0] = Math.max(maxPath[0], root.val + leftSum + rightSum);

      return root.val + Math.max(leftSum, rightSum);

   }

   public int maxPathSum(TreeNode root) {
      int[] maxPath = new int[1];
      maxPath[0] = Integer.MIN_VALUE;
      downPathSum(root, maxPath);
      return maxPath[0];
   }
}