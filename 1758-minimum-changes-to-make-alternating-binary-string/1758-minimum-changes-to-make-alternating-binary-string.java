class Solution {
    public int minOperations(String s) {
        
        int n = s.length();
        int count = 0;
        int prev = 0; // We are tring to make string of length n like 10101010...
        for(int i=0;i<n;i++){
            int currBit = s.charAt(i) - '0';
            if(currBit==prev){
                currBit = 1 - prev;
                count++;
            }
            prev = currBit;
        }
        return Math.min(count, n-count);
    }
}