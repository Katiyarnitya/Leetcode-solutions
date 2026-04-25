class Solution {
    public int compress(char[] chars) {
        
        int n = chars.length;

        int count = 1;
        int idx = 0;
        for(int i=1;i<n;i++){

            if(chars[i] == chars[i-1]){
                count++;
            }else{
                chars[idx++] = chars[i-1];
                if(count > 1){
                    String s = String.valueOf(count);
                    for(char c : s.toCharArray()){
                        chars[idx++] = c;
                    }
                }
                count = 1;
            }
        }
        chars[idx++] = chars[n-1];

        if(count > 1){
            String s = String.valueOf(count);
            for(char c : s.toCharArray()){
                chars[idx++] = c;
            }
        }
        return idx;
    }
}