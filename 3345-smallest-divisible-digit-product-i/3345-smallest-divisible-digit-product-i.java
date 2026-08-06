class Solution {
    public int prod(int n){
        
        int ans = 1;
        while(n>0){
            int lastDigit = n%10;
            ans *= lastDigit;
            n /= 10;
        }
        return ans;
    }
    public int smallestNumber(int n, int t) {
        
        // At most 10 consecutive numbers we have to check from n, because every 10 consecurtive numbers will must have a number ending with 0.
        // And if any no. is not divisible by t, no. ending with 10 will surely be divisible.

        for(int i=n;i< n+10;i++){
            if(prod(i) % t ==0){
                return i;
            }
        }
        return 0;
    }
}