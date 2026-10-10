class Solution {
    public int minInsertions(String s) {
        
        int n = s.length();
        int minInsertion = 0;
        int depth = 0;

        for(int i=0;i<n;i++){
            char ch = s.charAt(i);

            if(ch=='('){
                depth+=2;
            }else{
                if(i+1<n && s.charAt(i+1)==')'){
                    if(depth>=2){
                        depth-=2;
                    }else{
                        minInsertion++;
                    }
                    i++;
                }else{
                    if(depth>=2){
                        depth-=2;
                        minInsertion++;
                    }else{
                        minInsertion+=2;
                    }
                }
            }
        }
        return minInsertion + (depth);
    }
}