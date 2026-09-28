class Solution {
    public int maxDepth(String s) {
        
        int n = s.length();
        int maxLength = 0;
        Stack<Character> st = new Stack<>();

        for(char ch : s.toCharArray()){
            if(ch=='('){
                st.push(ch);
                maxLength = Math.max(maxLength,st.size());
            }else if(ch==')'){
                st.pop();
            }
        }
        return maxLength;
    }
}