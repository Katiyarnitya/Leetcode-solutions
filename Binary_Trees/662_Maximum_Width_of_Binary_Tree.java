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
class Pair {
   TreeNode node;
   int idx;

   Pair(TreeNode node, int idx) {
      this.node = node;
      this.idx = idx;
   }
}

class Solution {
   public int widthOfBinaryTree(TreeNode root) {
      if (root == null)
         return 0;
      int maxWidth = 0;
      Queue<Pair> Q = new LinkedList<>();
      Q.offer(new Pair(root, 0));

      while (!Q.isEmpty()) {
         int size = Q.size();
         int levelMinIdx = Q.peek().idx;
         int first = 0;// index of the first node in that level
         int last = 0;// index of the last node in that level

         for (int i = 0; i < size; i++) {
            Pair currPair = Q.poll();
            TreeNode currNode = currPair.node;
            int idx = currPair.idx - levelMinIdx;

            if (i == 0) {
               first = idx;
            }
            if (i == size - 1) {
               last = idx;
            }
            if (currNode.left != null) {
               Q.offer(new Pair(currNode.left, 2 * idx + 1));
            }
            if (currNode.right != null) {
               Q.offer(new Pair(currNode.right, 2 * idx + 2));
            }
         }
         maxWidth = Math.max(maxWidth, last - first + 1);
      }
      return maxWidth;
   }
}