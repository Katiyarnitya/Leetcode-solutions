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
   public void helper(TreeNode root, String path, List<String> list) {
      if (root == null)
         return;

      // If node is leaf, add the path
      if (root.left == null && root.right == null) {
         list.add(path + root.val);
         return;
      }

      if (root.left != null) {
         helper(root.left, path + root.val + "->", list);
      }
      if (root.right != null) {
         helper(root.right, path + root.val + "->", list);
      }
   }

   public List<String> binaryTreePaths(TreeNode root) {
      List<String> ans = new ArrayList<>();
      if (root == null) {
         return ans;
      }
      helper(root, "", ans);
      return ans;
   }
}