class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        
        if(rows ==1) return encodedText;

        int n = encodedText.length();
        int cols = n/rows;
        char[][] matrix = new char[rows][cols];

        // int idx = 0;
        // for(int i=0;i<rows;i++){
        //     for(int j=0;j<cols; j++){
        //         matrix[i][j] = encodedText.charAt(idx);
        //         idx++;
        //     }
        // }
        // StringBuilder sb = new StringBuilder();
        // for(int col=0;col<cols;col++){
        //     int i = 0;
        //     int j = col;
        //     while(i<rows && j<cols){
        //         sb.append(matrix[i][j]);
        //         i++;
        //         j++;
        //     }
        // }
        // while (sb.length() > 0 && sb.charAt(sb.length() - 1) == ' ') {
        //     sb.deleteCharAt(sb.length() - 1);
        // }
        // return sb.toString();

        // Aproach 2;
        StringBuilder originalText = new StringBuilder();

        for(int col = 0;col<cols;col++){
            for(int i=col; i<n;i+= cols+1){
                originalText.append(encodedText.charAt(i));
            }
        }
        while (originalText.length() > 0 && originalText.charAt(originalText.length() - 1) == ' ') {
            originalText.deleteCharAt(originalText.length() - 1);
        }
        return originalText.toString();
    }
}