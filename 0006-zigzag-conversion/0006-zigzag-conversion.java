class Solution {
    public String convert(String s, int numRows) {
        
        if(numRows==1) return s;

        StringBuilder[] row = new StringBuilder[numRows];

        for(int i=0;i<numRows;i++){
            row[i] = new StringBuilder();
        }

        boolean goingDown = true;
        int r=0; // row no.

        for(char ch : s.toCharArray()){

            row[r].append(ch);

            if(r==0){
                goingDown = true;
            }else if(r==numRows-1){
                goingDown = false;
            }

            if(goingDown){
                r++;
            }else{
                r--;
            }
        }
        StringBuilder ans = new StringBuilder();
        for(int i=0;i<numRows;i++){
            ans.append(row[i]);
        }
        return ans.toString();
    }
}