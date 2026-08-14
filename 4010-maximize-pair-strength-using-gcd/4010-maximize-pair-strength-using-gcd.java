class Solution {
    public long gcd(long a, long b){

        long rem = a%b;

        if(rem==0){
            return b;
        }else{
           return gcd(b,rem);
        }
    }
    public long maxPairStrength(int[] nums) {
        
        int n = nums.length;

        long maxStrength = -1;

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){

                int a = nums[i];
                int b = nums[j];

                long mul = (long)a * b;
                long gcd = gcd(a,b);

                maxStrength = Math.max(maxStrength,mul / (gcd*gcd));
            }
        }
        return maxStrength;
    }
}