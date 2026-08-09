class Solution {
    public int[] validSequence(String word1, String word2) {
        
        int n = word1.length();
        int m = word2.length();

        int[] numberOfCharMathFromRHS = new int[n];

        int i = n-1;
        int j = m-1;

        int charMatchedCount = 0;
        while(i>=0 && j>=0){
            if(word1.charAt(i) == word2.charAt(j)){
                charMatchedCount++;
                numberOfCharMathFromRHS[i] = charMatchedCount;
                i--;
                j--;
            }else{
                numberOfCharMathFromRHS[i] = (i==n-1) ? 0 : numberOfCharMathFromRHS[i+1];   
                i--;
            }
        }
        while(i>=0){
            numberOfCharMathFromRHS[i] = numberOfCharMathFromRHS[i+1];
            i--;
        }
        i=0;
        j=0;

        int[] seq = new int[m];
        boolean usedModifyingPower = false;
        int k = 0;
        while(i<n && j<m){
            if(word1.charAt(i) == word2.charAt(j)){
                seq[k] = i;
                k++;
                i++;
                j++;
            }else{
                if(usedModifyingPower==false && i+1<n && numberOfCharMathFromRHS[i+1] >= m-1-j){
                    seq[k] = i;
                    usedModifyingPower = true;
                    k++;
                    i++;
                    j++;
                }else{
                    i++;
                }
            }
        }
        return (k != m) ? new int[]{} : seq;
    }
}