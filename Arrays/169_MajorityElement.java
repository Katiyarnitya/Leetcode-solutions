public class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;

        // BRUTE FORCE

        // int mid = 0 +(n-1+0)/2;
        // Arrays.sort(nums);
        // if(n%2!=0){//Odd
        //     return nums[mid];
        // }
        // return nums[mid+1];

        // Boyer-Moore Voting Algorithm

        int candidate = nums[0];
        int count=1;
        for(int i=1;i<n;i++){
            if(nums[i]==candidate){
                count++;
            }else{
                count--;
                if(count==0){
                    candidate=nums[i];
                    count=1;
                }
            }
        }
        return candidate;
    }
}{

}
