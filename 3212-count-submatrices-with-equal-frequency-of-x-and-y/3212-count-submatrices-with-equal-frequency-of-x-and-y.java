class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;

        int[][] mat = new int[n][m];
        int[][] countX = new int[n][m];

        // Build mat and initial countX
        for(int i = 0; i < n; i++){ 
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 'X'){
                    mat[i][j] = 1;
                    countX[i][j] = 1;
                }else if(grid[i][j] == 'Y'){
                    mat[i][j] = -1;
                }else{
                    mat[i][j] = 0;
                }
            }
        }

        int[][] prefix = new int[n][m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                
                int xVal = countX[i][j]; // preserve original

                if(i == 0 && j == 0){
                    prefix[i][j] = mat[i][j];
                    countX[i][j] = xVal;
                }
                else if(i == 0){
                    prefix[i][j] = mat[i][j] + prefix[i][j-1];
                    countX[i][j] = xVal + countX[i][j-1];
                }
                else if(j == 0){
                    prefix[i][j] = mat[i][j] + prefix[i-1][j];
                    countX[i][j] = xVal + countX[i-1][j];
                }
                else{
                    prefix[i][j] = mat[i][j] 
                                 + prefix[i-1][j] 
                                 + prefix[i][j-1] 
                                 - prefix[i-1][j-1];

                    countX[i][j] = xVal 
                                 + countX[i-1][j] 
                                 + countX[i][j-1] 
                                 - countX[i-1][j-1];
                }

                if(prefix[i][j] == 0 && countX[i][j] > 0){
                    count++;
                }
            }
        }

        return count;
    }
}