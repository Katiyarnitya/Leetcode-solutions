class Solution {
    public int longestBalanced(String s) {

        int n = s.length();
        int maxi = Integer.MIN_VALUE;

        for(int i=0;i<n;i++){
            char[] freq = new char[26];// 0-> a or 25->z
            for(int j=i; j<n;j++){
                char ch = s.charAt(j);
                freq[ch- 'a']++;
                int key = 0;
                for(int k=0;k<26;k++){
                    if(freq[k]!=0){
                        key =  freq[k];
                        break;
                    }
                }
                boolean valid = true;
                for(int p=0;p<26;p++){
                    if(freq[p]!=0 && freq[p] !=key){
                        valid = false;
                    }
                }
                if(valid){
                    int len = j-i+1;
                    maxi = Math.max(maxi, len);
                }
            }
        }
        return maxi;
    }
}