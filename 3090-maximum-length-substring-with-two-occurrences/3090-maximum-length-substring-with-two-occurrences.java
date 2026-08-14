class Solution {
    public int maximumLengthSubstring(String s) {
        
        int n = s.length();

        HashMap<Character,Integer> map = new HashMap<>();
        boolean freqGreaterThan2 = false;

        int maxLength = 0;
        int l = 0;

        for(int r=0; r<n; r++){
            char ch = s.charAt(r);
            map.put(ch,map.getOrDefault(ch,0)+1);
            if(map.get(ch)>2){
                freqGreaterThan2 = true;
            }

            while(freqGreaterThan2){
                map.put(s.charAt(l),map.get(s.charAt(l))-1);
                if(map.get(ch)<=2){
                    freqGreaterThan2 = false;
                }
                l++;
            }
            maxLength = Math.max(maxLength,r-l+1);
        }
        return maxLength;
    }
}