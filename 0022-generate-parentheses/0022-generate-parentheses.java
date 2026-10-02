class Solution {
    List<String> result;
    public void solve(int i, StringBuilder sb, int open, int close, int n){

        if(i>=2*n){
            result.add(sb.toString());
            return;
        }

        // 2 options
        // open bracket
        if(open>0){
            sb.append("(");
            solve(i+1,sb,open-1,close,n);
            sb.deleteCharAt(sb.length() - 1);
        }
        if(open<close){
            sb.append(")");
            solve(i+1,sb,open,close-1,n);
            sb.deleteCharAt(sb.length() - 1);
        }        
        // return;
    }
    public List<String> generateParenthesis(int n) {

        result = new ArrayList<>();   
        StringBuilder sb = new StringBuilder();
        solve(0,sb,n,n,n);
        return result;
    }
}