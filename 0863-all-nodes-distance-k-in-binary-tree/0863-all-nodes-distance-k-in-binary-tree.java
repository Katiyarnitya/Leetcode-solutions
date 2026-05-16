/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    HashMap<TreeNode, TreeNode> map = new HashMap<>();
    public void parentMap(TreeNode root, TreeNode parent){
        if(root==null){
            return;
        }
        map.put(root,parent);
        parentMap(root.left,root);
        parentMap(root.right,root);
    }
    class Pair{
        TreeNode node;
        int dis;
        Pair(TreeNode node, int dis){
            this.node = node;
            this.dis = dis;
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        
        List<Integer> ans = new ArrayList<>();
        if(root==null) return ans;

        parentMap(root,null);
        HashSet<TreeNode> vis = new HashSet<>();
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(target,0));
        vis.add(target);

        while(!q.isEmpty()){

            Pair curr = q.poll();
            TreeNode node = curr.node;
            int dis = curr.dis;
            if(dis==k){
                ans.add(node.val);
            }

            if(node.left!= null && !vis.contains(node.left)){
                q.offer(new Pair(node.left,dis+1));
                vis.add(node.left);
            }
            if(node.right!= null && !vis.contains(node.right)){
                q.offer(new Pair(node.right,dis+1));
                vis.add(node.right);

            }
            TreeNode parent = map.get(node);
            if(parent!=null && !vis.contains(parent)){
                q.offer(new Pair(parent,dis+1));
                vis.add(parent);
            }
        }
        return ans;
    }
}