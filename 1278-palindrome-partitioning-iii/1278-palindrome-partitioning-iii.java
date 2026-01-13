class Solution {
    int n;
    String str;
    int[][] palindrome;

    // We can use an extra dp to calculate and store there . 
    public int checkPalinCount(int i, int j){
        int count = 0;
        while(i<j){
            if(str.charAt(i) != str.charAt(j)){
                count++; // We have to change that character
            }
            i++;
            j--;
        }
        return count;
    }
    public int solve(int idx, int k, int[][] dp){
        if(idx==n && k==0) return 0;

        if(idx==n || k==0) return (int)1e9; // either string has exhausted and partitions are left or string left but partition exhausted

        if(dp[idx][k] != -1) return dp[idx][k];
        int mini =(int)1e9; // can also take 1001 as str length is only 1000;
        for(int j=idx; j<n;j++){
            int change = checkPalinCount(idx,j);
            int cost = change + solve(j+1,k-1,dp);
            mini = Math.min(mini,cost);
        }
        return dp[idx][k] = mini;
    }
    public int palindromePartition(String s, int k) {
        n = s.length();
        str = s;
        int[][] dp = new int[n][k+1];
        for(int[] row : dp){
            Arrays.fill(row,-1);

        }
        return solve(0,k,dp);
    }
}  