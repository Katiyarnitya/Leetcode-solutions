class Solution {
    public int minSwaps(int[][] grid) {
        
        int n = grid.length;
        int[] maxRight = new int[n];

        for(int i=0;i<n;i++){
            int maxJ = 0;
            for(int j=0;j<n;j++){
                if(grid[i][j] == 1){
                    maxJ = Math.max(maxJ,j);
                }
            }
            maxRight[i] =  maxJ;
        }
        int swaps = 0;
        for(int i=0;i<n;i++){
            int j = i;
            while(j<n && maxRight[j]>i){ // skip t
                j++;
            }
            if(j==n){
                return -1;
            }
            while(j>i){
                int temp = maxRight[j];
                maxRight[j] =  maxRight[j-1];
                maxRight[j-1] = temp;
                swaps++;
                j--;
            }
       }
        return swaps;
    }
}