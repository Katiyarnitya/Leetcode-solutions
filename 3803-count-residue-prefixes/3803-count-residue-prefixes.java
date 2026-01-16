class Solution {
    public int residuePrefixes(String s) {

        int count=0;
        int  n = s.length();
        // BRUTE FORCE
        for(int j=0;j<n;j++){
            int idx=0;
            int len=0;
            HashSet<Character> set = new HashSet<>();
            
            for(int k=idx;k<=j;k++){
                set.add(s.charAt(k));
                len++;
            }
            if(set.size() == len%3){
                count++;
            }
        }
        return count;
    }
}