class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        
        int n = s.length();
        StringBuilder result = new StringBuilder();

        int m = knowledge.size();
        HashMap<String,String> map = new HashMap<>();

        for(List<String> list : knowledge){
            String key = list.get(0);
            String value = list.get(1);
            map.put(key,value);
        }

        boolean keyProcessing = false;
        StringBuilder key = new StringBuilder();
        for(int i=0;i<n;i++){
            
            if(s.charAt(i)=='('){
                keyProcessing = true;
                key.setLength(0);
            }else if(s.charAt(i)==')'){
                String value = map.getOrDefault(key.toString(),"?");
                result.append(value);
                keyProcessing = false;
            }else{
                if(keyProcessing){
                    key.append(s.charAt(i));
                }else{
                    result.append(s.charAt(i));
                }
            }
        }
        return result.toString();
    }
}