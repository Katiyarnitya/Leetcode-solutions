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
    public void solve(TreeNode root, int sum, int target, List<Integer> list, List<List<Integer>> result){

        if(root==null){
            return;
        }
        if(root.left==null && root.right==null){
            if(sum+root.val== target){
                list.add(root.val);
                result.add(new ArrayList<>(list));
                list.remove(list.size()-1);
            }
        }
        list.add(root.val);
        solve(root.left,sum+root.val,target,list,result);
        solve(root.right,sum+root.val,target,list,result);
        list.remove(list.size()-1);

    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        solve(root,0,targetSum,list,result);
        return result;

    }
}