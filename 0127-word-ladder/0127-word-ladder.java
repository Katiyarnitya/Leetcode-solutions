class Solution {
    static class Pair{
        String str;
        int step;
        public Pair(String str, int step){
            this.str = str;
            this.step=step;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        HashSet<String> set = new HashSet<>();
        for(String word : wordList){
            set.add(word);
        }
        set.remove(beginWord);

        // if(!set.contains(endWord)){
        //     return 0;
        // }

        int n = wordList.size();
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(beginWord,1));
        //  wl.len*word.len*26
        while(!q.isEmpty()){
            Pair curr = q.poll();
            String word = curr.str;
            int level = curr.step;

            if(word.equals(endWord)){
                return level;
            }
            for(int i=0; i<word.length();i++){
                char[] arr = word.toCharArray();
                for(char ch = 'a'; ch <='z'; ch++){
                    if(arr[i] == ch){
                        continue;
                    }
                    arr[i] = ch;
                    String replacedWord = new String(arr);
                    if(set.contains(replacedWord)){
                        q.offer(new Pair(replacedWord,level+1));
                        set.remove(replacedWord);
                    }
                }
            }
        }
        return 0;
    }
}
// class Pair{
//     String word;
//     int length;
//     Pair(String word, int length){
//         this.word=word;
//         this.length=length;
//     }
// }

// class Solution {
//     public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
//         HashSet<String> set = new HashSet<String>();
//         for(String word : wordList){
//             set.add(word);
//         }
//         set.remove(beginWord);

//         Queue<Pair> Q = new LinkedList<>();
//         Q.add(new Pair(beginWord, 1));

//         while(!Q.isEmpty()){
//            String word = Q.peek().word;
//            int steps = Q.peek().length;
//            Q.remove();

//            if(word.equals(endWord)==true){
//                 return steps;
//            }

//            for(int i=0;i<word.length();i++){
//                 for(char ch = 'a'; ch<='z'; ch++){
//                     char[] replacedCharArray = word.toCharArray();
//                     replacedCharArray[i]=ch;
//                     String replacedWord = new String(replacedCharArray);
//                     if(set.contains(replacedWord)==true){
//                         Q.add(new Pair(replacedWord, steps+1));
//                         set.remove(replacedWord);
//                     }
//                 }
//            }
//         }
//     return 0;
//     }
// }