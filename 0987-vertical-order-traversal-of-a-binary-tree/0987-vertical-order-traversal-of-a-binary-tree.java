/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    class Pair{
        TreeNode node;
        int row;
        int col;
        Pair(TreeNode node, int row, int col){
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root==null) return result;

        TreeMap<Integer, List<int[]>> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root,0,0));

        while(!q.isEmpty()){
            Pair curr = q.poll();
            TreeNode node = curr.node;
            int row = curr.row;
            int col = curr.col;

            if(!map.containsKey(col)){
                map.put(col,new ArrayList<>());
            }
            map.get(col).add(new int[]{row,node.val});
            if(node.left!=null) q.offer(new Pair(node.left,row+1,col-1));
            if(node.right!=null) q.offer(new Pair(node.right,row+1,col+1));
        }
        for(List<int[]> list : map.values()){
            Collections.sort(list, (a,b) -> {
                if(a[0]!=b[0]){
                    return a[0]-b[0];
                }else{
                    return a[1] - b[1];
                }
            });
            List<Integer> temp = new ArrayList<>();
            for(int[] row : list){
                temp.add(row[1]);
            }
            result.add(new ArrayList<>(temp));
        }
        return result;
    }
}