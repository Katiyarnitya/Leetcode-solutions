class Solution {
    public String reverseParentheses(String s) {
        
        int n = s.length();
        Stack<Integer> st = new Stack<>();
        Stack<Character> stChar = new Stack<>();

        int skipLeftChars = 0;

        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            
            if(ch=='('){
                st.push(stChar.size()); // At each time we encounter open bracket we will keep track that how many charcater we have to skip before that bracket. Therefore to store that information we can use the stack
            }else if(ch==')'){
        
                int charToSkip = st.pop(); // number of characters we have to skip while reversing
                String str = "";
                int charToPop = stChar.size()-charToSkip;
                for(int j=0;j<charToPop;j++){
                    str+=stChar.pop();
                }
                for(int j=0;j<str.length();j++){
                    stChar.push(str.charAt(j));
                }
                
            }else{
                stChar.push(ch);
            }
        }
        StringBuilder sb = new StringBuilder();
        int stCharSize= stChar.size();

        for(int i=0;i<stCharSize;i++){
            sb.append(stChar.pop());
        }

        return sb.reverse().toString();
    }
}