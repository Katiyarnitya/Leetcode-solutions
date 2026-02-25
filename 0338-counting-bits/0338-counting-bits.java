class Solution {
    public int count(int n){
        int noOfOne = 0;
        while (n > 0) {
            if(n%2==1){
                noOfOne++;
            }
            n /= 2;
        }
        return noOfOne;
    }
    public int[] countBits(int n) {
        int[] result = new int[n+1];

        for(int i=0;i<=n;i++){
            result[i] = count(i);
        }
        return result;
    }
}