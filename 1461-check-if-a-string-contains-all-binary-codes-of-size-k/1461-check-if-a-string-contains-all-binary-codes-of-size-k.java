class Solution {
    public boolean hasAllCodes(String s, int k) {
        
        int totalSub = (int)Math.pow(2,k);
        int n = s.length();
        int left =0;
        StringBuilder sb = new StringBuilder();
        HashSet<String> set = new HashSet<>();

        for(int right=0;right<n; right++){
            
            sb.append(s.charAt(right));
            if(sb.length()>k){
                sb.deleteCharAt(0);
                left--;
            }
            if(sb.length() == k){
                set.add(sb.toString());
            }
            
        }
        return (set.size()<totalSub) ? false : true;
    }
}