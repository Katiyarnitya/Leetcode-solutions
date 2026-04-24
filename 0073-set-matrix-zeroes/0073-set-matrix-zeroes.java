class Solution {
    public void setZeroes(int[][] matrix) {
        
        int m = matrix.length;
        int n = matrix[0].length;

        // checking 1st row impacted or not

        boolean firstRowImp = false;

        for(int i=0;i<m; i++){
            if(matrix[i][0]==0) firstRowImp = true;
        }

        boolean firstColImp = false;
        for(int j = 0;j<n;j++){
            if(matrix[0][j]==0) firstColImp = true;
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0; // storing that ith row will be all 0 at it's 1st cell
                    matrix[0][j] = 0;// storing that jth col will be all 0 at it's 1st cell
                }
            }
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(matrix[i][0] == 0 || matrix[0][j] == 0 ){
                    matrix[i][j] = 0;
                }
            }
        }
        if(firstRowImp){
            for(int i=0;i<m;i++){
                matrix[i][0] = 0;
            }
        }
        if(firstColImp){
            for(int j=0;j<n;j++){
                matrix[0][j] = 0;
            }
        }

        // boolean[] row = new boolean[m];
        // boolean[] col = new boolean[n];
        // for(int i=0;i<m;i++){
        //     for(int j=0;j<n;j++){
        //         if(matrix[i][j] == 0){
        //             row[i] = true;
        //             col[j] = true;
        //         }
        //     }
        // }
        // for(int i=0;i<m;i++){
        //     for(int j=0;j<n;j++){
        //         if(row[i] || col[j]){
        //             matrix[i][j] = 0;
        //         }
        //     }
        // }
    }
}