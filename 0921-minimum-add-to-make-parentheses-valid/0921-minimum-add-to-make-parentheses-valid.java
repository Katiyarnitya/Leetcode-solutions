class Solution {
    public int minAddToMakeValid(String s) {
        
        int n = s.length();
        if(n==0 || n==1){
            return n;
        }

        Stack<Character> stOpen = new Stack<>();
        Stack<Character> stClose = new Stack<>();

        for(char ch : s.toCharArray()){

            if(ch=='('){
                stOpen.push(ch);
            }else{
                if(!stOpen.isEmpty()){
                    stOpen.pop();
                }else{
                    stClose.push(ch);
                }
            }
        }
        return stOpen.size()+stClose.size();
    }
}