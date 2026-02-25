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
    List<List<Integer>> ans;
    public void solve(TreeNode node, int targetSum, int sum, ArrayList<Integer> al){
        if(node == null){
            return;
        }
        al.add(node.val);
        if(node.left==null && node.right==null){
            if(sum + node.val==targetSum){
                ans.add(new ArrayList<>(al));
            }
            al.remove(al.size() - 1); 
            return;
        }
        
        solve(node.left, targetSum, sum+node.val, al);
        solve(node.right, targetSum, sum+node.val, al);
        al.remove(al.size()-1);
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        
        ans = new ArrayList<>();
        solve(root,targetSum,0,new ArrayList<>());

        return ans;
    }
}