class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> st = new Stack<>();
        for(int i=m-1; i>=0; i--){
            int curr = nums2[i];

            while(!st.isEmpty() && st.peek()<curr){
                st.pop();
            }
            if(st.isEmpty()){
                map.put(nums2[i] , -1);
            }else{
                map.put(nums2[i], st.peek());
            }
            st.push(curr);
        }

        int[] result = new int[n];
        for(int i=0;i<n;i++){
            result[i] = map.get(nums1[i]);
        }
        return result;
    }
}