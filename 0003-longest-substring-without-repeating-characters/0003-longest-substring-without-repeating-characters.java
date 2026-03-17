class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int left = 0;
        int maxLength = 0;
        HashSet<Character> set = new HashSet<>();

        for(int right =0; right<n;right++){
            char ch = s.charAt(right);
            // shrink
            while(set.contains(ch)){
                set.remove(s.charAt(left));
                left++;
            }
            //expand
            set.add(ch);
            maxLength = Math.max(maxLength,right-left+1);
        }
        return maxLength;
    }
}