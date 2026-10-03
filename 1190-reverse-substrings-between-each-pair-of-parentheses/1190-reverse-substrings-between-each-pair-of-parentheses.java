class Solution {
    public String reverseParentheses(String s) {
        
        int n = s.length();
        Stack<Integer> countSkipCharStack = new Stack<>();
        Stack<Character> characterStack = new Stack<>();

        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            
            if(ch=='('){
                countSkipCharStack.push(characterStack.size()); // At each time we encounter open bracket we will keep track that how many charcater we have to skip before that bracket. Therefore to store that information we can use the stack
            }else if(ch==')'){
        
                int charToSkip = countSkipCharStack.pop(); // number of characters we have to skip while reversing
                StringBuilder str = new StringBuilder();
                int charToPop = characterStack.size()-charToSkip;
                for(int j=0;j<charToPop;j++){ // while(characterStack.size() > charToSkip){
                    str.append(characterStack.pop());
                }
                for(int j=0;j<str.length();j++){
                    characterStack.push(str.charAt(j));
                }
                
            }else{
                characterStack.push(ch);
            }
        }
        StringBuilder sb = new StringBuilder();

        while(!characterStack.isEmpty()){
            sb.append(characterStack.pop());
        }
        
        // int stCharSize= characterStack.size();
        // for(int i=0;i<stCharSize;i++){
        //     sb.append(characterStack.pop());
        // }

        return sb.reverse().toString();
    }
}