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
   private int postIndex;
   private Map<Integer, Integer> inorderMap = new HashMap<>();

   public TreeNode buildTree(int[] inorder, int[] postorder) {
      for (int i = 0; i < inorder.length; i++) {
         inorderMap.put(inorder[i], i);
      }
      postIndex = postorder.length - 1;
      return helper(postorder, 0, inorder.length - 1);
   }

   public TreeNode helper(int[] postorder, int inStart, int inEnd) {
      if (inStart > inEnd) {
         return null;
      }
      int rootVal = postorder[postIndex--];
      int rootIndex = inorderMap.get(rootVal);
      TreeNode root = new TreeNode(rootVal);

      root.right = helper(postorder, rootIndex + 1, inEnd);
      root.left = helper(postorder, inStart, rootIndex - 1);

      return root;
   }
}