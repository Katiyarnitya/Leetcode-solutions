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
    static int camera;
    // 0->covered
    // 1-> placed
    // 2-> not covered

    public static int solve(TreeNode node){
        if(node==null){
            return 2;
        }

        int left = solve(node.left);
        int right = solve(node.right);

        if(left == 0 || right ==0){ // if any child is not covered make its parent place camera therefore returns one
            camera++;
            return 1;
        }
        if(left==1 || right==1){
            return 2;
        }
        return 0; // If at that node neither the camera was lace not it was covered therefore you have to return that it is not covered
    }
    public int minCameraCover(TreeNode root) {
        camera = 0;

        if(solve(root) == 0){
            camera++;
        }
        return camera;
    }
}