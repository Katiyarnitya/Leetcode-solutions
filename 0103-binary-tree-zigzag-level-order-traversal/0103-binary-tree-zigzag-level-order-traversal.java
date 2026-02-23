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
        boolean LtoR;

        public Pair(TreeNode node , boolean LtoR){
            this.node = node;
            this.LtoR = LtoR;
        }
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        List<List<Integer>> ans = new ArrayList<>();
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root,true));

        while(!q.isEmpty()){
            int size= q.size();
            List<Integer> ls = new ArrayList<>();

            for(int i=0;i<size;i++){
                Pair curr = q.poll();
                TreeNode node = curr.node;
                boolean LtoR = curr.LtoR;
                if(node!=null){
                    if(!LtoR){
                        ls.addFirst(node.val);
                    }else{
                        ls.addLast(node.val);
                    }
                    if(node.left!=null){ // direction is R -> L
                        q.offer(new Pair(node.left , !LtoR));
                    }
                    if(node.right!=null){
                        q.offer(new Pair(node.right , !LtoR));
                    }
                }
            }
            if (!ls.isEmpty()) ans.add(ls);
        }
        return ans;
    }
}

// class Solution {
//     public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
//         List<List<Integer>> result = new ArrayList<>();
//         if(root==null){
//             return result;
//         }
//         Queue<TreeNode> Q = new LinkedList<>();
//         boolean LeftToRight = true;
//         Q.offer(root);
//         while(!Q.isEmpty()){
//             int size = Q.size();
//             List<Integer> row = new ArrayList<>();
//             for(int i=0;i<size;i++){
//                 TreeNode node = Q.poll();
//                 if(LeftToRight){
//                     row.add(node.val);
//                 }else{
//                     row.add(0,node.val);//0 means insert at index 0 of the list.(It will Reverse the order)
//                 }

//                 if(node.left!=null){
//                     Q.offer(node.left);
//                 }
//                 if(node.right!=null){
//                     Q.offer(node.right);
//                 }
//             }
//             result.add(row);
//             LeftToRight = !LeftToRight;

//         }
//         return result;
//     }
// }