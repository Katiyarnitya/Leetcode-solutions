class Solution {
     private double powHelper(double x, long n) {
        if (n == 0) return 1; // Base case: x^0 = 1

        double half = powHelper(x,n/2);
        if(n%2==0){
            return half * half;
        }else{
            return x * half* half;
        }
    }
    public double myPow(double x, int n) {
        long N = n; 
        
        if (N < 0) {   
            x = 1 / x; 
            N = -N;    
        }

        return powHelper(x, N);
    }
}