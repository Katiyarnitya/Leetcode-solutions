class Solution {
    static int mod = 1000000007;
    static Integer[][][]dp;
    public static int solve(int zeroesLeft, int onesLeft, int last, int limit){

        if(zeroesLeft==0 && onesLeft==0){
            return 1;
        }
        if(dp[zeroesLeft][onesLeft][last] != null) return dp[zeroesLeft][onesLeft][last];
        int ways = 0;
        if(last==1){
            for(int i=1;i<=Math.min(zeroesLeft,limit); i++){
                ways = (ways + solve(zeroesLeft-i, onesLeft,0,limit)) % mod;
            }
        }else{
            for(int i=1;i<=Math.min(onesLeft,limit); i++){
                ways = (ways + solve(zeroesLeft, onesLeft-i,1,limit)) % mod;
            }
        }
        return dp[zeroesLeft][onesLeft][last] = ways;
    }
    public int numberOfStableArrays(int zero, int one, int limit) {
        
        dp = new Integer[zero+1][one+1][2];
        int startZero = solve(zero,one,1,limit);
        int startOne = solve(zero,one,0,limit);

        return (startZero + startOne)%mod;
    }
}