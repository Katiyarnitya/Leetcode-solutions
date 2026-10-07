class Solution {

    public int openCloseBracketLeft(String str){

        int n = str.length();
        int openCount = 0;
        int extraCloseCount = 0;

        for (char ch : str.toCharArray()) {

            if (ch == '(') {
                openCount++;
            } else if(ch==')') {
                if (openCount <= 0) {
                    extraCloseCount++;
                } else {
                    openCount--;
                }
            }else{
                continue;
            }
        }
        return openCount + extraCloseCount;
    }

    HashSet<String> set;
    public void solve(int i, String ans, int maxLength, HashSet<String> set, String s){
        
        if(ans.length()==maxLength && openCloseBracketLeft(ans)==0){
            set.add(ans);
        }

        if(i>=s.length()){
            return;
        }

        char ch = s.charAt(i);
        // include
        solve(i+1,ans+ch,maxLength,set,s);
        if(ch=='(' || ch==')'){
            solve(i+1,ans,maxLength,set,s);
        }
    }
    public List<String> removeInvalidParentheses(String s) {
        set = new HashSet<>();

        int n = s.length();
        if (n == 1) {
            if(s.charAt(0)!='(' && s.charAt(0)!=')'){
                List<String> list = new ArrayList<>();
                list.add(String.valueOf(s.charAt(0)));
                return list;
            }else{
                return List.of("");
            }
        }

        
        int parenthesisToBeRemoved = openCloseBracketLeft(s);

       solve(0,"",n-parenthesisToBeRemoved,set,s);
      return new ArrayList<>(set);


    }
}