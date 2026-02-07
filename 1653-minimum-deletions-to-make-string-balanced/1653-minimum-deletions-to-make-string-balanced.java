class Solution {
    public int minimumDeletions(String s) {
        
        int n = s.length();
        int del = 0;
        Stack<Character> st = new Stack<>();
        st.push(s.charAt(0));
        for(int i=1;i<n;i++){
            char curr = s.charAt(i);
            if(!st.isEmpty() && st.peek() == 'b' && curr == 'a'){
                st.pop();
                del++;
            }else{
                st.push(curr);
            }
        }
        return del;
    }
}