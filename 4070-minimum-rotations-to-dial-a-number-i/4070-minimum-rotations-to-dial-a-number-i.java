class Solution {
    public int minRotations(String s) {
        
        int ans = 0;
        int from = 0;
        for(int i=0;i<10;i++){
            int to = s.charAt(i)-'0';

            int forwardSteps = (to-from+10)%10;
            int backwardSteps = (from-to+10)%10;

            ans += Math.min(forwardSteps,backwardSteps);
            from = to;
        }

        return ans;
    }
}