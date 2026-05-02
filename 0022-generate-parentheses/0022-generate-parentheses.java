class Solution { 
    public void helper(int open, int close, int n, List<String> ans, String str){
        if(str.length() == 2*n){
            ans.add(str);
            return;
        }
        if(open<n){
            helper(open+1,close,n,ans,str+"(");
        }
        if(close<open){
            helper(open, close+1, n, ans,str+")");
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        helper(0, 0, n, ans, "");
        return ans;
    }
}