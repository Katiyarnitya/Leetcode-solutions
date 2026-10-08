class Solution {
    public String removeOuterParentheses(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();

        int validStart = 0;

        int open = 0;
        int close = 0;
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='('){
                open++;
                sb.append("(");
            }else{
                close++;
                sb.append(")");
            }

            if(open==close && open!=0 && close!=0){
                sb.deleteCharAt(sb.length() - 1);
                sb.deleteCharAt(validStart);
                open=0;
                close=0;
                validStart =sb.length();
            }
        }
        return sb.toString();
    }
}