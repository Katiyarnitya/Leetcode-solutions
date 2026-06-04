class Solution {
    public int totalWaviness(int num1, int num2) {
        
        if(num2<=99){
            return 0;
        }
        int waviness = 0;
        for(int j=num1;j<=num2;j++){
            if(j<99){
                continue;
            }
            String num = String.valueOf(j);
            for(int i=1;i<num.length()-1;i++){
                if((num.charAt(i-1)<num.charAt(i) && num.charAt(i)>num.charAt(i+1)) || (num.charAt(i-1)>num.charAt(i) && num.charAt(i)<num.charAt(i+1))){
                    waviness++;
                }
            }
        }
        return waviness;
    }
}