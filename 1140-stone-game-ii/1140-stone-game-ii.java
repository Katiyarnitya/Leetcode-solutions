class Solution {
    public int solveForAlice(int turn, int i,int M, int[] piles,Integer[][][] dp){
        if(i>=piles.length){
            return 0;
        }
        if(dp[turn][i][M] != null) return dp[turn][i][M];

        int score = 0;
        int result = (turn==1) ? -1 : Integer.MAX_VALUE; // took negative bcz Alice is starting and we want maximum score for alice

        for(int x = 1;x<=2*M; x++){
            if(i+x-1<piles.length){
                score += piles[i+x-1];
                if(turn == 1){
                    result = Math.max(result, score + solveForAlice(0,i+x,Math.max(x,M),piles,dp));
                }else{
                    result = Math.min(result,solveForAlice(1,i+x,Math.max(x,M),piles,dp));
                }
            }
        }
        return dp[turn][i][M] =  result;
    }
    public int stoneGameII(int[] piles) {
        Integer[][][] dp = new Integer[2][101][101];
        return solveForAlice(1,0,1,piles,dp);
    }
}