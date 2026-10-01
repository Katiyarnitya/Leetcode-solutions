class Solution {


    // This approach is vlaid but here not memoized because everytime we are on any cell we ahve to check the state of stack also
    // public boolean solve(int i, int j, char[][] grid, Boolean[][]dp, int m, int n, Stack<Character> st){

    //     if(i>=m || j>=n){
    //         return false;
    //     }
    //     if(grid[i][j]=='('){
    //             st.push('(');
    //         }else{
    //             if(st.isEmpty()){
    //                 return false;
    //             }else{
    //                 st.pop();
    //             }
    //     }
    //     if(i==m-1 && j==n-1){
    //         if(st.isEmpty()){
    //             return true;
    //         }else{
    //             return false;
    //         }
    //     }

    //     if(dp[i][j]!=null){
    //         return dp[i][j];
    //     }

    //     boolean result = false;
    //     // 2 choices
    //     result = result || solve(i+1,j,grid,dp,m,n,st);
    //     result = result || solve(i,j+1,grid,dp,m,n,st);


    //     return dp[i][j] =  result;
    // }


    public boolean solve(int i, int j, int open,char[][] grid, Boolean[][][]dp, int m, int n){

        if(i>=m || j>=n || open<0){
            return false;
        }

        if(i==m-1 && j==n-1){
            if(open==1 && grid[i][j]==')'){
                return true;
            }else{
                return false;
            }
        }

        if(dp[i][j][open]!=null){
            return dp[i][j][open];
        }

        boolean result = false;
        // 2 choices
        if(grid[i][j]=='('){
            result = result || solve(i+1,j,open+1,grid,dp,m,n);
            result = result || solve(i,j+1,open+1,grid,dp,m,n);
        }else{
            result = result || solve(i,j+1,open-1,grid,dp,m,n);
            result = result || solve(i+1,j,open-1,grid,dp,m,n);
        }

        return dp[i][j][open] =  result;
    }
    public boolean hasValidPath(char[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        Boolean[][][] dp = new Boolean[m][n][m+n+1];
        return solve(0,0,0,grid,dp,m,n);
    }
}