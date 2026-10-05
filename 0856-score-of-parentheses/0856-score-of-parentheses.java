class Solution {
    public int scoreOfParentheses(String s) {
        

        int n = s.length();

        // Stack<Character> stBracket = new Stack<>();
        Stack<Integer> stScore = new Stack<>();
        int score = 0;
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);

            if(ch=='('){ // fresh start
                stScore.push(score);
                score = 0;
            }else{
                if(s.charAt(i-1)=='('){ // first time ) occuring
                    score = stScore.pop() + 1;
                }else{
                    score = stScore.pop() + 2*score;
                }
            }
        }
        return score;
    }
}