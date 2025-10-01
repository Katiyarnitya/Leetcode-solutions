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
   public List<List<Integer>> verticalTraversal(TreeNode root) {
      List<List<Integer>> result = new ArrayList<>();
      if (root == null)
         return result;

      // Map: col -> list of (row, val)
      Map<Integer, List<int[]>> columnTable = new HashMap<>();
      int minCol = 0, maxCol = 0;

      // Queue stores: node, row, col
      Queue<int[]> queue = new LinkedList<>(); // {row, col, nodeVal}
      Queue<TreeNode> nodeQueue = new LinkedList<>();

      nodeQueue.offer(root);
      queue.offer(new int[] { 0, 0 }); // row=0, col=0
      minCol = maxCol = 0;

      Map<TreeNode, int[]> nodePos = new HashMap<>();
      nodePos.put(root, new int[] { 0, 0 }); // row, col

      int row = 0;
      while (!nodeQueue.isEmpty()) {
         int size = nodeQueue.size();
         List<int[]> tempList = new ArrayList<>();

         for (int i = 0; i < size; i++) {
            TreeNode node = nodeQueue.poll();
            int[] pos = nodePos.get(node);
            int r = pos[0], c = pos[1];

            tempList.add(new int[] { r, node.val }); // store row and value

            minCol = Math.min(minCol, c);
            maxCol = Math.max(maxCol, c);

            if (node.left != null) {
               nodeQueue.offer(node.left);
               nodePos.put(node.left, new int[] { r + 1, c - 1 });
            }
            if (node.right != null) {
               nodeQueue.offer(node.right);
               nodePos.put(node.right, new int[] { r + 1, c + 1 });
            }

            columnTable.computeIfAbsent(c, k -> new ArrayList<>()).add(new int[] { r, node.val });
         }
      }

      // Collect columns
      for (int c = minCol; c <= maxCol; c++) {
         List<int[]> list = columnTable.get(c);
         Collections.sort(list, (a, b) -> {
            if (a[0] != b[0])
               return a[0] - b[0]; // row ascending
            return a[1] - b[1]; // val ascending
         });

         List<Integer> colList = new ArrayList<>();
         for (int[] pair : list) {
            colList.add(pair[1]);
         }
         result.add(colList);
      }

      return result;
   }
}