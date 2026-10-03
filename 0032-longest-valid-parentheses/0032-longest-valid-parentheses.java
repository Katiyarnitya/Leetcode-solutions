class Solution {
    public int longestValidParentheses(String s) {
        

        int n = s.length();
        int open = 0;
        int close = 0;
        int maxLength = 0;

        // L -> R
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);

            if(ch=='('){
                open++;
            }else{
                close++;
            }

            if(open<close){
                open = 0;
                close = 0;
            }
            if(open==close){
                maxLength = Math.max(maxLength,open+close);
            }
        }
        // R->L
        open = 0;
        close= 0;
        for(int i=n-1;i>=0;i--){
            char ch = s.charAt(i);

            if(ch=='('){
                open++;
            }else{
                close++;
            }

            if(close<open){
                open = 0;
                close = 0;
            }
            if(open==close){
                maxLength = Math.max(maxLength,open+close);
            }
        }
        return maxLength;
    }
}