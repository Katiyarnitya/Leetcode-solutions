class Solution {
    public String decodeString(String s) {
        Stack<String> stC = new Stack<>();
        Stack<Integer> stK = new Stack<>();
        int n = s.length();
        for(int i=0; i<n; i++){
            if(Character.isDigit(s.charAt(i))){
                int num = 0;
                while(i < n && Character.isDigit(s.charAt(i))){
                    num = num * 10 + (s.charAt(i) - '0');
                    i++;
                }
                stK.push(num);
                i--;    
            }else if(Character.isLetter(s.charAt(i)) || s.charAt(i)=='['){
                stC.push(String.valueOf(s.charAt(i)));
            }else{
                StringBuilder sb = new StringBuilder();
                while(!stC.isEmpty() && !stC.peek().equals("[")){
                    sb.insert(0, stC.pop()); 
                }
                stC.pop();
                int k = stK.pop();
                String temp = sb.toString(); 
                sb = new StringBuilder();
                for(int j=0;j<k;j++){
                    sb.append(temp);
                }
                stC.push(sb.toString());
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<stC.size();i++){
            sb.append(stC.get(i));
        }   
        return sb.toString();
    }
}