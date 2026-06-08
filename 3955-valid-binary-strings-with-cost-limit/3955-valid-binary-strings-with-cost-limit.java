class Solution {
    public List<String> generateValidStrings(int n, int k) {
        List<String> ans = new ArrayList<>();

        int total = 1<<n;

        for(int mask = 0;mask<total; mask++){
            StringBuilder sb = new StringBuilder();
            int cost = 0;
            boolean valid = true;

            for(int i=0;i<n;i++){
                if((mask &(1<<(n-1-i))) !=0){
                    sb.append('1');
                    cost += i;

                    if(i>0 && sb.charAt(i-1)=='1'){
                        valid = false;
                        break;
                    }
                }else{
                    sb.append('0');
                }
            }
            if(valid && cost<=k){
                ans.add(sb.toString());
            }
        }
        return ans;
    }
}