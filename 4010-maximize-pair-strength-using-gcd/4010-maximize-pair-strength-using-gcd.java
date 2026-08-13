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

                long a = nums[i];
                long b = nums[j];

                long mul = a * b;
                long gcd = (a>=b) ? gcd(a,b) : gcd(b,a);

                maxStrength = Math.max(maxStrength,mul / (gcd*gcd));
            }
        }
        return maxStrength;
    }
}