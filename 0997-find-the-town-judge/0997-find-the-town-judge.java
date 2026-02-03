class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] indeg = new int[n];
        int[] outdeg = new int[n];

        for(int i=0;i<trust.length;i++){
            int a = trust[i][1]-1;
            int b = trust[i][0]-1;
            indeg[a]++;
            outdeg[b]++;
        }
        for(int i=0;i<n;i++){
            if(indeg[i] == n-1 && outdeg[i] == 0){
                return i+1;
            }
        }
        return -1;
    }
}