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
   public List<Integer> helper(TreeNode root, int level, List<Integer> list) {
      // We will do preorder in reverse dir. i.e Root-> Right -> Left
      if (root == null) {
         return list;
      }
      if (level == list.size()) {
         list.add(root.val);
      }
      helper(root.right, level + 1, list);
      helper(root.left, level + 1, list);
      return list;
   }

   public List<Integer> rightSideView(TreeNode root) {
      List<Integer> ans = new ArrayList<>();
      helper(root, 0, ans);
      return ans;
   }
}