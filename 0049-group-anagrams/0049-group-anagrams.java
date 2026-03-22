class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        for(String str : strs){
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String sorted = new String(arr);
            map.putIfAbsent(sorted,new ArrayList<>());
            map.get(sorted).add(str);
        }
        List<List<String>> answer = new ArrayList<>();
        for(ArrayList<String> list : map.values()){
            answer.add(list);
        }

        return answer;
    }
}