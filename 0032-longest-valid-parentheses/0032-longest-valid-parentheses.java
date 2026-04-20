class Solution {
    public int longestValidParentheses(String s) {
        
        int n = s.length();

        Stack<Integer> st = new Stack<>();
        int[] arr = new int[n];

        for(int i=0; i<n; i++){
            if(s.charAt(i) == '('){
                st.push(i);
            }else{
                 if(!st.isEmpty()){
                    int top = st.pop();
                    arr[i] = 1;
                    arr[top] = 1;
                }
            }
        }
        int count = 0;
        int maxLen = 0;
        for(int i=0;i<n;i++){
            if(arr[i] == 1){
                count++;
            }else{
                maxLen = Math.max(maxLen, count);
                count = 0;
            }
        }
        return Math.max(maxLen, count); 
    }
}