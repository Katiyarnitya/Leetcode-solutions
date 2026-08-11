class Solution {

    public boolean isPerfectSq(int n){
        int sqrt = (int) Math.sqrt(n);
        return sqrt*sqrt == n;
    }

    public boolean solve(int n, boolean[]dp){ // turn=1 -> Alice else Bob
        
        if(n==0){
            return false; // whosover turn it is, he lost as no stones was left
        }
        if(isPerfectSq(n)){
            return true; // whosoever turn it is, he/she picked all stones and won
        } 
        if(dp[n] != false) return dp[n];

        for(int k=1; k*k<=n;k++){
            if(solve(n-k*k,dp)==false){ // at first when main calls solve(n), this call is for bob
                return dp[n] = true; // alice wins
            }
        }
        return dp[n] = false;
    }
    public boolean winnerSquareGame(int n) {

        if(isPerfectSq(n)){
            return true;
        }else{
            boolean[] dp = new boolean[n+1];
            return solve(n,dp);
        }
    }
}