class Solution {

    static HashSet<String> set;
    static String ans;
    public static void solve(int idx, String s, int n){
        
        if(ans!=null) return;
        if(idx == n){
            if(!set.contains(s)){
                ans = s;
            }
            return;
        }

        solve(idx+1, s+"0", n);
        solve(idx+1 , s+"1" , n);
    }
    public String findDifferentBinaryString(String[] nums) {
        
        int n = nums.length;
        // set = new HashSet<>();
        // ans = null;
        // for(int i=0;i<n;i++){
        //     set.add(nums[i]);
        // }
        // solve(0,"",n);
        // return ans;

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            if(nums[i].charAt(i) == '0'){
                sb.append('1');
            }else{
                sb.append('0');
            }
        }
        return sb.toString();
    }
}