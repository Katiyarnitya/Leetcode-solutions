class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;

        int l = 0;
        int h = n-1;

        while(l<=h){
            int mid=l+(h-l)/2;

            if(nums[mid]==target){
                return mid;
            }
            //Mid on L1
            if(nums[l]<=nums[mid]){
                //left of mid
                if(nums[l]<=target && target<nums[mid]){
                    h = mid-1;//mid is already checked therefore we will not check it again
                }else{//right of mid
                    l=mid+1;
                }
            }else{
                if(nums[mid]<target && target<=nums[h]){
                    l = mid+1;
                }else{
                   h = mid-1;
                }
            }

        }
        return -1;
    }
}

// class Solution {
//     public int search(int[] nums, int target) {
//         return modifiedBinarySearh(nums,target,0,nums.length-1);
//     }

//     public int modifiedBinarySearh(int nums[],int target,int si,int ei){

//         if(si>ei){
//             return -1;
//         }
//         int mid=si+(ei-si)/2;

//         if(nums[mid]==target){
//             return mid;
//         }
//         //Mid on L1
//         if(nums[si]<=nums[mid]){
//             //left of mid
//             if(nums[si]<=target && target<nums[mid]){
//                 return modifiedBinarySearh(nums,target,si,mid-1);//mid is already checked therefore we will not check it again
//             }else{//right of mid
//                 return modifiedBinarySearh(nums,target,mid+1,ei);
//             }
//         }else{
//             if(nums[mid]<target && target<=nums[ei]){
//                 return modifiedBinarySearh(nums,target,mid+1,ei);
//             }else{
//                 return modifiedBinarySearh(nums,target,si,mid-1);
//             }
//         }
        
//     }
// }