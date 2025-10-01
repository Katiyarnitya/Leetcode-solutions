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
   public void markParents(TreeNode root, Map<TreeNode, TreeNode> parentMap) {
      Queue<TreeNode> queue = new LinkedList<>();
      queue.offer(root);
      while (!queue.isEmpty()) {
         TreeNode node = queue.poll();
         if (node.left != null) {
            parentMap.put(node.left, node);
            queue.offer(node.left);
         }
         if (node.right != null) {
            parentMap.put(node.right, node);
            queue.offer(node.right);
         }
      }
   }

   public int amountOfTime(TreeNode root, int start) {

      // Marking parents
      Map<TreeNode, TreeNode> parentMap = new HashMap<>();
      markParents(root, parentMap);

      // Finding the startNode
      TreeNode startNode = null;
      Queue<TreeNode> search = new LinkedList<>();
      search.offer(root);
      while (!search.isEmpty()) {
         TreeNode curr = search.poll();
         if (curr.val == start) {
            startNode = curr;
         }
         if (curr.left != null) {
            search.offer(curr.left);
         }
         if (curr.right != null) {
            search.offer(curr.right);
         }
      }

      // BFS Traversal in order to find the time
      Queue<TreeNode> BFS = new LinkedList<>();
      Set<TreeNode> visited = new HashSet<>();
      BFS.offer(startNode);
      visited.add(startNode);

      int minutes = -1;

      while (!BFS.isEmpty()) {
         int size = BFS.size();
         minutes++; // Inc. at start of each level
         // infectedThisMinute variable can also be used to track the changes

         for (int i = 0; i < size; i++) {
            TreeNode curr = BFS.poll();
            // Now spread out for that current node
            // Left->Curr's left is not null and it is not visited then add in Queue and set
            if (curr.left != null && !visited.contains(curr.left)) {
               BFS.offer(curr.left);
               visited.add(curr.left);
            }
            // Right->Curr's right is not null and it is not visited then add in Queue and
            // set
            if (curr.right != null && !visited.contains(curr.right)) {
               BFS.offer(curr.right);
               visited.add(curr.right);
            }
            // Parent
            if (parentMap.containsKey(curr) && !visited.contains(parentMap.get(curr))) {
               BFS.offer(parentMap.get(curr));
               visited.add(parentMap.get(curr));
            }
         }
      }
      return minutes;
   }
}