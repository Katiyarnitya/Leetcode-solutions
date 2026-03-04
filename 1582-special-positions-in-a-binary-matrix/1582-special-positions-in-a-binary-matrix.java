class Solution {
    public int numSpecial(int[][] mat) {
        
        int m = mat.length;
        int n = mat[0].length;

        int[] row1 = new int[m];
        int[] col1 = new int[n];

        for(int i=0;i<m;i++){
            for(int j=0; j<n;j++){
                if(mat[i][j] == 1){
                    row1[i]++;
                    col1[j]++;
                }
            }
        }
        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j] == 1){
                    if(row1[i]==1 && col1[j]==1){
                        count++;
                    }
                }
            }
        }
        return count;
    }
}