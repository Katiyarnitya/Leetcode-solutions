class Solution {
    public long maxAlternatingSum(int[] nums) {
        
        int n = nums.length;
        long[] numsArray = new long[n];
        for(int i=0;i<n;i++){
            numsArray[i] = (long)nums[i]*nums[i];
        }
        Arrays.sort(numsArray);

        int left = 0;
        int right = n-1;

        long sum = 0;
        while(left<right){
            
            sum += numsArray[right];
            sum -= numsArray[left];

            left++;
            right--;
        }
        if(left==right){
            sum+=numsArray[left];
        }

        return sum;
    }
}