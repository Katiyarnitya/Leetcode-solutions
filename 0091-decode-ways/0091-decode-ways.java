class Solution {
    public int solve(int i, String s, int[] dp){
        if(i==s.length()) return 1;
        if(s.charAt(i) == '0') return 0;

        if(dp[i] != -1) return dp[i];

        int take1 = solve(i+1,s, dp);
        int take2 = 0;
        if(i+1< s.length()){
            int num = (s.charAt(i) - '0') * 10 + (s.charAt(i+1) - '0');
            if(num>=10 && num<= 26){
                take2 = solve(i+2,s, dp);
            }
        }
        return dp[i] = take1 + take2;
    }
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n];

        Arrays.fill(dp, -1);

        return solve(0,s,dp);
    }
}