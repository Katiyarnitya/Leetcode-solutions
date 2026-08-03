class Solution {

    int[] sumRange;
    int n;
    int sum;
    public Solution(int[] w) {
        
        n = w.length;
        sumRange = new int[n];
        sumRange[0] = w[0];
        sum = w[0];
        for(int i=1;i<n;i++){
            sum += w[i];
            sumRange[i] = sumRange[i-1]+w[i];
        }

    }
    
    public int pickIndex() {
        
        int random = (int)(Math.random() * sum) + 1;
        int low = 0;
        int high = n-1;

        while(low<=high){
            int mid = low + (high - low)/2;
            if(random < sumRange[mid]){
                high = mid-1;
            }else if(random > sumRange[mid]){
                low = mid +1;
            }else{
                return mid;
            }

        }
        return low;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */