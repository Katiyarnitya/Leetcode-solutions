class Solution {
    public boolean checkLeft(int[] row, int start) {
    int n = row.length;
    for (int i = 0; i < n; i++) {
        if (row[i] != row[(i + start) % n])  
            return false;
    }
    return true;
}
    public boolean checkRight(int[] row,int start) {
        int n=row.length;
        int i=0;

        while(i<n){
            if(row[i]!=row[start%n])
                return false;
            i++;
            start++;
        }
        return true;
    }
    
    public boolean areSimilar(int[][] mat, int k) {        
        int even=0;
        for(int[] row:mat){
            int n=row.length;
            int rotate=k%n;
            if(even==0){
                even=1;
                if(!checkLeft(row,rotate))
                    return false;
            }
            else
            {
                even=0;
                if(!checkRight(row,rotate))
                    return false;
            }
        }
        return true;
    }
}