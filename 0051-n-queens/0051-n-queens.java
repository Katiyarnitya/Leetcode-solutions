class Solution {

    public boolean isSafe(int row, int col, char[][] board, int n){
        //check the same col;
        for(int i=0;i<row;i++){
            if(board[i][col] == 'Q'){
                return false;
            }
        }

        // upper left
        for(int i=row-1, j=col-1; i>=0 && j>=0; i--,j--){
            if(board[i][j]=='Q'){
                return false;
            }
        }
        // upper right
        for(int i=row-1, j= col+1; i>=0 && j<n; i--,j++){
            if(board[i][j]=='Q'){
                return false;
            }
        }
        return true;
    }
    public void solve(int row, char[][] board, int n, List<List<String>> ans){
        
        if(row==n){
            ans.add(construct(board));
            return;
        }

        for(int col=0; col<n;col++){
            if(isSafe(row,col,board,n)){
                board[row][col] = 'Q';
                solve(row+1,board, n, ans);
                board[row][col] = '.';
            }
        }
    }
    public List<String> construct(char[][] board){
        List<String> ans = new ArrayList<>();
        for(char[] row : board){
            ans.add(new String(row));
        }
        return ans;
    }
    public List<List<String>> solveNQueens(int n) {
        
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];
        for(char[] row : board){
            Arrays.fill(row,'.');
        }
        solve(0,board,n,ans);
        return ans;
    }
}

// class Solution {
//     public void solve(int col, char[][] board, int n, List<List<String>> ans){
//         if(col==n){
//             ans.add(construct(board));
//             return;
//         }
//         for(int row=0; row<n; row++){
//             if(isSafe(row,col,n,board)){
//                 board[row][col]='Q';
//                 solve(col+1, board, n, ans);
//                 board[row][col]='.'; // backtrack
//             }
//         }
//     }
//     public boolean isSafe(int row,int col, int n, char board[][]){
//         // Left of the row
//         for(int i=0;i<col;i++){
//             if(board[row][i]=='Q'){
//                 return false;
//             }
//         }
//         //upper diagonal
//         for(int i=row-1, j=col-1;i>=0 && j>=0;i--,j--){
//             if(board[i][j]=='Q'){
//                 return false;
//             }
//         }
//         //Lower diagonal
//         for(int i=row+1,j=col-1;i<n && j>=0;i++,j--){
//             if(board[i][j]=='Q'){
//                 return false;
//             }
//         }
//         return true;
//     }
//     public List<String> construct(char[][] board){
//         List<String> res = new ArrayList<>();
//         for(int i=0;i<board.length;i++){
//             res.add(new String(board[i]));
//         }
//         return res;
//     }
//     public List<List<String>> solveNQueens(int n) {
//         List<List<String>> ans = new ArrayList<>();
//         // Creating char array to represe tboard
//         char[][] board = new char[n][n];
//         for(int i=0;i<n;i++){
//             Arrays.fill(board[i],'.');
//         }
//         solve(0,board,n,ans);
//         return ans;
//     }
// }
