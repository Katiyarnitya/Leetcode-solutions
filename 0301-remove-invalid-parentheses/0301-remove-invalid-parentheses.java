class Solution {

    public int openCloseBracketLeft(String str){

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

    
    public void solve(int i, String ans, int maxLength, HashSet<String> set, String s){
        
        if(ans.length()==maxLength && openCloseBracketLeft(ans)==0){
            set.add(ans);
            return;
        }

        if(i>=s.length()){
            return;
        }

        char ch = s.charAt(i);
        // include
        solve(i+1,ans+ch,maxLength,set,s);

        if(ch=='(' || ch==')'){
            //exclude
            solve(i+1,ans,maxLength,set,s);
        }
    }
    public List<String> removeInvalidParentheses(String s) {

        HashSet<String> set = new HashSet<>();

        int n = s.length();
        List<String> list = new ArrayList<>();

        if (n == 1) {
            if(s.charAt(0)!='(' && s.charAt(0)!=')'){
                list.add(String.valueOf(s.charAt(0)));
                return list;
            }else{
                list.add("");
               return list;
            }
        }

        
        int parenthesisToBeRemoved = openCloseBracketLeft(s);

       solve(0,"",n-parenthesisToBeRemoved,set,s);
       list.addAll(set);
        return list;
    }
}