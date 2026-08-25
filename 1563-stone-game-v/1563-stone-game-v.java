class Solution {

    int[] prefix;
    public int solve(int l, int r, Integer[][]dp, int[]stoneValue){

        if(l>=r){
            return 0;
        }
        
        if(dp[l][r]!=null) return dp[l][r];

        int score = 0;
        for(int mid=l; mid<=r-1;mid++){

            int leftSum = (l>0) ?  prefix[mid]- prefix[l-1] : prefix[mid];
            int rightSum = prefix[r]- prefix[mid];

            if(leftSum<rightSum){
                score = Math.max(score,leftSum+solve(l,mid,dp,stoneValue));
            }else if(rightSum<leftSum){
                score = Math.max(score,rightSum+solve(mid+1,r,dp,stoneValue));
            }else{
                score = Math.max(score,Math.max(leftSum+solve(l,mid,dp,stoneValue),rightSum+solve(mid+1,r,dp,stoneValue)));
            }
        }
        return dp[l][r] = score;
    }
    public int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;

        prefix = new int[n];
        prefix[0] = stoneValue[0];

        for(int i=1;i<n;i++){
            prefix[i] = prefix[i-1] + stoneValue[i];
        }

        Integer[][] dp = new Integer[n+1][n+1];

        return solve(0,n-1,dp,stoneValue);
    }
}