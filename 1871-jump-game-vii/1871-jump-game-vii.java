class Solution {
    public boolean solve(int idx, String s, int minJump, int maxJump, int n, Boolean[] dp){
        //TC -> for ech ix we hve couple of option n from there we re further exploring mny other choice lo O(n) * (mxJump-minJump)
        if(idx==n-1){
            return true;
        }
        // if(idx>=n) return false;
        if(dp[idx]!= null) return dp[idx];

        boolean ans = false;
        for(int i=idx+minJump; i<=idx+maxJump; i++){
            if(i<n && s.charAt(i)=='0'){
                ans = ans || solve(i,s,minJump, maxJump,n,dp);
                if(ans){
                    return dp[idx] = true;
                }
            }
        }
        return dp[idx] =  ans;
    }
    public boolean canReach(String s, int minJump, int maxJump) {

        int n = s.length();

        // Boolean[] dp = new Boolean[n];
        // return solve(0, s, minJump, maxJump, n,dp);

        boolean[] dp = new boolean[n];
        dp[0] = true; // dp[i] = means can you reach idx = i ??

        int reachable = 0;
        for(int i=1;i<n;i++){

            if(i-minJump >= 0 && dp[i-minJump]){
                reachable++;
            }
            if(i-maxJump-1 >= 0 && dp[i-maxJump-1]){
                reachable--;
            }
            if(reachable>0 && s.charAt(i)=='0'){
                dp[i] = true;
            }
        }
        return dp[n-1];
    }
}