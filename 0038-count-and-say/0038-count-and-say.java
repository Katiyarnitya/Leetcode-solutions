class Solution {
    public static String helper(String s){
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for(int i =0;i<n-1; i++){
            if(s.charAt(i)==s.charAt(i+1)){
                count++;
            }else{
                sb.append(count);
                sb.append(s.charAt(i));
                count = 1;
            }
        }
        sb.append(count);
        sb.append(s.charAt(n-1));
        return sb.toString();
    }
    public String countAndSay(int n) {
       String result = "1";
        for (int i = 1; i < n; i++) {
            result = helper(result);
        }
        return result;
    }
}