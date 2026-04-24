class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        
        int len = grid.length;
        int n = len*len;

        long actualSum = (long)(n*(n+1))/2;
        long actualSqSum = (long)(n*(n+1)*(2*n+1))/6;

        long gridSum = 0;
        long gridSqSum = 0;
        for(int i=0;i<len;i++){
            for(int j=0; j<len; j++){
                gridSum+= grid[i][j];
                gridSqSum += (long)(grid[i][j]*grid[i][j]);
            }
        }
        long diff = gridSum - actualSum;       // a - b
        long sqDiff = gridSqSum - actualSqSum; // a^2 - b^2

        long sumAB = sqDiff / diff; // a + b

        int a = (int)((diff + sumAB) / 2); // repeating
        int b = (int)(sumAB - a);          // missing

        return new int[]{a, b};
        
        // int[] freq = new int[(n*n)+1];
        // for(int i=0;i<n;i++){
        //     for(int j=0; j<n; j++){
        //         freq[grid[i][j]]++;
        //     }
        // }
        // int[] arr = new int[2];
        // for(int i=1;i<=n*n;i++){
        //     if(freq[i] == 2){
        //         arr[0] = i;
        //     }
        //     if(freq[i]==0){
        //         arr[1] = i;
        //     }
        // }
        // return arr;
    }
}