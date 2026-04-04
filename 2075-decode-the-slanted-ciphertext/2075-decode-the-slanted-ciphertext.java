class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        
        if(rows ==1) return encodedText;

        int n = encodedText.length();
        int cols = n/rows;
        char[][] matrix = new char[rows][cols];

        int idx = 0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols; j++){
                matrix[i][j] = encodedText.charAt(idx);
                idx++;
            }
        }

        int diagonals =0;
        for(int i=0;i<n;i++){
            if(encodedText.charAt(i) == ' '){
                diagonals = i;
                break;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int col=0;col<cols;col++){
            int i = 0;
            int j = col;
            while(i<rows && j<cols){
                sb.append(matrix[i][j]);
                i++;
                j++;
            }
        }
        while (sb.length() > 0 && sb.charAt(sb.length() - 1) == ' ') {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }
}