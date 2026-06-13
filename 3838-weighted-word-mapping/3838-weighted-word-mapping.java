class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        
        int n = words.length;
        
        StringBuilder sb =  new StringBuilder();
        HashMap<Integer,Character> map = new HashMap<>();
        int count = 0;
        for(char ch='a';ch<='z';ch++){
            map.put(count,ch);
            count++;
        }
        for(int i=0;i<n;i++){
            String str = words[i];
            int sum = 0;
            for(char ch : str.toCharArray()){
                sum += weights[ch-'a'];
            }
            int rem = 25 - (sum%26);
            char c = map.get(rem);
            sb.append(c);
        }
        return sb.toString();
    }
}