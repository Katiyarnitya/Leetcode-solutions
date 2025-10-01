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
   public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
      List<List<Integer>> result = new ArrayList<>();
      if (root == null) {
         return result;
      }
      Queue<TreeNode> Q = new LinkedList<>();
      boolean LeftToRight = true;
      Q.offer(root);
      while (!Q.isEmpty()) {
         int size = Q.size();
         List<Integer> row = new ArrayList<>();
         for (int i = 0; i < size; i++) {
            TreeNode node = Q.poll();
            if (LeftToRight) {
               row.add(node.val);
            } else {
               row.add(0, node.val);// 0 means insert at index 0 of the list.(It will Reverse the order)
            }

            if (node.left != null) {
               Q.offer(node.left);
            }
            if (node.right != null) {
               Q.offer(node.right);
            }
         }
         result.add(row);
         LeftToRight = !LeftToRight;

      }
      return result;
   }
}