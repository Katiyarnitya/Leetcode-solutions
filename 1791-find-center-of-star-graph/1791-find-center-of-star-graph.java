class Solution {
    public int findCenter(int[][] edges) {

        int A = edges[0][0];
        int B = edges[0][1];
        int C = edges[1][0];
        int D = edges[1][1];

        if(A==C || A==D){
            return A;
        }else{
            return B;
        }
        // return -1;
    }
}