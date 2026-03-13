class NumMatrix {
    int preMat[][];
    public NumMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        preMat = new int[m][n];
        preMat[0][0] = matrix[0][0];
        //1st Row
        for(int j=1;j<n;j++){
            preMat[0][j] = preMat[0][j-1] + matrix[0][j];
        }
         //1st col
        for(int i=1;i<m;i++){
            preMat[i][0] = preMat[i-1][0] + matrix[i][0];
        }

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                preMat[i][j] = matrix[i][j] + preMat[i-1][j] + preMat[i][j-1] - preMat[i-1][j-1];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        
        int ans = preMat[row2][col2];
        if(row1>0){
            ans -= preMat[row1-1][col2];
        }
        if(col1>0){
            ans -= preMat[row2][col1-1];
        }
        if(row1>0 && col1>0){
            ans+= preMat[row1-1][col1-1];
        }

        return ans;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */