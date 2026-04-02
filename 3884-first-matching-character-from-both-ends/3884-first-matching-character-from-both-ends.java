class Solution {
    public int firstMatchingIndex(String s) {
        int n = s.length();
        int half = n>>1;
        for(int i=0;i<=half;i++){
            if(s.charAt(i) == s.charAt(n-i-1)){
                return i;
            }
        }
        return -1;
    }
}