class Solution {
    public int solve(int i, int[] value, Integer[] dp){
        int n = value.length;
        if(i>=n){
            return 0;
        }
        if(dp[i]!=null) return dp[i];

        int ans = Integer.MIN_VALUE;

        int one=0;
            one = value[i] + Math.min(solve(i+2,value,dp),Math.min(solve(i+3,value,dp),solve(i+4,value,dp)));

        int two = (i+1<n) ? 0 : Integer.MIN_VALUE;
        if(i+1<n){
            two = value[i] + value[i+1] + Math.min(solve(i+3,value,dp),Math.min(solve(i+4,value,dp),solve(i+5,value,dp)));
        }
        int three = (i+2<n) ? 0 : Integer.MIN_VALUE;

        if(i+2<value.length){
            three = value[i] + value[i+1] + value[i+2] + Math.min(solve(i+4,value,dp),Math.min(solve(i+5,value,dp),solve(i+6,value,dp)));
        }
        ans  = Math.max(ans,Math.max(one,Math.max(two,three)));
        return dp[i] = ans;
    }
    public String stoneGameIII(int[] stoneValue) {
        
        int n = stoneValue.length;
        Integer[] dp = new Integer[n];

        int totalValue = 0;
        for(int i=0;i<n;i++){
            totalValue += stoneValue[i];
        }
        int aliceScore = solve(0,stoneValue,dp);

        if(aliceScore > totalValue-aliceScore){
            return "Alice";
        }else if( aliceScore < totalValue- aliceScore){
            return "Bob";
        }else{
            return "Tie";
        }

    }
}