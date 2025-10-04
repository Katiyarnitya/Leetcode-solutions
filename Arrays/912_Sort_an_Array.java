class Solution {
    public void mergeSort(int[] nums, int low,int high){
        if(low>=high){
            return;
        }
        int mid=(low+high)/2;
        mergeSort(nums,low,mid);
        mergeSort(nums,mid+1,high);
        // Sort and Merge the divided arrays
        merge(nums,low,mid,high);

    }
    public void merge(int[] nums, int low,int mid, int high){
        int[] temp = new int[high - low + 1];
        int left = low;
        int right = mid+1;
        int i = 0;

        while(left<=mid && right<=high){
            if(nums[left]<=nums[right]){
                temp[i]=nums[left];
                left++;
                i++;
            }else{
                temp[i]=nums[right];
                right++;
                i++;
            }
        }
        while(left<=mid){
            temp[i]=nums[left];
            left++;
            i++;
        }
        while(right<=high){
            temp[i]=nums[right];
            right++;
            i++;
        }
        for(int j=low ;j<=high;j++){
            nums[j]=temp[j-low];
        }
        
    }
    public int[] sortArray(int[] nums) {
        mergeSort(nums,0,nums.length-1);
        return nums;
    }
}