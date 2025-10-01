/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
   public void markParents(TreeNode root, Map<TreeNode, TreeNode> parent_track) {
      Queue<TreeNode> Q = new LinkedList<>();
      Q.offer(root);
      while (!Q.isEmpty()) {
         TreeNode currNode = Q.poll();
         if (currNode.left != null) {
            parent_track.put(currNode.left, currNode);
            Q.offer(currNode.left);
         }
         if (currNode.right != null) {
            parent_track.put(currNode.right, currNode);
            Q.offer(currNode.right);
         }
      }
   }

   public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
      List<Integer> ans = new ArrayList<>();
      if (root == null) {
         return ans;
      }
      // Mark parents for each node in a tree
      Map<TreeNode, TreeNode> track_parents = new HashMap<>();
      markParents(root, track_parents);

      Set<TreeNode> visited = new HashSet<>();// Set to keep track of elements visited or not
      visited.add(target);
      Queue<TreeNode> Q = new LinkedList<>();
      Q.offer(target);

      int dist = 0;

      while (!Q.isEmpty()) {
         int size = Q.size();
         if (dist == k) {
            break;
         }
         for (int i = 0; i < size; i++) {
            TreeNode curr = Q.poll();

            // LeftChild
            if (curr.left != null && !visited.contains(curr.left)) {
               Q.offer(curr.left);
               visited.add(curr.left);
            }
            // Right child
            if (curr.right != null && !visited.contains(curr.right)) {
               Q.offer(curr.right);
               visited.add(curr.right);
            }
            if (track_parents.containsKey(curr) && !visited.contains(track_parents.get(curr))) {
               Q.offer(track_parents.get(curr));
               visited.add(track_parents.get(curr));
            }
         }
         dist++;
      }
      while (!Q.isEmpty()) {
         ans.add(Q.poll().val);
      }
      return ans;
   }
}