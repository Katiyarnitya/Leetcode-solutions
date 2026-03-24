class Solution {
    static int mod = 12345;
    public int[][] constructProductMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] prefix = new int[n][m];
        int[][] suffix = new int[n][m];

        long currentProd = 1;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                prefix[i][j] = (int)currentProd;
                currentProd = ((currentProd * grid[i][j]) % mod) % mod;
            }
        }
        currentProd = 1;
        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                suffix[i][j] = (int) currentProd;
                currentProd = ((currentProd*grid[i][j])%mod)%mod;
            }
        }
        
        int[][] res = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                res[i][j] = (int)(((long)prefix[i][j] * suffix[i][j]) % mod);
            }
        }
        return res;
    }
}