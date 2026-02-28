class Solution {
    static int mod = 1000000007;
    static StringBuilder sb;

    public void deciToBinary(int n){
        StringBuilder temp = new StringBuilder();
        while(n>0){
            temp.append(n%2);
            n/=2;
        }
        sb.append(temp.reverse());
    }
    public int concatenatedBinary(int n) {
        sb = new StringBuilder();

        for(int i=1;i<=n;i++){
            deciToBinary(i);
        }
        String binary = sb.toString();
        long ans = 0;
        long pow = 1;
        for(int i=binary.length()-1;i>=0;i--){
            int dig = binary.charAt(i) - '0';
            if(dig==1){
                ans = (ans + pow) % mod;
            }
            pow = (pow *2)%mod;
        }
        return (int)ans;
    }
}