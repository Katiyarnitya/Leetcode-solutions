/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

   // Encodes a tree to a single string.
   public String serialize(TreeNode root) {
      StringBuilder sb = new StringBuilder();
      if (root == null) {
         return "";
      }
      Queue<TreeNode> Q = new LinkedList<>();
      Q.offer(root);
      while (!Q.isEmpty()) {
         TreeNode node = Q.poll();

         if (node == null) {
            sb.append("# ");
            continue;
         }
         // If node is not null
         sb.append(node.val + " ");
         Q.offer(node.left);
         Q.offer(node.right);
      }
      return sb.toString();
   }

   // Decodes your encoded data to tree.
   public TreeNode deserialize(String data) {
      if (data.equals("")) {
         return null;
      }
      Queue<TreeNode> Q = new LinkedList<>();
      String[] values = data.split(" "); // Made array out of string

      TreeNode root = new TreeNode(Integer.parseInt(values[0]));
      Q.offer(root);
      int i = 1;
      while (!Q.isEmpty() && i < values.length) {
         TreeNode node = Q.poll();
         // Left child
         if (i < values.length && !values[i].equals("#")) {
            TreeNode leftNode = new TreeNode(Integer.parseInt(values[i]));
            node.left = leftNode;
            Q.offer(leftNode);
         }
         i++;
         // Right child
         if (i < values.length && !values[i].equals("#")) {
            TreeNode rightNode = new TreeNode(Integer.parseInt(values[i]));
            node.right = rightNode;
            Q.offer(rightNode);
         }
         i++;
      }
      return root;
   }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));