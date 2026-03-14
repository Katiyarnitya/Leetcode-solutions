class Solution {

    int count = 0;
    String result = "";

    public String getHappyString(int n, int k) {
        solve(0, n, k, new StringBuilder());
        return result;
    }

    public void solve(int index, int n, int k, StringBuilder sb) {

        if(index == n){
            count++;
            if(count == k){
                result = sb.toString();
            }
            return;
        }

        for(char c : new char[]{'a','b','c'}){

            if(sb.length() > 0 && sb.charAt(sb.length()-1) == c){
                continue;
            }
            sb.append(c);
            solve(index+1, n, k, sb); 
            sb.deleteCharAt(sb.length()-1);

            if(!result.equals("")) return; // stop early if found
        }
    }
}
